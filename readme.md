# Order Management System

A full-featured ordering system built with Java and Spring Boot.

## Features
- RESTful API with CRUD operations
- PostgreSQL database integration via Docker
- Code quality enforced with Lombok and Spotless
- Automated CI/CD with GitHub Actions and Taskfile

## Tech Stack
- Java 17 (managed with SDKMAN)
- Spring Boot 3.x
- PostgreSQL 16 (Docker)
- Maven Wrapper
- Docker Compose
- GitHub Actions
- Postman
- Portainer (easier docker management)

## Getting Started

### Prerequisites
- Java 17 (SDKMAN recommended)
- Docker & Docker Compose
- Maven Wrapper (`./mvnw`)
- Postman
- taskfile

### Build it through Taskfile automation
```taskfile
task start_infra
```

### TODO:
- [ ] Add testcontainers
- [ ] Add flyway migrations
