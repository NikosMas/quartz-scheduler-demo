# Quartz-Scheduler-Demo


## Demo personal project to test the Quartz Scheduler using Java Spring Boot (https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling).

### The server (jetty server) exposes two endpoints:
    1 - Trigger the scheduler job to call 'https://www.epant.gr/openData.svc/GetNews' and save the returned dataset in an in-memory H2 db using Spring Repository interfaces after deserialization to Java JPA Entity POJO's.
    
        GET /demo/start HTTP/1.1
        Host: localhost:8081
    
    
    2 - Serve the persisted data.
    
        GET /demo/getMyNews HTTP/1.1
        Host: localhost:8081
        Accept: application/json


### To run the server please navigate to project solution's folder and run via cmd the following command: 'mvn jetty:run'. Server will start using Jetty on your localhost:8081. Important! First run 'mvn clean install' to build the project.


Note: The demo project developed in 2018 so the 'https://www.epant.gr/openData.svc/GetNews' site may not behave as it did.
