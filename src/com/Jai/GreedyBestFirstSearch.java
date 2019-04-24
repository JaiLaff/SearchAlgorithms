package com.Jai;

public class GreedyBestFirstSearch extends Search {


    public GreedyBestFirstSearch(Node root, Node[][] nodes, Agent agent, int[] stepcosts) {
        super(root, nodes, agent, stepcosts );
    }


    public void insertNodeToFrontier(Node n) {

        for( int i = 0; i < _frontier.size(); i++) {

            if (n.get_pathCost() < _frontier.get(i).get_pathCost()) {
                _frontier.add(i, n);
                return;
            }

            if (n.get_pathCost() == _frontier.get(i).get_pathCost()) {
                if (n.get_action().ordinal() < _frontier.get(i).get_action().ordinal()) {
                    _frontier.add(i, n);
                    return;
                } else {
                    _frontier.add(i + 1, n);
                    return;
                }
            }
        }

        _frontier.add(n);
    }

    public void addEdgesToFrontier(Node[] edges) {
        for (int i = 0; i < edges.length; i++) {

            _currentEdge = edges[i];
            if (_currentEdge != null && !_currentEdge.is_searched()) {
                _currentEdge.set_parent(_current);
                _currentEdge.set_action(_defaultOrder[i]);

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
