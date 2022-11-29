import java.util.*;

public class CardDeck {

    public static ArrayList CreateCardDeck() {
        ArrayList<PlayingCard> card_deck = new ArrayList<>();
        int counter_hearts = 0;
        int counter_diamonds = 0;
        int counter_spades = 0;
        int counter_clubs = 0;
        int card_number_counter_hearts = 1;
        int card_number_counter_diamonds = 1;
        int card_number_counter_spades = 1;
        int card_number_counter_clubs = 1;
        while (counter_hearts < 13) {
            String card_number_string = String.valueOf(card_number_counter_hearts);
            PlayingCard card = new PlayingCard(card_number_string, "h");
            card_deck.add(card);
            counter_hearts++;
            card_number_counter_hearts++;
        }
        while (counter_diamonds < 13) {
            String card_number_string = String.valueOf(card_number_counter_diamonds);
            PlayingCard card = new PlayingCard(card_number_string, "d");
            card_deck.add(card);
            counter_diamonds++;
            card_number_counter_diamonds++;
        }
        while (counter_spades < 13) {
            String card_number_string = String.valueOf(card_number_counter_spades);
            PlayingCard card = new PlayingCard(card_number_string, "s");
            card_deck.add(card);
            counter_spades++;
            card_number_counter_spades++;
        }
        while (counter_clubs < 13) {
            String card_number_string = String.valueOf(card_number_counter_clubs);
            PlayingCard card = new PlayingCard(card_number_string, "c");
            card_deck.add(card);
            counter_clubs++;
            card_number_counter_clubs++;
        }

        return card_deck;
    }

    public static ArrayList ShuffleCardDeck(ArrayList card_deck) {
        Collections.shuffle(card_deck);
        return card_deck;
    }

    public static PlayingCard DrawCard(ArrayList<PlayingCard> card_deck) {
        if (card_deck.size() > 1) {
            PlayingCard drawn_card = card_deck.get(0);
            card_deck.remove(0);
            return drawn_card;
        }
        else if (card_deck.size() == 1){
            System.out.println("Deck is now empty");
            PlayingCard drawn_card = card_deck.get(0);
            card_deck.remove(0);
            return drawn_card;
        }
        else {
            return null;
        }

    }

//        public static int MakeBlackJackHand(){
//            ArrayList<PlayingCard> card_deck = new ArrayList<>();
//            card_deck = CardDeck.CreateCardDeck();
//            ArrayList<PlayingCard> hand_of_cards = new ArrayList<>();
//            hand_of_cards.add(CardDeck.DrawCard(card_deck));
//            hand_of_cards.add(CardDeck.DrawCard(card_deck));
//            int handValue = 0;
//            int intCardValue = 0;
//            for (int i = 0; i < hand_of_cards.size(); i++) {
//                PlayingCard cardValue = hand_of_cards.get(i);
//                String stringCardValue = cardValue.getCard_number();
//                if (stringCardValue.equals("A")){
//                    intCardValue = 1;
//                    handValue += intCardValue;
//                } else if (stringCardValue.equals("J")) {
//                    intCardValue = 2;
//                    handValue += intCardValue;
//                } else if (stringCardValue.equals("Q")) {
//                    intCardValue = 3;
//                    handValue += intCardValue;
//                } else if (stringCardValue.equals("K")) {
//                    intCardValue = 4;
//                    handValue += intCardValue;
//                }
//                else {
//                    intCardValue = Integer.parseInt(stringCardValue);
//                    handValue += intCardValue;
//                }
//                System.out.println(hand_of_cards);
//            }
//            return handValue;
//        }
}



