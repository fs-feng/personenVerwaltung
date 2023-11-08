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

    public void createErrorMessage(String errorMessage){
        JTextArea textArea = new JTextArea(6, 30);
        textArea.setText(errorMessage);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea));
    }
    public DialogMainView getMainView() {
        return mainView;
    }

    public DialogBottomView getBottomView() {
        return bottomView;
    }
}
