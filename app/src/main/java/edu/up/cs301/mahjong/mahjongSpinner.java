package edu.up.cs301.mahjong;


import android.app.Activity;
import android.os.Bundle;

import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.R;
import edu.up.cs301.game.config.GameConfig;

public class mahjongSpinner extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_spinner);
    }


}
