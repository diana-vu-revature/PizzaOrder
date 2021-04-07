# Pizza Order App
A jank example of a pizza ordering application.

# User can:
    - order multiple pizzas
    - see database of orders

# Java 8:
- I/O Stream
- Collections API (Data Structures)
- Multi-threading
- Build Tool: Gradle
- Unit Testing: JUnit
- git & GitHub
- Readme's & Javadocs
- PostgreSQL database

# How to enter DB
```bash 
docker image build . -f docker/Dockerfile.dockerfile -t customer
docker run -d --name customer -e POSTGRES_PASSWORD=password -p 5432:5432 customer
docker exec -it customer psql -U hiworld
```
