package edu.up.cs301.mahjong;

import java.util.ArrayList;
import java.util.Collections;

public class mWall {

    private ArrayList<mTiles> wall;

    public mWall() {

        wall = new ArrayList<mTiles>();
        for (int i = 0; i < 9; i++) {
            //Bamboo suit 4 of one value made at a time 1-9 (mTiles[0-31])
            wall.add(4 * i, new mTiles(i + 1, "Bamboo"));
            wall.add(4 * i + 1, new mTiles(i + 1, "Bamboo"));
            wall.add(4 * i + 2, new mTiles(i + 1, "Bamboo"));
            wall.add(4 * i + 3, new mTiles(i + 1, "Bamboo"));
            //Characters suit 4 of one value made at a time 1-9 (mTiles[36-71])
        }
        for (int i = 0; i < 9; i++) {
            wall.add(4 * i + 36, new mTiles(i + 1, "Characters"));
            wall.add(4 * i + 37, new mTiles(i + 1, "Characters"));
            wall.add(4 * i + 38, new mTiles(i + 1, "Characters"));
            wall.add(4 * i + 39, new mTiles(i + 1, "Characters"));
        }
        for (int i = 0; i < 9; i++) {
            //Dots suit 4 of one value made at a time 1-9 (mTiles[72-107])
            wall.add(4 * i + 72, new mTiles(i + 1, "Dots"));
            wall.add(4 * i + 73, new mTiles(i + 1, "Dots"));
            wall.add(4 * i + 74, new mTiles(i + 1, "Dots"));
            wall.add(4 * i + 75, new mTiles(i + 1, "Dots"));
        }
        Collections.shuffle(wall);
        }

        public mWall(mWall in)
        {
            wall = new ArrayList<mTiles> ();
            for(int i = 0; i < in.wall.size(); i++)
            {
                int val = in.getWall().get(i).getValue();
                String str = in.getWall().get(i).getSuit();
                wall.add(i, new mTiles (val, str));
            }
        }



    public ArrayList<mTiles> getWall() {
        return wall;
    }

    public void setWall(ArrayList<mTiles>in){
        this.wall = in;
    }

    public int size(){
        return wall.size();
    }

    public mTiles remove(int index){
        return wall.remove(index);
    }

}

//initialized the first 108 tiles, 4 of each tile of each suit


//Values of wind : 0 - west, 1 - south, 2 - east, 3 - north
//Winds suit 4 of one wind made on each loop (mTiles[108-123])
        /*
        for (int j = 0; j < 4; j++) {
            wall.add(4 * j + 108, new mTiles(j + 1, "Winds"));
            wall.add(4 * j + 109, new mTiles(j + 1, "Winds"));
            wall.add(4 * j + 110, new mTiles(j + 1, "Winds"));
            wall.add(4 * j + 111, new mTiles(j + 1, "Winds"));
        }
        for (int j = 0; j < 4; j++) {
            if (j != 3) {
                //value of dragon : 0 - red dragon, 1 - green dragon, 2 - white dragon
                //Dragons suit 4 of one dragon made on each loop (mTiles[124-135])
                wall.add(4 * j + 124, new mTiles(j + 1, "Dragon"));
                wall.add(4 * j + 125, new mTiles(j + 1, "Dragon"));
                wall.add(4 * j + 126, new mTiles(j + 1, "Dragon"));
                wall.add(4 * j + 127, new mTiles(j + 1, "Dragon"));
            }
        }
        /*
        for (int j = 0; j < 4; j++) {
            //Flower and season tiles one of each value and suit made (mTiles[136-143])
            wall.add(j + 136, new mTiles(j + 1, "Flower"));
            wall.add(j + 140, new mTiles(j + 1, "Season"));
        }
        */

        /*
        External Citation:
        Problem: Shuffling and randomizing the Wall
        Source: https://www.geeksforgeeks.org/collections-shuffle-java-examples/
        Solution: use Collection.shuffle(object);
         */