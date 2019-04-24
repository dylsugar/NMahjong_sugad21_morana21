package edu.up.cs301.mahjong;

import java.io.Serializable;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

public class MahjongSelectAction extends GameAction implements Serializable {
    /*instant variables for a select action initialized*/

    private int tile;
    private int playerNum;
    public MahjongSelectAction (GamePlayer player, int selected, int pNum)
    {
        //the player that takes action as well as tile selected is
        //taken into account
        super(player);
        tile = selected;
        playerNum = pNum;
    }

    //returns the tile that was selected
    int getTile() { return tile; }


    //gets the number of players in the game
    int getPlayerNum() { return playerNum; }
}
