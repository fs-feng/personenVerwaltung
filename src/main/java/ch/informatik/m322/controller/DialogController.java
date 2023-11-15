package ch.informatik.m322.controller;

import ch.informatik.m322.database.Connector;
import ch.informatik.m322.model.Gender;
import ch.informatik.m322.model.Person;
import ch.informatik.m322.model.Region;
import ch.informatik.m322.view.dialog.DialogMainView;
import ch.informatik.m322.view.dialog.DialogWindow;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;

/**
 * The `DialogController` class manages the interaction between the graphical user interface (GUI)
 * and the underlying data model for creating and editing person records. It handles the setup
 * of dialog windows for creating and editing persons, as well as updating the database with the
 * modified or newly created person data. This class also provides methods for validating user input
 * and handling SQL exceptions.
 */
public class DialogController {
    private DialogListeners dialogListeners;
    private DialogWindow dialogData;
    private DialogWindow dialogWindow;
    private Person person;
    private Connector connector;
    private MainController mainController;

    /**
     * Constructs a new DialogController with the specified MainController.
     * dialoglistner is created and the dialogcontroller is a param for the dialoglisteners
     *
     * @param mainController mainController The main controller of the program.
     */
    public DialogController(MainController mainController) {
        dialogListeners = new DialogListeners(this);
        connector = Connector.getInstance();
        this.mainController = mainController;
    }

    /**
     * Sets up the dialog window for creating a new person. This method initializes the necessary
     * components and sets up the buttons necessary for editing and creating persons for the create dialog.
     */
    public void setupCreateDialog() {
        dialogWindow = new DialogWindow("create person", "create person");
        dialogListeners.setDialogWindow(dialogWindow);
        dialogListeners.setupCreate(dialogWindow.getDialogPanel().getBottomView().getActionButton());
        dialogListeners.setupCancel(dialogWindow.getDialogPanel().getBottomView().getCancelButton());
    }

    /**
     * Sets up the dialog window for editing an existing person. This method initializes the necessary
     * components, populates the fields with the person's data, and sets up the event listeners for the
     * edit dialog.
     *
     * @param person The currently selected person to be edited
     */
    public void setupEditDialog(Person person) {
        this.person = person;
        dialogWindow = new DialogWindow("save person", "edit person");
        setPersonData();
        dialogListeners.setDialogWindow(dialogWindow);
        dialogListeners.setupEdit(dialogWindow.getDialogPanel().getBottomView().getActionButton());
        dialogListeners.setupCancel(dialogWindow.getDialogPanel().getBottomView().getCancelButton());
    }

    /**
     * Populates the dialog window with the data of the currently edited person. This method is called
     * when setting up the edit dialog.
     */
    public void setPersonData() {
        dialogWindow.getDialogPanel().getMainView().getFirstNameText().setText(person.getFirstName());
        dialogWindow.getDialogPanel().getMainView().getSurNameText().setText(person.getSurName());
        dialogWindow.getDialogPanel().getMainView().getAhvField().setText(person.getAhvNumber());
        dialogWindow.getDialogPanel().getMainView().getDatePicker().setDate(Date.from(person.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        System.out.println(person.getBirthDate().toString());
        dialogWindow.getDialogPanel().getMainView().getChildSpinner().setValue(person.getChildren());
        dialogWindow.getDialogPanel().getMainView().getCombobox().setSelectedItem(person.getRegion());
        setGenderRadioButton(person.getGender());
        System.out.println(this.person.getBirthDate().toString());
    }

    /**
     * Sets the radio button for the specified gender in the edit dialog window.
     *
     * @param gender The gender to be set from the person.
     */
    private void setGenderRadioButton(Gender gender) {
        switch (gender) {
            case male:
                dialogWindow.getDialogPanel().getMainView().getRadioMen().setSelected(true);
                break;
            case female:
                dialogWindow.getDialogPanel().getMainView().getRadioWomen().setSelected(true);
                break;
            case other:
                dialogWindow.getDialogPanel().getMainView().getRadioOther().setSelected(true);
                break;
        }
    }

    /**
     * Updates the database with the modified person data after editing with a prepared statement
     * the main controller updates the table and info view.
     *
     * @throws SQLException If a SQL exception occurs during the update.
     */
    public void updatePerson() throws SQLException {
        DialogMainView mainView = dialogWindow.getDialogPanel().getMainView();

        person.setFirstName(mainView.getFirstNameText().getText());
        person.setSurName(mainView.getSurNameText().getText());
        person.setGender(getRadioGender(mainView));
        person.setRegion((Region) mainView.getCombobox().getSelectedItem());
        person.setChildren((int) mainView.getChildSpinner().getValue());
        person.setAhvNumber(mainView.getAhvField().getText());
        person.setBirthDate(mainView.getDatePicker().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        connector.setSqlQuery("UPDATE personen " +
                "SET name = ?, " +
                "vorname = ?, " +
                "kinder = ?, " +
                "region = ?, " +
                "geburtsdatum = ?, " +
                "geschlecht = ?, " +
                "ahvnummer = ? " +
                "WHERE id = ?");
        connector.setPreparedStatement(connector.getConnection().prepareStatement(connector.getSqlQuery()));
        connector.getPreparedStatement().setString(1, person.getSurName());
        connector.getPreparedStatement().setString(2, person.getFirstName());
        connector.getPreparedStatement().setInt(3, person.getChildren());
        connector.getPreparedStatement().setString(4, person.getRegion().toString());
        connector.getPreparedStatement().setDate(5, Date.valueOf(person.getBirthDate()));
        connector.getPreparedStatement().setString(6, person.getGender().toString());
        connector.getPreparedStatement().setString(7, person.getAhvNumber());
        connector.getPreparedStatement().setInt(8, person.getId());
        connector.getPreparedStatement().executeUpdate();

        mainController.updateTable();
        mainController.updateInfo();
    }

    /**
     * Creates a new person with the entered data, updates the database with a prepared statement.
     * The main controller updates the table and info view.
     * The index will be set to the max of in order to show the new person in the info view.
     *
     * @throws SQLException If a SQL exception occurs during the creation.
     */
    public void createNewPerson() throws SQLException {
        DialogMainView dialogMainView = dialogWindow.getDialogPanel().getMainView();
        person = new Person(
                dialogMainView.getSurNameText().getText(),
                dialogMainView.getFirstNameText().getText(),
                getRadioGender(dialogMainView),
                dialogMainView.getDatePicker().getDate(),
                dialogMainView.getAhvField().getText(),
                (Region) dialogMainView.getCombobox().getSelectedItem(),
                (int) dialogMainView.getChildSpinner().getValue()

        );

        connector.setSqlQuery("INSERT INTO personen (name, vorname, kinder, region, geburtsdatum, geschlecht, ahvnummer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)");
        connector.setPreparedStatement(connector.getConnection().prepareStatement(connector.getSqlQuery()));
        connector.getPreparedStatement().setString(1, person.getSurName());
        connector.getPreparedStatement().setString(2, person.getFirstName());
        connector.getPreparedStatement().setInt(3, person.getChildren());
        connector.getPreparedStatement().setString(4, person.getRegion().toString());
        connector.getPreparedStatement().setDate(5, Date.valueOf(person.getBirthDate()));
        connector.getPreparedStatement().setString(6, person.getGender().toString());
        connector.getPreparedStatement().setString(7, person.getAhvNumber());
        connector.getPreparedStatement().executeUpdate();

        mainController.updateTable();
        mainController.setIndexMax();
        mainController.updateInfo();
        System.out.println("Person created");
    }

    /**
     * Checks the validation of user input locally in the dialog window, displaying error messages for invalid input.
     *
     * @return True if the input is valid and false otherwise.
     */
    public boolean checkValidation(){
        DialogMainView dialogMainView = dialogWindow.getDialogPanel().getMainView();
        StringBuilder errorOutput = new StringBuilder();
        //Check if firstname, lastname, children and ahvnumber are valid inputs.
        if (dialogMainView.getFirstNameText().getText().isEmpty() || !Pattern.matches("[a-zA-Z]+",dialogMainView.getFirstNameText().getText())) {
            errorOutput.append("First Name invalid\n");
        }
        if (dialogMainView.getSurNameText().getText().isEmpty() || !Pattern.matches("[a-zA-Z]+",dialogMainView.getSurNameText().getText())) {
            errorOutput.append("Surname invalid\n");
        }
        if ((int) dialogMainView.getChildSpinner().getValue() > 127) {
            errorOutput.append("Cannot have more than 127 children\n");
        }
        if (dialogMainView.getAhvField().getText().contains(" ")) {
            errorOutput.append("AHV-Number invalid\n");
        }
        if (!dialogMainView.getRadioMen().isSelected() && !dialogMainView.getRadioOther().isSelected() && !dialogMainView.getRadioWomen().isSelected()) {
            errorOutput.append("Gender not selected\n");
        }
        if (dialogMainView.getDatePicker().getDate() == null) {
            errorOutput.append("Date invalid");
        }

        if(!errorOutput.toString().isEmpty()){
            dialogWindow.getDialogPanel().createErrorMessage(errorOutput.toString());
            return false;
        }
        return true;
    }

    /**
     * Retrieves the selected gender from the dialog window radio buttons.
     *
     * @param dialogMainView The main view to access gender radio buttons.
     * @return The selected enum gender.
     */
    private Gender getRadioGender(DialogMainView dialogMainView) {
        if (dialogMainView.getRadioMen().isSelected())
            return Gender.male;
        else if (dialogMainView.getRadioWomen().isSelected())
            return Gender.female;
        else
            return Gender.other;

    }

    /**
     * Handles SQL exceptions by printing the stack trace.
     *
     * @param e The SQLException to be handled.
     */
    public void sqlExceptionhandler(SQLException e) {
        e.printStackTrace();
    }

}
