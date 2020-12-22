package grapher;

import structure.tree.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalFrame extends JFrame {
    private static final int width = 900;
    private static final int height = 800;

    private GraphPanel panel_toGraph;
    private ButtonsPanel panel_Buttons;
    private JScrollPane jsPane_GraphPanel;

    public PrincipalFrame(ActionListener listener,Tree tree) {
        this.setSize(width, height);
        this.setLayout(new GridBagLayout());
        initComponents(listener,tree);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents(ActionListener listener, Tree tree) {
        panel_Buttons = new ButtonsPanel(width,100, listener);
        panel_toGraph = new GraphPanel(width,height,tree);
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

    public int getNewNode() {
        return panel_Buttons.getNewNode();
    }

    public void paintTree(Tree tree) {
        panel_toGraph.paintNewTree(tree);
    }

    public void myRepaint() {
        panel_toGraph.myRepaint();
        jsPane_GraphPanel.getHorizontalScrollBar().setValue((panel_toGraph.getWidth()/2)-jsPane_GraphPanel.getWidth()/2);
    }
}
