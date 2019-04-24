package com.Jai;

public class AStarSearch extends Search {


    public AStarSearch(Node root, Node[][] nodes, Agent agent, int[] stepCosts) {
        super(root, nodes, agent, stepCosts);
    }

    public void insertNodeToFrontier(Node n) {

        for (int i = 0; i < _frontier.size() - 1; i++) {


            if (n.get_totalPathScore() < _frontier.get(i).get_totalPathScore()) {
                _frontier.add(i, n);
                return;
            }

            if (n.get_totalPathScore() == _frontier.get(i).get_totalPathScore()) {
                int j = i;

                do {
                    if (n.get_action().ordinal() < _frontier.get(j + 1).get_action().ordinal()) {
                        _frontier.add(j + 1, n);
                        return;
                    }

                    j++;

                } while (n.get_totalPathScore() == _frontier.get(j).get_totalPathScore() && j <= _frontier.size());

                _frontier.add(n);
                return;
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
                //Gives direction (i) in order to figure out step costs;
                _currentEdge.incrementPathScore(_stepCosts, i);

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
