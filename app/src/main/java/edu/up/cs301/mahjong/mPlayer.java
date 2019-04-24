package edu.up.cs301.mahjong;

import java.io.Serializable;
import java.util.ArrayList;

public class mPlayer implements Serializable {

        /*
        Instant variables that define a player
         */
        private int position;
        private ArrayList<mTiles> hand;
        private String handType;
        private int score;
        private ArrayList<mTiles> discardHand;


        /*
        constructor for a player, each player is initially defaulted with this.
         */
        public mPlayer()
        {
            hand = new ArrayList <mTiles> ();
        }
        public mPlayer(int inPosition, ArrayList<mTiles> ownTiles) {

            position = inPosition;
            hand = ownTiles;
            handType = "";
            score = 0;
            discardHand = new ArrayList<mTiles>();

        }

        //returns player X's position (0-3)
        public int getPosition() {
            return this.position;
        }

        /*
        returns player X's hand as an array
         */
        public ArrayList<mTiles> getHand() {

            return this.hand;
        }

        /*
        takes in a players hand and sets it to the current hand for GameState
         */
        public void setHand(ArrayList<mTiles> currentHand) {
            hand = currentHand;
        }

        /*
        adds a single tile to a players hand
         */
        public void addTiletoHand(mTiles in){
            hand.add(in);
        }

        /*
        removes a tile from the players hand.
         */
        public void removeTile(mTiles out){

            hand.remove(out);

        }

}
