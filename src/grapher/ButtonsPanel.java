package grapher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonsPanel extends JPanel{
    private JButton btnInsert;
    private JTextField txtInsert;

    public ButtonsPanel(int width, int height, ActionListener listener) {
        this.setSize(width, height);
        this.requestFocus();
        btnInsert = new JButton("Insertar");
        btnInsert.addActionListener(listener);
        btnInsert.setActionCommand("Insert");
        txtInsert = new JTextField(10);
        txtInsert.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                btnInsert.doClick();
                txtInsert.setText("");
                txtInsert.requestFocus();
                }
            }
        });
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
        gbc.insets = new Insets(5,5,5,5);

        add(btnInsert, gbc);

        gbc.gridy = 1;
        add(txtInsert, gbc);
        txtInsert.grabFocus();
        txtInsert.requestFocus();
    }

    public int getNewNode() {
        return Integer.parseInt(txtInsert.getText());
    }

    public void requestFocusT() {
        txtInsert.requestFocus();
    }
}
