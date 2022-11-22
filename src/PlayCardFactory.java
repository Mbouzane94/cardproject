import java.util.Random;
public class PlayCardFactory {

    public static String generateRandomCard(){
        String random_card_suit = "";
        Random rand = new Random();
        int random_number = rand.nextInt(13) + 1;
        Random rand_suit = new Random();
        int random_suit_number = rand_suit.nextInt(4) + 1;
        if (random_suit_number == 1){
            random_card_suit = "H";
        } else if (random_suit_number == 2){
            random_card_suit = "D";
        }
        else if (random_suit_number == 3){
            random_card_suit = "S";
        }
        else if (random_suit_number == 4){
            random_card_suit = "C";
        }

        String random_number_string = "" + random_number;

        PlayingCard playingCard = new PlayingCard(random_number_string,random_card_suit);

        return playingCard.toString();
    }

    public static String generateRandomCardFromSuit(String suit){
        Random rand = new Random();
        int random_number = rand.nextInt(13) + 1;
        String random_number_string = "" + random_number;
        PlayingCard playingCard = new PlayingCard(random_number_string, suit);
        return playingCard.toString();
    }
}
