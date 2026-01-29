# OrangeHRM Automation Testing Framework

## Project Overview
This project focuses on automating functional test cases for the OrangeHRM web application using Selenium WebDriver and TestNG. The framework is designed using the Page Object Model (POM) to ensure maintainability, scalability, and reusability of test code.

The automation suite covers core HR functionalities, including login, user management, and admin operations, simulating real-world testing scenarios.

---

##  Tech Stack
- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Reporting:** Extent Reports  
- **Utilities:** Apache POI (for data-driven testing)  

---

## Project Structure

src/main/java  
 ├── com.jayant.orangehrm.core  
 │    ├── DriverFactory.java  
 │    └── ExtentManager.java  
 ├── com.jayant.orangehrm.util  
 │    ├── ExcelUtil.java  
 │    └── ScreenshotUtil.java  
 └── com.jayant.pages  
      ├── LoginPage.java  
      └── AdminPage.java  

src/test/java  
 ├── com.jayant.orangehrm.base  
 │    └── BaseTest.java  
 ├── com.jayant.orangehrm.listener  
 │    └── Listener.java  
 └── com.jayant.orangehrm.tests  
      ├── LoginDDT.java  
      └── AdminTest.java  

src/test/resources  
 └── excel-files  
      └── Orhm_loginData.xlsx  

testng.xml – TestNG suite configuration  
pom.xml – Maven dependencies  
Reports/ – Extent HTML reports  
Screenshots/ – Failure screenshots


---

##  Key Features
- Automated login and core functional workflows  
- Data-driven testing using Excel for valid and invalid test scenarios  
- Assertion-based validations to verify expected behaviour  
- Screenshot capture on test failure  
- Detailed execution reports using Extent Reports  

---

##  How to Run the Tests
1. Clone the repository  
2. Import the project as a Maven project in any IDE  
3. Update configuration files if required  
4. Run tests using `testng.xml` or by executing `mvn test`  

---

##  Notes
This project was created for learning and practice purposes to gain hands-on experience in Selenium automation testing and framework design.


