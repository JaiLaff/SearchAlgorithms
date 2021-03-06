package com.Jai;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

    private State _state;
    private Node _parent;
    private Direction _action;
    private Node[] _edges;
    private boolean _searched;
    private boolean _isFrontier;
    private boolean _isCurrent;
    private int _pathCost;

    public Node(State state) {
        _state = state;
        _parent = null;
        _action = Direction.NONE;
        _pathCost = 0;
    }

    public ArrayList<Direction> get_path() {
        Node n = this;
        ArrayList<Direction> path = new ArrayList<>();

        while (n != null) {

            path.add(n._action);

            n = n.get_parent();

        }

        path.remove(path.size() - 1);

        Collections.reverse(path);
        return path;
    }

    public int ManhattanDistanceToNode(Node n) {
        int result = Integer.MAX_VALUE;
        int x = this.get_x();
        int y = this.get_y();

        result = ((Math.abs(x - n.get_x())) + (Math.abs(y - n.get_y())));

        return result;
    }

    public int ManhattanDistanceToNearestGoal(ArrayList<Node> goals) {
        int result = Integer.MAX_VALUE;

        // Using manhattan distance to find distance to CLOSEST GOAL
        for (Node goal : goals) {
            int dist = ManhattanDistanceToNode(goal);
            if (dist < result) {
                result = dist;
            }
        }

        return result;
    }

    public void set_edges(Node[] edges) {
        _edges = edges;
    }

    public Node[] get_edges() {
        return _edges;
    }

    public int get_x() {
        return _state.get_x();
    }

    public int get_y() {
        return _state.get_y();
    }

    public void set_squareType(SquareType st) {
        _state.set_squareType(st);
    }

    public SquareType get_squareType() {
        return _state.get_squareType();
    }

    public boolean is_searched() {
        return _searched;
    }

    public boolean is_frontier() {
        return _isFrontier;
    }

    public void set_frontier(boolean frontier) {
        _isFrontier = frontier;
    }

    public void set_searched(boolean _searched) {
        this._searched = _searched;
    }

    public Node get_parent() {
        return this._parent;
    }

    public void set_parent(Node _parent) {
        this._parent = _parent;
    }

    public Direction get_action() {
        return _action;
    }

    public void set_action(Direction _action) {
        this._action = _action;
    }

    public void set_pathHeuristic(int pathHeuristic) {
        _state.set_pathHeuristic(pathHeuristic);
    }

    public void set_pathHeuristic(ArrayList<Node> goals) {
        set_pathHeuristic(ManhattanDistanceToNearestGoal(goals));
    }

    public int get_pathHeuristic() {
        return _state.get_pathHeuristic();
    }

    public int get_pathCost() {
        return _pathCost;
    }

    public void set_PathCost(int[] stepcosts, int i) {
        _pathCost = stepcosts[i];
    }

    public void set_PathCost(int pathCost) {
        _pathCost = pathCost;
    }

    public void incrementPathCost(int[] stepcosts, int i) {
        // Add to the cost to allow different weighted decisions
        _pathCost += stepcosts[i];
    }

    public boolean is_isCurrent() {
        return _isCurrent;
    }

    public void set_isCurrent(boolean _isCurrent) {
        this._isCurrent = _isCurrent;
    }

    public int get_totalPathScore() {
        return get_pathCost() + get_pathHeuristic();
    }
}
