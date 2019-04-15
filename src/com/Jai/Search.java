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


    public abstract Node BeginSearch();

    public abstract void addEdgesToFrontier(Node[] edges);

}
