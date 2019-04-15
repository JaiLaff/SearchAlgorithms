package com.Jai;

public class Main {


    public static void main(String[] args) {

		if(args.length < 2){
			System.out.println("ERROR: incorrect number of arguments");
			System.out.println("USAGE: SearchAlgorithms.jar filename search-type");
			return;
		}

		SearchType st;

		switch (args[1]){
			case "depth-first": st = SearchType.DEPTH; break;
			case "breadth-first": st = SearchType.BREADTH; break;
			case "greedy-best": st = SearchType.GREEDY; break;
			default: st = null;
		}

		if (st == null){
			System.out.println("ERROR: Unknown Search Type");
			System.out.println("Available Search Types:");
			System.out.println("\tdepth-first");
			System.out.println("\tbreadth-first");
			System.out.println("\tgreedy-best");
			System.out.println("\ta-star");
			return;
		}

	    Environment env = new Environment(args[0], st);
	    Agent agent = env.get_agent();
	    env.PrintEnvironment();

	    if (agent.Search()) {
	    	env.AddPath();
	    	env.PrintEnvironment();
		}
    }
}
