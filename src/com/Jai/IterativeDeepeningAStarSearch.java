package com.Jai;

public class IterativeDeepeningAStarSearch extends Search {

    private int sleepTime;

    public IterativeDeepeningAStarSearch(Node root, Node[][] nodes, Agent agent, int[] stepCosts) {
        super(root, nodes, agent, stepCosts);
    }

    public Node BeginSearch(int sleepTime) {

        this.sleepTime = sleepTime;

        Node root = _frontier.peekFirst();
        int threshold = root.get_pathHeuristic();

        IDAResult temp = new IDAResult(0, root, false);

        while (true) {

            temp.node.set_isCurrent(false);

            temp = Search(0, threshold);

            temp.node.set_isCurrent(true);

            if (temp.found) {
                reconstructPath();
                return temp.node;
            }

            if (temp.fValue == Integer.MAX_VALUE) {
                return null;
            }

            threshold = temp.fValue;

        }
    }

    public IDAResult Search(int g, int threshold) {
        Node node = _frontier.peekLast();

        int f = g + node.get_pathHeuristic();

        node.set_PathCost(f);

        if (f > threshold) {
            return new IDAResult(f, node, false);
        }
        if (node.get_squareType() == SquareType.GOAL) {
            return new IDAResult(f, node, true);
        }

        IDAResult min = new IDAResult(Integer.MAX_VALUE, null, false);


        for (int i = 0; i < node.get_edges().length; i++) {


            Node n = node.get_edges()[i];

            if (n != null && !_frontier.contains(n)) {

                _searchedNodes++;

                n.set_frontier(true);

                n.set_action(_defaultOrder[i]);

                _frontier.addLast(n);

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                updateUI();

                IDAResult temp = Search(g + _stepCosts[i], threshold);

                if (temp.found) {
                    return temp;
                }

                if (temp.fValue < min.fValue) {
                    min = temp;
                }

                n.set_frontier(false);

                _frontier.removeLast();
                updateUI();

            }

        }

        return min;
    }


    @Override
    public void addEdgesToFrontier(Node[] edges) {
        // unused
    }

    class IDAResult {
        int fValue;
        Node node;
        boolean found;

        IDAResult(int fvalue, Node node, boolean found) {
            this.fValue = fvalue;
            this.node = node;
            this.found = found;
        }
    }

    public void reconstructPath() {
        for (int i = _frontier.size() - 1; i > 0; i--) {
            _frontier.get(i).set_parent(_frontier.get(i - 1));
        }
    }
}
