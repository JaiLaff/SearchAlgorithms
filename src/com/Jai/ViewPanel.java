package com.Jai;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewPanel extends JPanel {

    private Node[][] nodes;
    private int squareLength;

    public ViewPanel(Node[][] nodes, int squareLength) {
        this.nodes = nodes;
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

                int pathCost = nodes[x/squareLength][y/squareLength].get_pathCost();
                int pathScore = nodes[x/squareLength][y/squareLength].get_pathScore();

                if (pathCost != 0) {  g.drawString(String.valueOf(pathCost), x+ (squareLength /4), y + (squareLength/3));}

                if (pathScore != 0) { g.drawString(String.valueOf(pathScore), x+ ((squareLength /4)*2), y + ((squareLength/3)*2));}


            }
        }
    }

    private Color getColour(Node n) {

        // Priority of colouring, some nodes can return positive for multiple statements
        Color result = Color.WHITE;

        if (n.get_squareType() == SquareType.WALL) {
            result = Color.GRAY;
        }

        if (n.is_searched()) {
            result = Color.LIGHT_GRAY;
        }

        if (n.is_frontier()) {
            result = Color.CYAN;
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
