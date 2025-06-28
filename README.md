# OrangeHRM Automation Framework

## 📌 Overview

This project is an automated end-to-end test framework for **OrangeHRM** using:

- **Java (JDK 21)**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**
- **WebDriverManager**
- **Maven**

The framework automates user management workflows, such as adding and deleting users in the OrangeHRM Admin section.

---

## 🛠️ Technologies & Tools

- Java 21
- Maven
- Selenium WebDriver 4.33.0
- Cucumber Java 7.23.0
- Cucumber TestNG 7.23.0
- WebDriverManager 6.1.0
- TestNG

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
   ```bash
   git clone https://github.com/yourusername/orangehrm-automation.git
   cd orangehrm-automation
   
2. **Build the project**
  ```bash
  mvn clean install
