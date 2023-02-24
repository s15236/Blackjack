import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int randomCard1 = drawRandomCard();
        int randomCard2 = drawRandomCard();
        int sum = Math.min(randomCard1, 10) + Math.min(randomCard2, 10);

        System.out.println("\n You get a \n" + cardString(randomCard1) + "\n and a \n" + cardString(randomCard2));

        System.out.println("Your total is: "+sum);

        int randomCard3 = drawRandomCard();
        int randomCard4 = drawRandomCard();
        System.out.println("The dealer shows \n" + cardString(randomCard3) + "\nand has a card facing down \n" + faceDown());
        System.out.println("The dealer's total is hidden");

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


}

