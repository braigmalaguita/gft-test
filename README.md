# Multimodular maven project with hexagonal arquitecture for gft/inditex tech evaluation
This project is composed by three layers.

## Domain module
The core module, contained in the other modules as a dependency. It's just a library with common definitions.
Composed by:
- Models
- Service Interfaces

## Service module
The business module, contained in the api module as a dependency. This module implements the main business logic, such as services implementations and persistence definitions.
Also, it has a mocked embeebed database configured with DataLoader class, so everything in this project is self-content.
Composed by:
- Persistence definitions
- Service Implementations
- Embeebed Database

Notice that Service, whose interface is defined in domain module, only has visibility to manage domain objects, so we difference and convert between entities and domain objects with mappers and organized structure.

## Api module
The application module, who has the other modules as dependencies. This module implements the api definition (with openapi), and the boot main application with proper configuration.
Composed by:
- Api definition (open api) and Controller Implementation
- Main boot application

Notice that we don't use the same domain objects in controller response. As we did in service module, we return Dtos and we use mappers to convert the equivalent objects.

###  Demo test URL (GET Method)

```
- Should return id 2 -> http://localhost:8080/price?date=2020-06-14T17:32:28Z&productId=35455&brandId=1 
- Should return id 1 -> http://localhost:8080/price?date=2020-06-14T09:32:28Z&productId=35455&brandId=1 
- Should return id 3 -> http://localhost:8080/price?date=2020-06-15T02:32:28Z&productId=35455&brandId=1 
- Should return id 1 -> http://localhost:8080/price?date=2020-06-15T12:32:28Z&productId=35455&brandId=1
- Should return id 4 -> http://localhost:8080/price?date=2020-06-15T19:32:28Z&productId=35455&brandId=1 
- Should return Not Found -> http://localhost:8080/price?date=2021-09-15T19:32:28Z&productId=35455&brandId=1 
- Should return Not Found -> http://localhost:8080/price?date=2020-09-15T19:32:28Z&productId=35455&brandId=2 
- Should return Bad Request -> http://localhost:8080/price?date=2020-13-15T19:32:28Z&productId=35455&brandId=2 
```