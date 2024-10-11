# Test configuration with Context Runner

## Enable `application.yml` in test
Adding initilizer `ConfigDataApplicationContextInitializer` will make properties from `application.yml` available in context.
```java
ApplicationContextRunner contextRunner = new ApplicationContextRunner()
    .withInitilizer(new ConfigDataApplicationContextInitializer())
    ///....
```