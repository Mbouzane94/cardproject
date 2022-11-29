import java.lang.*;

/**
 * Playing Card Class, creates and modifys playing card objects.
 */
public class PlayingCard {

    private String cardNumber;

    private String cardSuit;

    public PlayingCard(String inputCardNumber , String inputCardSuit){

        if (inputCardNumber.equals("1")) {
            this.cardNumber = "A";
        }
        else if (inputCardNumber.equals("11")) {
            this.cardNumber = "J";
        }
        else if (inputCardNumber.equals("12")) {
            this.cardNumber = "Q";
        }
        else if (inputCardNumber.equals("13")) {
            this.cardNumber = "K";
        }
        else {
            this.cardNumber = inputCardNumber;
        }

        String heartsString = "\u2764";
        String spadesString = "\u2660";
        String diamondsString = "\u2666";
        String clubsString = "\u2663";
        String cardSuitChecker = inputCardSuit.toUpperCase();
        if (cardSuitChecker.equals("H")) {
            this.cardSuit = heartsString;
        }
        else if (cardSuitChecker.equals("S")) {
            this.cardSuit = spadesString;
        }

        else if (cardSuitChecker.equals("C")) {
            this.cardSuit = clubsString;
        }

        else if (cardSuitChecker.equals("D")) {
            this.cardSuit = diamondsString;
        }
        else {
            System.out.println("Please Enter the first letter of the suit you are trying to make. IE for 'Hearts enter H");
        }
    }

    /**
     * Method for getting a numerical value of a card
     * @return string values, because of J, Q, K, A.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Method for getting the cards suit.
     * @return the suit of the playing card object that was passed in. String
     */
    public String getCardSuit() {
        return cardSuit;
    }

    @Override
    public String toString() {
        return cardNumber + cardSuit;
    }

}
