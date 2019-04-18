package com.Jai;

public class DepthFirstSearch extends Search {

    public DepthFirstSearch(Node root, Node[][]nodes, Agent agent) {
        super(root, nodes, agent);
    }

    public void addEdgesToFrontier(Node[] n) {
        for (int i = _defaultOrder.length - 1; i >= 0; i--) {
            _currentEdge = _currentEdges[i];

            if (_currentEdge != null && !_currentEdge.is_searched()) {

                _currentEdge.set_parent(_current);
                _currentEdge.set_action(_defaultOrder[i]);

                _frontier.addFirst(_currentEdge);
            }
        }
    }

}
