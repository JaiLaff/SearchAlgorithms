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
    private Agent _agent;

    public Search(Node root, Node[][] nodes, Agent agent) {
        _frontier = new LinkedList();
        _frontier.add(root);
        _nodes = nodes;
        _searchedNodes = 0;
        _current = null;
        _currentEdge = null;
        _currentEdges = null;
        _agent = agent;
    }

    public void updateUI() {
        _agent.updateUI(_nodes);
    }



    public Node BeginSearch() {

        while(!_frontier.isEmpty()){
            _current = _frontier.pollFirst();
            _current.set_searched(true);
            _current.set_frontier(false);
            _current.set_isCurrent(true);

            _searchedNodes++;

            if (_current.get_squareType() == SquareType.GOAL) {
                return _current;
            }

            _currentEdges = _current.get_edges();
            addEdgesToFrontier(_currentEdges);

            updateFrontier();

            updateUI();

            _current.set_isCurrent(false);
        }

        return null;
    }

    public void updateFrontier(){
        for (Node n : _frontier) {
           n.set_frontier(true);
        }
    }

    public abstract void addEdgesToFrontier(Node[] edges);

}
