package com.Jai;

public class Main {

    //TODO: Set up data structures for environment, wall, agent and goal.

    public static void main(String[] args) {
    	//TODO: Take in search strategy argument

		if(args.length < 1){
			System.out.println("ERROR: incorrect number of arguments");
			System.out.println("USAGE: SearchAlgorithms.jar filename search-type");
			return;
		}

	    Environment env = new Environment(args[0]);
	    Agent agent = env.get_agent();
	    env.PrintEnvironment();

	    if (agent.Search()) {
	    	env.AddPath();
	    	env.PrintEnvironment();
		}
    }
}
