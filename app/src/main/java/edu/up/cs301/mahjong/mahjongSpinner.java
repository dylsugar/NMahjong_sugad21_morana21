package edu.up.cs301.mahjong;


import android.app.Activity;
import android.os.Bundle;

import java.io.Serializable;

import edu.up.cs301.game.R;


public class mahjongSpinner extends Activity implements Serializable {

    private static long serialVersionUID = 1293786127936L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_spinner);
    }


}
