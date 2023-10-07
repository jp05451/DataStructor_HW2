import java.util.Random;

class shuffle {
    static Random random = new Random();

    static void shuffleCard(card cards[]) {
        for (int i = 0; i < cards.length; i++) {
            int r = random.nextInt(cards.length);
            // swap(cards[i], cards);
            card temp = cards[i];
            cards[i] = cards[r];
            cards[r] = temp;
        }
    }

    static void printCards(card cards[]) {
        for (int i = 0; i < cards.length; i++) {
            System.out.printf("%s%d\t", suits.suits[cards[i].suit], cards[i].number + 1);
            if (i % 13 == 12) {
                System.out.println("");
            }

        }
    }

    public static void main(String[] argv) {
        for (int i = 0; i < 52; i++) {
            cards[i] = new card();
            cards[i].suit = i / 13;
            cards[i].number = i % 13;
        }

        System.out.println("===========before shuffled=========");
        printCards(cards);

        shuffleCard(cards);

        System.out.println("===========after shuffled=========");
        printCards(cards);
    }

    static card cards[] = new card[52];
}

class suits {
    public static String[] suits = { "♠", "♥", "♦", "♣" };
}

class card {
    int number;
    int suit;
}
