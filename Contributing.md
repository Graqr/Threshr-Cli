---
Title: Contributing
Author: Jonathan Zollinger
Date: January 16 2024
Comment: It's expected that these instructions are edited with each repo, namely 
  - prerequisites
  - any mention of threshr
  - variations from maven 3.8.6, graal, or java  version 17.0.8
---

# Contributing

By participating in this project, you agree to abide our
[code of conduct](CODE_OF_CONDUCT.md).

## Set up your machine

[//]: # (TODO: remnove azul, add blurb on windows config for Graal )
`threshr` is written in [Java] using
Oracle's [GraalVM] and uses [Maven] as its build tool

Prerequisites:

- [Java 17.0.8]
- [Maven 3.8.6]

Other things you might need to run the tests:

- [Docker]

[//]: # (TODO: add docker configuration)

Create your own fork of `threshr`, then clone your fork anywhere:

```shell
git clone git@github.com:Graqr/Threshr.git
```

`cd` into the directory and install the dependencies:

```shell
mvn clean compile
```

## Branch off of main

It's a good practice not to put your changes in the main branch. Branch naming conventions aren't enforced, but I
personally like naming my branches with a `tag`/`task` convention. See [Create a commit].

See our [style guide] for supported coding practices.
## Test your change

Adequate acceptance testing is to be included with pull requests for new code. See
our [style guide] for our testing standards.

```sh
mvn clean test
```

## Validate `threshr` builds

```sh
mvn clean install
```


## Create a commit

Commit messages should be well formatted and conform to [Conventional Commits].

## Submit a pull request

Push your branch to your `threshr` fork and open a pull request against the original `threshr` main branch.

[Java]:https://www.oracle.com/java/technologies/java-se-glance.html
[Maven]:https://maven.apache.org/what-is-maven.html
[GraalVM]:https://github.com/oracle/graal
[java 17.0.8]:https://sdkman.io/jdks#graalvm
[maven 3.8.6]:https://maven.apache.org/install.html
[Docker]:https://www.docker.com/
[Convertional Commits]:https://www.conventionalcommits.org
[Create a commit]:#create-a-commit
[style guide]:https://github.com/Graqr#general-styling-guide