import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AssociativePropertyCheck {

    public static void main(String[] args) {
        int trials = 1000000;
        checkAssociativePropertyForFloat(trials);
    }

    private static void checkAssociativePropertyForFloat(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            float x = random.nextFloat();
            float y = random.nextFloat();
            float z = random.nextFloat();

            // Simulate precision  limitation
            double xDouble = (double) x;
            double yDouble = (double) y;
            double zDouble = (double) z;

            double leftSide = (xDouble + yDouble) + zDouble;
            double rightSide = xDouble + (yDouble + zDouble);

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        float percentage = (countEqual / (float) trials) * 100;
        System.out.printf("%.2f\n", percentage);
    }
}
