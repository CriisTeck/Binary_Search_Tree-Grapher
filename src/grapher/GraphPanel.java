package grapher;

import structure.tree.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphPanel extends JPanel {
    private Map<Integer, ArrayList<Float>> coordHistory = new HashMap<>();

    public GraphPanel(int width, int height) {
        this.setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
//        g.fillOval();
    }

    public void paintNewInsert(Tree data){

    }
}
