import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int playersCard1 = drawRandomCard();
        int playersCard2 = drawRandomCard();
        int playerSum = Math.min(playersCard1, 10) + Math.min(playersCard2, 10);

        System.out.println("\n You get a \n" + cardString(playersCard1) + "\n and a \n" + cardString(playersCard2));

        System.out.println("Your total is: " + playerSum);

        int dealersCard1 = drawRandomCard();
        int dealersCard2 = drawRandomCard();
        int dealerSum = Math.min(dealersCard1, 10) + Math.min(dealersCard2, 10);
        System.out.println("The dealer shows \n" + cardString(dealersCard1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("The dealer's total is hidden");

        while (true) {
            String hitOrStay = hitOrStay();

            if (hitOrStay.equals("stay")) break;

            int newCard = drawRandomCard();
            playerSum += Math.min(newCard, 10);
            System.out.println("You get a\n" + cardString(newCard));
            System.out.println("\nYour new total is: " + playerSum);

            if (playerSum > 21) {
                System.out.println("\nBust! Player loses.");
                System.exit(0);
            }
        }

        System.out.println("\nDealer's turn");
        System.out.println("The dealer's cards are\n" + cardString(playersCard2) + "\nand a\n" + cardString(dealersCard2));

        while (dealerSum < 17) {
            int newCard = drawRandomCard();
            dealerSum += Math.min(newCard, 10);
            System.out.println("\nDealer gets a\n" + cardString(newCard));
            System.out.println("\nDealer's total is " + dealerSum);
            if (dealerSum >= 17) {
                System.out.println("\nEnd of dealer's turn.");
                break;
            }
        }

        if (dealerSum > 21) {
            System.out.println("\nBust! Dealer loses");
            System.exit(0);
        }

        if (playerSum > dealerSum) {
            System.out.println("\nPlayer wins!");
        } else {
            System.out.println("\nDealer wins!");
        }
        scan.close();
    }

    /**
     * Function name – drawRandomCard
     *
     * @return (int)
     * <p>
     * Inside the function:
     * 1. Gets a random number between 1 and 13.
     * 2. Returns a card.
     */
    public static int drawRandomCard() {
        double card = (Math.random() * 13) + 1;
        return (int) card;
    }

    /**
     * Function name – cardString
     *
     * @param cardNumber (int)
     * @return (String)
     * <p>
     * Inside the function:
     * 1. Returns a String drawing of the card.
     */
    public static String cardString(int cardNumber) {
        return switch (cardNumber) {
            case 1 -> """
                       _____
                      |A _  |
                      | ( ) |
                      |(_'_)|
                      |  |  |
                      |____V|
                    """;
            case 2 -> """
                       _____
                      |2    |
                      |  o  |
                      |     |
                      |  o  |
                      |____Z|
                    """;
            case 3 -> """
                       _____
                      |3    |
                      | o o |
                      |     |
                      |  o  |
                      |____E|
                    """;
            case 4 -> """
                       _____
                      |4    |
                      | o o |
                      |     |
                      | o o |
                      |____h|
                    """;
            case 5 -> """
                       _____\s
                      |5    |
                      | o o |
                      |  o  |
                      | o o |
                      |____S|
                    """;
            case 6 -> """
                       _____\s
                      |6    |
                      | o o |
                      | o o |
                      | o o |
                      |____6|
                    """;
            case 7 -> """
                       _____\s
                      |7    |
                      | o o |
                      |o o o|
                      | o o |
                      |____7|
                    """;
            case 8 -> """
                       _____\s
                      |8    |
                      |o o o|
                      | o o |
                      |o o o|
                      |____8|
                    """;
            case 9 -> """
                       _____\s
                      |9    |
                      |o o o|
                      |o o o|
                      |o o o|
                      |____9|
                    """;
            case 10 -> """
                       _____\s
                      |10  o|
                      |o o o|
                      |o o o|
                      |o o o|
                      |___10|
                    """;
            case 11 -> """
                       _____
                      |J  ww|
                      | o {)|
                      |o o% |
                      | | % |
                      |__%%[|
                    """;
            case 12 -> """
                       _____
                      |Q  ww|
                      | o {(|
                      |o o%%|
                      | |%%%|
                      |_%%%O|
                    """;
            case 13 -> """
                       _____
                      |K  WW|
                      | o {)|
                      |o o%%|
                      | |%%%|
                      |_%%%>|
                    """;
            default -> "ERROR";
        };
    }

    /**
     * Function name – faceDown
     *
     * @return (String)
     * <p>
     * Inside the function:
     * 1. Returns a String drawing of the card faced down.
     */
    public static String faceDown() {
        return
                """
                           _____
                          |     |
                          |  J  |
                          | JJJ |
                          |  J  |
                          |_____|
                        """;
    }

    /**
     * Function name – hitOrStay
     *
     * @return (String)
     * <p>
     * Inside the function:
     * 1. Asks the user to hit or stay.
     * 2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     * Please write 'hit' or 'stay'
     * 3. Returns the user's option
     */
    public static String hitOrStay() {
        System.out.println("Please write 'hit' or 'stay'");
        String decision = scan.nextLine();
        while (!decision.equals("hit") && !decision.equals("stay")) {
            System.out.println("Please try again.");
            decision = scan.nextLine();
        }
        return decision;
    }
}

