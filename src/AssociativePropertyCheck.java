import java.util.Random;

public class AssociativePropertyCheck {

    public static void main(String[] args) {
        int trials = 1000000;
        
        System.out.println("\nChecking associative property for floats:");
        checkAssociativePropertyForFloat(trials);
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

}
