package com.Jai;

public class Agent {

    private int _initialX;
    private int _initialY;
    private SearchType _searchType;
    private Node[][] _nodes;
    ViewController viewController;
    private int[] _stepcosts;

    public Agent(int x, int y, SearchType st, int[] stepcosts) {
        _initialX = x;
        _initialY = y;
        _searchType = st;
        _nodes = null;
        _stepcosts = stepcosts;
    }

    public Agent(int x, int y, SearchType st) {
        this(x, y, st, new int[]{1, 1, 1, 1});
    }

    public Solution Search(int sleepTime) {

        Search search;

        switch (_searchType) {
            case DEPTH:
                search = new DepthFirstSearch(_nodes[_initialX][_initialY], _nodes, this, _stepcosts);
                break;
            case BREADTH:
                search = new BreadthFirstSearch(_nodes[_initialX][_initialY], _nodes, this, _stepcosts);
                break;
            case GREEDY:
                search = new GreedyBestFirstSearch(_nodes[_initialX][_initialY], _nodes, this, _stepcosts);
                break;
            case ASTAR:
                search = new AStarSearch(_nodes[_initialX][_initialY], _nodes, this, _stepcosts);
                break;
            case UCS:
                search = new UniformCostSearch(_nodes[_initialX][_initialY], _nodes, this, _stepcosts);
                break;
            case IDA:
                search = new IterativeDeepeningAStarSearch(_nodes[_initialX][_initialY], _nodes, this, _stepcosts);
                break;
            default:
                search = null;
        }

        Solution soln = new Solution(false);

        try {

            long startTime = System.nanoTime();

            Node goal = search.BeginSearch(sleepTime);

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;


            if (goal != null) {

                return new Solution(goal, goal.get_path(), elapsedTime, search._searchedNodes, true);
            } else {
                soln.error = true;
                return soln;
            }
        } catch (Exception e) {
            soln.error = true;
            return soln;
        }
    }

    public void updateUI(Node[][] nodes) {
        viewController.update(nodes);
    }

    public void set_ViewController(ViewController v) {
        this.viewController = v;
    }

    public int get_x() {
        return _initialX;
    }

    public int get_y() {
        return _initialY;
    }

    public void set_nodes(Node[][] nodes) {
        _nodes = nodes;
    }

}
