package controllers;

import grapher.PrincipalFrame;
import models.IntegerTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private IntegerTree model;
    private PrincipalFrame view;

    public Controller() {
        model = new IntegerTree();
        view = new PrincipalFrame(this, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Insert")) {
            insertNewNode();
            view.scrollToCenter();
        }
    }

    private void insertNewNode() {
        model.insert(view.getNewNode());

        view.paintTree(model.getTree());
        view.myRepaint();

    }
}
