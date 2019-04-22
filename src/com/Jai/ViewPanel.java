package com.Jai;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewPanel extends JPanel {

    private Node[][] nodes;
    private int width;
    private int height;
    private int squareLength;

    public ViewPanel(Node[][] nodes, int width, int height, int squareLength) {
        this.nodes = nodes;
        this.width = width;
        this.height = height;
        this.squareLength = squareLength;
    }

    public void paint( Graphics g ) {
        for ( int x = 0; x < squareLength * nodes.length; x += squareLength ) {
            for (int y = 0; y < squareLength * nodes[0].length; y += squareLength) {

                g.setColor(getColour(nodes[x/squareLength][y/squareLength]));
                g.fillRect(x, y, squareLength, squareLength);


                g.setColor(Color.BLACK);
                g.drawRect(x,y,squareLength,squareLength);

                Font myFont = new Font ("Helvetica", 1, 10);
                g.setFont(myFont);
                g.drawString(String.valueOf(nodes[x/squareLength][y/squareLength].get_pathCost()), x+ (squareLength /4), y + (squareLength/2));
            }
        }
    }

    private Color getColour(Node n) {
        Color result = Color.WHITE;

        if (n.get_squareType() == SquareType.WALL) {
            result = Color.GRAY;
        }

        if (n.is_searched()) {
            result = Color.LIGHT_GRAY;
        }

        if (n.is_frontier()) {
            result = Color.BLUE;
        }

        if(n.is_isCurrent()) {
            result = Color.MAGENTA;
        }

        if (n.get_squareType() == SquareType.AGNT) {
            result = Color.RED;
        }

        if (n.get_squareType() == SquareType.PATH) {
            result = Color.YELLOW;
        }

        if (n.get_squareType() == SquareType.GOAL) {
            result = Color.GREEN;
        }

        return result;
    }
}
