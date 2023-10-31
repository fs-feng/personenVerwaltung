package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

public class DialogPanel extends JPanel {
    private DialogMainView mainView;
    private DialogBottomView bottomView;
    public DialogPanel(String actionString) {
        super(new BorderLayout());
        mainView = new DialogMainView();
        bottomView = new DialogBottomView(actionString);


        this.add(mainView, BorderLayout.CENTER);
        this.add(bottomView, BorderLayout.SOUTH);
    }


    public DialogMainView getMainView() {
        return mainView;
    }

    public DialogBottomView getBottomView() {
        return bottomView;
    }
}
