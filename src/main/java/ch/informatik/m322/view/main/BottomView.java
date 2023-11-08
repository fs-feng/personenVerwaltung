package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * @TODO
 */
public class BottomView extends JPanel {
    private JPanel leftHolder;
    private JPanel rightHolder;

    private JButton btnSwitchLeft;
    private JButton btnSwitchRight;

    private JButton btnCreatePerson;
    private JButton btnDeletePerson;
    private JButton btnEditPerson;

    /**
     * @TODO
     */
    public BottomView() {
        super(new BorderLayout());

        btnSwitchLeft = new JButton("<");
        btnSwitchRight = new JButton(">");

        btnCreatePerson = new JButton("new person");
        btnDeletePerson = new JButton("delete person");
        btnEditPerson = new JButton("edit person");


        leftHolder = new JPanel();
        rightHolder = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        leftHolder.add(btnSwitchLeft, BorderLayout.WEST);
        leftHolder.add(btnSwitchRight, BorderLayout.EAST);

        rightHolder.add(btnEditPerson);
        rightHolder.add(btnCreatePerson);
        rightHolder.add(btnDeletePerson);

        this.add(leftHolder, BorderLayout.WEST);
        this.add(rightHolder, BorderLayout.CENTER);
    }

    /**
     * @TODO
     * @return
     */
    public JButton getBtnSwitchLeft() {
        return btnSwitchLeft;
    }

    /**
     * @TODO
     * @return
     */
    public JButton getBtnSwitchRight() {
        return btnSwitchRight;
    }

    /**
     * @TODO
     * @return
     */
    public JButton getBtnCreatePerson() {
        return btnCreatePerson;
    }

    /**
     * @TODO
     * @return
     */
    public JButton getBtnDeletePerson() {
        return btnDeletePerson;
    }

    /**
     * @TODO
     * @return
     */
    public JButton getBtnEditPerson() {
        return btnEditPerson;
    }
}
