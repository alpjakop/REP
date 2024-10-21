import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AssociativePropertyCheck {

    public static void main(String[] args) {
        int trials = 1000000;
        System.out.println("Checking associative property for doubles:");
        checkAssociativePropertyForDouble(trials);

        System.out.println("\nChecking associative property for floats:");
        checkAssociativePropertyForFloat(trials);

        System.out.println("\nChecking associative property with precision limitation:");
        checkAssociativePropertyWithPrecisionLimitation(trials);

        System.out.println("\nChecking associative property for ints:");
        checkAssociativePropertyForInt(trials);
    }

    private static void checkAssociativePropertyForDouble(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();

            double leftSide = (x + y) + z;
            double rightSide = x + (y + z);

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        double percentage = (countEqual / (double) trials) * 100;
        System.out.printf("Percentage for double: %.6f%%\n", percentage);
    }

    private static void checkAssociativePropertyForFloat(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            float x = random.nextFloat();
            float y = random.nextFloat();
            float z = random.nextFloat();

            float leftSide = (x + y) + z;
            float rightSide = x + (y + z);

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        float percentage = (countEqual / (float) trials) * 100;
        System.out.printf("Percentage for float: %.6f%%\n", percentage);
    }

    // New method simulating precision limitation (half precision)
    private static void checkAssociativePropertyWithPrecisionLimitation(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();

            // Simulate precision limitation
            float xFloat = (float) x;
            float yFloat = (float) y;
            float zFloat = (float) z;

            float leftSide = (xFloat + yFloat) + zFloat;
            float rightSide = xFloat + (yFloat + zFloat);

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        double percentage = (countEqual / (double) trials) * 100;
        System.out.printf("Percentage with precision limitation: %.6f%%\n", percentage);
    }

    private static void checkAssociativePropertyForInt(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            int x = random.nextInt();
            int y = random.nextInt();
            int z = random.nextInt();

            int leftSide = (x + y) + z;
            int rightSide = x + (y + z);

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        double percentage = (countEqual / (double) trials) * 100;
        System.out.printf("Percentage for int: %.6f%%\n", percentage);
    }
}
