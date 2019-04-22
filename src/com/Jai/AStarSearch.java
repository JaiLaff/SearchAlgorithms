package com.Jai;

public class AStarSearch extends Search {


    public AStarSearch(Node root, Node[][] nodes, Agent agent) {
        super(root, nodes, agent);
    }

    public int pathScore(Node n) {
        int result;

        n.set_pathCost(n.get_pathCost() + n.get_pathScore());

        result = n.get_pathCost();


        return result;
    }

    public void insertNodeToFrontier(Node n) {

        for( int i = 0; i < _frontier.size() -1; i++) {

            if (n.get_pathCost() < _frontier.get(i).get_pathCost()) {
                _frontier.add(i, n);
                return;
            }

            if (n.get_pathCost() == _frontier.get(i).get_pathCost()) {
                int j = i;

                do {
                    if (n.get_pathCost() < _frontier.get(j+1).get_pathCost()) {
                        _frontier.add(j+1, n);
                        return;
                    }

                    j++;

                }while (j < _frontier.size() -1);

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
                _currentEdge.incrementPathScore();

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
