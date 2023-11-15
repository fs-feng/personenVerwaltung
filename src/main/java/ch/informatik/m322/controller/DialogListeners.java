package ch.informatik.m322.controller;

import ch.informatik.m322.view.dialog.DialogPanel;
import ch.informatik.m322.view.dialog.DialogWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Class with ActionListeners for the buttons in the DialogWindow
 */
public class DialogListeners {
    private DialogWindow dialogWindow;
    private DialogController dialogController;

    /**
     * constructor
     *
     * @param dialogController
     */
    public DialogListeners(DialogController dialogController) {
        this.dialogController = dialogController;
    }

    /**
     * setup ActionListener for the cancel-button in DialogWindow
     * when clicking the button, dialogWindow closes
     *
     * @param btnCancel
     */
    public void setupCancel(JButton btnCancel) {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogWindow.dispose();
            }
        });

    }

    /**
     * setup ActionListener for the create-button in DialogWindow
     * when the button is clicked, checkValidation() is executed
     * if checkValidation() returns true, createNewPerson() is executed and dialogWindow disposes
     * Errors will be handled with try-catch
     *
     * @param btnCreate
     */
    public void setupCreate(JButton btnCreate) {
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (dialogController.checkValidation()) {
                        dialogController.createNewPerson();
                        dialogWindow.dispose();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                    dialogController.sqlExceptionhandler(ex);
                }

            }
        });
    }

    /**
     * setup ActionListener for the edit-button in DialogWindow
     * when the button is clicked, checkValidation() is executed
     * if checkValidation() returns true, updatePerson() is executed and dialogWindow disposes
     * Errors will be handled with try-catch
     *
     * @param btnEdit
     */
    public void setupEdit(JButton btnEdit) {
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (dialogController.checkValidation()) {
                        dialogController.updatePerson();
                        dialogWindow.dispose();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * setup the dialogWindow
     *
     * @param dialogWindow
     */
    public void setDialogWindow(DialogWindow dialogWindow) {
        this.dialogWindow = dialogWindow;
    }
}
