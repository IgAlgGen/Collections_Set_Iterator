package Verifications;

public class Verifications {

    public static String verificationString(String string, String byDefault) {
        if (string == null || string.isBlank()) {
            return byDefault;
        }
        return string;
    }

    public static double verificationDouble(double num, double byDefault) {
        return num <= 0 ? byDefault : num;
    }

}
