package bullscows;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StartGame();
    }

    public static void StartGame() {
        System.out.println("Please, enter the secret code's length:");
        int codeLength = scanner.nextInt();
        if (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of 11" +
                    " because there aren't enough unique digits.");
        } else {
            System.out.println("Input the number of possible symbols in the code:");
            int possibleSymbols = scanner.nextInt();
            System.out.println("Okay, let's start a game!");

            GenerateCode generateCode = new GenerateCode(codeLength, possibleSymbols);
            String code = generateCode.PrepareCode();
            generateCode.OutputCode();

            boolean win = false;
            int turn = 1;

            while (!win) {
                System.out.printf("Turn %d:\n", turn++);
                String guess = scanner.next();
                win = CodeGrader(code, guess);
            }

            System.out.println("Congratulations! You guessed the secret code.");
        }
    }

    public static boolean CodeGrader(String code, String guess) {

        int bulls = 0;
        int cows = 0;

        int bullsRN = 0;
        int cowsRN = 0;

        String[] codeChar = code.split("");
        String[] guessChar = guess.split("");

        for (int i = 0; i < codeChar.length; i++) {
            for (int j = 0; j < guessChar.length; j++) {
                if (codeChar[i].equals(guessChar[j])) {
                    cowsRN = 1;
                    if (i == j) {
                        bullsRN = 1;
                    }
                }
            }

            bulls += bullsRN;
            cows += cowsRN;

            bullsRN = 0;
            cowsRN = 0;
        }

        cows -= bulls;

        if (cows != 0 && bulls != 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", cows, bulls);
        } else if (cows == 0 && bulls != 0) {
            System.out.printf("Grade: %d bull(s).\n", bulls);
        } else if (cows != 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
        } else {
            System.out.println("Grade: None.");
        }

        return bulls == code.length();
    }

}
