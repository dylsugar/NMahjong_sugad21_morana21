package edu.up.cs301.mahjong;

import java.io.Serializable;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * this is the discard action class that is called in make move
 *
 * @author Dylan Suga
 * @author Anthony Moran
 * @version April 2019
 */

public class MahjongDrawDiscardAction extends GameAction implements Serializable {

    private static final long serialVersionUID = 49293039201923L;
    private int playerNum;

    public MahjongDrawDiscardAction (GamePlayer player, int pos)

    {
        super(player);
        playerNum = pos;
    }

    public int getPlayerNum()
    {
        return playerNum;
    }
}
