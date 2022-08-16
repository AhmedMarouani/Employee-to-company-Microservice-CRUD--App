# Spring-Microservices-Employee-Company-CRUD


This project presents the management of a company employees. It is composed of 2 micro-services: Employee and company.

Every microservice has it own data base and they can communicate through Feign Dependency.

The port of Employee server is 8081. The port of the company server is 8082.
To test the employee's microservice : localhost:8081/api/v1/Employee/retrieveCompany/{companyId}
