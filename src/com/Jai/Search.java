package com.Jai;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public abstract class Search {

    protected Deque<Node> _frontier;
    protected Node[][] _nodes;
    protected Direction[] _defaultOrder = {Direction.UP, Direction.LEFT, Direction.DOWN, Direction.RIGHT};

    public Search(Node root, Node[][] nodes) {
        _frontier = new LinkedList();
        _frontier.add(root);
        _nodes = nodes;
    }


    public abstract Node BeginSearch();

    // Depending on the algorithm, different requirements exist for which nodes are to be added when
    public abstract void addNextNodesToFrontier();
}
