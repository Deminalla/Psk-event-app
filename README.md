### Technical requirements
- Java 17
- Postgresql

### Application configurations
- application.properties
  - Connection details to the database, use those to create local database
  - server port
  - jpa and mybatis settings regarding db
- build.gradle
  - dependencies
- db/migration
-   If you change something important regarding entity and notice that it doesnt automatically change in database, write a migration
-   If you want to add data that everyone should have as base data for testing 

### General rules/recommendations
- work on your own branch and afterwards create a pull request. You cannot directly push/merge to master without approval
- if you added something new and think it's required for everyone to know, you can write it in README for future reference
- more to come?
