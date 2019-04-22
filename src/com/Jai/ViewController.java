package com.Jai;
import javax.swing.*;
import java.util.ArrayList;

public class ViewController{

    private JFrame f;
    private ViewPanel p;
    private int width;
    private int height;
    private int squareLength;

    public ViewController(int squareLength, Node[][] nodes, SearchType st){

        this.width = (squareLength * nodes.length);
        this.height = (squareLength * nodes[0].length) + squareLength/2; //Height bug
        this.squareLength = squareLength;

        f = new JFrame("Search Algorithms - " + st.get_longSearchType());
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(this.width, this.height);
        f.setResizable(false);

        p = new ViewPanel(nodes, this.width, this.height, this.squareLength);
        f.add(p);

        f.setVisible(true);
    }

    public void update(Node[][] nodes) {
        f.remove(p);
        p = new ViewPanel(nodes, this.width, this.height, this.squareLength);
        f.add(p);
        f.validate();
    }
}
