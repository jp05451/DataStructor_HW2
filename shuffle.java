import java.util.Random;
package queue/src/queue/LinkedQueue;

public class shuffle {
    static Random random = new Random();

    static void shuffleCard() {
        for (int i = 0; i < cards.length; i++) {
            int r = random.nextInt(cards.length);
            // swap(cards[i], cards);
            card temp = cards[i];
            cards[i] = cards[r];
            cards[r] = temp;
        }
    }

    static void dealCard()
    {
        for(int i=0;i<4;i++)
        {
            players[i]=new LinkedQueue();
        }
        for(int i=0;i<52;i++)
        {
            players[i%4].append(cards[i]);
        }
    }

    static void printCards() 
    {
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
        printCards();

        shuffleCard();

        System.out.println("===========after shuffled=========");
        printCards();

        System.out.println("===========after shuffled=========");
        for(int i=0;i<4;i++)
        {
            players[i].forEach(System.out.print());
            System.out.println();
        }
    }

    static card cards[] = new card[52];
    static LinkedQueue<card> players[] = new LinkedQueue[4];
}

class suits {
    public static String[] suits = { "♠", "♥", "♦", "♣" };
}

class card {
    int number;
    int suit;
}
