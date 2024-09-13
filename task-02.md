# Task 02: WebFlux

Create service to provide and store data about user.

Introduce domain object `User` with the following fields:

```
id: Long
firstName: String
lastName: String
```

`spring-webflux` provides two ways how to write handlers of incoming `HTTP` requests:

- using `controllers`
- using `routers`

Implement following endpoints using `controllers`:

```
GET /user/{id}  -- returns data about user with specified `id`
GET /user       -- returns data about all users
POST /user      -- creates new one user                                                      
```

Implement following endpoints using `routers`:

```
PUT /user/{id}    -- updates data about user with specified `id`
DELETE /user/{id} -- deletes data about user with specified `id`  
```

To transfer data from client to server use `JSON` format.

Create `in-memory` repository to store data about users. \
Here you can use some Java collection.

Optionally you can use `Project Reactor`.


## Documentation

* https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html
* https://www.baeldung.com/spring-webflux
* https://github.com/PacktPublishing/Hands-On-Reactive-Programming-in-Spring-5
* just type 'spring webflux' in Google and read any article
