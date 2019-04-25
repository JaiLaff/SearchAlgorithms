package com.Jai;

import javax.swing.*;

public class ViewController {

    private JFrame f;
    private ViewPanel p;
    private int width;
    private int height;
    private int squareLength;
    private String title;

    public ViewController(int squareLength, Node[][] nodes, SearchType st) {

        this.width = (squareLength * nodes.length);
        //Without the half squarelength, controller was too short for the grid
        this.height = (squareLength * nodes[0].length) + squareLength / 2;
        this.squareLength = squareLength;

        title = "Search Algorithms - " + st.get_longSearchType();

        f = new JFrame(title);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(this.width, this.height);
        f.setResizable(false);

        p = new ViewPanel(nodes, this.squareLength);
        f.add(p);

        f.setVisible(true);
    }

    public void update(Node[][] nodes) {
        //Recreate panel each time
        f.remove(p);
        p = new ViewPanel(nodes, this.squareLength);
        f.add(p);
        f.validate();
    }
}
