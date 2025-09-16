# ShriSells- An E-commerce Platform (Monolithic Backend)

## Project Overview
This project is a back-end application for a modern e-commerce platform, built with a **monolithic architecture** using the **Spring Boot** framework. It provides a robust and scalable set of REST APIs to handle core e-commerce functionalities, including:

- User management  
- Product catalog browsing  
- Shopping cart  
- Secure order processing pipeline  

The application is designed as a **self-contained unit**, simplifying initial development and deployment. All business logic and data access layers are unified within a single codebase.

---

## Architecture
The application follows a **monolithic architecture**.  
This design centralizes all components into a single deployable unit, making development and testing more manageable for this scope.

### Key Components
- **User Management**: Handles user registration, authentication (via JWT), and profile management.  
- **Product Catalog**: Manages product details, categories, and inventory.  
- **Shopping Cart & Order Management**: Supports cart operations and manages the complete order lifecycle.  
- **Payment Integration**: Connects to a third-party payment gateway for secure transactions.  

---

## Database Schema
The application uses a **relational database (MySQL)** to store persistent data. The schema is designed for **data integrity and efficiency**.

### Core Tables
- **users**: Stores customer credentials and profile details.  
- **products**: Contains all available items for sale.  
- **orders**: Tracks user orders.  
- **order_items**: Junction table linking products to orders with quantities and prices.  
- **carts**: Manages products and quantities in a user’s shopping cart.  

---

## Core Features

### 1. User Management
- **Registration & Login**: Secure user registration and authentication with JWT.  
- **Password Security**: Passwords are hashed using **BCrypt**.  
- **Profile Management**: Users can view and update their profiles.  

### 2. Product Catalog
- **Product Listing**: Public API to view all available products.  
- **Product Details**: Fetch detailed product information.  
- **Search & Filter**: Search products by name and filter by categories or price range.  

### 3. Shopping Cart & Order Management
- **Cart API**: Add, update, and remove items from the cart (per user).  
- **Order Creation**: Convert cart into an order while atomically updating inventory.  
- **Order History**: View past orders via authenticated endpoints.  

### 4. Payment Integration
- **Secure Transactions**: Integration with a third-party payment gateway (e.g., Stripe).  
- **Transaction Status**: Order status updates based on payment gateway response.  

---

## Deployment & Quality Assurance

### Deployment
- Containerized with **Docker** for portability.  
- Configured for deployment on **AWS, Google Cloud, or Heroku**.  
- Automated deployment pipeline for smooth transitions from dev to prod.  

### Code Quality & Security
- **Static Analysis**: SonarQube for continuous code quality monitoring.  
- **Testing**: Unit & integration tests to validate core services and APIs.  

---

## Technologies Used
- **Backend**: Java, Spring Boot  
- **Database**: MySQL  
- **Authentication**: JWT (JSON Web Tokens)  
- **Build Tool**: Maven  
- **Quality Assurance**: SonarQube  
- **Deployment**: Docker  

---

## Getting Started

### Prerequisites
- Java 24  
- Maven  
- Clone the repository
- Install gradle for building
- Install Intellij idea for running the sprint boot solution.

### Run command
- mvn spring-boot:run
