package Logic;

import java.util.Random;

public class Utils {
    public static String generateCardNumber(){
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            number.append(digit);
        }
        return number.toString();
    }

    public static int generatePinNumber(){
        Random random = new Random();

        return random.nextInt(1000, 9999);
    }
}
