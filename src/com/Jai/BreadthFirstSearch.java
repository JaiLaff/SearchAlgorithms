package com.Jai;

public class BreadthFirstSearch extends Search {


    public BreadthFirstSearch(Node root, Node[][] nodes, Agent agent) {
        super(root, nodes, agent);
    }

    @Override
    public void addEdgesToFrontier(Node[] edges) {
        // Edges default to standard order
        for (int i = 0; i < _currentEdges.length ; i++) {
            _currentEdge = edges[i];

            if (_currentEdge != null && !_currentEdge.is_searched()) {

                _currentEdge.set_searched(true);
                _currentEdge.set_parent(_current);
                _currentEdge.set_action(_defaultOrder[i]);

                _frontier.add(_currentEdge);
            }
        }
    }
}
