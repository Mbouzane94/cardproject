import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Account player_account = new Account("Matthew", 1000);
        System.out.println("you have created a new account and have a starting balance of " + player_account.getBalance());
        Scanner input = new Scanner(System.in);
        boolean aceFlag = false;
        char c; //Char to drive menu choice
        ArrayList<PlayingCard> card_deck = new ArrayList<>();
        ArrayList<PlayingCard> playingDeck = new ArrayList<>();
        card_deck = CardDeck.CreateCardDeck();
        playingDeck = CardDeck.ShuffleCardDeck(card_deck);
        do{
            printMenu();
            //Grab the user input
            c = Character.toUpperCase(input.next().charAt(0));


            if(c=='A'){
                System.out.println("Please Enter Bet");
                Scanner betScanner = new Scanner(System.in);
                int bet = betScanner.nextInt();
                player_account.debit(bet);
                ArrayList<PlayingCard> hand_of_cards = new ArrayList<>();
                hand_of_cards.add(CardDeck.DrawCard(playingDeck));
                hand_of_cards.add(CardDeck.DrawCard(playingDeck));
                int handValue = 0;
                int intCardValue = 0;
                for (int i = 0; i < hand_of_cards.size(); i++) {
                    PlayingCard cardValue = hand_of_cards.get(i);
                    String stringCardValue = cardValue.getCardNumber();
                    if (stringCardValue.equals("A")){
                        intCardValue = 11;
                        handValue += intCardValue;
                    } else if (stringCardValue.equals("J")) {
                        intCardValue = 10;
                        handValue += intCardValue;
                    } else if (stringCardValue.equals("Q")) {
                        intCardValue = 10;
                        handValue += intCardValue;
                    } else if (stringCardValue.equals("K")) {
                        intCardValue = 10;
                        handValue += intCardValue;
                    }
                    else {
                        intCardValue = Integer.parseInt(stringCardValue);
                        handValue += intCardValue;
                    }
                }
                if (handValue == 21) {
                    System.out.println("BLACKJACK!!!! YOU WIN");
                    double winningBet = bet * 2.5;
                    player_account.credit(winningBet);
                }
                while( handValue < 21) {
                    System.out.println("Your hand is " + hand_of_cards + " with a total value of " + handValue);
                    System.out.println("Would you like to hit? (y/n)");
                    Scanner hitScanner = new Scanner(System.in);
                    char d = Character.toUpperCase(input.next().charAt(0));
                    if (d == 'Y') {
                        PlayingCard cardDrawn = CardDeck.DrawCard(playingDeck);
                        hand_of_cards.add(cardDrawn);
                        System.out.println("You Drew " + cardDrawn.toString());
                        if (cardDrawn.getCardNumber().equals("A")) {
                            int aceValue = 11;
                            handValue += aceValue;
                            for (int j = 0; j < hand_of_cards.size() ; j++) {
                                String aceCheckerString = hand_of_cards.get(0).getCardNumber();
                                if (aceCheckerString.equals("A")) {
                                    System.out.println("Your current hand is" + hand_of_cards + " with a value of " + handValue);
                                    System.out.println("Would you like your ace to be worth 1 or 11? \n select a for 1, select b for 11");
                                    Scanner aceScanner = new Scanner(System.in);
                                    char e = Character.toUpperCase(input.next().charAt(0));
                                    if (e == 'A'){
                                        int newAceValue = 1;
                                        handValue = handValue - aceValue;
                                        handValue += newAceValue;
                                    } else if (e == 'B'){
                                        int newAceValue = 11;
                                        handValue = handValue - aceValue;
                                        handValue += newAceValue;
                                    }
                                }
                            }
                        } else if (cardDrawn.getCardNumber().equals("J")) {
                            handValue += 10;
                        } else if (cardDrawn.getCardNumber().equals("Q")) {
                            handValue += 10;
                        } else if (cardDrawn.getCardNumber().equals("K")) {
                            handValue += 10;
                        } else{
                            handValue += Integer.parseInt(cardDrawn.getCardNumber());
                        }
                    }
                    if (d == 'N') {
                        System.out.println("Your hand value is " + handValue);
                        break;
                    }
                    if (handValue > 21) {
                        for (int j = 0; j < hand_of_cards.size() ; j++) {
                            String aceCheckerString = hand_of_cards.get(0).getCardNumber();
                            if (aceCheckerString.equals("A")) {
                                System.out.println("Your current hand is" + hand_of_cards + " with a value of " + handValue);
                                System.out.println("Would you like your ace to be worth 1 or 11? \n select a for 1, select b for 11");
                                Scanner aceScanner = new Scanner(System.in);
                                char f = Character.toUpperCase(input.next().charAt(0));
                                if (f == 'A'){
                                    handValue += 1;
                                } else if (f == 'B'){
                                    handValue += 11;
                                }
                            }
                        }
                        System.out.println("BUST! YOU LOSE");
                        boolean bust = true;
                        break;
                    }
                }
                if (handValue > 21){
                    System.out.println("Thanks for playing!");
                }
                else{
                System.out.println("Your Hand Value is " + handValue + " Lets see if you beat the dealers");
                ArrayList<PlayingCard> dealer_hand_of_cards = new ArrayList<>();
                dealer_hand_of_cards.add(CardDeck.DrawCard(playingDeck));
                dealer_hand_of_cards.add(CardDeck.DrawCard(playingDeck));
                int dealerhandValue = 0;
                int dealerintCardValue = 0;
                for (int i = 0; i < dealer_hand_of_cards.size(); i++) {
                    PlayingCard dealerCardValue = dealer_hand_of_cards.get(i);
                    String dealerStringCardValue = dealerCardValue.getCardNumber();
                    if (dealerStringCardValue.equals("A")) {
                        dealerintCardValue = 11;
                        dealerhandValue += dealerintCardValue;
                    } else if (dealerStringCardValue.equals("J")) {
                        dealerintCardValue = 10;
                        dealerhandValue += dealerintCardValue;
                    } else if (dealerStringCardValue.equals("Q")) {
                        dealerintCardValue = 10;
                        dealerhandValue += dealerintCardValue;
                    } else if (dealerStringCardValue.equals("K")) {
                        dealerintCardValue = 10;
                        dealerhandValue += dealerintCardValue;
                    } else {
                        dealerintCardValue = Integer.parseInt(dealerStringCardValue);
                        dealerhandValue += dealerintCardValue;
                    }}
                    while(dealerhandValue < 17){
                        PlayingCard dealerCardDrawn = CardDeck.DrawCard(playingDeck);
                        dealer_hand_of_cards.add(dealerCardDrawn);
                        if (dealerCardDrawn.getCardNumber().equals("A")) {
                            if ((dealerhandValue + 11) > 21) {
                                dealerhandValue += 1;
                            } else {
                                dealerhandValue += 11;
                            }

                        }
                        else if (dealerCardDrawn.getCardNumber().equals("J")){
                            dealerhandValue += 10;
                        }
                        else if (dealerCardDrawn.getCardNumber().equals("Q")){
                            dealerhandValue += 10;
                        }
                        else if (dealerCardDrawn.getCardNumber().equals("K")){
                            dealerhandValue += 10;
                        }
                        else{
                            dealerhandValue += Integer.parseInt(dealerCardDrawn.getCardNumber());
                        }
                    }

                if (dealerhandValue > 21){
                    System.out.println("Dealer Busts with a hand of " + dealer_hand_of_cards + "with a value of" + dealerhandValue + " Player wins");
                    player_account.credit(bet * 2);
                }
                else if (dealerhandValue < handValue) {
                    System.out.println("You Win, Your hand value is " + handValue + ", You beat the dealers hand value of " + dealerhandValue + " Dealers hand" + dealer_hand_of_cards);
                    player_account.credit(bet * 2);
                }
                else if (dealerhandValue == handValue) {
                    System.out.println("PUSH");
                    System.out.println("Your hand" + hand_of_cards + "Dealers hand" + dealer_hand_of_cards);
                    player_account.credit(bet);
                }
                else{
                    System.out.println("You LOSE");
                    System.out.println("Dealer wins with a hand of " + dealer_hand_of_cards + "with a value of " + dealerhandValue + " Dealer wins");
                }
                System.out.println("You have " + player_account.getBalance() + " Money left, Thanks for Playing!");
                //todo enter dealer code
                }
            }
            else if(c=='B'){
                System.out.println("you have a balance of " + player_account.getBalance());
            }
            else if (c=='C'){
                System.out.println("Please enter amount you would like to add");
                Scanner amountToAdd = new Scanner(System.in);
                double moneyToAdd = amountToAdd.nextInt();
                player_account.credit(moneyToAdd);
                System.out.println("you have a balance of " + player_account.getBalance());


            }
            else if (c=='D'){
                player_account.reset();
                player_account.credit(1000);
                System.out.println("Your account has been reset and has the starting balance of " + player_account.getBalance());
            }


        }while(c!='Q');

        System.out.println("\nGOODBYE!");
    }

    public static void printMenu(){
        System.out.println("\n\nMake a choice");
        System.out.println("(A) Play Blackjack!");
        System.out.println("(B) Check Balance");
        System.out.println("(C) Add Funds");
        System.out.println("(D) Reset Account");
        System.out.println("(Q) Quit");
    }
}
