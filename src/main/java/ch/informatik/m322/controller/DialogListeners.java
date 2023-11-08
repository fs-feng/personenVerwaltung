package ch.informatik.m322.controller;

import ch.informatik.m322.view.dialog.DialogPanel;
import ch.informatik.m322.view.dialog.DialogWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DialogListeners {
    private JButton btnCreate;
    private JButton btnCancel;
    private JButton btnEdit;
    private DialogWindow dialogWindow;
    private DialogController dialogController;

    public DialogListeners(DialogController dialogController) {
        this.dialogController = dialogController;
    }

    public void setupCancel(JButton btnCancel) {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogWindow.dispose();
            }
        });

    }

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
                    dialogController.sqlExceptionhandler(ex);
                }

            }
        });
    }

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

    public void setDialogWindow(DialogWindow dialogWindow) {
        this.dialogWindow = dialogWindow;
    }
}
