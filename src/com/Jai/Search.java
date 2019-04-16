package com.Jai;

import java.util.LinkedList;

public abstract class Search {

    protected LinkedList<Node> _frontier;
    protected Node[][] _nodes;
    protected Direction[] _defaultOrder = {Direction.UP, Direction.LEFT, Direction.DOWN, Direction.RIGHT};
    protected int _searchedNodes;
    protected Node _current;
    protected Node _currentEdge;
    protected Node[] _currentEdges;

    public Search(Node root, Node[][] nodes) {
        _frontier = new LinkedList();
        _frontier.add(root);
        _nodes = nodes;
        _searchedNodes = 0;
        _current = null;
        _currentEdge = null;
        _currentEdges = null;
    }


    public Node BeginSearch() {

        while(!_frontier.isEmpty()){
            _current = _frontier.pollFirst();
            _current.set_searched(true);

            _searchedNodes++;

            if (_current.get_squareType() == SquareType.GOAL) {
                return _current;
            }

            _currentEdges = _current.get_edges();
            addEdgesToFrontier(_currentEdges);
        }

        return null;
    }

    public abstract void addEdgesToFrontier(Node[] edges);

}
