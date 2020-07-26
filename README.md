# SQLI Internal Hackathon BattleBrain 2020
###  Submitted by 
* Mustapha Belmokhtar
* Ilyas Maamri

This solution is only (unfortunately) available as a REST API service. 

Some conditions leaded us to decide, that, it would be enough as a submission, knowing that, the aim of it is not to win a competition, but at least to finish a competition! 

## REQUIREMENTS : 
1. Java 8 or above
1. Maven 3.6.3 or above
1. Mysql Ver 15.1 Distrib 10.1.37-MariaDB

## Steps to run the solution : 

1. Configure the database connection : 
To run the solution, we will need a relational database. We choose Mysql for instance. 
Having Mysql installed, create a new database (schema) named `cody`. 
Then gather the connection string to this database, for example:  
`jdbc:mysql://localhost:3306/cody?createDatabaseIfNotExist=true&useSSL=true`.
After that note the username and the password to access this database. 
2. Perform maven tasks
Place the commande line to this directory : 
Run this maven command : 
`mvn clean install`
Then go to the generated folder target and find the built-up jar file. 
Then run the java command : 
java -jar  cody-1.0-jar-with-dependencies.jar
