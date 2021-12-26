package converter;

public class Prompt {
    static int objectCounter;
    final int id;
    private final String originalText;

    Prompt(String text) {
        id = ++objectCounter;
        originalText = text;
    }

    String getDisplayText(User user) {
        return originalText.replace("{user source base}", String.valueOf(user.sourceBase))
                           .replace("{user target base}", String.valueOf(user.targetBase)) + " ";
    }
}
