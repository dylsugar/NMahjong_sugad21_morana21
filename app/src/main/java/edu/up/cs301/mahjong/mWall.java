package edu.up.cs301.mahjong;

import java.util.ArrayList;
import java.util.Collections;

public class mWall {

    private ArrayList<mTiles> wall;

    public mWall() {

        wall = new ArrayList<mTiles>();
        String suit = "default";

        for (int i = 0; i < 4; i++) { //changes amount of cards based on amount of players
            if (i == 0) {
                suit = "Dots";
            } else if (i == 1) {
                suit = "Character";
            } else if (i == 2) {
                suit = "Bamboo";
            }
            for (int j = 0; j < 13; j++) { //each suit has 13 cards
                mTiles tile = new mTiles(j, suit);
                wall.add(tile);
            }
        }
        Collections.shuffle(wall);
    }

    public ArrayList<mTiles> getDeck() {
        return wall;
    }

    public int size(){
        return wall.size();
    }

    public mTiles remove(int index){
        return wall.remove(index);
    }

}
