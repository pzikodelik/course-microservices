# Course Microservice

This was created with Maven as Multimodule project, Spring boot and Spring Cloud.

## 1. Tools 
1. Java 11
2. Spring Boot 2.7.18
3. Spring Cloud 2021.0.3
4. Docker

## 2. Additional Dependencies
1. Lombok

## Patterns
1. Eureka-Server
2. Gateway-Server 
3. Config-Server
4. Trace (Zipkin and Sleuth)
5. Circuit Breaker and Resilience4J

## 3. Instructions to Run
> You must run this project with the next order:
> 1. Execute <code>docker-compose up -d</code>
> 2. You can execute the next list of applications with maven with the next command <code>mvn spring-boot:run</code> or directly with the IDE, **you must respect the order**:
>    * Run <code>config-server</code>
>    * Run <code>eureka-server</code> 
>    * Run <code>user-microservice</code> 
>    * Run <code>user-microservice-fallback</code> 
>    * Run <code>gateway-server</code> 
> 
> Note: If you want to test the **Circuit Breaker** please don't execute <code>user-microservice</code> and automatically <code>gateway-server</code> is going to call to the **fallback** service.

## 4. URL's of Services and Tools
| Service        | URL                                                                                                                                          |
|----------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| Eureka         | http://localhost:8761                                                                                                                        |
| Gateway        | http://localhost:8090                                                                                                                        |
| Users          | This runs in localhost but the port is Random, you must set the port directly in application.yml or check the console log for fetching this. |
| Users-Fallback | This is the same case of Users service.                                                                                                      |
| Zipkin         | http:localhost:9411                                                                                                                          |
| Rabbit         | This server is running on 5672 but if you want to see the management UI you must see into this http://localhost:15672                        |
| Mysql          | This server is running on 3306 port                                                                                                          |
| Adminer        | This is the tools that we used for seeing the information of Mysql Server and you can see the UI on http://localhost:8080                    |


## 5. Developer

* Yoni Herrera
* ingyoniherrera@hotmail.com
* ISC
