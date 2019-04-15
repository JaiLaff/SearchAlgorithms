package com.Jai;

public class DepthFirstSearch extends Search {

    public DepthFirstSearch(Node root, Node[][]nodes) {
        super(root, nodes);
    }


    @Override
    public Node BeginSearch() {

        while(!_frontier.isEmpty()) {

            _current = _frontier.pollLast();

            if (!_current.is_searched()) {
                _current.set_searched(true);

                _searchedNodes++;

                if (_current.get_squareType() == SquareType.GOAL) {
                    return _current;
                }

                _currentEdges = _current.get_edges();
                addEdgesToFrontier(_currentEdges);
            }

        }
        return null;
    }

    public void addEdgesToFrontier(Node[] n) {
        for (int i = _defaultOrder.length - 1; i >= 0; i--) {
            _currentEdge = _currentEdges[i];

            if (_currentEdge != null && !_currentEdge.is_searched()) {

                _currentEdge.set_parent(_current);
                _currentEdge.set_action(_defaultOrder[i]);

                _frontier.add(_currentEdge);
            }
        }
    }

}
