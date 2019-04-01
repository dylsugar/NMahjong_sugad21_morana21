package edu.up.cs301.mahjong;

import edu.up.cs301.game.R;

public class mTiles {
    private int value;
    private String suit;

    public mTiles(){
        value = 6;
        suit = "hearts";
    }

    public mTiles(int inValue, String inSuit){
        value = inValue;
        suit = inSuit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    //sets value of each value to a number 0-12 so it can be accessed as such

    public int getFace(){
        int temp = this.value;
        if(temp == 0){
            return 0;
        } else if(temp == 1){
            return 1;
        } else if(temp == 2){
            return 2;
        } else if(temp == 3){
            return 3;
        } else if(temp == 4){
            return 4;
        } else if(temp == 5){
            return 5;
        } else if(temp == 6){
            return 6;
        } else if(temp == 7){
            return 7;
        } else if(temp == 8){
            return 8;
        } else if(temp == 9) {
            return 9;
        }
        return 0;
    }

    public String getCardName(){
        return this.getFace() +"_" +this.getSuit();
    }

    //draws card from hand based parameters
    //if it is certain suit
    //checks 7-ace then 3-6 b/c bombs and wilds
    public int getDrawable() {
        switch (this.getFace()) {
            case 1:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo1;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot1;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character1;
                }
                break;
            case 2:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo2;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot2;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character2;
                }
                break;
            case 3:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo3;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot3;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character3;
                }
                break;
            case 4:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo4;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot4;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character4;
                }
                break;
            case 5:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo5;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot5;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character5;
                }
                break;
            case 6:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo6;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot6;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character6;
                }
                break;
            case 7:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo7;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot7;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character7;
                }
                break;
            case 8:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo8;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot6;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character6;
                }
                break;
            case 9:
                if (this.getSuit() == "Bamboo") {
                    return R.drawable.bamboo7;
                } else if (this.getSuit() == "Dots") {
                    return R.drawable.dot7;
                } else if (this.getSuit() == "Character") {
                    return R.drawable.character7;
                }
                break;
            default:
                break;
        }

        return 0;
    }
}
