import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class PropertyCheck {

    // Method to check property between two operations
    public static int[] checkProperty(String operation1, String operation2, int repetitions) {
        Random random = new Random();
        int correctCount = 0;

        for (int i = 0; i < repetitions; i++) {
            // Generate random numbers
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();

            // Dynamically evaluate the operations
            double result1 = evaluateOperation(operation1, x, y, z);
            double result2 = evaluateOperation(operation2, x, y, z);

            // Check if the results are equal
            if (Double.compare(result1, result2) == 0) {
                correctCount++;
            }
        }

        return new int[] {correctCount, repetitions};
    }

    // Method to evaluate operations dynamically (parses strings)
    public static double evaluateOperation(String operation, double x, double y, double z) {
        operation = operation.replace("x", String.valueOf(x))
                             .replace("y", String.valueOf(y))
                             .replace("z", String.valueOf(z));

        if (operation.contains("+")) {
            String[] parts = operation.split("\\+");
            return Double.parseDouble(parts[0].trim()) + Double.parseDouble(parts[1].trim());
        } else if (operation.contains("*")) {
            String[] parts = operation.split("\\*");
            return Double.parseDouble(parts[0].trim()) * Double.parseDouble(parts[1].trim());
        } else if (operation.contains("/")) {
            String[] parts = operation.split("/");
            return Double.parseDouble(parts[0].trim()) / Double.parseDouble(parts[1].trim());
        }
        return 0;
    }

    public static void main(String[] args) {
        // Runtime parameters for variability factors
        String[] operations = {
            "(x + y) + z,x + (y + z)",
            "x + y,y + x",
            "(x * y) * z,x * (y * z)",
            "x * (y / z),(x * y) / z"
        };

        // Read number of repetitions from environment variable
        int[] repetitionsList = {500, 1000, 2000};
        int sampleSize = 0; // 0 means no sampling by default
        
        // Check for environment variables
        if (System.getenv("REPETITIONS_LIST") != null) {
            String[] repEnv = System.getenv("REPETITIONS_LIST").split(",");
            repetitionsList = new int[repEnv.length];
            for (int i = 0; i < repEnv.length; i++) {
                repetitionsList[i] = Integer.parseInt(repEnv[i]);
            }
        }
        
        if (System.getenv("SAMPLE_SIZE") != null) {
            sampleSize = Integer.parseInt(System.getenv("SAMPLE_SIZE"));
        }

        List<String[]> combinations = new ArrayList<>();
        for (String operation : operations) {
            for (int reps : repetitionsList) {
                combinations.add(new String[] {operation, String.valueOf(reps)});
            }
        }

        // If sampleSize is set and less than total combinations, sample a subset
        if (sampleSize > 0 && sampleSize < combinations.size()) {
            combinations = combinations.subList(0, sampleSize);
        }

        // Prepare results
        StringBuilder results = new StringBuilder();

        for (String[] combo : combinations) {
            String[] ops = combo[0].split(",");
            int reps = Integer.parseInt(combo[1]);
            int[] result = checkProperty(ops[0], ops[1], reps);
            int correctCount = result[0];

            results.append("Checked ").append(ops[0]).append(" vs ").append(ops[1])
                   .append(" with ").append(reps).append(" repetitions: ")
                   .append(correctCount).append(" times the property held.\n");

            System.out.println("Checked " + ops[0] + " vs " + ops[1] + " with " + reps +
                    " repetitions: " + correctCount + " times the property held.");
        }

        // Write results to CSV
        String outputFile = "results.csv";
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.append("operation1,operation2,repetitions,correct_count\n");
            for (String[] combo : combinations) {
                String[] ops = combo[0].split(",");
                int reps = Integer.parseInt(combo[1]);
                int[] result = checkProperty(ops[0], ops[1], reps);
                writer.append(ops[0]).append(",")
                      .append(ops[1]).append(",")
                      .append(String.valueOf(reps)).append(",")
                      .append(String.valueOf(result[0])).append("\n");
            }
            System.out.println("Results have been written to '" + outputFile + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the CSV file.");
            e.printStackTrace();
        }
    }
}
