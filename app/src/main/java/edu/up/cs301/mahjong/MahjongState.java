package edu.up.cs301.mahjong;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.game.infoMsg.GameState;


public class MahjongState extends GameState implements Serializable {
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

        mPlayer EastPlayer = new mPlayer(0, new ArrayList<mTiles>());
        mPlayer NorthPlayer = new mPlayer(1, new ArrayList<mTiles>());
        mPlayer WestPlayer = new mPlayer(2, new ArrayList<mTiles>());
        mPlayer SouthPlayer = new mPlayer(3, new ArrayList<mTiles>());

        /*
        initialized players are added to the gamePlayers arrayList
         */
        in.gamePlayers.add(EastPlayer);
        in.gamePlayers.add(NorthPlayer);
        in.gamePlayers.add(WestPlayer);
        in.gamePlayers.add(SouthPlayer);

        /*
        each player is set with a hand is initialized
        using separate methods of initHand#. We tried to
        do nested for-loops for the the hand initialization,
        but errors were given.
         */
        EastPlayer.setHand(in.initHand0());
        NorthPlayer.setHand(in.initHand1());
        WestPlayer.setHand(in.initHand2());
        SouthPlayer.setHand(in.initHand3());


        for(int i = 0; i < in.getWall().size(); i++){
            mTiles tSource = in.wall.getWall().get(i);
            mTiles newTile = new mTiles(tSource.getValue(),tSource.getSuit());
            in.getWall().getWall().add(newTile);
        }



        this.discardTiles = in.discardTiles;
        this.turn = in.turn;
        this.lastTurn = in.lastTurn;
        this.recentDiscard = in.recentDiscard;

        /*
        players are initialized
        constructor is called and initialized with their
        position and empty array list of tiles
        */
        EastPlayer = new mPlayer(0, new ArrayList<mTiles>());
        NorthPlayer = new mPlayer(1, new ArrayList<mTiles>());
        WestPlayer = new mPlayer(2, new ArrayList<mTiles>());
        SouthPlayer = new mPlayer(3, new ArrayList<mTiles>());

        /*
        initialized players are added to the gamePlayers arrayList
         */
        in.gamePlayers.add( EastPlayer);
        in.gamePlayers.add(NorthPlayer);
        in.gamePlayers.add(WestPlayer);
        in.gamePlayers.add(SouthPlayer);

        /*
        each player is set with a hand is initialized
        using separate methods of initHand#. We tried to
        do nested for-loops for the the hand initialization,
        but errors were given.
         */
        EastPlayer.setHand(in.initHand0());
        NorthPlayer.setHand(in.initHand1());
        WestPlayer.setHand(in.initHand2());
        SouthPlayer.setHand(in.initHand3());
    }

    /*
    public void initTiles() {
        wall = new mWall();
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
        //initialized the first 108 tiles, 4 of each tile of each suit


        //Values of wind : 0 - west, 1 - south, 2 - east, 3 - north
        //Winds suit 4 of one wind made on each loop (mTiles[108-123])
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
         /
        Collections.shuffle(wall);
    }
    */

    public ArrayList<mTiles> initHand0() {

        for (int i = 0; i < 14; i++) {
            gamePlayers.get(0).addTiletoHand(wall.getWall().get(i));
            wall.getWall().remove(wall.getWall().get(i));
            gamePlayers.get(0).setHand(gamePlayers.get(0).getHand());
        }
        return gamePlayers.get(0).getHand();
    }

    public ArrayList<mTiles> initHand1() {
        for (int j = 14; j < 27; j++) {
            gamePlayers.get(1).addTiletoHand(wall.getWall().get(j));
            wall.getWall().remove(wall.getWall().get(j));

            gamePlayers.get(1).setHand(gamePlayers.get(1).getHand());

        }
        return gamePlayers.get(1).getHand();
    }


    public ArrayList<mTiles> initHand2() {
        for (int k = 27; k < 40; k++) {
            gamePlayers.get(2).addTiletoHand(wall.getWall().get(k));
            wall.getWall().remove(wall.getWall().get(k));

            gamePlayers.get(2).setHand(gamePlayers.get(2).getHand());

        }
        return gamePlayers.get(2).getHand();
    }

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

    public ArrayList<mPlayer> getGamePlayers() {
        return gamePlayers;
    }

    public mWall getWall() {
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

    public void setPlayerTiles(ArrayList<mTiles> inPTiles) {
        this.playerTiles = inPTiles;
    }

    public void setLastTurn(int lTurn) { this.lastTurn = lTurn; }

    public void setTurn(int inTurn) {
        this.turn = inTurn;
    }

    public void setRecentDiscard(mTiles inMTile) {
        this.recentDiscard = inMTile;
    }

    public boolean drawFromWall(mTiles drawnTile, int position) {
        /*
        if the image of the draw tile is selected, then a tile from the wall array will
        be accessed and this new tile will be added into the array of X player and removed from
        the wall
         */

        if (!(currentTurn(this.getGamePlayers().get(position)))) {
            return false;
        }
        this.getGamePlayers().get(position).addTiletoHand(drawnTile);
        wall.getWall().remove(drawnTile);

        return true;
    }

    public boolean discardTile(mTiles discardTile, int position) {
        /*
        If user selects on tile of own collection during turn, then the tile is
        set to the most recently discarded card and is available for other players
        to take in order of clockwise.
         */
        mPlayer newPlayer = this.gamePlayers.get(position);
        if (!(currentTurn(this.gamePlayers.get(position)))) {
            return false;
        }
        this.gamePlayers.get(position).removeTile(discardTile);
        //newPlayer.setHand(newPlayer.getHand());
        nextTurn(this.getGamePlayers().get(position));
        return true;
    }


    public boolean currentTurn(mPlayer cTurn) {
        if (getTurn() == cTurn.getPosition()) {
            return true;
        }
        return false;
    }

    public boolean nextTurn(mPlayer pTurn) {
        /*
        Once current player is done, this method is called in order to move to next player
         */
        if (getTurn() == pTurn.getPosition()) {

            switch (pTurn.getPosition()) {
                case 0:
                    setTurn(1);
                    break;
                case 1:
                    setTurn(2);
                    break;
                case 2:
                    setTurn(3);
                    break;
                case 3:
                    setTurn(0);
                    break;
            }
            return true;
        }
        return false;
    }


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

    public ArrayList<mTiles> findPreferredTiles(ArrayList<mTiles> pHand)
    {
        ArrayList<mTiles> viableTiles = new ArrayList<> ();

        for(int i = 0; i < pHand.size(); i++)
        {
            mTiles temp = new mTiles(pHand.get(i).getValue(), pHand.get(i).getSuit());
            if(!viableTiles.contains(temp))
            {
                viableTiles.add(temp);
            }

            if(temp.getValue() > 1)
            {
                if(!viableTiles.contains(
                        new mTiles(pHand.get(i).getValue()-1,pHand.get(i).getSuit())))
                {
                    viableTiles.add(new mTiles(pHand.get(i).getValue()-1,pHand.get(i).getSuit()));
                }
            }
            if(temp.getValue() < 9)
            {
                if(!viableTiles.contains(
                        new mTiles(pHand.get(i).getValue()+1,pHand.get(i).getSuit())))
                {
                    viableTiles.add(new mTiles(pHand.get(i).getValue()+1,pHand.get(i).getSuit()));
                }
            }
        }

        return viableTiles;
    }

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

}

