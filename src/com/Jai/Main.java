package com.Jai;

public class Main {

    //TODO: Set up data structures for environment, wall, agent and goal.

    public static void main(String[] args) {
	    Environment env = new Environment("input.txt");
	    Agent agent = env.get_agent();
	    env.PrintEnvironment();
    }
}
