"# adneom-partition-test" 


This is a simple Java test from Adneom.

First run "mvn clean install" for the project, then use command line to run "adnoem-test-1.0-SNAPSHOT-jar-with-dependencies.jar" (java -jar)

You can expect :
input : partition([1,2,3,4,5], 2)             output : [ [1,2], [3,4], [5] ] 
input : partition([1,2,3,4,5], 3)             output : [ [1,2,3], [4,5] ] 
input : partition([1,2,3,4,5], 1)             output: [ [1], [2], [3], [4], [5] ] 

