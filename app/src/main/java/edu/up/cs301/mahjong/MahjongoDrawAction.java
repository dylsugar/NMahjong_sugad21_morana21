package edu.up.cs301.mahjong;

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
public class MahjongoDrawAction extends GameAction {
	
	// to satisfy the serializable interface
	private static final long serialVersionUID = 28062013L;

	//whether this move is a plus (true) or minus (false)
	private boolean isPlus;
	
	/**
	 * Constructor for the MahjongoDrawAction class.
	 * 
	 * @param player
	 *            the player making the move
	 * @param isPlus
	 *            value to initialize this.isPlus
	 */
	public MahjongoDrawAction(GamePlayer player, boolean selectTile) {
		super(player);
		this.isPlus = isPlus;
	}
	

}//class MahjongoDrawAction