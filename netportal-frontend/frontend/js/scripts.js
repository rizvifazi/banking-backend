// This file contains the JavaScript code that handles user interactions, form submissions, and API calls to the Spring Boot authentication endpoints for user registration and login functionality.

document.addEventListener('DOMContentLoaded', function() {
    const registerForm = document.getElementById('registerForm');
    const loginForm = document.getElementById('loginForm');

    registerForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = new FormData(registerForm);
        const data = Object.fromEntries(formData.entries());

        fetch('http://localhost:8080/api/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Registration successful!');
            } else {
                alert('Registration failed: ' + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = new FormData(loginForm);
        const data = Object.fromEntries(formData.entries());

        fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Login successful!');
                // Redirect to dashboard or another page
            } else {
                alert('Login failed: ' + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});