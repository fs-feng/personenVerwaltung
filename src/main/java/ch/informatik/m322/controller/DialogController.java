package ch.informatik.m322.controller;

import ch.informatik.m322.view.dialog.DialogWindow;

public class DialogController {
    private DialogListeners dialogListeners;
    DialogWindow dialogData;

    public DialogController(DialogWindow dialogData) {
        this.dialogData = dialogData;
        dialogListeners = new DialogListeners(dialogData);
    }
}
