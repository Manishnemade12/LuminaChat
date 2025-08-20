# Gemini Ai Wrapper Spring Boot React
 A full-stack application that wraps Google's Gemini AI API with Spring Boot backend and React frontend,
 providing conversation management and a responsive UI for AI chat interactions.

## Features

- Real-time chat with Google's Gemini AI
- Persistent conversation history
- Responsive design that works on all devices
- Dark/light mode support based on system preferences
- RESTful API for AI interactions

## Tech Stack

### Backend
- Java 17
- Spring Boot 3.2.3
- Spring AI with Vertex AI Gemini integration
- Spring Data JPA for persistence
- SQLite database support
- SpringDoc OpenAPI for API documentation

### Frontend
- React with modern functional components and hooks
- Vite for fast development experience
- Responsive design with CSS variables
- Dark/light mode theme support

## Getting Started

### Prerequisites
- Java 17 
- Node.js LTS and npm
- SQLite (for development)
- Google Cloud account with Gemini API access
- Gcloud cli (recommended)

### Backend Setup
1. Clone this repository
2. Configure your database connection in `application.properties`
3. Set up Google Cloud credentials for Gemini API access.
   You must set at least your project-id in `application.properties` (it is highly recommended to set this as an environment variable on your system).
   To set your credentials, you can use:
``` 
gcloud auth application-default login
   ```
4. Run the application using your favorite IDE (Example: IntelliJ)
5. The app will be accessible at http://localhost:8080/swagger-ui/index.html#. 
(to make fetch requests, use http://localhost:8080/)

### Frontend Setup
1. Navigate to the frontend directory:
   ```
   cd Gemini-Ai-Wrapper-Spring-Boot-React\frontend
   ```
2. Install dependencies:
   ```
   npm install
   ```
3. Start the development server:
   ```
   npm run dev
   ```
4. The frontend will be available at `http://localhost:5173`

## API Endpoints

| Endpoint                                  | Method | Description                      |
|-------------------------------------------|--------|----------------------------------|
| `/gemini-ai-wrapper/v1/chat`              | POST   | Send a prompt to Gemini AI       |
| `/gemini-ai-wrapper/v1/conversation/{id}` | GET    | Retrieve a specific conversation |
| `/gemini-ai-wrapper/v1/conversation`      | GET    | Get all conversations            |


