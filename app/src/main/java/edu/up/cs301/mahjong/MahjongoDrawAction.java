package edu.up.cs301.mahjong;

import java.io.Serializable;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * A MahjongoDrawAction is an action that is a "move" the game: either increasing
 * or decreasing the counter value.
 * 
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version September 2012
 */
public class MahjongoDrawAction extends GameAction implements Serializable {
	
	// to satisfy the serializable interface
	private static final long serialVersionUID = 28062013L;

	//whether this move is a plus (true) or minus (false)
	private int playerNum;
	
	/**
	 * Constructor for the MahjongoDrawAction class.
	 * 
	 * @param player
	 *            the player making the move
	 */
	public MahjongoDrawAction(GamePlayer player, int pos) {
		super(player);
		playerNum = pos;
	}

	public int getPlayerNum()
	{
		return playerNum;
	}

}//class MahjongoDrawAction
