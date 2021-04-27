# Pizza Order App
A jank example of a pizza ordering application.

# Project Description:
A customer can:
    - order multiple pizzas
    - select toppings for their pizza
    - see database of orders

# Technologies Used:
- I/O Stream
- Collections API (Data Structures)
- Multi-threading
- Build Tool: Gradle
- Unit Testing: JUnit
- git & GitHub
- PostgreSQL database

# Features
To-do List:
    - Customer can review and edit their order

# Getting Started
- clone repository
- install Gradle
### How to enter DB
```bash 
docker image build . -f docker/Dockerfile.dockerfile -t customer
docker run -d --name customer -e POSTGRES_PASSWORD=password -p 5432:5432 customer
docker exec -it customer psql -U hiworld
```
