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
            //If there is no discard, do not allow actions besides discard
            if(gameState.getRecentDiscard() == null) return false;
            /*if(!gameState.currentTurn(gameState.
					getGamePlayers().get(((MahjongoDrawAction) action).getPlayerNum())))
            	return false;
            	*/
            if(gameState.getGamePlayers().get(((MahjongoDrawAction) action).
					getPlayerNum()).getHand().size() == 14)
            	return false;

            gameState.drawFromWall(gameState.getWall().getWall().get(0), gameState.getTurn());
            
		}
		else if(action instanceof MahjongSelectAction)
		{

		    //Checks to see if the player has enough tiles to discard one
            if(gameState.getGamePlayers().get(((MahjongSelectAction) action).getPlayerNum()).getHand().size() < 14)
            {

            }
            //If the players hand is of size 14, allow them to discard the one they selected
            else {
                int tileToDiscard = ((MahjongSelectAction) action).getTile();

				gameState.setRecentDiscard(gameState.getGamePlayers().get(
						((MahjongSelectAction) action).getPlayerNum()).getHand().get(tileToDiscard - 1));
                gameState.getGamePlayers().get(((MahjongSelectAction) action).getPlayerNum()).getHand().remove(tileToDiscard-1);
            }


            gameState.nextTurn(gameState.getGamePlayers().get(((MahjongSelectAction) action).getPlayerNum()));
		}
		else if(action instanceof MahjongDrawDiscardAction)
        {
			gameState.getGamePlayers().get(((MahjongDrawDiscardAction) action).
					getPlayerNum()).getHand().add(gameState.getRecentDiscard());
			gameState.setRecentDiscard(null);
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
		return null;
	}

}// class MahjongLocalGame
