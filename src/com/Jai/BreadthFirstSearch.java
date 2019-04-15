package com.Jai;

import java.util.ArrayList;

public class BreadthFirstSearch extends Search {


    public BreadthFirstSearch(Node root, Node[][] nodes) {
        super(root, nodes);
    }

    @Override
    public Node BeginSearch() {

        while(!_frontier.isEmpty()) {

            _current = _frontier.pollFirst();

            _searchedNodes++;

            _current.set_searched(true);

            if (_current.get_squareType() == SquareType.GOAL) {
                return _current;
            }

            _currentEdges = _current.get_edges();
            addEdgesToFrontier(_currentEdges);

        }

        return null;
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
