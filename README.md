# Doctor Patient Platform

This is a backend API project built using Spring Boot Framework and Hibernate for carrying out database operations. The platform allows doctors to register their patients through a mobile or web portal and suggest the best doctor based on patient’s symptoms. 

## Features

- Add a doctor to the platform
- Add a patient along with their symptoms
- Suggest the best doctor based on the patient’s symptom and location

## Entities

### Doctor

In our database, we will have the following fields for the doctor entity:

- Name (should be at least 3 characters)
- City (should be at max 20 characters)
- Email (should be a valid email address)
- Phone number (should be at least 10 numbers)
- Speciality (can have 4 values i.e. Orthopedic, Gynecology, Dermatology, ENT specialist)

A doctor can be added or removed from the platform.

### Patient

In our database, we will have the following fields for the patient entity:

- Name (should be at least 3 characters)
- City (should be at max 20 characters)
- Email (should be a valid email address)
- Phone number (should be at least 10 numbers)
- Symptom (can have the following values only: Arthritis, Back Pain, Tissue injuries (comes under Orthopedic speciality), Dysmenorrhea (comes under Gynecology speciality), Skin infection, skin burn (comes under Dermatology speciality), Ear pain (comes under ENT speciality))

A patient can be added or removed from the platform.

## Suggesting Doctors

This API will accept a patient ID, and on calling this API, it will suggest the best doctors based on the patient’s location and symptom.

### Edge-Cases

- If there isn’t any doctor on that location (i.e. outside Delhi, Noida, Faridabad), the response should be “We are still waiting to expand to your location”
- If there isn’t any doctor for that symptom on that location, the response should be “There isn’t any doctor present at your location for your symptom”

## Technologies Used

- Java 17
- Spring Boot Framework(version - 3.0.6)
- Hibernate
- Swagger (optional)
- MySQL database

## Installation

1. Clone the repository:
```
git clone https://github.com/abhishek-singh-manhas/DoctorPatient.git
```

2. Open the project in your favorite IDE
3. Modify the application.properties file with your MySQL database information:
```
spring.datasource.url=jdbc:mysql://localhost:3306/dbdoctor
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

4. Run the project
Access the Swagger documentation at 
```
http://localhost:8080/swagger-ui/index.html
```

## Validation
The following fields are validated at the backend:
- Name (should be at least 3 characters)
- City (should be at max 20 characters)
- Email (should be a valid email address)
- Phone number (should be at least 10 number)

## Snapshots
![swagger snap 1](https://github.com/abhishek-singh-manhas/DoctorPatient/blob/b4275cc7e5edd58d5e4c138e9ebd238bc2ba70ea/snapshots/outputSwagger1.jpg)
![swagger snap 2](https://github.com/abhishek-singh-manhas/DoctorPatient/blob/b4275cc7e5edd58d5e4c138e9ebd238bc2ba70ea/snapshots/outputSwagger2.jpg)


