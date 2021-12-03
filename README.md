# Advent of Code 2021

My attempt at the Advent of Code for 2021 using Java

```text
              _                 _            __    _____          _        ___   ___ ___  __
     /\      | |               | |          / _|  / ____|        | |      |__ \ / _ \__ \/_ |
    /  \   __| |_   _____ _ __ | |_    ___ | |_  | |     ___   __| | ___     ) | | | | ) || |
   / /\ \ / _` \ \ / / _ \ '_ \| __|  / _ \|  _| | |    / _ \ / _` |/ _ \   / /| | | |/ / | |
  / ____ \ (_| |\ V /  __/ | | | |_  | (_) | |   | |___| (_) | (_| |  __/  / /_| |_| / /_ | |
 /_/    \_\__,_| \_/ \___|_| |_|\__|  \___/|_|    \_____\___/ \__,_|\___| |____|\___/____||_|

```

![Made with Java](https://forthebadge.com/images/badges/made-with-java.svg)
![GitHub](https://img.shields.io/github/license/Skerwe/Advent-of-Code-2020?style=for-the-badge)

## Advent of Code 2021 Progress

1. Sonar Sweep :star: :star:
2. Dive! :star: :star:
3. Day 3: Binary Diagnostic :star: :star:

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purposes.

### Prerequisites

- You will need Java 1.8 or higher installed and configured on your system PATH.  
  It's best to use the [OpenJDK][openjdk], Windows users can get binaries from [AdoptOpenJDK][adoptopenjdk].
- [Apache Maven 3+][maven]

### Installing and Running

1. Clone the repository:  
    `git clone https://github.com/Skerwe/Advent-of-Code-2021.git`

2. In bash/terminal/command line, cd into the project directory:  
    `cd Advent-of-Code-2021`

3. Compile and build the application:  
   `mvn compile package`

Run the application for all days:

```shell
mvn compile exec:java -Dexec.mainClass="za.web.skerwe.adventofcode2021.Main"
```

Run the application for a specific day:

```shell
mvn compile exec:java -Dexec.mainClass="za.web.skerwe.adventofcode2021.Main" -Dexec.arguments="D01,D03"
```

The final output of the challenge is printed to the console.

## Maven Site and Reports

Access the Maven dashboard site on [localhost:8080](http://localhost:8080/)

```shell
mvn site site:run
```

The site will include all other reports, like the test reports, code coverage and code quality reports.  
But you can run each report separatly:

### 1. Surefire Test Reports

```shell
mvn surefire-report:report
```

Test report output to folder:

`target\site\surefire-reports`

### 2. Javadocs

```shell
mvn javadoc:javadoc
```

Javadocs output folder:

`target\site\apidocs`

### 3. Code Coverage

```shell
mvn jacoco:check
```

### 4. Code Quality

```shell
mvn checkstyle:check
```

```shell
mvn pmd:check
```

## This project was built with

- [Java](https://www.java.com/en/) programming language
- [Maven][maven] build tool
- [JUnit Jupiter][junit] (JUnit 5) testing framework
- [textfac.es](https://textfac.es/) ಠ⌣ಠ

## License

The source code is free -- see the [LICENSE](LICENSE) file for details

[openjdk]: https://openjdk.java.net/
[adoptopenjdk]: https://adoptopenjdk.net/
[maven]: https://maven.apache.org/
[junit]: https://junit.org/junit5/
