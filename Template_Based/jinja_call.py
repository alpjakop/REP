from jinja2 import Template
import os

# Load the template
template_path = 'Template_Based/property_template.py.jinja'
template_content = open(template_path).read()
template = Template(template_content)

# Define different variability factors
factors = {
    "operation1": "(x + y) + z",
    "operation2": "x + (y + z)",
    "repetitions": 1000,  # Can be changed to any number of repetitions
}

# Render the template with specific values
generated_code = template.render(factors)

# Define the output path
output_path = os.path.join('Template_Based', 'generated_property_check.py')

# Save the generated code to a Python file in the Template_Based directory
with open(output_path, 'w') as f:
    f.write(generated_code)

print(f"Generated code has been written to '{output_path}'.")

# Define additional factor combinations
factor_combinations = [
    {"operation1": "(x + y) + z", "operation2": "x + (y + z)", "repetitions": 1000},
    {"operation1": "x + y", "operation2": "y + x", "repetitions": 500},
]

# Generate and run code for each combination
for factors in factor_combinations:
    generated_code = template.render(factors)
    # Save the generated code to the same file (overwrites previous)
    with open(output_path, 'w') as f:
        f.write(generated_code)

    # Run the generated code automatically (in a real scenario, you'd use subprocess)
    print(f"Running check for factors: {factors}")
    exec(generated_code)  # Use exec to run the code directly
