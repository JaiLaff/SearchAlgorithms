package com.Jai;

public class UniformCostSearch extends Search {

    public UniformCostSearch(Node root, Node[][] nodes, Agent agent, int[] stepCosts) {
        super(root, nodes, agent, stepCosts);
    }

    public void insertNodeToFrontier(Node n) {

        // Similar to A*
        // No Heuristic
        for( int i = 0; i < _frontier.size() -1; i++) {



            if (n.get_pathScore() <= _frontier.get(i).get_pathScore()) {
                _frontier.add(i, n);
                return;
            }
        }

        _frontier.add(n);
    }

    @Override
    public void addEdgesToFrontier(Node[] edges) {
        for (int i = 0; i < edges.length; i++) {

            _currentEdge = edges[i];


            if (_currentEdge != null && !_currentEdge.is_searched()) {
                _currentEdge.set_parent(_current);

                _currentEdge.set_action(_defaultOrder[i]);

                //Gives direction (i) in order to figure out step costs;
                _currentEdge.set_PathScore(_stepCosts, i);

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
