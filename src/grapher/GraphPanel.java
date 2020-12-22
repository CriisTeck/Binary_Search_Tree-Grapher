package grapher;

import structure.tree.Node;
import structure.tree.Tree;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private Tree tree;
    private Node<Integer> radix;


    public GraphPanel(int width, int height, Tree tree) {
        paintNewTree(tree);
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int levels;
        if (tree != null)
            levels = tree.getMaximumLevel();
        else levels = 0;
        paintTree(g, radix, getWidth() / 2, 100, levels * 200, 200);
    }

    public void paintNewTree(Tree data) {
        tree = data;
        if (data != null){
        this.setPreferredSize(new Dimension((data.getMaximumLevel()*400)*2, data.getMaximumLevel() * 200));
            radix = data.getRadix();

//        paint(this.getComponentGraphics(this.getGraphics()));
        }
    }

    private void paintTree(Graphics g, Node<Integer> node, int x, int y, int offX, int offY) {
//        this.revalidate();
        if (node == null) return;
        g.setColor(Color.black);
        if (node.getRight() != null) {
            g.drawLine(x+25, y+25, (x + offX / 2)+25, (y + offY / 2)+25);
        }
        if (node.getLeft() != null) {
            g.drawLine(x+25, y+25, (x - offX / 2)+25, (y + offY / 2)+25);
        }

        g.fillOval(x, y, 50, 50);
        g.setColor(Color.white);
        g.drawString(String.valueOf(node.getData()), x+20, y+30);

        paintTree(g, node.getLeft(), x - offX / 2, y + offY / 2, offX / 2, offY);
        paintTree(g, node.getRight(), x + offX / 2, y + offY / 2, offX / 2, offY);
    }

    public void myRepaint() {
        this.updateUI();
    }
}
