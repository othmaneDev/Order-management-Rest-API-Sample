# Order-management-Rest-API-Sample
A sample Order management API This Java REST API project which demonstrate how to build a Rest API using Spring boot (Spring Data JPA, Spring HATEOS)

Prerequisites Java 8+ & Maven

REST endpoints :
    GET : orders: To retrieve all the orders from h2 in memory database 
    GET: orders/id : to retrieve an order having the id from request 
    POST: orders : Make a new order using the body (in JSON format (having the description as String)
    PUT : orders/id : Update the description of an order (The new order need to be provided in the body)
    DELETE : orders/id : Cancel an order having the id from request
    
You can build and run the application using this command on terminal: mvn spring-boot:run

Then you can access the API from postman using : http://localhost:7006/
