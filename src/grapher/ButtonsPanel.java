package grapher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel{
    private JButton btnInsert;
    private JTextField txtInsert;

    public ButtonsPanel(int width, int height, ActionListener listener) {
        this.setSize(width, height);
        btnInsert = new JButton("Insertar");
        btnInsert.addActionListener(listener);
        btnInsert.setActionCommand("Insert");
        txtInsert = new JTextField(10);
        this.setLayout(new GridBagLayout());
        initComponents();
    }

    private void initComponents() {
        posicionateComponents();
    }

    private void posicionateComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(btnInsert, gbc);

        gbc.gridx = 1;
        add(txtInsert, gbc);
    }

    public int getNewNode() {
        return Integer.parseInt(txtInsert.getText());
    }
}
