This Spring Boot project contains 2 microservices, and a Eureka Server. 

The ShufflerService accepts a POST request consisting of a number, and returns a list of every unique number from 1 until the input number, in a shuffled order.  

The LoggerService accepts a POST request from the ShufflerService, and logs the request.

The ShufflerService makes the REST call to the LoggerService asynchronously.

Both microservices are Eureka clients, and the project includes a Eureka server to provide service discovery. 
This allows the ShufflerService to detect the LoggerService dynamically without having to provide a hardcoded URL.

Ports:

ShufflerService: 8080

LoggerService: 8082

EurekaServer: 8761

Java 21 and Spring Boot 3.4.1 are used.

Example POST request http://localhost:8080/shuffle with request body:

{ "number" : "10" }

returns the following output: [1, 6, 2, 9, 8, 3, 5, 10, 7, 4]

where:  1 <= number <= 1000.