
# apiautomation
This project(apiautomation) is designed to automate an api using Java as the core programming language and verify the acceptance criteria provied.

## Getting Started
In order to kick start using the api automator please clone the code from git url:
https://github.com/GShar/apiautomation.git

### Prerequisites

Make sure you have Java installed.
Also make sure you are using an editor with support for both gradle and Java.
I have used the following:
* Intellij Idea as the editor
* Gradle as the build tool


## Running the tests
Please folow the steps below to run the test suite:
1. After cloning, make sure you have gradle installed and run the following command in the root directory:

 `gradle wrapper`

 * This command will create the gradlew file.


2. Make sure that you have edited and updated the configuration properties file (testapi.properties) with the correct values for both fields mentioned below:

* requestURL=https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false
* requestMethod=Get

The File is located at <RootFolder>/src/test/resources

2. Now go to the root folder of the project and run the following gradlew command from command line:
`./gradlew clean test`

This command will run the test and output the results of the build on terminal.

## Authors
Gopal Sharma




