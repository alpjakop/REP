# REP Associativity

## Dockerfile
Execute by using the commands found in the Dockerfile  
<code> docker build -t associative-property-check . </code> 
<code> docker run associative-property-check </code> 

## Files
- **src/AssociativePropertyCheck.java :** Main program, creates **answer_associativity.txt** file
- **alignment/alignment.py :** In the context of "aligning" results across different repositories, the goal is to standardize or control the variability factors so that different groups or environments compute the same result for the same problem. 
- **Template-Based/generated_property_check.py :** Implements using a template-based approach
- **CLI_Based/check_aritmetic_properties.py :** Implements using a CLI-based approach
- **Runtime_Parameter_Based/parametrized.py :** Implements using a runtime-parameter-based approach, creates the **results.csv** file
- **analysis.ipynb :** Jupyter Notebook to run the analysis