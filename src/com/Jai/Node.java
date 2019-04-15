package com.Jai;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

    private State _state;
    private Node _parent;
    private Direction _action;
    private Node[] _edges;
    private boolean _searched;

    public Node(State state) {
        _state = state;
        _parent = null;
        _action = Direction.NONE;
    }

    public ArrayList<Direction> get_path() {
        Node parent = this;
        ArrayList<Direction> path = new ArrayList<>();

        while (parent!= null){

            path.add(parent._action);

            parent = parent.get_parent();

        }

        path.remove(path.size() -1);

        Collections.reverse(path);
        return path;
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

    public void set_squareType(SquareType st){
        _state.set_squareType(st);
    }

    public SquareType get_squareType() {
        return _state.get_squareType();
    }

    public boolean is_searched() {
        return _searched;
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

    public int get_pathCost() {
        return _state.get_pathCost();
    }
}
