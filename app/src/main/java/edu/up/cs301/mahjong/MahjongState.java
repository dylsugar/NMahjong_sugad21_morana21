package edu.up.cs301.mahjong;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.game.infoMsg.GameState;


public class MahjongState extends GameState implements Serializable {

    private static final long serialVersionUID = 9100119201923L;
    /*
    Instant variables for the GameState.
    Players, wall, tiles of each player,
    discard tiles, the most recently discarded tile declared
     */

    private ArrayList<mPlayer> gamePlayers;
    private mWall wall;
    private ArrayList<mTiles> playerTiles;
    private ArrayList<mTiles> discardTiles;
    private mTiles recentDiscard;
    private int turn;
    private int lastTurn;

    public MahjongState() {

        //initialize values for each instance variable
        gamePlayers =new ArrayList<mPlayer>();
        wall = new mWall ();
        discardTiles =new ArrayList<mTiles>();
        turn =0;
        lastTurn =0;
        recentDiscard = null;

        /*
        players are initialized
        constructor is called and initialized with their
        position and empty array list of tiles
        */
        mPlayer EastPlayer = new mPlayer(0, new ArrayList<mTiles>());
        mPlayer NorthPlayer = new mPlayer(1, new ArrayList<mTiles>());
        mPlayer WestPlayer = new mPlayer(2, new ArrayList<mTiles>());
        mPlayer SouthPlayer = new mPlayer(3, new ArrayList<mTiles>());

        /*
        initialized players are added to the gamePlayers arrayList
         */
        gamePlayers.add(EastPlayer);
        gamePlayers.add(NorthPlayer);
        gamePlayers.add(WestPlayer);
        gamePlayers.add(SouthPlayer);

        /*
        each player is set with a hand is initialized
        using separate methods of initHand#. We tried to
        do nested for-loops for the the hand initialization,
        but errors were given.
         */
        EastPlayer.setHand(initHand0());
        NorthPlayer.setHand(initHand1());
        WestPlayer.setHand(initHand2());
        SouthPlayer.setHand(initHand3());


    }

    /*
    Copy Constructor to save current state of game as a copy, so original
    isn't used for instance variables
     */
    /*
    External Citation:
    Problem: Adding player of collection to currrent game players
    Source: Used example of Pig State we did in lab
    Solution: use the add method already implemented with arrayLists
     */
    public MahjongState(MahjongState in) {

        super();

        this.gamePlayers = new ArrayList<mPlayer>();
        this.setRecentDiscard(in.getRecentDiscard());
        this.discardTiles = new ArrayList<mTiles>();
        this.setTurn(in.getTurn());
        this.setLastTurn(in.getLastTurn());
        this.setWall(new mWall());
        this.getWall().getWall().clear();

        for (int i = 0; i < in.getGamePlayers().size(); i++) {
            this.getGamePlayers().add(new mPlayer());
            this.getGamePlayers().get(i).setPosition(in.getGamePlayers().get(i).getPosition());

            for (int j = 0; j < in.getGamePlayers().get(i).getHand().size(); j++) {

                this.getGamePlayers().get(i).getHand().add(new mTiles(
                        in.getGamePlayers().get(i).getHand().get(j).getValue(),
                        in.getGamePlayers().get(i).getHand().get(j).getSuit()));
            }
        }

        for (int i = 0; i < in.getDiscardTiles().size(); i++) {
            this.getDiscardTiles().add(new mTiles(
                    in.getDiscardTiles().get(i).getValue(),
                    in.getDiscardTiles().get(i).getSuit()));
        }

        for (int i = 0; i < in.getWall().getWall().size(); i++) {
            this.getWall().getWall().add(new mTiles(
                    in.getWall().getWall().get(i).getValue(),
                    in.getWall().getWall().get(i).getSuit()));

        }
    }

    /**
     * Initializes the hand of the first player and return
     * the array created.
     *
     * Accesses the first 14 tiles
     */
    public ArrayList<mTiles> initHand0() {

        for (int i = 0; i < 14; i++) {
            gamePlayers.get(0).addTiletoHand(wall.getWall().get(i));
            wall.getWall().remove(wall.getWall().get(i));
            gamePlayers.get(0).setHand(gamePlayers.get(0).getHand());
        }
        return gamePlayers.get(0).getHand();
    }

    /**
     * Initializes the hand of the first player and return
     * the array created.
     *
     * Accesses the next 13 tiles
     */
    public ArrayList<mTiles> initHand1() {
        for (int j = 14; j < 27; j++) {
            gamePlayers.get(1).addTiletoHand(wall.getWall().get(j));
            wall.getWall().remove(wall.getWall().get(j));

            gamePlayers.get(1).setHand(gamePlayers.get(1).getHand());

        }
        return gamePlayers.get(1).getHand();
    }


    /**
     * Initializes the hand of the first player and return
     * the array created.
     *
     * Accesses the next 13 tiles
     */
    public ArrayList<mTiles> initHand2() {
        for (int k = 27; k < 40; k++) {
            gamePlayers.get(2).addTiletoHand(wall.getWall().get(k));
            wall.getWall().remove(wall.getWall().get(k));

            gamePlayers.get(2).setHand(gamePlayers.get(2).getHand());

        }
        return gamePlayers.get(2).getHand();
    }


    /**
     * Initializes the hand of the first player and return
     * the array created.
     *
     * Accesses the next 13 tiles
     */
    public ArrayList<mTiles> initHand3() {
        for (int l = 40; l < 53; l++) {
            gamePlayers.get(3).addTiletoHand(wall.getWall().get(l));
            wall.getWall().remove(wall.getWall().get(l));

            gamePlayers.get(3).setHand(gamePlayers.get(3).getHand());

        }
        setWall(getWall());
        return gamePlayers.get(3).getHand();
    }

    public mTiles getRecentDiscard() {
        return recentDiscard;
    }

    synchronized public ArrayList<mPlayer> getGamePlayers() {
        return gamePlayers;
    }

    synchronized public mWall getWall() {
        return wall;
    }

    public ArrayList<mTiles> getPlayerTiles() {

        return playerTiles;
    }

    public ArrayList<mTiles> getDiscardTiles() {
        return discardTiles;
    }

    public int getTurn() {
        return turn;
    }

    public int getLastTurn() {
        return lastTurn;
    }

    public void setWall(mWall inWall) {
        this.wall = inWall;
    }

    public void setLastTurn(int lTurn) { this.lastTurn = lTurn; }

    public void setTurn(int inTurn) {
        this.turn = inTurn;
    }

    public void setRecentDiscard(mTiles inMTile) {
        this.recentDiscard = inMTile;
    }

    /**
     * if the image of the draw tile is selected, then a tile from the wall array will
     * be accessed and this new tile will be added into the array of X player and removed from
     * he wall
     *
     * @param drawnTile
     * @param position
     * @return
     */
    public boolean drawFromWall(mTiles drawnTile, int position) {

        if (!(currentTurn(this.getGamePlayers().get(position)))) {
            return false;
        }
        this.getGamePlayers().get(position).addTiletoHand(drawnTile);
        wall.getWall().remove(drawnTile);


        return true;
    }

    public boolean currentTurn(mPlayer cTurn) {
        if (getTurn() == cTurn.getPosition()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param pTurn
     * @return
     */
    public boolean nextTurn(mPlayer pTurn) {
        /*
        Once current player is done, this method is called in order to move to next player
         */
        if (getTurn() == pTurn.getPosition()) {

            switch (pTurn.getPosition()) {
                case 0:
                    setTurn(1);
                    //setLastTurn(0);
                    break;
                case 1:
                    setTurn(2);
                    //setLastTurn(1);
                    break;
                case 2:
                    setTurn(3);
                    //setLastTurn(2);
                    break;
                case 3:
                    setTurn(0);
                    //setLastTurn(3);
                    break;
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @param pHand
     * @return
     */
    public boolean mahjongCheck(ArrayList<mTiles> pHand)
    {
        if(pHand.size() == 13) return false;
        ArrayList<mTiles> bamboos = new ArrayList<mTiles> ();
        ArrayList<mTiles> dots = new ArrayList<mTiles> ();
        ArrayList<mTiles> characters = new ArrayList<mTiles> ();

        for(int i = 0; i < pHand.size(); i++)
        {
            if(pHand.get(i).getSuit() == "Bamboo")
            {
                bamboos.add(pHand.get(i));
            }
            else if(pHand.get(i).getSuit() == "Dots")
            {
                dots.add(pHand.get(i));
            }
            else if(pHand.get(i).getSuit() == "Characters")
            {
                characters.add(pHand.get(i));
            }
        }

        if(checkSuit(bamboos))
        {
            if(checkSuit(dots))
            {
                if(checkSuit(characters))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    External Citation:
    Problem: Sorting the players hand
    Source: StackOverflow
    Solution: use Collection.swap(object, index1, index2);
    */

    /**
     * Organizes a hand by suit
     *
     * @param pHand
     * @return
     */
    public boolean checkSuit(ArrayList<mTiles> pHand)
    {
        ArrayList<mTiles> suitList = pHand;

        for(int i = 0; i < suitList.size(); i++)
        {
            for(int j = i; j < suitList.size(); j++)
            {
                if(suitList.get(i).getValue() > suitList.get(j).getValue())
                {
                    Collections.swap(suitList, i, j);
                }
            }
        }

        int prevSize = -1;
        ArrayList<Integer> temp = findLowestSet(suitList);
        while(suitList.size() != prevSize)
        {
            prevSize = suitList.size();
            for(int i = temp.size() - 1; i >= 0; i--)
            {
                suitList.remove(temp.get(i).intValue());
            }
            temp = findLowestSet(suitList);
        }


        prevSize = -1;
        if(suitList.size() == 0) return true;

        temp = findLowestMatching(suitList);
        while(suitList.size() != prevSize)
        {
            prevSize = suitList.size();
            for(int i = temp.size() - 1; i >= 0; i--)
            {
                suitList.remove(temp.get(i).intValue());
            }
            temp = findLowestMatching(suitList);
        }

        if(suitList.size() == 0) return true;
        return false;
    }


    /**
     * Finds the lowest matching value of a
     * given suit.
     *
     * @param suitList
     * @return ArrayList of Integer
     */
    public ArrayList<Integer> findLowestMatching(ArrayList<mTiles> suitList) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        int heldVal, occurences = 0;

        for (int i = 0; i < suitList.size() - 1; i++) {
            heldVal = suitList.get(i).getValue();

            if (heldVal == suitList.get(i + 1).getValue()) {
                indexes.add(i);
                break;
            }
        }

        if(indexes.size() == 0) return indexes;


        for (int i = indexes.get(0)+1; i < suitList.size() &&
                suitList.get(indexes.get(0)).getValue() == suitList.get(i).getValue(); i++)
        {

            if(suitList.get(indexes.get(0)).getValue() == suitList.get(i).getValue());
            {
                indexes.add(i);
            }
        }

        if(indexes.size() == suitList.size()) return indexes;
        //This next if statement is to check if by removing these tiles it would ruin a set
        //if a tile can be removed without ruining the matching tiles
        if(indexes.size() > 2)
        {
            if(indexes.get(0) == 0)
            {
                if(suitList.get(indexes.get(indexes.size() - 1).intValue()).getValue() ==
                        suitList.get(indexes.get(indexes.size() - 1).intValue() + 1).getValue() - 1)
                {
                    indexes.remove(0);
                }
            }
            else if (indexes.get(indexes.size() - 1) == suitList.size() - 1)
            {

                if (suitList.get(indexes.get(0).intValue()).getValue() ==
                        suitList.get(indexes.get(0).intValue() - 1).getValue() + 1)
                {
                    indexes.remove(0);
                }

            }
            else
            {
                //if the value of the first indexes spot is 1 more than the value of index-1
                if (suitList.get(indexes.get(0).intValue()).getValue() ==
                        suitList.get(indexes.get(0).intValue() - 1).getValue() + 1 ||
                        //if the value of the last indexes spot is 1 less than the value of the index+1
                        suitList.get(indexes.get(indexes.size() - 1).intValue()).getValue() ==
                                suitList.get(indexes.get(indexes.size() - 1).intValue() + 1).getValue() - 1) {
                    indexes.remove(0);
                }
            }
        }

        return indexes;
    }

    /**
     * Iterates through and sorts the
     * particular suit and checks what the
     * lowest set is
     *
     * @param suitList
     * @return ArrayList of Integers
     */
    public ArrayList<Integer> findLowestSet(ArrayList<mTiles> suitList)
    {
        ArrayList<Integer> indexes = new ArrayList<>();

        for(int i = 0; i < suitList.size(); i++)
        {
            for(int j = i; j < suitList.size(); j++)
            {
                if(suitList.get(i).getValue() > suitList.get(j).getValue())
                {
                    Collections.swap(suitList, i, j);
                }
            }
        }

        int prevVal;

        for(int i = 0; i < suitList.size(); i++)
        {
            prevVal = suitList.get(i).getValue();

            for(int j = i + 1; j < suitList.size(); j++)
            {

                if(suitList.get(j).getValue() == prevVal+1)
                {
                    prevVal = suitList.get(j).getValue();
                    if(indexes.size() == 0) indexes.add(i);
                    indexes.add(j);
                }
            }

            if(indexes.size() > 2) return indexes;
            else indexes.clear();
        }

        return indexes;
    }


    /**
     * Determines which tile to discard. adds tile
     * to hand and calls on method that will
     * sort through the lowest set and check
     * if there is a tile that doesn't make
     * a set.
     *
     * @param pHand
     * @return mTiles
     */
    public mTiles tileToDiscard(ArrayList<mTiles> pHand)
    {
        int prevSize = -1;

        ArrayList<mTiles> bamboos = new ArrayList<mTiles> ();
        ArrayList<mTiles> dots = new ArrayList<mTiles> ();
        ArrayList<mTiles> characters = new ArrayList<mTiles> ();

        for(int i = 0; i < pHand.size(); i++)
        {
            if(pHand.get(i).getSuit() == "Bamboo")
            {
                bamboos.add(pHand.get(i));
            }
            else if(pHand.get(i).getSuit() == "Dots")
            {
                dots.add(pHand.get(i));
            }
            else if(pHand.get(i).getSuit() == "Characters")
            {
                characters.add(pHand.get(i));
            }
        }

        if(!checkSuit(bamboos))
        {
            if(findBadTile(bamboos) != null) return findBadTile(bamboos);
        }
        if(!checkSuit(dots))
        {
            if(findBadTile(dots) != null) return findBadTile(dots);
        }
        if(!checkSuit(characters))
        {
            if(findBadTile(characters) != null) return findBadTile(characters);
        }
        return null;
    }


    /**
     *
     * In a particular suit, checks the list
     * of tiles in the array and swaps if tile doesn't
     * have matching suit
     *
     * @param suitList
     * @return mTiles
     */
    public mTiles findBadTile(ArrayList<mTiles> suitList)
    {
        for(int i = 0; i < suitList.size(); i++)
        {
            for(int j = i; j < suitList.size(); j++)
            {
                if(suitList.get(i).getValue() > suitList.get(j).getValue())
                {
                    Collections.swap(suitList, i, j);
                }
            }
        }

        int prevSize = -1;
        ArrayList<Integer> temp = findLowestSet(suitList);
        while(suitList.size() != prevSize)
        {
            prevSize = suitList.size();
            for(int i = temp.size() - 1; i >= 0; i--)
            {
                suitList.remove(temp.get(i).intValue());
            }
            temp = findLowestSet(suitList);
        }

        prevSize = -1;
        if(suitList.size() == 0) return null;

        temp = findLowestMatching(suitList);
        while(suitList.size() != prevSize)
        {
            prevSize = suitList.size();
            for(int i = temp.size() - 1; i >= 0; i--)
            {
                suitList.remove(temp.get(i).intValue());
            }
            temp = findLowestMatching(suitList);
        }

        if(suitList.size() == 0) return null;
        return suitList.get(0);
    }

    public ArrayList<Integer> findLargestSet(ArrayList<mTiles> suitList)
    {
        //Create var to hold index of current high val of set
        int prevValInd = 0;
        //Create arraylist to hold all indexes of tiles part of set
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        if(suitList.size() == 0) return indexes;

        //Create var to hold the current highest val of set
        int prevVal = suitList.get(0).getValue();

        //Iterate through all of the tiles
        for(int i = 0; i < suitList.size() - 1; i++)
        {
            prevVal = suitList.get(i).getValue();
            prevValInd = i;
            //If i th card val is equal to prevVal+1 then add the index
            //where prevVal was found to the arraylist
            if(suitList.get(i+1).getValue() == prevVal + 1 && suitList.get(i).getValue() == prevVal)
            {
                indexes.add(prevValInd);
            }
            else if(indexes.size() <= 2)
            {
                indexes.clear();
            }
            else if(prevVal == suitList.get(i-1).getValue()+1)
            {
                indexes.add(i);

            }
        }
        if(prevVal + 1 == suitList.get(suitList.size()-1).getValue())
        {
            indexes.add(suitList.size()-1);
        }

        //largest set must be at least 3 tiles long
        return indexes;
    }


}

