import java.lang.*;
import java.util.*;
import java.io.*;
public class PlayingCard {

    private String card_number;

    private String card_suit;

    public PlayingCard(String input_card_number , String input_card_suit){

        if (input_card_number.equals("1")) {
            this.card_number = "A";
        }
        else if (input_card_number.equals("11")) {
            this.card_number = "J";
        }
        else if (input_card_number.equals("12")) {
            this.card_number = "Q";
        }
        else if (input_card_number.equals("13")) {
            this.card_number = "K";
        }
        else {
            this.card_number = input_card_number;
        }

        String hearts_string = "\u2764";
        String spades_string = "\u2660";
        String diamonds_string = "\u2666";
        String clubs_string = "\u2663";
        String card_suit_checker = input_card_suit.toUpperCase();
        if (card_suit_checker.equals("H")) {
            this.card_suit = hearts_string;
        }
        else if (card_suit_checker.equals("S")) {
            this.card_suit = spades_string;
        }

        else if (card_suit_checker.equals("C")) {
            this.card_suit = clubs_string;
        }

        else if (card_suit_checker.equals("D")) {
            this.card_suit = diamonds_string;
        }
        else {
            System.out.println("Please Enter the first letter of the suit you are tring to make. IE for 'Hearts enter H");
        }
    }


    public String getCard_number() {
        return card_number;
    }

    public String getCard_suit() {
        return card_suit;
    }


    public String toString() {
        return card_number + card_suit;
    }

}
