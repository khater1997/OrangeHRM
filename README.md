# OrangeHRM Automation Framework

## 📌 Overview

This project is an automated end-to-end test framework for **OrangeHRM** using:
## 🛠️ Technologies & Tools
- **Java (JDK 21)**
- **Selenium WebDriver 4.33.0**
- **Cucumber (BDD)**
  - ***Cucumber Java 7.23.0***
  - ***Cucumber TestNG 7.23.0***
- **TestNG**
- **WebDriverManager 6.1.0**
- **Maven**

The framework automates user management workflows, such as adding and deleting users in the OrangeHRM Admin section.

---

## 🗂️ Project Structure
```
├── src
│ ├── main
│ │ └── java
│ │ └── OrangeHRM
│ │ └── Pages
│ │ ├── LoginPage.java
│ │ └── AdminPage.java
│ └── test
│ ├── java
│ │ └── OrangeHRM
│ │ ├── stepDefs
│ │ │ ├── Hooks.java
│ │ │ └── UserSteps.java
│ │ └── testRunner
│ │ └── Runner.java
│ └── resources
│ └── features
│ └── UserManagement.feature
├── pom.xml
└── README.md
```
---
## ✅ Prerequisites
Make sure you have the following installed:
- Java JDK 21
- Maven
- Git
- Chrome Browser
---

## 🚀 Setup Instructions

1. **Clone the repository** 
2. **Build the project**
---

## 🧪 Running the Tests
To run all scenarios tagged @smoke:
This will:

- Launch Chrome using WebDriverManager
- Log in to OrangeHRM
- Add a test user
- Search and delete the user
- Generate test execution reports

## 🎯 Example @CucumberOptions in the test runner:
```
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "OrangeHRM.stepDefs",
    tags = "@smoke",
    plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "junit:target/cukes.xml",
        "rerun:target/rerun.txt"
    }
)
```
You can modify the tags property to run different scenarios.

## 📊 Test Reports
After running the tests, reports are generated in the target directory:

1. **HTML Report:**
   - target/cucumber.html
      - (Open this file in your browser)

2. **JSON Report:**
   - target/cucumber.json

3. **JUnit XML Report:**
   - target/cukes.xml

4. **Rerun File:**
   - target/rerun.txt 
      - (Contains any failed scenarios for re-execution)

