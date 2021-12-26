package converter;


public class Number {
    private String numeral;
    private String wholePart;
    private String fraction;

    Number(String number) {
        numeral = number;
        String[] parts = numeral.split("\\.");
        fraction = parts.length > 1 ? parts[1] : "";
        wholePart = parts[0] == null ? "" : parts[0];
    }

    boolean hasFraction() {
        return fraction.length() > 0;
    }

    String getFraction() {
        return fraction;
    }

    String getWholePart() {
        return wholePart;
    }
}
