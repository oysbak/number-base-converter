package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ConverterCalculator {
    private static final List<String> SYMBOLS = Arrays.asList("0123456789abcdefghijklmnopqrstuvwxyz".split(""));

    static String compute(String number, int sourceBase, int targetBase) {
        // Figure out if number has a fraction or not
        Number numeral = new Number(number);
        if (numeral.hasFraction()) {
            return decimalToTargetBase(sourceBaseToDecimal(numeral.getWholePart(), sourceBase), targetBase)
                    + fractionToTargetBase(fractionToDecimal(numeral.getFraction(), sourceBase), targetBase);
        } else {
            return decimalToTargetBase(sourceBaseToDecimal(numeral.getWholePart(), sourceBase), targetBase);
        }
    }

    // My masterpiece
    static String integerToBinary(int number) {
        String binaryDigit = String.valueOf(number % 2);
        return (number / 2 > 0) ? integerToBinary(number / 2) + binaryDigit : binaryDigit;
    }

    // Whole number function #1
    private static BigInteger sourceBaseToDecimal(String number, int sourceBase) {
        return new BigInteger(number, sourceBase);
    }

    // Whole number function #2
    private static String decimalToTargetBase(BigInteger number, int targetBase) {
        return number.toString(targetBase);
    }

    // Fraction function #1
    public static String fractionToDecimal(String fraction, int sourceBase) {
        // Remove the dot(.) and create an array
        String[] number = ("0" + fraction).split("");
        BigDecimal result = new BigDecimal("0");
        for (int i = 0; i < number.length; i++) {
            result = result.add(new BigDecimal(SYMBOLS.indexOf(number[i]) / Math.pow(sourceBase, i)));
        }
        return result.toPlainString();
    }

    // Fraction function #2
    public static String fractionToTargetBase(String decimalFraction, int targetBase) {
        int maxLoops = 5;
        BigDecimal number = new BigDecimal(decimalFraction);
        BigDecimal tBase = new BigDecimal(targetBase);
        StringBuilder digits = new StringBuilder();
        while (number.compareTo(BigDecimal.ZERO) != 0 && maxLoops-- > 0) {
            number = number.multiply(tBase);
            digits.append(SYMBOLS.get(number.intValue()));
            number = number.subtract(new BigDecimal(number.intValue()));
        }
        return ("." + digits + "00000").substring(0, 6);
    }
}