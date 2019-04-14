package edu.up.cs301.mahjong;

import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * A computer-version of a counter-player.  Since this is such a simple game,
 * it just sends "+" and "-" commands with equal probability, at an average
 * rate of one per second. 
 * 
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version September 2013
 */
public class MahjongComputerPlayer3 extends GameComputerPlayer implements Tickable {

    mTiles lastDiscarded = new mTiles(0, "placeholder");

    /**
     * Constructor for objects of class MahjongComputerPlayer1
     *
     * @param name
     * 		the player's name
     */
    public MahjongComputerPlayer3(String name) {
        // invoke superclass constructor
        super(name);
        
        // start the timer, ticking 20 times per second
        getTimer().setInterval(50);
        getTimer().start();
    }
    
    /**
     * callback method--game's state has changed
     * 
     * @param info
     * 		the information (presumably containing the game's state)
     */
	@Override
	protected void receiveInfo(GameInfo info) {
		// Do nothing, as we ignore all state in deciding our next move. It
		// depends totally on the timer and random numbers.
        if(info instanceof MahjongState) {

            //need implement for drawDiscard decisions, looping send actions can crash
            MahjongState temp = (MahjongState) info;

            if (temp.getTurn() == this.playerNum)
            {
                game.sendAction(new MahjongoDrawAction(this, playerNum));
                for(int i = 0; i < temp.getGamePlayers().get(playerNum).getHand().size(); i++)
                {
                    if(temp.tileToDiscard(temp.getGamePlayers().get(playerNum).getHand()).getValue() ==
                       temp.getGamePlayers().get(playerNum).getHand().get(i).getValue() &&
                       temp.tileToDiscard(temp.getGamePlayers().get(playerNum).getHand()).getSuit() ==
                       temp.getGamePlayers().get(playerNum).getHand().get(i).getSuit())
                    {
                        lastDiscarded = temp.getGamePlayers().get(playerNum).getHand().get(i);
                        game.sendAction(new MahjongSelectAction(this, i+1, playerNum));
                        break;
                    }
                }
                if(temp.getGamePlayers().get(playerNum).getHand().size() == 14)
                {
                    game.sendAction(new MahjongSelectAction(this, 1, playerNum));
                }
            }
        }
	}
}
