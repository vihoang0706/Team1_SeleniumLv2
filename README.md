# Selenium Java

Selenium is an umbrella project encapsulating a variety of tools and libraries enabling web browser automation. 
Selenium specifically provides infrastructure for the W3C WebDriver specification — a platform and language-neutral 
coding interface compatible with all major web browsers.

The project is made by the small group includes 3 members. The purpose of this project to
learn about how to build an automation framework by using Selenium.

AUT(Application under Test): TA Dashboard

## Requirements

1. Java 8
2. IntelliJ IDEA ( It is an integrated development environment written in Java for developing computer software)
or any tools you prefer
3. java and jar on the PATH (make sure you use java executable from JDK but not JRE).
   To test this, try running the command javac. This command won't exist if you only have the JRE installed. 
   If you're met with a list of command-line options, you're referencing the JDK properly.

##How to use this project

Firstly, you can clone the source code from the github on local by using the command line,
or you can download the zip file.

After having the source code on the local, you import this project into the tool where you use writing the test script

##How to run this project
There are 2 ways to run Selenium project
+ Run on local
+ Run via Selenium Grid

1. Run on local
    
    You can go ```{root project}\Team1_SeleniumLv2\src\main\resources\suites\testsuites.xml``` file to edit the parameter 
    "runOn" with value "local"

2. Run via Selenium Grid
Firstly, you should set up the environment. On this project, we have already defined how to create a grid and hub on the 
```resource/grid``` folder. You can go to this project and run 2 files .bat (```grid_hub.bat``` and ```grid_node.bat```) in case you run
on windows platform

In case, you want to run test scripts by parallel, you can config file ```testsuites.xml``` as below:

```<test name="UserManagement" parallel="classes" thread-count="1">```

On this file, you define all test cases you want to run on there.
After that, right clicking on ```testsuites.xml``` and run test scripts.

##Framework structure
Selenium project designed to Page Object Model pattern