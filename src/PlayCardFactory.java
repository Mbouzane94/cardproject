import java.util.Random;
public class PlayCardFactory {

    /**
     * Method to create a random playing card
     * @return a string that contains the value and the suit of a Playing card object
     */
    public static String generateRandomCard(){
        String randomCardSuit = "";
        Random rand = new Random();
        int randomNumber = rand.nextInt(13) + 1;
        Random rand_suit = new Random();
        int randomSuitNumber = rand_suit.nextInt(4) + 1;
        if (randomSuitNumber == 1){
            randomCardSuit = "H";
        } else if (randomSuitNumber == 2){
            randomCardSuit = "D";
        }
        else if (randomSuitNumber == 3){
            randomCardSuit = "S";
        }
        else if (randomSuitNumber == 4){
            randomCardSuit = "C";
        }

        String randomNumberString = "" + randomNumber;

        PlayingCard playingCard = new PlayingCard(randomNumberString,randomCardSuit);

        return playingCard.toString();
    }

    /**
     * Creates a Plying card object with a random value from the given suit.
     * @param suit the suit you would like to create a Playing card from
     * @return String with the values of the playing card.
     */
    public static String generateRandomCardFromSuit(String suit){
        Random rand = new Random();
        int randomNumber = rand.nextInt(13) + 1;
        String randomNumberString = "" + randomNumber;
        PlayingCard playingCard = new PlayingCard(randomNumberString, suit);
        return playingCard.toString();
    }
}
