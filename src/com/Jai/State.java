package com.Jai;

public class State {
    private int _x;
    private int _y;
    private SquareType _squareType;
    private int _pathHeuristic;

    public State(int x, int y, SquareType st) {
        _x = x;
        _y = y;
        _squareType = st;
    }

    public void set_squareType(SquareType st) {
        _squareType = st;
    }

    public SquareType get_squareType() {
        return _squareType;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_pathHeuristic(int _pathCost) {
        this._pathHeuristic = _pathCost;
    }

    public int get_pathHeuristic() {
        return _pathHeuristic;
    }
}
