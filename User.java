package converter;

import java.util.Locale;
import java.util.Scanner;

class User {
    Scanner scanner;
    String userInput;
    boolean doExit;
    boolean doBack;
    int sourceBase;
    int targetBase;
    String number;

    User() {
        this.scanner = new Scanner(System.in);
    }

    void request(Prompt prompt) {
        System.out.print(prompt.getDisplayText(this));
        userInput = scanner.nextLine().toLowerCase(Locale.ROOT);
        switch (prompt.id) {
            case 1:
                if (userInput.equals("/exit")) {
                    doExit = true;
                } else {
                    String[] bases = userInput.split(" ");
                    sourceBase = Integer.parseInt(bases[0]);
                    targetBase = Integer.parseInt(bases[1]);
                }
                break;
            case 2:
                if (userInput.equals("/back")) {
                    doBack = true;
                } else {
                    number = userInput;
                }
                break;
            default:
                break;
        }
    }
}
