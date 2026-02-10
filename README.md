OrangeHRM Automation Testing Framework
📌 Project Overview

This project is an end-to-end Test Automation Framework developed for the OrangeHRM application as part of a Human Resource Management domain capstone project. The framework automates critical HR workflows including login validation and Admin user management operations.

The framework is built using Selenium WebDriver + TestNG + Maven and follows the Page Object Model (POM) design pattern to ensure scalability, maintainability, and reusability of test components.

It also incorporates Data Driven Testing, Parallel Execution support, Thread-safe reporting, and Failure debugging utilities, simulating real-world enterprise automation framework standards.

🎯 Automation Scope
Module 1: Login

Automated login and logout functionality using multiple test datasets.

✔ Valid and invalid login scenarios
✔ Test data read dynamically from Excel
✔ Assertion validation for success and failure scenarios
✔ Screenshot capture for failed test cases
✔ Extent Report generation for execution summary

Module 2: Admin – User Management

Automated Admin module validations covering employee search and filter operations.

✔ Left menu validation and navigation
✔ Search employee by Username
✔ Search employee by User Role
✔ Search employee by Status
✔ Record count validation after search
✔ Page refresh handling and dynamic wait implementation

🛠 Tech Stack
Category	Technology
Language	Java (JDK 17)
Automation Tool	Selenium WebDriver
Test Framework	TestNG
Build Tool	Maven
Design Pattern	Page Object Model (POM)
Reporting	Extent Reports
Data Handling	Apache POI (Excel Integration)
Dependency Management	Maven
Version Control	Git & GitHub
🏗 Framework Design Highlights
✔ Page Object Model Implementation

Separation of UI locators and test logic

Improves code reusability and maintainability

✔ Thread-Safe WebDriver Management

Implemented using ThreadLocal

Supports parallel execution safely

✔ Custom Reporting Framework

Extent Reports with:

Test status tracking

Failure logs

Screenshot attachments

Dark theme UI

✔ Data Driven Testing

Login test data maintained in Excel

Dynamic dataset execution using TestNG DataProvider

✔ Centralized Utilities

Screenshot capture utility

Excel data reader utility

Driver initialization factory

✔ TestNG Listener Integration

Automated logging of:

Pass / Fail / Skip status

Screenshot capture on failure

Report generation

src/main/java
 ├── com.jayant.orangehrm.core
 │    ├── DriverFactory.java
 │    └── ExtentManager.java
 │
 ├── com.jayant.orangehrm.util
 │    ├── ExcelUtil.java
 │    └── ScreenshotUtil.java
 │
 └── com.jayant.pages
      ├── LoginPage.java
      └── AdminPage.java

src/test/java
 ├── com.jayant.orangehrm.base
 │    └── BaseTest.java
 │
 ├── com.jayant.orangehrm.listener
 │    └── Listener.java
 │
 └── com.jayant.orangehrm.tests
      ├── LoginDDTTest.java
      └── AdminTest.java

src/test/resources
 └── excel-files
      └── Orhm_loginData.xlsx

testNG.xml – Test execution suite  
pom.xml – Maven dependencies  
Reports/ – Execution reports  
Screenshots/ – Failure screenshots

✅ Test Scenarios Covered
Login Module

Valid login validation

Invalid login validation

Logout validation

Excel driven test execution

Admin Module

Left side menu validation

Search user by username

Search user by role

Search user by status

Record count validation

📊 Reporting & Debugging Features

Automatic HTML report generation

Screenshot capture on failure

Step-level execution logs

Thread-safe report creation

▶️ How To Execute The Project
Prerequisites

Java JDK 17+

Maven installed

Chrome Browser

Git

Steps To Run
Clone Repository
git clone <repository-url>

Navigate to Project
cd orangehrm-automation

Execute Tests
mvn clean test


OR run using:

testNG.xml

📸 Sample Output

Extent HTML Execution Reports

Screenshot evidence for failed tests

Console logs showing test execution details

🚀 Key Learning Outcomes

Automation framework design using POM

Real-time Data Driven Testing implementation

Thread-safe automation framework setup

TestNG listener and reporting integration

Dynamic synchronization using WebDriverWait

Industry-standard test structure implementation

📎 Application Under Test

OrangeHRM Demo Application
https://opensource-demo.orangehrmlive.com

👨‍💻 Author

Jayant Kumar Shukla
🔗 LinkedIn: https://www.linkedin.com/in/jayant-kumar-shukla

🔗 GitHub: https://github.com/jayantshukla3009-spec
