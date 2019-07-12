# bank-microservices

## description

The application is built using microservices architecture and it consists of 5 microservices.

| Microservice  |  Port |   
|---|---|
|  Database |  8000 |   
|  Customer |   8100|   
| Credit  | 8200  |  
|  Product | 8300  |   
|  Eureka | 8761  |   



## HTTP methods 

REST API consists of 2 methods:



1. GET - /credits returns the list of all credits in the following format:

```json
[
     {
         "customer": {
             "creditId": 1,
             "firstName": "Piotr22",
             "pesel": "12345678902",
             "lastName": "Juskiewicz22"
         },
         "product": {
             "creditId": 1,
             "productName": "Test Test22",
             "value": 20200
         },
         "credit": {
             "id": 1,
             "creditName": "Test Test"
         }
     },
     {
         "customer": {
             "creditId": 1001,
             "firstName": "Piotr",
             "pesel": "12345678901",
             "lastName": "Juskiewicz"
         },
         "product": {
             "creditId": 1001,
             "productName": "Test Test",
             "value": 1000
         },
         "credit": {
             "id": 1001,
             "creditName": "Test Test"
         }
     }
 ]
```

 <br />
 2. POST - /credits accepts a data object:
 
```json
{
       "customer": {
           "firstName": "Piotr22",
           "pesel": "12345678902",
           "lastName": "Juskiewicz22"
       },
       "product": {
           "productName": "Test Test22",
           "value": 20200
       },
       "credit": {
           "creditName": "Test Test"
       }
   }
```

   and returns the credit id:
   
   ```json
   {
           "id": 2,
           "creditName": "Test Test"
       }
   ```
   
    
 ## How to run application
 
 To run the application you need to run each microservice 
 separately with `mvn spring-boot:run` in the following order:
 1. Eureka discovery server
 2. Database microservice
 3. Customer microservice
 4. Product microservice
 5. Credit microservice
 
 When all microservices are running you can start to interact with
 the API by calling GET or POST methods in your Postman.
 <br />
 Credit service runs on port 8100 so to get all credits you will
 need to send GET request to:
  [localhost://8100/credits](localhost://8100/credits)
    
 ## Needs implementation
 
 The application is in a prototype version. There are several requirements that
 need to be implemented:
 
 1. Config Server
 2. Unit and integration testing - mockito, junit etc
 3. API gateway service - zuul api gateway
 4. Docker containers - Jib Maven plugin
 5. Kubernetes orchestration
