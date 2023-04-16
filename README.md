Description: A test task for a REST client of a bookstore using spring boot technology

Stack: Java 17, SpringBoot 2.7.10, MySQL

Dependencies:
    - Spring Web:
        Building web, including RESTful, applications using Spring MVC. 
        Uses Apache Tomcat as the default embedded container.
    - Spring Data JPA:
        Persisting data in SQL stores with Java Persistence API using Spring Data and Hibernate.
    - MySQL Driver:
        MySQL JDBC driver.
    - Lombok:
        Java annotation library which helps to reduce boilerplate code.

Instructions for building the application:
    1. open the console, change the current directory to the project directory
    2. enter this command: mvn package

Launching the application:
    1. open the console
    2. enter this command: mvn package && java -jar target/bookstore-0.0.1-SNAPSHOT.jar

Request example:
    - $ curl http://localhost:8080/api/authors
        1. GET: runs the getAllAuthors() method and returns a list of all authors with a list of their books
           Body request: none
        2. POST: runs the saveAuthor() method saves the author with his list of books in the database and returns it
            Body request:
                {
                    "name": "Jack London",
                    "birth" : "12-01-1876",
                    "stile" : "Prose",
                    "country" : "USA",
                    "books":[
                        {
                            "name":"Martin Eden",
                            "publication" : "1909",
                            "price" : 750,
                            "genre" : "Drama"
                        }
                }
        3. DELETE: runs the deleteAllAuthors() the method removes all authors from the database along with a list of their books
            Body request: none
    - $ curl http://localhost:8080/api/authors/id
        1. GET: runs the findAuthorById() method and returns the author with his list of books by his ID
            Body request: none
        2. PUT: runs the updateAuthor() method and modifies the author and his list of books and returns the modified author
            Body request:
                {
                    "name": "New name",
                    "birth" : "New date",
                    "stile" : "New stile",
                    "country" : "New country",
                    "books":[
                        {
                            "name":"New name",
                            "publication" : "New date",
                            "price" : new price,
                            "genre" : "New genre"
                        }
                }
        3. DELETE: runs the deleteAuthorById() modifies and deletes the author by his ID
            Body request: none