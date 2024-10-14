# REP

## AssociativePropertyCheckInt
Answers the “How often x+(y+z) == (x+y)+z” question by using int  
**Results** : 100.000000%

## AssociativePropertyCheckDouble
Answers the “How often x+(y+z) == (x+y)+z” question by using double  
**Results** : 82.819300%

## AssociativePropertyCheckFloat
Answers the “How often x+(y+z) == (x+y)+z” question by using float  
**Results** : 82.881805%

# Dockerfile
Execute by using the commands found in the Dockerfile  
docker build -t associative-property-check .  
docker run associative-property-check

