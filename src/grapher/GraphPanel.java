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
        this.setPreferredSize(new Dimension(width,height));
    }

    @Override
    public void paint(Graphics g) {
        this.revalidate();
        super.paint(g);
        g.setColor(Color.black);
        g.fillOval(this.getWidth()/2,this.getHeight()/2,50,50);
        g.setColor(Color.WHITE);
        g.drawString("5",this.getWidth()/2 + 20,this.getHeight() /2 +30);
    }

    public void paintNewInsert(Tree data){

    }
}
