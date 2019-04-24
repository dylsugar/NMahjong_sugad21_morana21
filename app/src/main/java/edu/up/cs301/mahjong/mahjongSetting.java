package edu.up.cs301.mahjong;


import android.app.Activity;
import android.os.Bundle;

import java.io.Serializable;

import edu.up.cs301.game.R;


public class mahjongSetting extends Activity implements Serializable {
    private static long serialVersionUID = 1850386927582L;


    /*
    goes to game_setting xml if this class is called
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_settings);

    }


}