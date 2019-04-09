package com.Jai;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Agent {

    private int _initialX;
    private int _initialY;
    // private SearchType _searchType;
    private Node[][] _nodes;
    ArrayList<Direction> _solution;

    public Agent(int x, int y){
        _initialX = x;
        _initialY = y;
        //_searchType = searchType;
        _nodes = null;
        _solution = null;
    }

    public boolean Search() {
        //TODO: Need a switch depending on search type

        BreadthFirstSearch bfs = new BreadthFirstSearch(_nodes[_initialX][_initialY], _nodes);

        Node goal = bfs.BeginSearch();

        if (goal != null) {
            System.out.println(String.format("\nGoal found at: %d,%d!", goal.get_x(), goal.get_y()));
            System.out.println("Path from origin: ");
            _solution = goal.get_path();
            System.out.println(_solution);
            return true;
        } else {
            System.out.println("\nNo Solution Found");
            return false;
        }
    }

    public int get_x() {
        return _initialX;
    }

    public int get_y() {
        return _initialY;
    }

    public void set_nodes(Node[][] nodes){
        _nodes = nodes;
    }

    public ArrayList<Direction> get_solution() {
        return _solution;
    }

}
