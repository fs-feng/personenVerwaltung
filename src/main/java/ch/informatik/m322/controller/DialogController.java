package ch.informatik.m322.controller;

import ch.informatik.m322.database.Connector;
import ch.informatik.m322.model.Gender;
import ch.informatik.m322.model.Person;
import ch.informatik.m322.model.Region;
import ch.informatik.m322.view.dialog.DialogMainView;
import ch.informatik.m322.view.dialog.DialogWindow;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;

public class DialogController {
    private DialogListeners dialogListeners;
    private DialogWindow dialogData;
    private DialogWindow dialogWindow;
    private Person person;
    private Connector connector;

    public DialogController() {
        dialogListeners = new DialogListeners();
        connector = Connector.getInstance();
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
        dialogWindow.getDialogPanel().getMainView().getBirthDateField().setText(person.getBirthDate().toString());
        System.out.println(person.getBirthDate().toString());
        dialogWindow.getDialogPanel().getMainView().getChildSpinner().setValue(person.getChildren());
        dialogWindow.getDialogPanel().getMainView().getRegionSpinner().setValue(person.getRegion());
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

    public void createNewPerson() throws SQLException {
        DialogMainView dialogMainView = dialogWindow.getDialogPanel().getMainView();
        person = new Person(
                dialogMainView.getSurNameText().getText(),
                dialogMainView.getFirstNameText().getText(),
                getRadioGender(dialogMainView),
                dialogMainView.getBirthDateField().getText(),
                dialogMainView.getAhvField().getText(),
                (Region) dialogMainView.getRegionSpinner().getValue(),
                (int) dialogMainView.getChildSpinner().getValue()

        );

        connector.setSqlQuery("INSERT INTO personen");
        connector.setPreparedStatement(connector.getConnection().prepareStatement(connector.getSqlQuery()));
        connector.getPreparedStatement().setInt(1, person.getId());
        connector.getPreparedStatement().executeUpdate();
    }


    private Gender getRadioGender(DialogMainView dialogMainView) {
        if (dialogMainView.getRadioMen().isSelected())
            return Gender.male;
        else if (dialogMainView.getRadioWomen().isSelected())
            return Gender.female;
        else
            return Gender.other;

    }


    public DialogListeners getDialogListeners() {
        return dialogListeners;
    }
}
