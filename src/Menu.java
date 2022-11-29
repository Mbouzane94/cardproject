import java.util.*;

public class Menu {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            char c; //Char to drive menu choice
            ArrayList<PlayingCard> card_deck = new ArrayList<>();
            card_deck = CardDeck.CreateCardDeck();

            do{
                printMenu();
                //Grab the user input
                c = Character.toUpperCase(input.next().charAt(0));


                if(c=='A'){
                    System.out.println(CardDeck.DrawCard(card_deck));
                }
                else  if(c=='B'){
                    ArrayList<PlayingCard> hand_of_cards = new ArrayList<>();
                    hand_of_cards.add(CardDeck.DrawCard(card_deck));
                    hand_of_cards.add(CardDeck.DrawCard(card_deck));
                    hand_of_cards.add(CardDeck.DrawCard(card_deck));
                    hand_of_cards.add(CardDeck.DrawCard(card_deck));
                    hand_of_cards.add(CardDeck.DrawCard(card_deck));
                    System.out.println(hand_of_cards);
                }
                else if (c=='C'){
                    CardDeck.ShuffleCardDeck(card_deck);

                }
                else if (c=='D'){
                    System.out.println(card_deck);
                }


            }while(c!='Q');

            System.out.println("\nGOODBYE!");
        }

        public static void printMenu(){
            System.out.println("\n\nMake a choice");
            System.out.println("(A) Draw a card");
            System.out.println("(B) Draw a hand");
            System.out.println("(C) Shuffle the deck");
            System.out.println("(D) Print the deck");
            System.out.println("(Q) Quit");
        }

    }
