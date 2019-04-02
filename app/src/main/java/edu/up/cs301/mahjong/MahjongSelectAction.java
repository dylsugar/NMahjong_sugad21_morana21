package edu.up.cs301.mahjong;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

public class MahjongSelectAction extends GameAction {

    private int tile;
    public MahjongSelectAction (GamePlayer player, int selected)
    {
        super(player);
        tile = selected;
    }
    int getTile() { return tile; }
}
