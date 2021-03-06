package edu.up.cs301.mahjong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * This is the smart AI
 *
 * @author Dylan Suga
 * @author Anthony Moran
 * @version April 2019
 */
public class MahjongComputerPlayer3 extends GameComputerPlayer implements Tickable, Serializable {
    private static final long serialVersionUID = 91093039201944L;

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
     *
     *
     * 	The Smart AI basically checks if the discarded tile matches one of
     * 	the tiles in the Smart AI's hand. If it does, then it draws that tile
     */
	@Override
	protected void receiveInfo(GameInfo info) {
		// Do nothing, as we ignore all state in deciding our next move. It
		// depends totally on the timer and random numbers.
        if(info instanceof MahjongState) {

            //need implement for drawDiscard decisions, looping send actions can crash
            MahjongState temp = (MahjongState) info;

            if (temp.getTurn() == this.playerNum &&
            temp.getGamePlayers().get(playerNum).getHand().size() != 14                 )
            {
                game.sendAction(new MahjongoDrawAction(this, playerNum));
            }
            else if(temp.getLastTurn() == playerNum)
            {
                sleep(3000);
                    for (int i = 0; i < temp.getGamePlayers().get(playerNum).getHand().size(); i++)
                    {
                        if (temp.tileToDiscard(temp.getGamePlayers().get(playerNum).getHand()).getValue() ==
                                temp.getGamePlayers().get(playerNum).getHand().get(i).getValue() &&
                                temp.tileToDiscard(temp.getGamePlayers().get(playerNum).getHand()).getSuit() ==
                                        temp.getGamePlayers().get(playerNum).getHand().get(i).getSuit()) {
                            lastDiscarded = temp.getGamePlayers().get(playerNum).getHand().get(i);
                            game.sendAction(new MahjongSelectAction(this, i + 1, playerNum));
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
