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
    protected int[] _stepCosts;

    public Search(Node root, Node[][] nodes, Agent agent, int[] stepCosts) {
        _frontier = new LinkedList();
        _frontier.add(root);
        _nodes = nodes;
        _searchedNodes = 0;
        _current = null;
        _currentEdge = null;
        _currentEdges = null;
        _agent = agent;
        _stepCosts = stepCosts;
    }

    public void updateUI() {
        _agent.updateUI(_nodes);
    }


    public Node BeginSearch(int sleepTime) {

        //For basic iterative searches the actual search is the same.
        //Using a base search function allows us to customise the
        //addition of nodes to the frontier to change the method of searching.

        while (!_frontier.isEmpty()) {
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

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            _current.set_isCurrent(false);

            updateUI();

        }

        return null;
    }

    public void updateFrontier() {
        for (Node n : _frontier) {
            n.set_frontier(true);
        }
    }

    // Function that changes how the search traversed the frontier
    public abstract void addEdgesToFrontier(Node[] edges);

}
