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
5. Monitoring (Micrometer, Prometheus and Grafana)
6. Circuit Breaker and Resilience4J

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
> 
> The above running process is just when you wan to run this from IDE or maven, in that case you must change the name of the docker containers of the service, 
> for example, if you see into application.yml of eureka-server you are going to find something like http://config-server:8888/ in that case you must change <code>config-server</code> by localhost, this action must be 
> for al application properties.
>
> But if you want to test this directly with Docker, you must <code>clean</code> and <code>package</code> because we must generate a docker image for each application, after this packaging you must run the next Docker 
> command:
> <code>docker run --name [name-application] --publish [port-application] --network [network-application] [image-id]</code>
> 
> For example, in the case of config-server, we executed this:
> 
> <code>docker run --name config-server --publish 8888:8888 --network course-net 13d98dd998f3</code>
> 
> NOTE: The **network** must be the same for all applications and you must run each image with the same order of the point 2.

## 4. URL's of Services and Tools
| Service        | URL                                                                                                                       |
|----------------|---------------------------------------------------------------------------------------------------------------------------|
| Eureka         | http://localhost:8761                                                                                                     |
| Gateway        | http://localhost:8090                                                                                                     |
| Users          | http://localhost:8081/users/                                                                                              |
| Users-Fallback | http://localhost:8082/fallback/users/                                                                                     |
| Zipkin         | http:localhost:9411                                                                                                       |
| Rabbit         | This server is running on 5672 but if you want to see the management UI you must see into this http://localhost:15672     |
| Mysql          | This server is running on 3306 port                                                                                       |
| Adminer        | This is the tools that we used for seeing the information of Mysql Server and you can see the UI on http://localhost:8080 |
| Grafana        | http://localhost:3000, The user and password by default is <code>admin</code> you must change this by your own.           |
| Prometheus     | http://localhost:9090                                                                                                     |


## 5. Developer

* Yoni Herrera
* ingyoniherrera@hotmail.com
* ISC
