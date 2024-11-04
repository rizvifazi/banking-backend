# Frontend Project Documentation

## Overview
This project is a front-end application designed to connect with Spring Boot authentication endpoints for user registration and login functionality. It utilizes HTML, CSS, and JavaScript to create a user-friendly interface.

## Project Structure
```
frontend
├── css
│   └── styles.css
├── js
│   └── scripts.js
├── index.html
└── README.md
```

## Files Description
- **index.html**: The main HTML document that serves as the entry point for the application. It includes the structure for user registration and login forms, along with links to the CSS and JavaScript files.
  
- **css/styles.css**: Contains the styles for the application, defining the layout, colors, fonts, and other visual aspects of the user interface.
  
- **js/scripts.js**: Contains the JavaScript code that handles user interactions, form submissions, and API calls to the Spring Boot authentication endpoints for user registration and login functionality.

## Setup Instructions
1. Clone the repository to your local machine.
2. Open the `frontend` directory in your preferred code editor.
3. Open `index.html` in a web browser to view the application.

## Usage Guidelines
- Users can register by filling out the registration form and submitting it.
- Existing users can log in using their credentials.
- The application communicates with the Spring Boot backend for authentication.

## Authentication Functionality
This application connects to the following Spring Boot authentication endpoints:
- **POST /api/register**: For user registration.
- **POST /api/login**: For user login.

Ensure that the Spring Boot application is running and accessible for the front-end to function correctly.