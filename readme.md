# Farmer Market Platform

A simple farmer-to-customer marketplace web application built using HTML, CSS, Java Servlets, JDBC, and MySQL.  
The project is designed to help farmers connect directly with customers and reduce dependency on middlemen.

## Features

- Purple-black themed responsive UI.
- Separate landing page with farmer and customer login paths.
- Detailed farmer registration form.
- Detailed customer registration form.
- Servlet-based form handling.
- JDBC database insertion for both farmer and customer data.
- File upload support for profile photo and document uploads.
- Easy-to-modify database connection settings.

## Project Pages

- `index.html` - Main landing page with farmer and customer options.
- `farmer.html` - Farmer registration page.
- `customer.html` - Customer registration page.
- `FarmerRegisterServlet.java` - Servlet to handle farmer form submission.
- `CustomerRegisterServlet.java` - Servlet to handle customer form submission.

## Technology Stack

- HTML5
- CSS3
- Java Servlet
- JDBC
- MySQL

## Folder Structure

```text
project-root/
├── index.html
├── farmer.html
├── customer.html
├── src/
│   ├── FarmerRegisterServlet.java
│   └── CustomerRegisterServlet.java
└── uploads/
```

## Prerequisites

Before running this project, make sure you have:

- Java JDK installed.
- Apache Tomcat or any Servlet container.
- MySQL database installed.
- MySQL JDBC driver added to the project.

## Database Setup

Create a database in MySQL and then create the required tables.

### Farmers Table

```sql
CREATE TABLE farmers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    gender VARCHAR(20),
    dob VARCHAR(20),
    aadhaar VARCHAR(50),
    pan VARCHAR(50),
    email VARCHAR(100),
    mobile VARCHAR(20),
    door_no VARCHAR(100),
    street VARCHAR(255),
    village VARCHAR(100),
    taluk VARCHAR(100),
    district VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(20),
    farm_name VARCHAR(150),
    farm_type VARCHAR(50),
    experience VARCHAR(20),
    land_size VARCHAR(50),
    crops VARCHAR(255),
    farming_details TEXT,
    bank_name VARCHAR(150),
    account_holder VARCHAR(150),
    account_number VARCHAR(100),
    ifsc VARCHAR(50),
    upi_id VARCHAR(100),
    branch_name VARCHAR(150),
    username VARCHAR(100),
    password VARCHAR(100),
    profile_photo VARCHAR(255),
    land_document VARCHAR(255)
);
```

### Customers Table

```sql
CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    gender VARCHAR(20),
    dob VARCHAR(20),
    email VARCHAR(100),
    mobile VARCHAR(20),
    door_no VARCHAR(100),
    street VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(20),
    landmark VARCHAR(150),
    address_notes TEXT,
    language VARCHAR(50),
    contact_method VARCHAR(50),
    preferences VARCHAR(255),
    additional_requests TEXT,
    username VARCHAR(100),
    password VARCHAR(100),
    payment_method VARCHAR(50),
    upi_id VARCHAR(100),
    profile_photo VARCHAR(255),
    address_proof VARCHAR(255)
);
```

## Configuration

In both servlet files, change these values:

```java
private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
private static final String JDBC_USER = "your_username";
private static final String JDBC_PASSWORD = "your_password";
```

## How It Works

1. User opens `index.html`.
2. User chooses either farmer or customer.
3. Farmer opens `farmer.html`, customer opens `customer.html`.
4. On submit, the form sends data to the matching servlet.
5. Servlet stores the submitted data into MySQL.
6. Uploaded files are saved in the `uploads` folder.

## Running the Project

1. Import the project into Eclipse, IntelliJ, or any Java web IDE.
2. Add the MySQL connector JAR to the project.
3. Create the database and tables.
4. Update JDBC URL, username, and password in both servlets.
5. Deploy the project on Tomcat.
6. Open `index.html` in the browser.

## Notes

- The project is intentionally kept simple.
- You can later add login validation, sessions, admin pages, and product listing pages.
- The upload folder must have write permission.
- If you change table column names, update the servlet SQL queries accordingly.

## Future Improvements

- Add separate login and registration logic.
- Add password hashing.
- Add session management.
- Add product listing and order pages.
- Add admin dashboard.
- Add validation and error messages.

## License

This project is for educational use.