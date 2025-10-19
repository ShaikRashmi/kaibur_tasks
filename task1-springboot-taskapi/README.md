# Kaiburr Assessment - Task 1 (Spring Boot REST API)

This project implements Task 1: a Spring Boot REST API to manage Task objects stored in MongoDB.

## Run locally

1. Start MongoDB (recommended via Docker):
   docker run -d -p 27017:27017 --name mongo mongo

2. Build and run:
   mvn spring-boot:run

3. Test endpoints (examples):
   PUT http://localhost:8080/tasks
   GET http://localhost:8080/tasks
   PUT http://localhost:8080/tasks/1/execute

See full README in repository for screenshots and instructions to capture system time/name.
