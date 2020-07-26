# SQLI Internal Hackathon BattleBrain 2020
###  Submitted by 
* Mustapha Belmokhtar
* Ilyas Maamri

This solution is only (unfortunately) available as a REST API service. 

Some conditions leaded us to decide, that, it would be enough as a submission, knowing that, the aim of it is not to win a competition, but at least to finish a competition! 

## Work Flow : https://trello.com/b/5duIc8jY/cody

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
Place the commande line to this directory : `battlebrain2020/code/back/`
Run this maven command : 
`mvn clean install`
3. Then go to the generated folder `battlebrain2020/code/back/cody-runner/target` and find the built-up jar file. 
Then run the java command : 
`java -jar cody_1.0.jar --server.port=8070 spring.datasource.username=[the user name of the created database]  --spring.datasource.password=[the set up password for your database`
4. run this sql script to create the default user : 
```SQL
 INSERT INTO `cody`.`user` (`created_at`, `updated_at`, `email`, `password`, `team_id`) VALUES (null, null, 'test', '$2a$10$aL3BJmOMQEPPAaerlG8J9OBq7t4RcKNJlQIRI/ohu4McZ4xEzkDju', null)
```
4. Go to `http://localhost:8070/swagger-ui.html`
5.Connect to the swagger UI : user `test`, password `test`
## Missing artifacts:  
1. Solution screencast
