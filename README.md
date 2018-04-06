"# adneom-partition-test" 


This is a simple partition project for Adneom.

Use "mvn clean install" to install and the project and run the IT.

The service take a list of integer and a partition factor as parameters, and return the partitioned list.

Exemple : 

partition([1,2,3,4,5], 2)   =>    [ [1,2], [3,4], [5] ] 
partition([1,2,3,4,5], 3)   =>    [ [1,2,3], [4,5] ] 
partition([1,2,3,4,5], 1)   =>    [ [1], [2], [3], [4], [5] ] 

