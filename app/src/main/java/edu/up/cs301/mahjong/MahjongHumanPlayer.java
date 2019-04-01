package edu.up.cs301.mahjong;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.view.View;
import android.widget.Button;
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
	public void onClick(View button) {
	}// onClick
	
	/**
	 * callback method when we get a message (e.g., from the game)
	 * 
	 * @param info
	 * 		the message
	 */
	@Override
	public void receiveInfo(GameInfo info) {


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


		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated

	}

}// class MahjongHumanPlayer

