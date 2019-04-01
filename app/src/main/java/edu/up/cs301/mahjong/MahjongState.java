package edu.up.cs301.mahjong;


import java.util.ArrayList;
import java.util.Collections;


public class MahjongState {

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
        wall =new mWall();
        Collections.shuffle(wall.getWall());
        playerTiles =new ArrayList<mTiles>();
        discardTiles =new ArrayList<mTiles>();
        turn =0;
        lastTurn =0;
        recentDiscard = getRecentDiscard();

        gamePlayers = new ArrayList<mPlayer>();
        for (int i = 0; i < gamePlayers.size(); i++) {
            gamePlayers.add(gamePlayers.get(i));
        }


        int j = 0;
        int size = wall.size();
        for (int i = 0; i < size; i++) {
            gamePlayers.get(j).addTiletoHand(wall.remove(0));
            if (j < gamePlayers.size() - 1) {
                j++;
            } else {
                j = 0;
            }
        }


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

        gamePlayers = new ArrayList<mPlayer>();
        for (int i = 0; i < in.gamePlayers.size(); i++) {
            gamePlayers.add(in.gamePlayers.get(i));
        }

        playerTiles = new ArrayList<mTiles>();
        for(int m = 0; m < in.getPlayerTiles().size(); m++){
            playerTiles.add(in.playerTiles.get(m));
        }

        discardTiles = new ArrayList<mTiles>();
        for (int l = 0; l < in.getDiscardTiles().size(); l++) {
            discardTiles.add(in.discardTiles.get(l));
        }

        turn = in.getTurn();
        lastTurn = in.getLastTurn();
        recentDiscard = in.getRecentDiscard();
    }


    public mTiles getRecentDiscard() {
        return recentDiscard;
    }

    public ArrayList<mPlayer> getGamePlayers() {
        return gamePlayers;
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

    public void setPlayerTiles(ArrayList<mTiles> inPTiles) {
        this.playerTiles = inPTiles;
    }

    public void setDiscardTiles(mTiles inDTiles) {
        getDiscardTiles().add(inDTiles);
    }

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
        mPlayer newPlayer = this.gamePlayers.get(position);
        if (!(currentTurn(newPlayer))) {
            return false;
        }
        newPlayer.addTiletoHand(drawnTile);
        getWall().remove(drawnTile);
        setPlayerTiles(getPlayerTiles());
        setWall(getWall());
        nextTurn(newPlayer);
        return true;
    }

    public boolean discardTile(mTiles discardTile, int position) {
        /*
        If user selects on tile of own collection during turn, then the tile is
        set to the most recently discarded card and is available for other players
        to take in order of clockwise.
         */
        mPlayer newPlayer = this.gamePlayers.get(position);
        if (!(currentTurn(newPlayer))) {
            return false;
        }
        setDiscardTiles(discardTile);
        newPlayer.setDiscardHand(getDiscardTiles());
        newPlayer.removeTile(discardTile);
        newPlayer.setHand(newPlayer.getHand());

        return true;
    }

    /*
    if a user just discarded a card, then anyone can pick up the card just discarded
    and choose to discard it or keep it
     */
    public boolean drawDiscardTile(mTiles drawDTile, int position) {
        mPlayer newPlayer = this.gamePlayers.get(position);
        if (discardTile(recentDiscard, getLastTurn())) {
            for (int i = 0; i <= gamePlayers.size(); i++) {
                if (newPlayer.getPosition() != gamePlayers.get(i).getPosition()) {
                    playerTiles.add(drawDTile);
                    getDiscardTiles().remove(drawDTile);
                    setRecentDiscard(null);
                    setPlayerTiles(getPlayerTiles());
                    return true;
                }
            }
        }
        return false;
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


    /*
    All Methods below will be implemented during Alpha Release and will check during hands of
    each player and check winning conditions
     */
    public void handCheck(ArrayList<mTiles> pHand) {
        /*
        Checks hand of currentTurnPlayer and if there is a mahjong, then gameOver method is
        called. But if player picked up a discarded tile and completes a set, that is not mahjong.
        Toast appears for 5 seconds showing the current set completed.(One can only get mahjong if
        one draw from wall or discarded tile.
         */
    }

    public boolean gameOver() {
        /*
        Returns T/F if a player has mahjong and ends game
         */
        return true;
    }

    public boolean pungSet(ArrayList<mTiles> pHand) {
        /*
        returns true if there is a pung in a players hand
         */
        return true;
    }

    public boolean kongSet(ArrayList<mTiles> pHand) {
        /*
        returns true if there is a kong in a players hand
         */
        return true;
    }

    public boolean quintSet(ArrayList<mTiles> pHand) {
        /*
        returns true if there is a quint
         */
        return true;
    }

    public boolean sextetSet(ArrayList<mTiles> pHand) {
        /*
        returns true if sextet
         */
        return true;
    }

    public boolean pairSet(ArrayList<mTiles> pHand) {
        /*
        returns true if pair in hand
         */
        return true;
    }

    public boolean winningHands(ArrayList<mTiles> pHand) {
        /*
        This method will check the current players hand once picked up a discarded tile
        or wall tile to see all the different combinations of winning hands. So
         */
        return true;
    }

    public boolean mahjongCheck(ArrayList<mTiles> pHand) {
        ArrayList<mTiles> bamboos = new ArrayList<mTiles>();
        ArrayList<mTiles> dots = new ArrayList<mTiles>();
        ArrayList<mTiles> characters = new ArrayList<mTiles>();

        for (int i = 0; i < pHand.size() - 1; i++) {
            if (pHand.get(i).getSuit() == "Bamboo") {
                bamboos.add(pHand.get(i));
            } else if (pHand.get(i).getSuit() == "Dots") {
                dots.add(pHand.get(i));
            } else if (pHand.get(i).getSuit() == "Characters") {
                characters.add(pHand.get(i));
            }
        }

        if (checkSuit(bamboos)) {
            if (checkSuit(dots)) {
                if (checkSuit(characters)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSuit(ArrayList<mTiles> suitList) {
        int prevSize = 1000;
        for (int i = 0; i < suitList.size(); i++) {
            for (int j = i; j < suitList.size(); j++) {
                if (suitList.get(i).getValue() > suitList.get(j).getValue()) {
                    Collections.swap(suitList, i, j);
                }
            }
        }

        while (findLargestSet(suitList).size() != 0 && prevSize != suitList.size()) {
            prevSize = suitList.size();
            ArrayList<Integer> temp = new ArrayList<>();
            temp = findLargestSet(suitList);
            for (int x = temp.size() - 1; x >= 0; x--) {
                suitList.remove(temp.get(x));
            }
        }

        prevSize = 1000;
        while (findLowestMatching(suitList).size() != 0 && prevSize != suitList.size()) {
            prevSize = suitList.size();
            ArrayList<Integer> temp = new ArrayList<>();
            temp = findLowestMatching(suitList);
            for (int x = temp.size() - 1; x >= 0; x--) {
                suitList.remove(temp.get(x));
            }
        }

        if (suitList.size() == 0) return true;
        else return false;
    }

    public ArrayList<Integer> findLargestSet(ArrayList<mTiles> suitList) {


        //Create var to hold index of current high val of set
        int prevValInd = 0;
        //Create arraylist to hold all indexes of tiles part of set
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        if (suitList.size() == 0) return indexes;

        //Create var to hold the current highest val of set
        int prevVal = suitList.get(0).getValue();

        //Iterate through all of the tiles
        for (int i = 0; i < suitList.size() - 1; i++) {
            prevVal = suitList.get(i).getValue();
            prevValInd = i;
            //If i th card val is equal to prevVal+1 then add the index
            //where prevVal was found to the arraylist
            if (suitList.get(i + 1).getValue() == prevVal + 1) {
                indexes.add(prevValInd);
            } else if (indexes.size() <= 2) {
                indexes.clear();
            }
        }
        if (prevVal + 1 == suitList.get(suitList.size() - 1).getValue()) {
            indexes.add(suitList.size() - 1);
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

        if (indexes.size() == 0) return indexes;


        for (int i = indexes.get(0) + 1; i < suitList.size() &&
                suitList.get(indexes.get(0)).getValue() == suitList.get(i).getValue(); i++) {

            if (suitList.get(indexes.get(0)).getValue() == suitList.get(i).getValue()) ;
            {
                indexes.add(i);
            }
        }


        return indexes;
    }


}
