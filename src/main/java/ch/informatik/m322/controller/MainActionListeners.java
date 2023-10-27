package ch.informatik.m322.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainActionListeners {
    private JButton btnSwitchLeft;
    private JButton btnSwitchRight;
    private JButton btnCreatePerson;
    private JButton btnDeletePerson;
    private JButton btnEditPerson;

    public MainActionListeners(JButton btnSwitchLeft, JButton btnSwitchRight, JButton btnCreatePerson, JButton btnDeletePerson, JButton btnEditPerson) {
        this.btnSwitchLeft = btnSwitchLeft;
        this.btnSwitchRight = btnSwitchRight;
        this.btnCreatePerson = btnCreatePerson;
        this.btnDeletePerson = btnDeletePerson;
        this.btnEditPerson = btnEditPerson;

        setupSwitchLeft();
        setupSwitchRight();
        setupCreatePerson();
        setupDeletePerson();
        setupEditPerson();
    }

    private void setupSwitchLeft() {
        btnSwitchLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
            }
        });
    }

    private void setupSwitchRight() {
        btnSwitchRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
            }
        });
    }

    private void setupCreatePerson() {
        btnCreatePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("create");
            }
        });
    }

    private void setupDeletePerson() {
        btnDeletePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("delete");
            }
        });
    }

    private void setupEditPerson() {
        btnEditPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("edit");
            }
        });
    }
}
