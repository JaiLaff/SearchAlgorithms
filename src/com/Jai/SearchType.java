package com.Jai;

public enum SearchType {
    DEPTH,BREADTH,GREEDY,ASTAR, UCS, IDA;

    public String get_longSearchType() {
        switch (this) {
            case DEPTH: return "Depth-First-Search";
            case BREADTH: return "Breadth-First-Search";
            case GREEDY: return "Greedy-Best-First-Search";
            case ASTAR: return "A-Star";
            case UCS: return "Uniform-Cost-Search";
            case IDA: return "Iterative-Deepening-A-Star";
            default: return "error";
        }
    }
}
