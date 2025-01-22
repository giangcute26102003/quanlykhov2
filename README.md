Warehouse Management Application
Overview
This is a Warehouse Management Application developed in Java using the Three Layer Architecture. The application helps manage inventory, track stock levels, and handle warehouse operations efficiently.

Features
Add, update, and delete products

Track stock levels

Generate inventory reports

User authentication and authorization

Search functionality for products

Architecture
The application follows the Three Layer Architecture:

Presentation Layer: Handles the user interface and user interactions.

Business Logic Layer: Contains the business logic and rules.

Data Access Layer: Manages data storage and retrieval.

Technologies Used
Java

JavaFX for the user interface

JDBC for database connectivity

MySQL as the database

Installation
Clone the repository:

bash
git clone https://github.com/yourusername/warehouse-management.git
Navigate to the project directory:

bash
cd warehouse-management
Set up the database:

Create a MySQL database named warehouse_db.

Import the provided SQL script to create the necessary tables.

Configure the database connection in the config.properties file.

Build and run the application:

bash
mvn clean install
mvn javafx:run
Usage
Launch the application.

Log in with your credentials.

Use the menu options to manage products, track stock levels, and generate reports.

Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

License
This project is licensed under the MIT License. See the LICENSE file for more details.
