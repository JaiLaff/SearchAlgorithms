package com.Jai;

import java.util.ArrayList;

public class Solution {

    Node node;
    ArrayList<Direction> path;
    long elapsedTime;
    int expandedNodes;
    boolean validSolution;
    boolean error;


    public Solution(Node n, ArrayList<Direction> path, long time, int expandedNodes, boolean validSolution) {
        this.node = n;
        this.path = path;
        this.elapsedTime = time;
        this.expandedNodes = expandedNodes;
        this.validSolution = validSolution;
    }

    public Solution(boolean validSolution) {
        this.validSolution = validSolution;
    }

}
