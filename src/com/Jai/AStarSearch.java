package com.Jai;

public class AStarSearch extends Search {


    public AStarSearch(Node root, Node[][] nodes, Agent agent, int[] stepCosts) {
        super(root, nodes, agent, stepCosts);
    }

    public void insertNodeToFrontier(Node n) {

        for (int i = 0; i < _frontier.size() - 1; i++) {

            int ftotalScore = _frontier.get(i).get_totalPathScore();
            int ntotalScore = n.get_totalPathScore();


            if (ntotalScore < ftotalScore) {
                _frontier.add(i, n);
                return;
            }

            if (ntotalScore == ftotalScore) {
                if (n.get_action().ordinal() < _frontier.get(i).get_action().ordinal()) {
                    _frontier.add(i, n);
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
                //Gives direction (i) in order to figure out step costs;
                _currentEdge.incrementPathCost(_stepCosts, i);

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
