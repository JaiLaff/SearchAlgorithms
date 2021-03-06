package com.Jai;

public class GreedyBestFirstSearch extends Search {


    public GreedyBestFirstSearch(Node root, Node[][] nodes, Agent agent, int[] stepcosts) {
        super(root, nodes, agent, stepcosts);
    }


    public void insertNodeToFrontier(Node n) {

        // Insertion based on heuristic values

        for (int i = 0; i < _frontier.size()-1; i++) {

            if (n.get_pathHeuristic() <= _frontier.get(i).get_pathHeuristic()) {
                _frontier.add(i, n);
                return;
            }

            // Should heuristics equal, use default order to prioritise
            if (n.get_pathHeuristic() == _frontier.get(i).get_pathHeuristic()) {
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

                insertNodeToFrontier(_currentEdge);

            }
        }
    }
}
