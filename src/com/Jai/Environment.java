package com.Jai;
import java.io.*;
import java.util.Arrays;

public class Environment {

    private SquareType[][] _grid;
    private Agent _agent;

    public Environment(int w, int h) {
        Init(w,h);
    }

    public Environment(String filename){
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
                        _agent = new Agent(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));
                        break;
                    case 3:
                        String[] goals = newStr.split("[|]");

                        for (int i = 0; i < goals.length; i++){
                            String[] goalVals = goals[i].split(",");
                            _grid[Integer.parseInt(goalVals[0])][Integer.parseInt(goalVals[1])] = SquareType.GOAL;
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
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.deepToString(_grid));
    }

    private void Init(int w, int h){
        _grid = new SquareType[w][h];

        for (SquareType[] arrayOfYValues : _grid) {
            for (SquareType XValueInYValueArray : arrayOfYValues) {
                XValueInYValueArray = SquareType.BLANK;
            }
        }
    }

    public void AddWall(int x, int y, int w, int h){

        // for every value of x within wall bounds
        for (int i = x; i  < x + w; i++){
            // for every value of y within wall bounds
            for (int j = y; j < y + h; j ++){
                _grid[i][j] = SquareType.WALL;
            }
        }
    }

    public void AddGoal(int x, int y){
        _grid[x][y] = SquareType.GOAL;
    }

    public SquareType get_SquareType(int x, int y){
        return _grid[x][y];
    }

    public Agent get_agent(){
        return _agent;
    }


}
