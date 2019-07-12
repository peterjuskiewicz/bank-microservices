# bank-microservices

## description

The application is built using microservices architecture and it consists of 5 microservices.

| Microservice  |  Port |   |   |   |
|---|---|---|---|---|
|  Database |  8000 |   
|  Customer |   8100|   
| Credit  | 8200  |  
|  Product | 8300  |   
|  Eureka | 8761  |   



## HTTP methods 

REST API consists of 2 methods:



1. GET - /credits returns the list of all credits in the following format:
<br />
`[
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
 ]`
 <br />
 2. POST - /credits accepts a data object:
 <br />
  `{
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
   }` 
   <br />
   and returns the credit id:
   <br />
   `{
        "id": 2,
        "creditName": "Test Test"
    }`
    
 ## Needs implementation
 
 The application is in a prototype version. There are several requirements that
 need to be implemented:
 
 1. Config Server
 2. Unit and integration testing - mockito, junit etc
 3. API gateway service - zuul api gateway
 4. Docker containers - Jib Maven plugin
 5. Kubernetes orchestration
