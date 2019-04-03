package edu.up.cs301.mahjong;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

public class MahjongSelectAction extends GameAction {

    private int tile;
    private int playerNum;
    public MahjongSelectAction (GamePlayer player, int selected, int pNum)
    {
        super(player);
        tile = selected;
        playerNum = pNum;
    }
    int getTile() { return tile; }

    int getPlayerNum() { return playerNum; }
}
