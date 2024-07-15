# E-commerce Automation Framework

## Project Setup Instructions
1. Clone the repository:
    ```sh
    git clone https://github.com/your-repo-url.git
    ```
2. Navigate to the project directory:
    ```sh
    cd automation-framework
    ```
3. Install dependencies:
    ```sh
    mvn clean install
    ```

## How to Run the Tests
1. Run the frontend tests:
    ```sh
    mvn test -Dtest=ProductSearchTest
    ```
2. Run the backend tests:
    ```sh
    mvn test -Dtest=ApiTests
    ```

## Framework Design and Structure
- `src/test/java/com/ecommerce`: Contains test classes for frontend and backend tests.
- `src/main/resources`: Contains test resources.
- `pom.xml`: Maven configuration file with project dependencies.
- `README.md`: Project setup instructions and overview.

## Framework Overview
- The frontend automation uses Selenium WebDriver to perform actions on Amazon and Flipkart.
- The backend automation uses RestAssured to perform API tests on selected endpoints.
