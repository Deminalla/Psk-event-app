### Technical requirements
- Java 17
- Postgresql

### Application configurations
- go to application.properties.
  - That file contains the details for connection to the database. Use those to create local database.
  - server port.
  - jpa and mybatis settings regarding db.
- go to build.gradle file.
  - run dependencies.
- might need db/migration.
-   If you change something important regarding entity and notice that it doesnt automatically change in database, write a migration.
-   If you want to add data that everyone should have as base data for testing.

### General rules/recommendations
- Fork the repository, make your changes, and submit a pull request.
- Pull requests require approval to be merged.

### Technology Stack
- Spring Boot: Provides the framework for building Java-based web applications and microservices.
- Spring Data JPA: Simplifies data access operations, improving the implementation of database interactions.
- MyBatis: SQL Mapper framework for custom SQL, stored procedures, and advanced mappings in Java.
- Flyway: Database migration tool for version control of the database schema.
- PostgreSQL: Open-source relational database used as the primary data store.
- Hibernate: ORM framework for mapping an object-oriented domain model to a relational database.
- Spring MVC: Model-View-Controller framework for building web applications.
- Thymeleaf: Server-side Java template engine for web environments.
- Lombok: Java library tool used to minimize/remove boilerplate code.
- MapStruct: Data mapper tool used for object mapping, simplifying the conversion between different object models.

### Features
- Event creation, updating, deletion.
- Event filtering.
- User registration and authentication.
- User details editing.
- Event joining.
- Guest list.
- Interceptor for logging request details.
- Modular architecture for easy maintenance and scalability.

## Documentation/links
- Front end: https://github.com/MazIeva/psk-event-app-front.git
- Microsoft Teams group: https://teams.microsoft.com/l/team/19%3aoZszOLJksBG3FlhdLhgqw8S3Np8DN1M016ZE8DjFMPc1%40thread.tacv2/conversations?groupId=d632b911-03ab-4d65-8df7-18d97dfd3fe7&tenantId=82c51a82-548d-43ca-bcf9-bf4b7eb1d012
- Technical requirements document: https://docs.google.com/document/d/1wdQ2DROo0WeW7H-xc5UWKGgROLNW1urtuN8CB02yJXs/edit?usp=sharing
- TSP document: https://docs.google.com/document/d/1IeETue6Zx2xk51dT6cEBSJv8O4EgUUW0MDfLFv9hcoM/edit?usp=sharing
- Trello: https://trello.com/invite/pskteamproject/ATTI225aecdb21726dea2f4b22bd5a9a084a27E4A4FF
- Update this README or other documentation according to the changes made.