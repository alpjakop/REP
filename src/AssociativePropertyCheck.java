import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AssociativePropertyCheck {

    public static void main(String[] args) {
        int trials = 1000000;
        String filePath = "../answer_associativity.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Checking associative property for doubles:\n");
            checkAssociativePropertyForDouble(trials, writer);

            writer.write("\nChecking associative property for floats:\n");
            checkAssociativePropertyForFloat(trials, writer);

            writer.write("\nChecking associative property for ints:\n");
            checkAssociativePropertyForInt(trials, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkAssociativePropertyForDouble(int trials, BufferedWriter writer) throws IOException {
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
        writer.write(String.format("Percentage for double: %.6f%%\n", percentage));
    }

    private static void checkAssociativePropertyForFloat(int trials, BufferedWriter writer) throws IOException {
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
        writer.write(String.format("Percentage for float: %.6f%%\n", percentage));
    }

    private static void checkAssociativePropertyForInt(int trials, BufferedWriter writer) throws IOException {
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
        writer.write(String.format("Percentage for int: %.6f%%\n", percentage));
    }
}
