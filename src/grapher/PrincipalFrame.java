package grapher;

import javax.swing.*;

public class PrincipalFrame extends JFrame {
    private static final int width = 200;
    private static final int height = 800;

    private JPanel panel_toGraph;
    private JPanel panel_Buttons;

    public PrincipalFrame() {
        this.setSize(width, height);
        initComponents();
    }

    private void initComponents() {
        panel_Buttons = new ButtonsPanel(width,100);
        panel_toGraph = new GraphPanel(width,height - 100);
    }
}
