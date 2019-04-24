package edu.up.cs301.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.mahjong.MahjongState;
import edu.up.cs301.mahjong.mTiles;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

public class MahjongTest {

    @Test
    public void initTiles() {
        MahjongState gameState = new MahjongState();
        for(int i = 0; i < 14; i++)
        {
            assertTrue( "i: " + i + "\ntile: " + gameState.getGamePlayers().get(0).getHand().get(i).getValue(),
                    gameState.getGamePlayers().get(0).getHand().get(0).getValue() >= 1 &&
                            gameState.getGamePlayers().get(0).getHand().get(i).getValue() <= 9);
        }
    }

    @Test
    public void currentTurn() {
        MahjongState gameState = new MahjongState();
        assertTrue(gameState.getTurn() == 0);
    }

    @Test
    public void nextTurn() {
        MahjongState gameState = new MahjongState();
        assertTrue(gameState.nextTurn(gameState.getGamePlayers().get(0)));

        assertEquals(gameState.getGamePlayers().get(0).getPosition(), 0);
        assertEquals(gameState.getGamePlayers().get(1).getPosition(), 1);
        assertEquals(gameState.getGamePlayers().get(2).getPosition(), 2);
        assertEquals(gameState.getGamePlayers().get(3).getPosition(), 3);

        assertEquals(gameState.getTurn(), 1);
    }

    @Test
    public void drawFromWall() {
        MahjongState gameState = new MahjongState();
        mTiles tile = new mTiles(1,"Bamboo");
        assertTrue(gameState.drawFromWall(tile, 0));
        // ArrayList<mPlayer> temp = new ArrayList<> (gameState.getGamePlayers());
        assertTrue(gameState.getGamePlayers().get(0).getHand().get(0).getValue() >= 1 &&
                gameState.getGamePlayers().get(0).getHand().get(0).getValue() <= 9);
    }

    @Test
    public void findLargestSet()
    {
        MahjongState state = new MahjongState();
        ArrayList<mTiles> bamboos = new ArrayList<mTiles> ();

        for(int i = 0; i < state.getGamePlayers().get(0).getHand().size(); i++)
        {
            if(state.getGamePlayers().get(0).getHand().get(i).getSuit() == "Bamboo")
            {
                bamboos.add(state.getGamePlayers().get(0).getHand().get(i));
            }
        }
        for(int i = 0; i < bamboos.size(); i++)
        {
            for(int j = i; j < bamboos.size(); j++)
            {
                if(bamboos.get(i).getValue() > bamboos.get(j).getValue())
                {
                    Collections.swap(bamboos, i, j);
                }
            }
        }
        mTiles dot1 = new mTiles( 1, "Bamboo");
        mTiles dot2 = new mTiles( 2, "Bamboo");
        mTiles dot4 = new mTiles( 4, "Bamboo");
        mTiles dot5 = new mTiles( 5, "Bamboo");
        mTiles dot6 = new mTiles( 6, "Bamboo");
        mTiles dot7 = new mTiles( 7, "Bamboo");

        ArrayList<mTiles> dots = new ArrayList<> ();
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot4);
        dots.add(dot5);
        dots.add(dot6);
        dots.add(dot7);

        // assertTrue("" + state.findLargestSet(dots).size(), false);
        for(int i = 0; i < state.findLargestSet(dots).size(); i++)
        {
            assertEquals(dots.get(state.findLargestSet(dots).get(i)).getValue(), i+4);
        }
        assertTrue(state.findLargestSet(dots).size() == 4);

    }

    @Test
    public void findLowestMatching ()
    {
        MahjongState state = new MahjongState();
        ArrayList<mTiles> bamboos = new ArrayList<mTiles> ();

        for(int i = 0; i < state.getGamePlayers().get(0).getHand().size(); i++)
        {
            if(state.getGamePlayers().get(0).getHand().get(i).getSuit() == "Bamboo")
            {
                bamboos.add(state.getGamePlayers().get(0).getHand().get(i));
            }
        }
        for(int i = 0; i < bamboos.size(); i++)
        {
            for(int j = i; j < bamboos.size(); j++)
            {
                if(bamboos.get(i).getValue() > bamboos.get(j).getValue())
                {
                    Collections.swap(bamboos, i, j);
                }
            }
        }
        //assertEquals(state.findLowestMatching(bamboos).size(), -1);

        /*
        for(int i = 0; i < state.findLowestMatching(bamboos).size(); i++)
        {
            assertTrue("" + state.findLowestMatching(bamboos).get(i),false);
        }
        */

        mTiles dot1 = new mTiles( 1, "Dot");
        mTiles dot2 = new mTiles( 1, "Dot");
        mTiles dot4 = new mTiles( 2, "Dot");
        mTiles dot5 = new mTiles( 2, "Dot");
        mTiles dot6 = new mTiles( 6, "Dot");
        mTiles dot7 = new mTiles( 7, "Dot");

        ArrayList<mTiles> dots = new ArrayList<> ();
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot4);
        dots.add(dot5);
        dots.add(dot6);
        dots.add(dot7);
        // assertTrue("" + state.findLowestMatching(dots).get(16), false);
    }


    @Test
    public void mahjongCheck ()
    {
        MahjongState state = new MahjongState();
        ArrayList<mTiles> pHand = state.getGamePlayers().get(0).getHand();
        ArrayList<mTiles> winningHand = new ArrayList<> ();

        mTiles tile1 = new mTiles(1, "Bamboo");
        mTiles tile2 = new mTiles(2, "Bamboo");
        mTiles tile3 = new mTiles(3, "Bamboo");
        mTiles tile4 = new mTiles(4, "Bamboo");
        mTiles tile5 = new mTiles(1, "Dots");
        mTiles tile6 = new mTiles(1, "Dots");
        mTiles tile7 = new mTiles(1, "Dots");
        mTiles tile8 = new mTiles(5, "Characters");
        mTiles tile9 = new mTiles(6, "Characters");
        mTiles tile10 = new mTiles(7, "Characters");
        mTiles tile11 = new mTiles(8, "Characters");
        mTiles tile12 = new mTiles(7, "Bamboo");
        mTiles tile13 = new mTiles(8, "Bamboo");
        mTiles tile14 = new mTiles(5, "Bamboo");

        winningHand.add(tile1);
        winningHand.add(tile2);
        winningHand.add(tile3);
        winningHand.add(tile4);
        winningHand.add(tile5);
        winningHand.add(tile6);
        winningHand.add(tile7);
        winningHand.add(tile8);
        winningHand.add(tile9);
        winningHand.add(tile10);
        winningHand.add(tile11);
        winningHand.add(tile12);
        winningHand.add(tile13);
        winningHand.add(tile14);


        assertTrue(state.mahjongCheck(winningHand));
    }
}

