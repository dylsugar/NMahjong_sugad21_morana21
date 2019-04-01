package edu.up.cs301.mahjong;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import edu.up.cs301.game.R;

public class MahjongGameActivity extends Activity implements View.OnClickListener {

    private MahjongState instance;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);

        slot1 = (ImageButton) findViewById(R.id.slot1);
        slot1.setOnClickListener(this);
        slot2 = (ImageButton) findViewById(R.id.slot2);
        slot2.setOnClickListener(this);
        slot3 = (ImageButton) findViewById(R.id.slot3);
        slot3.setOnClickListener(this);
        slot4 = (ImageButton) findViewById(R.id.slot4);
        slot4.setOnClickListener(this);
        slot5 = (ImageButton) findViewById(R.id.slot5);
        slot5.setOnClickListener(this);
        slot6 = (ImageButton) findViewById(R.id.slot6);
        slot6.setOnClickListener(this);
        slot7 = (ImageButton) findViewById(R.id.slot7);
        slot7.setOnClickListener(this);
        slot8 = (ImageButton) findViewById(R.id.slot8);
        slot8.setOnClickListener(this);
        slot9 = (ImageButton) findViewById(R.id.slot9);
        slot9.setOnClickListener(this);
        slot10 = (ImageButton) findViewById(R.id.slot10);
        slot10.setOnClickListener(this);
        slot11 = (ImageButton) findViewById(R.id.slot11);
        slot11.setOnClickListener(this);
        slot12 = (ImageButton) findViewById(R.id.slot12);
        slot12.setOnClickListener(this);
        slot13 = (ImageButton) findViewById(R.id.slot13);
        slot13.setOnClickListener(this);
        slot14 = (ImageButton) findViewById(R.id.slot14);
        slot14.setOnClickListener(this);
        wallDraw = (ImageButton) findViewById(R.id.drawButton);
        wallDraw.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.slot1:
            case R.id.slot2:
            case R.id.slot3:
            case R.id.slot4:
            case R.id.slot5:
            case R.id.slot6:
            case R.id.slot7:
            case R.id.slot8:
            case R.id.slot9:
            case R.id.slot10:
            case R.id.slot11:
            case R.id.slot12:
            case R.id.slot13:
            case R.id.drawButton:
        }
    }

        public void updateTiles() {
            int i = instance.getGamePlayers().get(playerIndex).getHand().size();
            if (i > 1) {
                slot1.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand().get(1).getCardName(), "drawable", getPackageName()));
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
                                                                slot13.setImageResource(getResources().getIdentifier(instance.getGamePlayers().get(playerIndex).getHand).get(13).getCardName(), "drawable", getPackageName());
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

        public void updateDiscardTile {
            if(instance.)


        }
    }
}
