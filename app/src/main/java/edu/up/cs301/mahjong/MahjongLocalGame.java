package edu.up.cs301.mahjong;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import android.util.Log;

/**
 * A class that represents the state of a game. In our counter game, the only
 * relevant piece of information is the value of the game's counter. The
 * MahjongState object is therefore very simple.
 * 
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version July 2013
 */
public class MahjongLocalGame extends LocalGame {

	// When a counter game is played, any number of players. The first player
	// is trying to get the counter value to TARGET_MAGNITUDE; the second player,
	// if present, is trying to get the counter to -TARGET_MAGNITUDE. The
	// remaining players are neither winners nor losers, but can interfere by
	// modifying the counter.
	public static final int TARGET_MAGNITUDE = 10;

	// the game's state
	private MahjongState gameState;
	
	/**
	 * can this player move
	 * 
	 * @return
	 * 		true, because all player are always allowed to move at all times,
	 * 		as this is a fully asynchronous game
	 */
	@Override
	protected boolean canMove(int playerIdx) {
		return true;
	}

	/**
	 * This ctor should be called when a new counter game is started
	 */
	public MahjongLocalGame() {
		// initialize the game state, with the counter value starting at 0
		this.gameState = new MahjongState();
	}

	/**
	 * The only type of GameAction that should be sent is MahjongoDrawAction
	 */
	@Override
	protected boolean makeMove(GameAction action) {

		if(action instanceof MahjongoDrawAction)
		{


		}
		else if(action instanceof MahjongSelectAction)
		{
			int tileToDiscard = ((MahjongSelectAction) action).getTile();
			switch (tileToDiscard)
			{
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					break;
			}
		}
		return true;
	}//makeMove
	
	/**
	 * send the updated state to a given player
	 */
	@Override
	protected void sendUpdatedStateTo(GamePlayer p) {
		// this is a perfect-information game, so we'll make a
		// complete copy of the state to send to the player
		p.sendInfo(gameState);
		
	}//sendUpdatedSate
	
	/**
	 * Check if the game is over. It is over, return a string that tells
	 * who the winner(s), if any, are. If the game is not over, return null;
	 * 
	 * @return
	 * 		a message that tells who has won the game, or null if the
	 * 		game is not over
	 */
	@Override
	protected String checkIfGameOver() {
		if(gameState.mahjongCheck(gameState.getGamePlayers().get(0).getHand()))
		{
			return "Player " + playerNames[0] + " has won!";
		}
		else if(gameState.mahjongCheck(gameState.getGamePlayers().get(1).getHand()))
		{
			return "Player " + playerNames[1] + " has won!";
		}
		else if(gameState.mahjongCheck(gameState.getGamePlayers().get(2).getHand()))
		{
			return "Player " + playerNames[2] + " has won!";
		}
		else if(gameState.mahjongCheck(gameState.getGamePlayers().get(3).getHand()))
		{
			return "Player " + playerNames[3] + " has won!";
		}
		else
		{
			return "No winner yet";
		}
	}

}// class MahjongLocalGame
