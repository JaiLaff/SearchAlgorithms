package com.Jai;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Agent {

    private int _initialX;
    private int _initialY;
    private SearchType _searchType;
    private Node[][] _nodes;
    ArrayList<Direction> _solution;

    public Agent(int x, int y, SearchType st){
        _initialX = x;
        _initialY = y;
        _searchType = st;
        _nodes = null;
        _solution = null;
    }

    public boolean Search() {

        Search search;

        switch(_searchType){
            case DEPTH:
                search = new DepthFirstSearch(_nodes[_initialX][_initialY], _nodes);
                break;
            case BREADTH:
                search = new BreadthFirstSearch(_nodes[_initialX][_initialY], _nodes);
                break;
            default:
                search = null;
        }

        try {
            Node goal = search.BeginSearch();

            if (goal != null) {
                System.out.println(String.format("\nGoal found at: %d,%d in %d expansions", goal.get_x(), goal.get_y(), search._searchedNodes));
                System.out.println("Path from origin: ");
                _solution = goal.get_path();
                System.out.println(_solution);
                return true;
            } else {
                System.out.println("\nNo Solution Found");
                return false;
            }
        } catch(Exception e){
            System.out.println("Search Failed");
            System.out.println("It is possible the search type does not currently exist");
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
