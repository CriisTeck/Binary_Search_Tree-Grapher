package grapher;

import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame {
    private static final int width = 900;
    private static final int height = 800;

    private GraphPanel panel_toGraph;
    private ButtonsPanel panel_Buttons;
    private JScrollPane jsPane_GraphPanel;

    public PrincipalFrame() {
        this.setSize(width, height);
        this.setLayout(new GridBagLayout());
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        panel_Buttons = new ButtonsPanel(width,100);
        panel_toGraph = new GraphPanel(width*2,height*2);
        jsPane_GraphPanel = new JScrollPane();
        jsPane_GraphPanel.setViewportView(panel_toGraph);
        jsPane_GraphPanel.setPreferredSize(new Dimension(width-20,height-100));
        posicionateComponents();
    }

    private void posicionateComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        add(jsPane_GraphPanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.1;
        add(panel_Buttons, gbc);

    }
}
