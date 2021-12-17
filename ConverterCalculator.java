package converter;

import java.math.BigInteger;

public class ConverterCalculator {
    static String compute(int sourceBase, int targetBase, String number) {
        return new BigInteger(number, sourceBase).toString(targetBase);
    }
}
