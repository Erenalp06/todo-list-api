# Spring Boot - To Do List API

Build Restful CRUD API for a todo list using Spring Boot.

## Steps to Setup

**1. Docker. First, you need to install docker**

* Download Docker [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature on Windows and restart.
* Then open powershell and check:

docker version
```bash
docker -v
```

or docker compose version
```bash
docker-compose -v
```

**2. Create PostgreSQL database**
```bash
create database todo_db
```

**3. Change postgreSQL username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your postgreSQL installation

**4. Spring Boot app**
* Clone the repository
```bash
git clone https://github.com/Erenalp06/todo-list-api.git
```
* Build the maven project:
```bash
mvn clean install
```
* Running the containers:

This command will build the docker containers and start them.
```bash
docker-compose up
```

The app will start running at <http:localhost:9643>

Appendix A.

All commands should be run from project root (where docker-compose.yml locates)

* If you have to want to see running containers.
Checklist docker containers
```bash
docker container list -a
```
or
```bash
docker-compose ps
```
![Screenshot docker containers list](https://www.hizliresim.com/2tyb2d4)
*Screenshot with running containers*

## Explore Rest API's

The app defines following CRUP APIs.

### Users

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /v1/users/{userId} | Get user by userId with task list | |
| POST   | /v1/users | Create new user | [JSON](#usercreate) |
| PUT    | /v1/users/{userId} | Update user | |
| DELETE | /v1/users/{userId} | Delete user by userId | |

### Tasks

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /v1/tasks/{userId} | Get tasks by userId | |
| POST   | /v1/tasks/{userId} | Create new task by userId | [JSON](#taskcreate) |
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

