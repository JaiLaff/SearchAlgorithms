package com.Jai;


public class Main {

    public static void main(String[] args) {

        int sleepTimeInMillis = 0;

        if (args.length < 2) {
            System.out.println("ERROR: incorrect number of arguments");
            System.out.println("USAGE: SearchAlgorithms.jar inputFile searchMethod sleepTime(ms)");
            return;
        }

        SearchType st;

        switch (args[1]) {
            case "depth-first":
                st = SearchType.DEPTH;
                break;
            case "breadth-first":
                st = SearchType.BREADTH;
                break;
            case "greedy-best":
                st = SearchType.GREEDY;
                break;
            case "a-star":
                st = SearchType.ASTAR;
                break;
            case "uniform-cost":
                st = SearchType.UCS;
                break;
            case "id-a-star":
                st = SearchType.IDA;
                break;
            default:
                st = null;
        }

        if (st == null) {
            System.out.println("ERROR: Unknown Search Type");
            System.out.println("Available Search Types Arguments:");
            System.out.println("\tdepth-first");
            System.out.println("\tbreadth-first");
            System.out.println("\tgreedy-best");
            System.out.println("\ta-star");
            System.out.println("\tuniform-cost");
            System.out.println("\tid-a-star");

            return;
        }

        Environment env = new Environment(args[0], st);
        Agent agent = env.get_agent();

        if (args.length == 3) {
            try {
                sleepTimeInMillis = Integer.parseInt(args[2]);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error parsing sleep time - Continuing with no sleep");
            }
        }

        try {

            Solution soln = agent.Search(sleepTimeInMillis);

            System.out.print(String.format("%s %s", args[0], st.get_longSearchType()));

            if (soln.validSolution == true) {
                env.AddPath(soln);
                env.vc.update(env.get_nodes());

                System.out.print(String.format(" %d %dms\n", soln.expandedNodes, soln.elapsedTime/1000000));


                System.out.println(soln.path);

            } else if (soln.error != true) {
                System.out.print(" No Solution Found\n");

            } else {
                System.out.println("\nUncaught Critical Error");

            }
        } catch (Exception e) {
            System.out.println("Search Failed - Exception Caught");
            e.printStackTrace();
        }
    }
}
