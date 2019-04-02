package edu.up.cs301.mahjong;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

/**
 * A GUI of a counter-player. The GUI displays the current value of the counter,
 * and allows the human player to press the '+' and '-' buttons in order to
 * send moves to the game.
 * 
 * Just for fun, the GUI is implemented so that if the player presses either button
 * when the counter-value is zero, the screen flashes briefly, with the flash-color
 * being dependent on whether the player is player 0 or player 1.
 * 
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version July 2013
 */
public class MahjongHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */
	private ArrayList<mTiles> hand;

	
	// The TextView the displays the current counter value
	private TextView counterValueTextView;
	
	// the most recent game state, as given to us by the MahjongLocalGame
	private MahjongState state;
	
	// the android activity that we are running
	private GameMainActivity myActivity;
    private ImageButton slot1;
    private ImageButton slot2;
    private ImageButton slot3;
    private ImageButton slot4;
    private ImageButton slot5;
    private ImageButton slot6;
    private ImageButton slot7;
    private ImageButton slot8;
    private ImageButton slot9;
    private ImageButton slot10;
    private ImageButton slot11;
    private ImageButton slot12;
    private ImageButton slot13;
    private ImageButton slot14;
    private ImageButton wallDraw;
	private ImageButton ibutton;
	
	/**
	 * constructor
	 * @param name
	 * 		the player's name
	 */

	public MahjongHumanPlayer(String name) {
		super(name);
	}

	/**
	 * Returns the GUI's top view object
	 * 
	 * @return
	 * 		the top object in the GUI's view heirarchy
	 */
	public View getTopView() {
		return myActivity.findViewById(R.id.top_layer);
	}
	


	/**
	 * this method gets called when the user clicks the '+' or '-' button. It
	 * creates a new MahjongoDrawAction to return to the parent activity.
	 * 
	 * @param button
	 * 		the button that was clicked
	 */
	/**
	 * callback method when we get a message (e.g., from the game)
	 * 
	 * @param info
	 * 		the message
	 */
	@Override
	public void receiveInfo(GameInfo info) {
        if ((info instanceof MahjongState)) {
            MahjongState temp = (MahjongState) info;

            if (playerNum == 0) {
                temp.setPlayerTiles(temp.getGamePlayers().get(0).getHand());
                temp.mahjongCheck(temp.getGamePlayers().get(0).getHand());

            } else if (playerNum == 1) {

            } else if (playerNum == 2) {

            } else if (playerNum == 3) {

            }
            int i = state.getGamePlayers().get(playerNum).getHand().size();
            if (i > 1) {
                slot1.setImageResource(state.getWall().getWall().` `);
                if (i > 2) {
                    slot2.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(2).getCardName(), "drawable", getPackageName()));
                    if (i > 3) {
                        slot3.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(3).getCardName(), "drawable", getPackageName()));
                        if (i > 4) {
                            slot4.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(4).getCardName(), "drawable", getPackageName()));
                            if (i > 5) {
                                slot5.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(5).getCardName(), "drawable", getPackageName()));
                                if (i > 6) {
                                    slot6.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(6).getCardName(), "drawable", getPackageName()));
                                    if (i > 7) {
                                        slot7.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(7).getCardName(), "drawable", getPackageName()));
                                        if (i > 8) {
                                            slot8.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(8).getCardName(), "drawable", getPackageName()));
                                            if (i > 9) {
                                                slot9.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(9).getCardName(), "drawable", getPackageName()));
                                                if (i > 10) {
                                                    slot10.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(10).getCardName(), "drawable", getPackageName()));
                                                    if (i > 11) {
                                                        slot11.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(11).getCardName(), "drawable", getPackageName()));

                                                        if (i > 12) {
                                                            slot12.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(12).getCardName(), "drawable", getPackageName()));

                                                            if (i > 13) {
                                                                slot13.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(13).getCardName(), "drawable", getPackageName()));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i < 14) {
                slot13.setVisibility(View.INVISIBLE);
                if (i < 13) {
                    slot12.setVisibility(View.INVISIBLE);
                    if (i < 12) {
                        slot11.setVisibility(View.INVISIBLE);
                        if (i < 11) {
                            slot10.setVisibility(View.INVISIBLE);
                            if (i < 10) {
                                slot9.setVisibility(View.INVISIBLE);
                                if (i < 9) {
                                    slot8.setVisibility(View.INVISIBLE);
                                    if (i < 8) {
                                        slot7.setVisibility(View.INVISIBLE);
                                        if (i < 7) {
                                            slot6.setVisibility(View.INVISIBLE);
                                            if (i < 6) {
                                                slot5.setVisibility(View.INVISIBLE);
                                                if (i < 5) {
                                                    slot4.setVisibility(View.INVISIBLE);
                                                    if (i < 4) {
                                                        slot3.setVisibility(View.INVISIBLE);
                                                        if (i < 3) {
                                                            slot2.setVisibility(View.INVISIBLE);
                                                            if (i < 2) {
                                                                slot1.setVisibility(View.INVISIBLE);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
	
	/**
	 * callback method--our game has been chosen/rechosen to be the GUI,
	 * called from the GUI thread
	 * 
	 * @param activity
	 * 		the activity under which we are running
	 */
	public void setAsGui(GameMainActivity activity) {
		
		// remember the activity
		myActivity = activity;
		
	    // Load the layout resource for our GUI
		activity.setContentView(R.layout.play_screen);

	}

        @Override
        public void onClick(View v) {

        }




}// class MahjongHumanPlayer

