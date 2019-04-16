package com.Jai;

public class AStarSearch extends Search {


    public AStarSearch(Node root, Node[][] nodes) {
        super(root, nodes);
    }

    public int pathScore(Node n) {
        Node node = n;
        int result  = 0;

        while (node != null) {
            result += node.get_pathCost();
            node = node.get_parent();
        }

        return result;
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
                _currentEdge.set_pathCost(pathScore(_currentEdge));

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
