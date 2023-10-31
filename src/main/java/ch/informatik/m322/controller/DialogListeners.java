package ch.informatik.m322.controller;

import ch.informatik.m322.view.dialog.DialogPanel;
import ch.informatik.m322.view.dialog.DialogWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogListeners {
    private JButton btnCreate;
    private JButton btnCancel;
    private JButton btnEdit;
    private DialogWindow dialogData;

    public DialogListeners(DialogWindow dialogData) {
        this.dialogData = dialogData;
    }

    public void setupCancel() {
        btnCancel = dialogData.getDialogPanel().getBottomView().getCancelButton();

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogData.dispose();
            }
        });

    }

    public void setupCreate() {

    }

    public void setupEdit() {

    }
}
