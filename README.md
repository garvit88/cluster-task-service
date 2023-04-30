# cluster-task-service
Cluster Task Service

To setup database follow below steps:
1. Create a database:

CREATE DATABASE taskservice;

2. Create Task table:

create table task (
      id bigserial not null,
      created timestamp(6) with time zone not null,
      updated timestamp(6) with time zone not null,
      deadline timestamp(6) with time zone not null,
      description varchar(255) not null,
      status varchar(255) not null,
      title varchar(255) not null,
      primary key (id)
);

Run application:

If you are running on local system than start the application as spring boot application otherwise you can deploy it on any server like any microservice

API Documentation:

1. Creating a new task:

Curl:

curl --location 'localhost:8081/api/ts/v1/task' \
--header 'Content-Type: application/json' \
--data '{
    "title":"test1",
    "description":"testing 1",
    "status":"PENDING",
    "deadline":"2021-02-09T11:19:42.120Z"
}'

Method Type: POST
Path: {{url}}:{{port}}/api/ts/v1/task

Sample Request:

{
    "title":"test1",
    "description":"testing 1",
    "status":"PENDING",
    "deadline":"2021-02-09T11:19:42.120Z"
}

Sample Response:

{
    "message": "Task Created Successfully",
    "status": "Created",
    "statusCode": 201,
    "data": {
        "id": 1,
        "created": "2023-04-30T09:06:30.627300Z",
        "updated": "2023-04-30T09:06:30.627303Z",
        "title": "test11",
        "description": "testing 1",
        "status": "PENDING",
        "deadline": "2021-02-09T11:19:42.120Z"
    }
}

2. Updating an existing task:

Curl:

curl --location --request PUT 'localhost:8081/api/ts/v1/task/5' \
--header 'Content-Type: application/json' \
--data '{
    "title":"test12",
    "description":"testing 1",
    "status":"IN_PROGRESS",
    "deadline":"2021-02-09T11:19:42.120Z"
}'

Method Type: PUT
Path: {{url}}:{{port}}/api/ts/v1/task/5

Sample Request:

{
    "title":"test12",
    "description":"testing 1",
    "status":"IN_PROGRESS",
    "deadline":"2021-02-09T11:19:42.120Z"
}

Sample Response:

{
    "message": "Task Updated Successfully",
    "status": "Success",
    "statusCode": 200,
    "data": {
        "id": 5,
        "created": "2023-04-30T08:37:35.249132Z",
        "updated": "2023-04-30T08:38:11.766084Z",
        "title": "test12",
        "description": "testing 1",
        "status": "IN_PROGRESS",
        "deadline": "2021-02-09T11:19:42.120Z"
    }
}

3. Fetching an existing task:

Curl:

curl --location 'localhost:8081/api/ts/v1/task/5' \
--data ''

Method Type: GET
Path: {{url}}:{{port}}/api/ts/v1/task/5

Sample Response:

{
    "message": "Task Fetched Successfully",
    "status": "Success",
    "statusCode": 200,
    "data": {
        "id": 5,
        "created": "2023-04-30T08:37:35.249132Z",
        "updated": "2023-04-30T08:38:11.766084Z",
        "title": "test12",
        "description": "testing 1",
        "status": "IN_PROGRESS",
        "deadline": "2021-02-09T11:19:42.120Z"
    }
}

4. Deleting an existing task:

Curl:

curl --location --request DELETE 'localhost:8081/api/ts/v1/task/5' \
--data ''

Method Type: DELETE
Path: {{url}}:{{port}}/api/ts/v1/task/5

Sample Response:

{
    "message": "Task Deleted Successfully",
    "status": "Success",
    "statusCode": 200,
    "data": null
}
