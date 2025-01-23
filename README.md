This project contains 2 microservices.
The ShufflerService accepts a POST request consisting of a number, and returns every number from 1 until the input number, in a shuffled order.  
The LoggerService accepts a POST request from the ShufflerService, and logs the request.
The ShufflerService makes the REST call to the LoggerService asynchronously.
Both microservices are Eureka clients, and the project includes a Eureka server to provide service discovery.

Ports:
ShufflerService: 8080
LoggerService: 8082
EurekaServer: 8761
