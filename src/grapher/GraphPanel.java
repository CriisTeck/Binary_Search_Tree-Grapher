package grapher;

import structure.tree.Node;
import structure.tree.Tree;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private Tree tree;
    private Node<Integer> radix;
    private JScrollPane pane;
    private int counter;


    public GraphPanel(int width, int height, Tree tree) {
        paintNewTree(tree, pane,0);
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int levels;
        if (tree != null)
            levels = tree.getMaximumLevel();
        else levels = 0;
        paintTree(g, radix, getWidth() / 2, 100, (int) (80.147*Math.exp(0.8138*levels))/(levels+1), 200);
        if(counter < 1 && tree != null){
        pane.getHorizontalScrollBar().setValue((this.getWidth()/2)-pane.getWidth()/2);
            counter++;
        }
    }

    public void paintNewTree(Tree data, JScrollPane pane, int counter) {
        tree = data;
        this.pane = pane;
        this.counter = counter;
        if (data != null) {
            int levels = data.getMaximumLevel();
            this.setPreferredSize(new Dimension((int) (80.147*Math.exp(0.8138* levels))/(levels+1)*2, levels* 150));
            radix = data.getRadix();
        }
    }

    private void paintTree(Graphics g, Node<Integer> node, int x, int y, int offX, int offY) {
        if (node == null) return;
        g.setColor(Color.black);
        if (node.getRight() != null) {
            g.drawLine(x + 25, y + 25, (x + offX / 2) + 25, (y + offY / 2) + 25);
        }
        if (node.getLeft() != null) {
            g.drawLine(x + 25, y + 25, (x - offX / 2) + 25, (y + offY / 2) + 25);
        }

        g.fillOval(x, y, 50, 50);
        g.setColor(Color.white);
        g.drawString(String.valueOf(node.getData()), x + 20, y + 30);

        paintTree(g, node.getLeft(), x - offX / 2, y + offY / 2, offX / 2, offY);
        paintTree(g, node.getRight(), x + offX / 2, y + offY / 2, offX / 2, offY);
    }

    public void myRepaint() {
            this.updateUI();


    }
}
