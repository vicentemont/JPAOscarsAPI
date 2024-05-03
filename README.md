# Oscars REST API

Welcome to the Oscars REST API! This project provides a RESTful API for managing and retrieving information about Oscars and related movies.

## Features
- Retrieve a list of all Oscars.
- Search Oscars based on different criteria (movie title, TMDB ID, IMDB ID, category, or year).
- Add a single Oscar or a list of Oscars.
- Update existing Oscars.
- Delete Oscars by ID.

## Technology Stack
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL

## Getting Started
To get started with the Oscars REST API, follow these steps:

### Prerequisites
- JDK 17 or later
- Maven or Gradle
- MySQL database

### Setup Instructions
1. **Clone the Repository**:
   
Configure the Database:
Ensure you have MySQL installed and running.
Create a database named oscars.
Update the application.properties file with your MySQL database connection information:
spring.datasource.url=jdbc:mysql://localhost:3306/oscars
spring.datasource.username=root
spring.datasource.password=12345678
Optionally, you can change the default port (8082) or other configurations in application.properties.

2. **Database Initialization**:
To initialize the database with movie data from the oscar-nominations.json file (located in the src/main/resources folder), send a POST request to the /addOscarList endpoint with the JSON file's content.
You can use tools like Postman or curl to make this request.

3. **Access the API**:
By default, the application runs on localhost:8082. Open a browser and navigate to http://localhost:8082/ to see the welcome message.
API Endpoints
Here are the available API endpoints and their functionalities:

## Get Welcome Message:
GET /
Returns a welcome message.
## Search Oscars:
GET /oscars/search

**Query parameters**:
title: Search by movie title.

tmdb_id: Search by TMDB ID.

imdb_id: Search by IMDB ID.

category: Search by category.

year: Search by year.

Example: GET /oscars/search?title=The Godfather
## Add Oscar:
POST /addOscar
Accepts a JSON object representing an Oscar.
## Add Multiple Oscars:
POST /addOscarList
Accepts a JSON array of Oscars.
## Edit Oscar:
PUT /editOscar
Accepts a JSON object representing the Oscar to be updated.
## Delete Oscar:
DELETE /deleteOscar
Accepts the ID of the Oscar to be deleted.


oscar-nominations.json contains all the data. Thanks to https://github.com/delventhalz/
