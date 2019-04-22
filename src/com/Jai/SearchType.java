package com.Jai;

public enum SearchType {
    DEPTH,BREADTH,GREEDY,ASTAR;

    public String get_longSearchType() {
        switch (this) {
            case DEPTH: return "Depth First Search";
            case BREADTH: return "Breadth First Search";
            case GREEDY: return "Greedy Best First Search";
            case ASTAR: return "A Star";
            default: return "error";
        }
    }
}
