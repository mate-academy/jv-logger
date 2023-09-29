### Common mistakes

 * Let's remove all TODO comments before submitting solution.
 * Don't forget about empty lines in the end of files.
 * Let's make our log messages informative

Bad example:
```java
    logger.debug("Method login was called");
```
Good example:
```java
    logger.debug("Method login was called. Params: login={}", login);
```
