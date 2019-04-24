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
    private int _pathScore;

    public Node(State state) {
        _state = state;
        _parent = null;
        _action = Direction.NONE;
        _pathScore = 0;
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

    public void set_pathCost(int pathCost) {
        _state.set_pathCost(pathCost);
    }

    public void set_pathCost(ArrayList<Node> goals) {
        set_pathCost(ManhattanDistanceToNearestGoal(goals));
    }

    public int get_pathCost() {
        return _state.get_pathCost();
    }

    public int get_pathScore() {
        return _pathScore;
    }

    public void set_PathScore(int[] stepcosts, int i) {
        _pathScore = stepcosts[i];
    }

    public void set_PathScore(int pathScore) {
        _pathScore = pathScore;
    }

    public void incrementPathScore(int[] stepcosts, int i) {
        _pathScore += stepcosts[i];
    }

    public boolean is_isCurrent() {
        return _isCurrent;
    }

    public void set_isCurrent(boolean _isCurrent) {
        this._isCurrent = _isCurrent;
    }

    public int get_totalPathScore() {
        int result;

        result = get_pathCost() + get_pathScore();


        return result;
    }
}
