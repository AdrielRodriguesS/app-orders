# app-order
## Ongoing project

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/AdrielRodriguesS/app-orders/blob/main/LICENCE)

# About

This application is a portfolio project to show java knowledges.
This applications have the finality to control quotations and purchase orders.
To this, the application have client data, storage data, product data etc.
The application work with Rest Api and have end-points that will can consume by other apps.

# End-points available

##BASE: http://localhost:8080/

### H2 Database
... /h2-console

###Adress:
GET / POST: .../adress
GET / PUT / DELETE: .../adress/{id}

###Client:
GET / POST: .../clients
GET / PUT / DELETE: .../clients/{id}

###Product:
GET / POST: .../products
GET / PUT / DELETE: .../products/{id}

###Purchase Order:
GET / POST: .../purchase-orders
GET / PUT / DELETE: .../purchase-orders/{id}

###Quotation:
GET / POST: .../quotations
GET / PUT / DELETE: .../quotations/{id}

###Quotation Product:
GET / POST: .../quotation-products
GET / PUT / DELETE: .../quotation-products/{id}

###Storage:
GET / POST: .../storage
GET / PUT / DELETE: .../storage/{id}

###StorageData:
GET: .../storage-data
GET / PUT / DELETE / POST: .../storage-data/{id}

# Json to use with POST and PUT http methods
See the file JsonExamples.txt in the projct tree

# Technologies

## Back end
- Java
- Spring Boot, Web, Data
- Jpa
- H2 Database in memory
- Maven

## Skills
- Java OO
- Rest API
- CRUD
- Exception Handling

## Features
- complete CRUD in all entities;
- Rest API with end points;
- Spring Data JPA;

# How to use

## Requirements
- Eclipse IDE
- Java
- Postman

## clone the repository
git clone https://github.com/AdrielRodriguesS/app-orders

## Eclipse IDE configurations
Open the application in Eclipse and atualize the maven dependencies

## Run the project
### When run the application, the Spring Boot generate a DataBase in memory with the file "data.sql" data.
- Run the main class like java application;
- Open the postman and choice a http method;
- To GET and DELETE, use one end point avaliabe above;
- To POST and PUT, choice a json example in the archive and copy to the tab body
- Open the tab Headers, include the key Content-type and value application/json;
- ENJOY

# Autor

Adriel Rodrigues de Sales

https://www.linkedin.com/in/adriel-sales-70706551/
