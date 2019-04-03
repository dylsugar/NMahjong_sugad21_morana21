package edu.up.cs301.mahjong;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

public class MahjongDrawDiscardAction extends GameAction {

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
