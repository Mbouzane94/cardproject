import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.ArrayList;

public class playingcardtest {

    public static void main(String[] args){
//        PlayingCard playingCard = new PlayingCard("7", "D");
//        String x = playingCard.toString();
//        System.out.println(x);
//
//        String y = PlayCardFactory.generateRandomCardFromSuit("H");
//        System.out.println(y);

        ArrayList<PlayingCard> card_deck = new ArrayList<>();
        card_deck = CardDeck.CreateCardDeck();
        CardDeck.ShuffleCardDeck(card_deck);
        PlayingCard card1 = CardDeck.DrawCard(card_deck);
        PlayingCard card2 = CardDeck.DrawCard(card_deck);
        PlayingCard card3 = CardDeck.DrawCard(card_deck);
        PlayingCard card4 = CardDeck.DrawCard(card_deck);
        PlayingCard card5 = CardDeck.DrawCard(card_deck);
        PlayingCard card6 = CardDeck.DrawCard(card_deck);
        PlayingCard card7 = CardDeck.DrawCard(card_deck);
//        System.out.println(card1);
//        System.out.println(card2);
//        System.out.println(card3);
//        System.out.println(card4);
//        System.out.println(card5);
//        System.out.println(card6);
//        System.out.println(card7);
//        System.out.println(card_deck);

        int x = CardDeck.MakeBlackJackHand(card_deck);
        System.out.println(x);

    }

}
