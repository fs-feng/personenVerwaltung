package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the bottom view panel with buttons for user interaction.
 * The buttons are: switch left, switch right, create person, delete person, edit person.
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
     * Constructs a BottomView panel with buttons for user interaction.
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
     * Gets the button for switching left.
     * @return the button for switching left
     */
    public JButton getBtnSwitchLeft() {
        return btnSwitchLeft;
    }

    /**
     * Gets the button for switching right.
     * @return the button for switching right
     */
    public JButton getBtnSwitchRight() {
        return btnSwitchRight;
    }

    /**
     * Gets the button for creating a new person.
     * @return the button for creating a new person
     */
    public JButton getBtnCreatePerson() {
        return btnCreatePerson;
    }

    /**
     * Gets the button for deleting a person.
     * @return the button for deleting a person
     */
    public JButton getBtnDeletePerson() {
        return btnDeletePerson;
    }

    /**
     * Gets the button for editing a person.
     * @return the button for editing a person
     */
    public JButton getBtnEditPerson() {
        return btnEditPerson;
    }
}
