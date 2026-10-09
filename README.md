# SmartDesk AI – Intelligent Customer Support Chatbot

SmartDesk AI is a Java-based customer-support chatbot built with Spring Boot. It provides an interactive web interface where users can ask common questions about services, working hours, company information, and support.

## Features

* Interactive chatbot interface
* Quick-action buttons for Services, Working Hours, About AI, and Contact
* Intent-based response handling
* FAQ and customer-support responses
* Responsive chat interface
* Light and dark theme toggle
* Chat timestamps and online status indicator

## Technologies Used

* **Java** – application logic
* **Spring Boot** – backend application framework
* **Maven** – dependency and build management
* **HTML, CSS, JavaScript** – frontend interface
* **REST API** – backend communication, where configured

## Project Structure

```text
smartdesk-ai/
├── src/
│   └── main/
│       ├── java/
│       └── resources/
│           └── static/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

* Java JDK compatible with the project's Spring Boot version
* Visual Studio Code or another Java IDE
* Internet access for the initial Maven dependency download

### Run the Application

1. Clone or download this repository.
2. Open the project directory containing `pom.xml`.
3. Open a terminal in that directory.
4. Run:

```powershell
.\mvnw.cmd spring-boot:run
```

5. Open your browser and visit:

http://localhost:8080

## Purpose

This project demonstrates Java backend development, chatbot intent handling, frontend integration, and customer-support user-interface design.

## Future Improvements

* Persistent conversation history
* Expanded FAQ and intent recognition
* Admin dashboard and usage analytics
* Automated unit and integration testing
* Improved error handling and API documentation

## Disclaimer

SmartDesk AI is a learning and demonstration project. Responses depend on the application's configured logic and data.

## Author

Siddharth H Vibhuthi
