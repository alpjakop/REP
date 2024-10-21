#!/bin/bash

# List of combinations
combinations=(
    "--operation1=(x+y)+z --operation2=x+(y+z) --repetitions=1000"
    "--operation1=x+y --operation2=y+x --repetitions=500"
    "--operation1=(x-y)-z --operation2=x-(y-z) --repetitions=1000"
    "--operation1=x*(y/z) --operation2=(x*y)/z --repetitions=700"
)

# Loop through each combination and run the CLI program
for combination in "${combinations[@]}"
do
    echo "Running: python3 check_arithmetic_properties.py $combination"
    python3 check_arithmetic_properties.py $combination
done
