package converter;

public class NumberConverter {
    private final User user;
    private final Prompt basesOrExit;
    private final Prompt numberOrBack;

    public NumberConverter() {
        user = new User();
        basesOrExit = new Prompt("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
        numberOrBack = new Prompt(
                "Enter number in base {user source base} to convert to base {user target base} (To go back type " +
                        "/back)");
    }

    void mainPage() {
        user.doExit = false;
        do {
            user.request(basesOrExit);
            if (!user.doExit) {
                secondaryPage();
            }
        } while (!user.doExit);
    }

    public void secondaryPage() {
        user.doBack = false;
        do {
            user.request(numberOrBack);
            if (!user.doBack) {
                System.out.print("Conversion result: ");
                System.out.println(ConverterCalculator.compute(user.sourceBase, user.targetBase, user.number));
            }
        } while (!user.doBack);
    }
}
