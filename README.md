# Task Manager Backend Using Spring Boot
This project is the backend of a Task Manager. It uses Java Spring Boot and MySQL for database management. The application includes RESTful APIs for Task Manager and (Manager and Developer) registration. And JWT for the authorization. The application is hosted on AWS EC2 and S3 .
 
# Prerequisites
Java 17 \
MySQL 8.0\
Running the Application 
# 1. Configure MySQL
Create a new database and user for the application. You can do this using the following SQL commands:
 
sql \
Download \
Copy code \
CREATE DATABASE dcbapp; \
FLUSH PRIVILEGES; 
# 2. Configure Application Properties
Open the src/main/resources/application.yml file and set the following properties:
 
properties \
Download \
Copy code \
spring.jpa.hibernate.ddl-auto=create \
spring.datasource.url=jdbc:mysql://localhost:3306/dcbapp \
spring.datasource.username=root \
spring.datasource.password=password \
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver \
spring.jpa.show-sql: true \
#spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect \
Replace your_password with the password you set for the task_manager_user MySQL user. 
 
# 3. Run the Application
You can run the application by executing the following command in the project directory:
 
bash \
Download \
Copy code \
./mvnw spring-boot:run 
 
 # License
This project is licensed under the MIT License - see the LICENSE file for details.
