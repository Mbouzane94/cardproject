import java.util.*;

public class CardDeck {
    /**
     * class for creating Card decks. will work EVERYTIME
     * @return an arraylist of Playing Cards order in sequential value that follows hearts, Diamond, Spades, Clubs
     */
    public static ArrayList CreateCardDeck() {
        ArrayList<PlayingCard> cardDeck = new ArrayList<>();
        int counterHearts = 0;
        int counterDiamonds = 0;
        int counterSpades = 0;
        int counterClubs = 0;
        int cardNumberCounterHearts = 1;
        int cardNumberCounterDiamonds = 1;
        int cardNumberCounterSpades = 1;
        int cardNumberCounterClubs = 1;
        while (counterHearts < 13) {
            String cardNumberString = String.valueOf(cardNumberCounterHearts);
            PlayingCard card = new PlayingCard(cardNumberString, "h");
            cardDeck.add(card);
            counterHearts++;
            cardNumberCounterHearts++;
        }
        while (counterDiamonds < 13) {
            String cardNumberString = String.valueOf(cardNumberCounterDiamonds);
            PlayingCard card = new PlayingCard(cardNumberString, "d");
            cardDeck.add(card);
            counterDiamonds++;
            cardNumberCounterDiamonds++;
        }
        while (counterSpades < 13) {
            String cardNumberString = String.valueOf(cardNumberCounterSpades);
            PlayingCard card = new PlayingCard(cardNumberString, "s");
            cardDeck.add(card);
            counterSpades++;
            cardNumberCounterSpades++;
        }
        while (counterClubs < 13) {
            String cardNumberString = String.valueOf(cardNumberCounterClubs);
            PlayingCard card = new PlayingCard(cardNumberString, "c");
            cardDeck.add(card);
            counterClubs++;
            cardNumberCounterClubs++;
        }

        return cardDeck;
    }

    /**
     * Method to shuffle (Randomnize) the cardDeck
     * @param cardDeck an arraylist of Playingcard objects
     * @return the passed in cardDeck, shuffled
     */
    public static ArrayList ShuffleCardDeck(ArrayList cardDeck) {
        Collections.shuffle(cardDeck);
        return cardDeck;
    }

    /**
     * Method to draw a card from a carddeck. remocves it from the original card deck
     * @param cardDeck
     * @return the first Playingcard object from the card deck
     */
    public static PlayingCard DrawCard(ArrayList<PlayingCard> cardDeck) {
        if (cardDeck.size() > 1) {
            PlayingCard drawn_card = cardDeck.get(0);
            cardDeck.remove(0);
            return drawn_card;
        }
        else if (cardDeck.size() == 1){
            System.out.println("Deck is now empty");
            PlayingCard drawn_card = cardDeck.get(0);
            cardDeck.remove(0);
            return drawn_card;
        }
        else {
            return null;
        }

    }

        public static int MakeBlackJackHand(ArrayList<PlayingCard> cardDeck){
            ArrayList<PlayingCard> hand_of_cards = new ArrayList<>();
            hand_of_cards.add(CardDeck.DrawCard(cardDeck));
            hand_of_cards.add(CardDeck.DrawCard(cardDeck));
            int handValue = 0;
            int intCardValue = 0;
            for (int i = 0; i < hand_of_cards.size(); i++) {
                PlayingCard cardValue = hand_of_cards.get(i);
                String stringCardValue = cardValue.getCardNumber();
                if (stringCardValue.equals("A")){
                    intCardValue = 1;
                    handValue += intCardValue;
                } else if (stringCardValue.equals("J")) {
                    intCardValue = 2;
                    handValue += intCardValue;
                } else if (stringCardValue.equals("Q")) {
                    intCardValue = 3;
                    handValue += intCardValue;
                } else if (stringCardValue.equals("K")) {
                    intCardValue = 4;
                    handValue += intCardValue;
                }
                else {
                    intCardValue = Integer.parseInt(stringCardValue);
                    handValue += intCardValue;
                }
                System.out.println(hand_of_cards);
            }
            return handValue;
        }
}



