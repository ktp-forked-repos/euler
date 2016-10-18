package problem054;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by kiran on 1/25/16.
 *
 * This problem has a crazy long description. tl;dr:
 *
 * The file, poker.txt, contains one-thousand random hands dealt to two players.
 * Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards.
 * You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

 How many hands does Player 1 win?
 */
public class Problem054 {

    public static void main(String[] args) {
        int playerOneWins = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/problem054/p054_poker.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] cardArray = line.split(" ");

                Card[] playerOneCards = new Card[5];
                Card[] playerTwoCards = new Card[5];

                for (int i = 0; i < 5; i++) {
                    playerOneCards[i] = new Card(cardArray[i].charAt(0), cardArray[i].charAt(1));
                }

                for (int i = 5; i < 10; i++) {
                    playerTwoCards[i - 5] = new Card(cardArray[i].charAt(0), cardArray[i].charAt(1));
                }

                PokerHand playerOne = new PokerHand(playerOneCards);
                PokerHand playerTwo = new PokerHand(playerTwoCards);

                if (playerOne.beats(playerTwo)) {
                    playerOneWins++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(playerOneWins);

    }
}

//Answer: 376
