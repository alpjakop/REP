import java.util.Random;

public class AssociativePropertyCheck {

    public static void main(String[] args) {
        int trials = 1000000;
        System.out.println("Checking associative property for doubles:");
        checkAssociativePropertyForDouble(trials);

        System.out.println("\nChecking associative property for floats:");
        checkAssociativePropertyForFloat(trials);

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

        double leftSide = x + (y + z);  // Changed from (x + y) + z
        double rightSide = (x + y) + z; // Changed from x + (y + z)

        if (leftSide == rightSide) {
            countEqual++;
        }
    }

    double percentage = (countEqual / (double) trials) * 100;
    System.out.printf("Percentage for double (modified order): %.6f%%\n", percentage);
}


    private static void checkAssociativePropertyForFloat(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            float x = random.nextFloat();
            float y = random.nextFloat();
            float z = random.nextFloat();

            float leftSide = x + (y + z);  // Changed from (x + y) + z
            float rightSide = (x + y) + z; // Changed from x + (y + z)

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        float percentage = (countEqual / (float) trials) * 100;
        System.out.printf("Percentage for float (modified order): %.6f%%\n", percentage);
    }

    private static void checkAssociativePropertyForInt(int trials) {
        int countEqual = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            int x = random.nextInt();
            int y = random.nextInt();
            int z = random.nextInt();

            int leftSide = x + (y + z);
            int rightSide = (x + y) + z;

            if (leftSide == rightSide) {
                countEqual++;
            }
        }

        double percentage = (countEqual / (double) trials) * 100;
        System.out.printf("Percentage for int (modified order): %.6f%%\n", percentage);
    }
}
