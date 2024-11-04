import random
import csv
import os

def check_property(operation1, operation2, repetitions):
    correct_count = 0
    for _ in range(repetitions):
        x = random.random()
        y = random.random()
        z = random.random()

        # Dynamically evaluate the operations
        result1 = eval(operation1)
        result2 = eval(operation2)

        if result1 == result2:
            correct_count += 1

    return correct_count, repetitions

# Define possible combinations of operations
operations = [
    {"operation1": "(x + y) + z", "operation2": "x + (y + z)"},  # Associativity
    {"operation1": "x + y", "operation2": "y + x"},              # Commutativity
    {"operation1": "(x * y) * z", "operation2": "x * (y * z)"},  # Associativity (multiplication)
    {"operation1": "x * (y / z)", "operation2": "(x * y) / z"}   # Combination of operations
]

# Define different repetition counts
repetitions_list = [500, 1000, 2000]

# Prepare to store results
results = []

# Loop through all combinations of operations and repetitions
for op in operations:
    for reps in repetitions_list:
        correct_count, repetitions = check_property(op['operation1'], op['operation2'], reps)
        results.append({
            "operation1": op['operation1'],
            "operation2": op['operation2'],
            "repetitions": repetitions,
            "correct_count": correct_count
        })
        print(f"Checked {op['operation1']} vs {op['operation2']} with {reps} repetitions: {correct_count} times the property held.")

# Write results to CSV
output_file = 'results.csv'
with open(output_file, 'w', newline='') as csvfile:
    fieldnames = ["operation1", "operation2", "repetitions", "correct_count"]
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
    for result in results:
        writer.writerow(result)

print(f"Results have been written to '{output_file}'.")
