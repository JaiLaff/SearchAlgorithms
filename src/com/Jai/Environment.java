package com.Jai;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Environment {

    private Node[][] _grid;
    private Agent _agent;
    private int _w,_h;

    public Environment(String filename, SearchType st){

        // Constructor reads file - could probably put in another method
        try{
            String thisLine = "";
            int lineNumber = 1;
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((thisLine = br.readLine()) != null) {

                String newStr = thisLine.replaceAll("[\\(\\)\\[\\]]", "");
                String[] vals = newStr.split(",");

                switch(lineNumber){
                    case 1:
                        Init(Integer.parseInt(vals[1]), Integer.parseInt(vals[0]));
                        break;
                    case 2:
                        _agent = new Agent(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]),st);
                        break;
                    case 3:
                        String[] goals = newStr.split("[|]");

                        for (int i = 0; i < goals.length; i++){
                            String[] goalVals = goals[i].split(",");

                            int gridX = Integer.parseInt(goalVals[0]);
                            int gridY = Integer.parseInt(goalVals[1]);

                            _grid[gridX][gridY].set_squareType(SquareType.GOAL);
                        }
                        break;
                    default:
                        int[] wallVals = new int[vals.length];

                        for (int i = 0; i < vals.length; i++) {
                            wallVals[i] = Integer.parseInt(vals[i]);
                        }

                        AddWall(wallVals[0], wallVals[1], wallVals[2], wallVals[3]);
                        break;

                }
                lineNumber ++;
            }

            _grid[_agent.get_x()][_agent.get_y()].set_squareType(SquareType.AGNT);

            addNodeEdges();

            _agent.set_nodes(_grid);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates entirely empty 2d space with nodes.
    private void Init(int w, int h){
        _w = w;
        _h = h;
        _grid = new Node[w][h];

        for (int x = 0; x < _grid.length; x ++) {
            for (int y = 0; y < _grid[x].length; y++) {
                _grid[x][y] = new Node(new State(x,y, SquareType.BLNK));
            }
        }

    }

    private void addNodeEdges() {
        Node n;
        for (int x = 0; x < _grid.length; x ++) {
            for (int y = 0; y < _grid[x].length; y++) {
                n = _grid[x][y];
                Node[] edges = {null,null,null,null};

                // {UP,LEFT,DOWN,RIGHT}
                if (y > 0 && _grid[x][y-1].get_squareType() != SquareType.WALL) {edges[0] = _grid[x][y-1];}
                if (x > 0 && _grid[x-1][y].get_squareType() != SquareType.WALL) {edges[1] = _grid[x-1][y];}
                if (y < _h -1 && _grid[x][y+1].get_squareType() != SquareType.WALL) {edges[2] = _grid[x][y+1];}
                if (x < _w -1 && _grid[x+1][y].get_squareType() != SquareType.WALL) {edges[3] = _grid[x+1][y];}

                n.set_edges(edges);
            }
        }
    }

    private void AddWall(int x, int y, int w, int h){

        // for every value of x within wall bounds
        for (int i = x; i  < x + w; i++){
            // for every value of y within wall bounds
            for (int j = y; j < y + h; j ++){
                _grid[i][j].set_squareType(SquareType.WALL);
            }
        }
    }

    public Agent get_agent(){
        return _agent;
    }



    public void PrintEnvironment(){
        System.out.println("\nCurrent Environment:");

        for (int y = 0; y < _h; y++){
            System.out.print("[");

            for (int x = 0; x < _w-1; x++){
                System.out.print(_grid[x][y].get_squareType() + " ");
            }

            System.out.print(_grid[_w-1][y].get_squareType());
            System.out.print("]\n");
        }
    }

    public void AddPath() {
        int x = _agent.get_x();
        int y = _agent.get_y();

        for (Direction d : _agent.get_solution()) {
            switch (d) {
                case RIGHT:
                    x++;
                    break;

                case LEFT:
                    x--;
                    break;

                case UP:
                    y--;
                    break;

                case DOWN:
                    y++;
                    break;
                default:
                    break;
            }
            _grid[x][y].set_squareType(SquareType.PATH);

        }

        _grid[x][y].set_squareType(SquareType.GOAL);
    }


}
