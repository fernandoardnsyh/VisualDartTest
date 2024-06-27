UI Automation Test Framework with Cucumber, Java, Gradle, and Selenium Project Description

This project provides a UI Automation Testing framework to test web applications. The framework utilizes Cucumber, Java, Gradle, and Selenium to achieve the following goals:

Automate UI test scenarios: Cucumber enables writing test scenarios in easy-to-read and understand Gherkin language.
Robust test execution: Java and Selenium provide powerful libraries to interact with web elements and execute tests effectively.
Efficient build management: Gradle helps manage dependencies, build the project, and run tests automatically.
Page Object Model Design Pattern

The framework implements the Page Object Model (POM) design pattern to improve code maintainability and readability. Each web page in the application under test is represented as a separate Java class. This class contains all the locators and methods required to interact with elements on that page.

Running the Tests

To run the tests, follow these steps:

Clone the GitHub repository: Clone the GitHub repository containing the project's source code.
Ensure prerequisites are met: Ensure you have Java Development Kit (JDK) and Gradle installed on your system.
Run the tests: Open a terminal and navigate to the project's root directory. 

Execute the following command to run the tests with type on terminal : ./gradlew webTest or 

To run with trigger any push and pull to directory on github
you can change the "userid" and "username" on web.features file and push to github for trigger 

To run with Actions on Github
- go to directory github
- click actions
- click "Web Automation Workflow" and run workflow

The report file will be auotamic generate after finish workflows, you can check on: 
- go to directory
- click action
- go to "Web Automation Worflow"
- choose finished workflow
- click download Artifact Cucumber Report
- extract on your local repo
- open file and choose web you want to open the report test file 

Test Case including 
- Initial Application Setup Create User A
- Initial Application Setup Create User B
- User A Create and Setup Group Channel with user B
- User A send message and file to user B
- User B receive message and file from user A
- test
  
