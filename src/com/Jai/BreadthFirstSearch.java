package com.Jai;

import java.util.ArrayList;

public class BreadthFirstSearch extends Search {


    public BreadthFirstSearch(Node root, Node[][] nodes) {
        super(root, nodes);
    }

    @Override
    public Node BeginSearch() {

        Node current = null;
        Node currentEdge = null;
        Node[] currentEdges = null;

        while(!_frontier.isEmpty()) {

            current = _frontier.pollFirst();
            current.set_searched(true);

            if (current.get_squareType() == SquareType.GOAL) {
                return current;
            }

            currentEdges = current.get_edges();

            // Edges default to standard order
            for (int i = 0; i < currentEdges.length ; i++) {
                currentEdge = currentEdges[i];

                if (currentEdge != null && !currentEdge.is_searched()) {

                    currentEdge.set_searched(true);
                    currentEdge.set_parent(current);
                    currentEdge.set_action(_defaultOrder[i]);

                    _frontier.add(currentEdge);
                }
            }
        }

        return null;
    }

    @Override
    public void addNextNodesToFrontier() {

    }
}
