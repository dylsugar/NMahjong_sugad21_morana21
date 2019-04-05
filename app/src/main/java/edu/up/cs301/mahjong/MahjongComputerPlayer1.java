package edu.up.cs301.mahjong;

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
public class MahjongComputerPlayer1 extends GameComputerPlayer implements Tickable {
	
    /**
     * Constructor for objects of class MahjongComputerPlayer1
     * 
     * @param name
     * 		the player's name
     */
    public MahjongComputerPlayer1(String name) {
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



            MahjongState temp = (MahjongState) info;
            if(temp.getTurn() != this.playerNum) return;
            Random rand = new Random();

            /*
            if(temp.getRecentDiscard() != null)
            {

                if(rand.nextInt(4) == 0)
                {

                    game.sendAction(new MahjongDrawDiscardAction(this, playerNum));
                    switch (rand.nextInt(14))
                    {
                        case 0:
                            game.sendAction(new MahjongSelectAction(this,1, playerNum));
                            break;
                        case 1:
                            game.sendAction(new MahjongSelectAction(this,2, playerNum));
                            break;
                        case 2:
                            game.sendAction(new MahjongSelectAction(this,3, playerNum));
                            break;
                        case 3:
                            game.sendAction(new MahjongSelectAction(this,4, playerNum));
                            break;
                        case 4:
                            game.sendAction(new MahjongSelectAction(this,5, playerNum));
                            break;
                        case 5:
                            game.sendAction(new MahjongSelectAction(this,6, playerNum));
                            break;
                        case 6:
                            game.sendAction(new MahjongSelectAction(this,7, playerNum));
                            break;
                        case 7:
                            game.sendAction(new MahjongSelectAction(this,8, playerNum));
                            break;
                        case 8:
                            game.sendAction(new MahjongSelectAction(this,9, playerNum));
                            break;
                        case 9:
                            game.sendAction(new MahjongSelectAction(this,10, playerNum));
                            break;
                        case 10:
                            game.sendAction(new MahjongSelectAction(this,11, playerNum));
                            break;
                        case 11:
                            game.sendAction(new MahjongSelectAction(this,12, playerNum));
                            break;
                        case 12:
                            game.sendAction(new MahjongSelectAction(this,13, playerNum));
                            break;
                        case 13:
                            game.sendAction(new MahjongSelectAction(this,14, playerNum));
                            break;

                    }
                }

            }
            if(temp.getTurn() != playerNum) return;
*/
            if (temp.getTurn() == this.playerNum) {
                game.sendAction(new MahjongoDrawAction(this, playerNum));
                switch (rand.nextInt(14)) {
                    case 0:
                        game.sendAction(new MahjongSelectAction(this, 1, playerNum));
                        break;
                    case 1:
                        game.sendAction(new MahjongSelectAction(this, 2, playerNum));
                        break;
                    case 2:
                        game.sendAction(new MahjongSelectAction(this, 3, playerNum));
                        break;
                    case 3:
                        game.sendAction(new MahjongSelectAction(this, 4, playerNum));
                        break;
                    case 4:
                        game.sendAction(new MahjongSelectAction(this, 5, playerNum));
                        break;
                    case 5:
                        game.sendAction(new MahjongSelectAction(this, 6, playerNum));
                        break;
                    case 6:
                        game.sendAction(new MahjongSelectAction(this, 7, playerNum));
                        break;
                    case 7:
                        game.sendAction(new MahjongSelectAction(this, 8, playerNum));
                        break;
                    case 8:
                        game.sendAction(new MahjongSelectAction(this, 9, playerNum));
                        break;
                    case 9:
                        game.sendAction(new MahjongSelectAction(this, 10, playerNum));
                        break;
                    case 10:
                        game.sendAction(new MahjongSelectAction(this, 11, playerNum));
                        break;
                    case 11:
                        game.sendAction(new MahjongSelectAction(this, 12, playerNum));
                        break;
                    case 12:
                        game.sendAction(new MahjongSelectAction(this, 13, playerNum));
                        break;
                    case 13:
                        game.sendAction(new MahjongSelectAction(this, 14, playerNum));
                        break;

                }
            }
        }
	}
}
