package com.Jai;

public enum SearchType {
    DEPTH,BREADTH,GREEDY,ASTAR, UCS;

    public String get_longSearchType() {
        switch (this) {
            case DEPTH: return "Depth-First-Search";
            case BREADTH: return "Breadth-First-Search";
            case GREEDY: return "Greedy-Best-First-Search";
            case ASTAR: return "A-Star";
            case UCS: return "Uniform-Cost-Search";
            default: return "error";
        }
    }
}
