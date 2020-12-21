package grapher;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private JButton btnInsert;
    private JTextField txtInsert;

    public ButtonsPanel(int width, int height) {
        this.setSize(width, height);
        btnInsert = new JButton("Insertar");
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
}
