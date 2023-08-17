# Swagger Implementation

## Swagger API Documentation Link - [Swagger](http://localhost:8080/swagger-ui.html "Swagger")

**Request URL**

 curl -X GET "http://localhost:8080/employee" -H "accept: */*"

***

 curl -X POST "http://localhost:8080/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"empDesg\": \"Software Engineer\", \"empId\": 1, \"empLoc\": \"Pune\", \"empName\": \"Mohsin\", \"empSal\": 10.0}"
 
 
 
***

* curl -X GET "http://localhost:8080/employee/1" -H "accept: */*"

