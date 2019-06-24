[TOC]



# Java Building Blocks

## Java Class Structure

### Classes vs Files

Multiple classes are allowed to be defined in one file, but only one of the is allowed to be declared as `public.`

```java
class Fruit {
    
}

public class Apple extends Fruit {
    
}

// Following class definition not allowed to be public
public class Pear extends Fruit {
    
}
```

> It is recommended only one class to be defined per file