# Spring Boot - To Do List API

Build Restful CRUD API for a todo list using Spring Boot.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/Erenalp06/todo-list-api.git
```
**2. Create PostgreSQL database**
```bash
create database todo_db
```

**3. Change postgreSQL username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your postgreSQL installation

**4. Run the app using maven**
```bash
mvn spring-boot:run
```
The app will start running at <http:localhost:9643>

## Explore Rest API's

The app defines following CRUP APIs.

### Users

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /v1/users/{userId} | Get user by userId with task list | |
| POST   | /v1/users | Create new user | |
| PUT    | /v1/users/{userId} | Update user | |
| DELETE | /v1/users/{userId} | Delete user by userId | |

### Tasks

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /v1/tasks/{userId} | Get tasks by userId | |
| POST   | /v1/tasks/{userId} | Create new task by userId | |
| PUT    | /v1/tasks/{taskId} | Update task | |
| DELETE | /v1/tasks/{taskId} | Delete user by taskId | |

Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="usercreate">Create User -> /v1/users</a>
```json
{
  "name":  "John Doe",
  "email": "johndoe@example.com"
}
```
##### <a id="taskcreate">Create Task -> /v1/tasks</a>
```json
{
  "title": "Task 3",
  "description": "Task 3 description",
  "completed": false,
  "userId": 1
}
```

