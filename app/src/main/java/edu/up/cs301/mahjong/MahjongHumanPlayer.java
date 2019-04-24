package edu.up.cs301.mahjong;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.R;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * A GUI of a counter-player. The GUI displays the current value of the counter,
 * and allows the human player to press the '+' and '-' buttons in order to
 * send moves to the game.
 * <p>
 * Just for fun, the GUI is implemented so that if the player presses either button
 * when the counter-value is zero, the screen flashes briefly, with the flash-color
 * being dependent on whether the player is player 0 or player 1.
 *
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version July 2013
 */
public class MahjongHumanPlayer extends GameHumanPlayer implements OnClickListener, Serializable {

    private static final long serialVersionUID = 9214039201923L;
    /* instance variables */
    private ArrayList<mTiles> hand;
    private int position;
    MediaPlayer mediaPlayer;


    // The TextView the displays the current counter value
    private TextView counterValueTextView;

    // the most recent game state, as given to us by the MahjongLocalGame
    private MahjongState state;

    // the android activity that we are running
    private GameMainActivity myActivity;
    private GameMainActivity myActivity1;
    private GameMainActivity myActivity2;
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
    private ImageButton discardDraw;
    private ImageButton howTo;
    private ImageButton settings;
    private ImageButton info;
    private ImageButton exit;

    /**
     * constructor
     *
     * @param name the player's name
     */

    public MahjongHumanPlayer(String name) {
        super(name);
    }

    public int getPosition() {
        return position;
    }

    /**
     * Returns the GUI's top view object
     *
     * @return the top object in the GUI's view heirarchy
     */
    public View getTopView() {
        return myActivity.findViewById(R.id.top_layer);
    }

    /**
     * this method gets called when the user clicks the '+' or '-' button. It
     * creates a new MahjongoDrawAction to return to the parent activity.
     *
     * @param button the button that was clicked
     */
    public void onClick(View button) {

        if (button == slot1) {
            slot1.setBackgroundResource(R.drawable.plaintile);
            game.sendAction(new MahjongSelectAction(this, 1, getPosition()));
        } else if (button == slot2) {
            game.sendAction(new MahjongSelectAction(this, 2, getPosition()));
        } else if (button == slot3) {
            game.sendAction(new MahjongSelectAction(this, 3, getPosition()));
        } else if (button == slot4) {
            game.sendAction(new MahjongSelectAction(this, 4, getPosition()));
        } else if (button == slot5) {
            game.sendAction(new MahjongSelectAction(this, 5, getPosition()));
        } else if (button == slot6) {
            game.sendAction(new MahjongSelectAction(this, 6, getPosition()));
        } else if (button == slot7) {
            game.sendAction(new MahjongSelectAction(this, 7, getPosition()));
        } else if (button == slot8) {
            game.sendAction(new MahjongSelectAction(this, 8, getPosition()));
        } else if (button == slot9) {
            game.sendAction(new MahjongSelectAction(this, 9, getPosition()));
        } else if (button == slot10) {
            game.sendAction(new MahjongSelectAction(this, 10, getPosition()));
        } else if (button == slot11) {
            game.sendAction(new MahjongSelectAction(this, 11, getPosition()));
        } else if (button == slot12) {
            game.sendAction(new MahjongSelectAction(this, 12, getPosition()));
        } else if (button == slot13) {
            game.sendAction(new MahjongSelectAction(this, 13, getPosition()));
        } else if (button == slot14) {
            slot14.setBackgroundResource(R.drawable.plaintile);
            game.sendAction(new MahjongSelectAction(this, 14, getPosition()));
        } else if (button == wallDraw) {
            game.sendAction(new MahjongoDrawAction(this, getPosition()));
        } else if (button == discardDraw) {
            game.sendAction(new MahjongDrawDiscardAction(this, getPosition()));
        } else if (button == howTo) {
            Intent intent0 = new Intent(this.myActivity, mahjongSpinner.class);
            button.getContext().startActivity(intent0);

        } else if (button == settings) {
            Intent intent1 = new Intent(this.myActivity, mahjongSetting.class);
            button.getContext().startActivity(intent1);

        } else if (button == info) {
            Intent intent2 = new Intent(this.myActivity, MahjongAbout.class);
            button.getContext().startActivity(intent2);
        } else if (button == exit) {
            System.exit(0);
        }
        //else{

        // Toast.makeText(button.getContext().getApplicationContext(), "Invalid Move",
        //        Toast.LENGTH_SHORT).show();
        // }


    }// onClick

    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info the message
     */
    @Override
    public void receiveInfo(GameInfo info) {

        if (!(info instanceof MahjongState)) {
            return;
        }
        state = (MahjongState) info;



        int i = state.getGamePlayers().get(playerNum).getHand().size();
        if (state.getRecentDiscard() != null) {
            discardDraw.setBackgroundResource(state.getRecentDiscard().getDrawable());
            discardDraw.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            discardDraw.setBackgroundResource(R.drawable.plaintile);
        }

        switch (i) {
            case 14:

                slot1.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(0).getDrawable());
                slot2.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(1).getDrawable());
                slot3.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(2).getDrawable());
                slot4.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(3).getDrawable());
                slot5.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(4).getDrawable());
                slot6.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(5).getDrawable());
                slot7.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(6).getDrawable());
                slot8.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(7).getDrawable());
                slot9.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(8).getDrawable());
                slot10.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(9).getDrawable());
                slot11.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(10).getDrawable());
                slot12.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(11).getDrawable());
                slot13.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(12).getDrawable());
                slot14.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(13).getDrawable());
                break;

            case 13:
                slot1.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(0).getDrawable());
                slot2.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(1).getDrawable());
                slot3.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(2).getDrawable());
                slot4.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(3).getDrawable());
                slot5.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(4).getDrawable());
                slot6.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(5).getDrawable());
                slot7.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(6).getDrawable());
                slot8.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(7).getDrawable());
                slot9.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(8).getDrawable());
                slot10.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(9).getDrawable());
                slot11.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(10).getDrawable());
                slot12.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(11).getDrawable());
                slot13.setBackgroundResource(state.getGamePlayers().get(playerNum).getHand().get(12).getDrawable());
                slot14.setBackgroundResource(R.drawable.plaintile);
                break;
        }
        /*
        if (i > 0) {
            slot1.setBackgroundResource(state.getGamePlayers().get(getPosition()).getHand().get(0).getDrawable());
            if (i > 1) {
                slot2.setBackgroundResource(
                        state.getGamePlayers().get(getPosition()).getHand().get(1).getDrawable());
                if (i > 2) {
                    slot3.setBackgroundResource(
                            state.getGamePlayers().get(getPosition()).getHand().get(2).getDrawable());
                    if (i > 3) {
                        slot4.setBackgroundResource(
                                state.getGamePlayers().get(getPosition()).getHand().get(3).getDrawable());
                        if (i > 4) {
                            slot5.setBackgroundResource(
                                    state.getGamePlayers().get(getPosition()).getHand().get(4).getDrawable());
                            if (i > 5) {
                                slot6.setBackgroundResource(
                                        state.getGamePlayers().get(getPosition()).getHand().get(5).getDrawable());
                                if (i > 6) {
                                    slot7.setBackgroundResource(
                                            state.getGamePlayers().get(getPosition()).getHand().get(6).getDrawable());
                                    if (i > 7) {
                                        slot8.setBackgroundResource(
                                                state.getGamePlayers().get(getPosition()).getHand().get(7).getDrawable());
                                        if (i > 8) {
                                            slot9.setBackgroundResource(
                                                    state.getGamePlayers().get(getPosition()).getHand().get(8).getDrawable());
                                            if (i > 9) {
                                                slot10.setBackgroundResource(
                                                        state.getGamePlayers().get(getPosition()).getHand().get(9).getDrawable());
                                                if (i > 10) {
                                                    slot11.setBackgroundResource(
                                                            state.getGamePlayers().get(getPosition()).getHand().get(10).getDrawable());
                                                    if (i > 11) {
                                                        slot12.setBackgroundResource(
                                                                state.getGamePlayers().get(getPosition()).getHand().get(11).getDrawable());
                                                        if (i > 12) {
                                                            slot13.setBackgroundResource(
                                                                    state.getGamePlayers().get(getPosition()).getHand().get(12).getDrawable());
                                                            if (i > 13) {
                                                                slot14.setBackgroundResource(
                                                                        state.getGamePlayers().get(getPosition()).getHand().get(13).getDrawable());
                                                            }
                                                            else
                                                            {
                                                                slot14.setBackgroundResource(R.drawable.plaintile);
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
            */

}


    /**
     * callback method--our game has been chosen/rechosen to be the GUI,
     * called from the GUI thread
     *
     * @param activity the activity under which we are running
     */
    public void setAsGui(GameMainActivity activity) {

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.play_screen);
        mediaPlayer = MediaPlayer.create(activity.getApplicationContext(), R.raw.celebrate);
        mediaPlayer.start();


        this.slot1 = (ImageButton) activity.findViewById(R.id.slot1);
        this.slot2 = (ImageButton) activity.findViewById(R.id.slot2);
        this.slot3 = (ImageButton) activity.findViewById(R.id.slot3);
        this.slot4 = (ImageButton) activity.findViewById(R.id.slot4);
        this.slot5 = (ImageButton) activity.findViewById(R.id.slot5);
        this.slot6 = (ImageButton) activity.findViewById(R.id.slot6);
        this.slot7 = (ImageButton) activity.findViewById(R.id.slot7);
        this.slot8 = (ImageButton) activity.findViewById(R.id.slot8);
        this.slot9 = (ImageButton) activity.findViewById(R.id.slot9);
        this.slot10 = (ImageButton) activity.findViewById(R.id.slot10);
        this.slot11 = (ImageButton) activity.findViewById(R.id.slot11);
        this.slot12 = (ImageButton) activity.findViewById(R.id.slot12);
        this.slot13 = (ImageButton) activity.findViewById(R.id.slot13);
        this.slot14 = (ImageButton) activity.findViewById(R.id.slot14);
        this.wallDraw = (ImageButton) activity.findViewById(R.id.drawButton);
        this.discardDraw = (ImageButton) activity.findViewById(R.id.discardDraw);
        this.howTo = (ImageButton)activity.findViewById(R.id.howToButton);
        this.settings = (ImageButton)activity.findViewById(R.id.settingButton);
        this.info = (ImageButton)activity.findViewById(R.id.infoButton);
        this.exit = (ImageButton)activity.findViewById(R.id.exitButton);

        slot1.setOnClickListener(this);
        slot2.setOnClickListener(this);
        slot3.setOnClickListener(this);
        slot4.setOnClickListener(this);
        slot5.setOnClickListener(this);
        slot6.setOnClickListener(this);
        slot7.setOnClickListener(this);
        slot8.setOnClickListener(this);
        slot9.setOnClickListener(this);
        slot10.setOnClickListener(this);
        slot11.setOnClickListener(this);
        slot12.setOnClickListener(this);
        slot13.setOnClickListener(this);
        slot14.setOnClickListener(this);
        wallDraw.setOnClickListener(this);
        discardDraw.setOnClickListener(this);
        howTo.setOnClickListener(this);
        settings.setOnClickListener(this);
        info.setOnClickListener(this);
        exit.setOnClickListener(this);


        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}



