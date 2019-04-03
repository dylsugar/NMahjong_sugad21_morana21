package edu.up.cs301.mahjong;

import android.graphics.drawable.Drawable;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

public class MahjongSelectAction extends GameAction {

    private Drawable tile;
    public MahjongSelectAction (GamePlayer player, Drawable selected)
    {
        super(player);
        tile = selected;
    }
    public Drawable getTile() { return tile; }
}
