import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGameTesting {

    public static void main(String[] args) {
        Account player_account = new Account("Matthew", 1000);
        System.out.println("you have created a new account and have a starting balance of " + player_account.getBalance());
        Scanner input = new Scanner(System.in);
        boolean aceFlag = false;
        char c; //Char to drive menu choice
        ArrayList<PlayingCard> cardDeck = new ArrayList<>();
        ArrayList<PlayingCard> playingDeck = new ArrayList<>();
        cardDeck = CardDeck.CreateCardDeck();
        playingDeck = CardDeck.ShuffleCardDeck(cardDeck);
        do{
            printMenu();
            //Grab the user input
            c = Character.toUpperCase(input.next().charAt(0));


            if(c=='A'){
                System.out.println("Please Enter Bet");
                Scanner betScanner = new Scanner(System.in);
                int bet = betScanner.nextInt();
                int handValue = 0;
                player_account.debit(bet);
                handValue += CardDeck.MakeBlackJackHand(playingDeck);
                System.out.println(handValue);


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
