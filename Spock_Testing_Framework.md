# Cons
## Cannot use helper methods to create complex mock objects
```groovy
def 'cannot use helper methods to create complex mocks' {
    def myMock = createComplexMock()
}

def createComplexMock() {
    return Mock(Someclass)
}
```

## Problematic assert of argument in method call
```groovy
def 'problematic assert of argument in method call' {
    def someService = Mock(SomeService)

    // some code

    1 * someService.foo(_ as SomeObject) >> {
        SomeObject obj -> 
            obj.getSomeValue() == 'some value' // This will not work
            assert obj.getSomeValue() == 'some value' // This will work
    }
} 
```
Unfortunatelly Spock test will not fail if `assert` keyword is missing, as result is quite simple to miss such case and get false-positive test.

## Refactoring
This issue is more Groovy related, but even having greate IDE like IntelliJ Idea, quite often it happens if some method is renamed, the Spock test will not be updated and as result tests will start to fail.