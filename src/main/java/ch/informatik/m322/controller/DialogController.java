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

public class DialogController {
    private DialogListeners dialogListeners;
    private DialogWindow dialogData;
    private DialogWindow dialogWindow;
    private Person person;
    private Connector connector;
    private MainController mainController;

    public DialogController(MainController mainController) {
        dialogListeners = new DialogListeners(this);
        connector = Connector.getInstance();
        this.mainController = mainController;
    }


    public void setupCreateDialog() {
        dialogWindow = new DialogWindow("create person");
        dialogListeners.setDialogWindow(dialogWindow);
        dialogListeners.setupCreate(dialogWindow.getDialogPanel().getBottomView().getActionButton());
        dialogListeners.setupCancel(dialogWindow.getDialogPanel().getBottomView().getCancelButton());
    }

    public void setupEditDialog(Person person) {
        this.person = person;
        dialogWindow = new DialogWindow("save person");
        setPersonData();
        dialogListeners.setDialogWindow(dialogWindow);
        dialogListeners.setupEdit(dialogWindow.getDialogPanel().getBottomView().getActionButton());
        dialogListeners.setupCancel(dialogWindow.getDialogPanel().getBottomView().getCancelButton());
    }

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

    private void setGenderRadioButton(Gender gender) {
        switch (gender) {
            case male:
                dialogWindow.getDialogPanel().getMainView().getRadioMen().setSelected(true);
                break;
            case female:
                dialogWindow.getDialogPanel().getMainView().getRadioWomen().setSelected(true);
                System.out.println("test1");
                break;
            case other:
                dialogWindow.getDialogPanel().getMainView().getRadioOther().setSelected(true);
                System.out.println("test2");
                break;
        }
    }

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


    private Gender getRadioGender(DialogMainView dialogMainView) {
        if (dialogMainView.getRadioMen().isSelected())
            return Gender.male;
        else if (dialogMainView.getRadioWomen().isSelected())
            return Gender.female;
        else
            return Gender.other;

    }

    public void sqlExceptionhandler(SQLException e) {
        e.printStackTrace();
    }


    public DialogListeners getDialogListeners() {
        return dialogListeners;
    }
}
