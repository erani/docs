
# Java Building Blocks

## Java Classes vs Files

Multiple classes are allowed to be defined in one file, but only one of the is allowed to be declared as `public.`

```java
class Fruit {
    
}

public class Apple extends Fruit {
    
}

// !!! ERROR - Following class definition not allowed to be public
public class Pear extends Fruit {
    
}
```
The file name mast match the name of `public` class and  `.java` as extension.
```java
// File Fruit.java
public class Fruit {
	// ...
}
```
After compilation the resulted file will have the name `Fruit.class`.

**Summary**
* Each file should contain only one class
* The filename must match class name and `.java` extension

## The entry point
A program written in Java has it's entry point in `main()` method.
```java
public static void main(String argc[]) {
	// ...
}
```
A non `public` or non `static` method with name `main()` is not considered entry point.
The arguments of the method are also important, it should be an array of `String` which mean the following declarations are valid:
* `String[] argc`
* `String argc[]`
* `String ... argc`

**Summary**
* The entry point method must be named `main()`
* The method must be `public`
* The method must be `static`
* The method should accept only one argument, an array of `String`

## Packages
Java classes can be (and it is recommended) to be grouped in packages.
In case the class does not have the `package` statement as first line then it is considered to be in `default` package.
```java
public class Apple {
}
```
The above class is defined in `default` package. 

And the following class is placed in `com.foo.fruit` package.

```java
package com.foo.fruit;

public class Pear {
}
```
The package name also represent the directory structure of the project. The above class `Pear` should be placed in `com/foo/fruit` directory relative to you root folder and the class `Apple` should be placed directly in root folder.

### Name convention & rules
Package names are written in all lower case to avoid conflict with the names of classes or interfaces.

Companies use their reversed Internet domain name to begin their package names, for example, `com.fuitcompany.fruit` for a package named mypackage created by a programmer at `com.fuitcompany`.

The allowed naming rule is the same as for variables.
A package can be of any length of unicode letter or digit. It should begin with letter, dollar sign (`$`) or underscore (`_`).

The package `java.lang` is auto imported and do not require explicit declaration.

### Wildcard
Java allow to import all classes from one package with one import statment.

```java
import com.foo.fruits.*;
```

The `import` statment in combination with wildcard can **not** import:
* Child packages
* Methods and Fields
* Cannot be placeholder

```java
import java.util.*.*; // The wildcard can be only at the end
import java.util.*; // The class java.util.file.Files will not be imported
import java.util.file.Files.*; // Methods are not imported
```

### Redundant Imports
If a wildcard is used to import some class(es) then a statment which import concrete class from same package is redundant. 
Same is true for auto imported package `java.lang`.

```java
import java.util.*;
import java.util.Random; // Redundant
import java.lang.String; // Redundant
```

### Naming conflicts
Java will not be able to compile in case two objects with same name are imported. This may happen in cases like:
* Two packages are imported using wildcard which contains a class with same name
```java
import java.util.*; // Contains class Date
import java.sql.*; // Contains class Date
```
* Two classes with same name a explcit imported from different packages
```java
import java.util.Date;
import java.sql.Date;
```

The explicit import take precedence over wildcard import.
```java
import java.sql.Date;
import java.util.*; // The java.util.Date is not imported because above explicit import
```

In case both classes should be used, then Java offer two solutions:
1. Use of fully qualified names
```java
// No imports
public class Fruit {
	private java.util.Date processedDate;
	private java.sql.Date dbSavedDate;
}
```
2. Use wildcard or explicit import and fully qualified name
```java
import java.util.Date; // Or import java.util.*

public class Fruit {
	private Date processedDate;
	private java.sql.Date dbSavedDate;
}
```

## Summary
TODO: Missing the summary of the chapter!

## Objects
### Constructors
An object is created by invoking it's constructor.
If no constructor is defined for object then a **default** one is used.

The constructor looks like a method, but it has two key points:
1. A contructor should have same name as class
2. A constructor definition should not provide return type
```java
class Fruit {
	public Fruit() {
		// Initialization
	}

	public void Fruit() { // !!! Not a constructor, it's a method!
		// Some code
	}
}
```

### Instance Initializer Blocks
An object can be initialized by *Block Initializer*.
The *Block Initializer* is a sequence of code which is enclosed between brackets and is not part of any method.
A class **can have multiple** *Block Initializers*.

```java
class Fruit {
	{
		// Fist initializer
	}

	{
		// Second initializer
	}
}
```

Order of object initialization matter
* Fields and instance initializer blocks are run in the order in which they appear.
* The constructor is executed after all fields and initializer blocks are executed.

```java
public class Fruit {

    Fruit() {
        System.out.println("Constructor execution");
    }

    String color = "Yellow";

    {
        System.out.println("Initializer Block 1");
        System.out.println(color);
        System.out.println(weight); // Cannot access weight property, the initializer block is defined before property
    }

    double weight = 0.2;

    {
        System.out.println("Initializer Block 2");
        System.out.println(color);
        System.out.println(weight);
    }

    public static void main(String[] args) {
        new Fruit();
    }

}
```

The above code with commented line `System.out.println(weight);` will produce:

```terminal
Initializer Block 1
Yellow
Initializer Block 2
Yellow
0.2
Constructor execution
```

### Summary
1. If no constructor is defined, then **default** constructor is used.
2. A constructor should have same name as class and **no** return type.
3. The order of initializer blocks **matter** 
4. The code inside initializer block **cannot** refer to fields declared after the block.
5. The constructor is execute after all iniliazer blocks and fields initialization.

## Primitve Types
Java define eight built-in data types also refered as primitve types:

| Keyword | Type                  |
|:--------|:----------------------|
| boolean | true/false            |
| byte    | 8-bit integer         |
| short   | 16-bit integer        |
| int     | 32-bit integer        |
| long    | 64-bit integer        |
| float   | 32-bit floating point |
| double  | 64-bit floating point |
| char    | 16-bit Unicode        |

When the number is present in the code it is named *literal*. 
By default value defined by literal is of type *int*.
For example:

```java
long max = 3123456789; // Do not compile, the defined value is out of boundary for an int
```
A solution is to specify the type by adding `L` or `l` character which will indicate that is *Long*:
```java
long max = 3123456789L;
```

Java allow to specify numbers in different base.

| Base        | Characters | Prefix   | Example      |
|:------------|:-----------|:---------|:-------------|
| Octal       | 0-7        | 0        | 017          |
| Hexadecimal | 0-9, A-F   | 0X or 0x | 0xFF         |
| Binary      | 0 and 1    | 0b or 0B | 0b11 or 0B11 |

### Underscore in numbers (Java 7 feature)
Starting with Java 7 it is possible to use underscore, `_` in order to simplify the read of numbers, like `1_000`.

The underscore cannot be added:
* At beginning of literal, `_1000.00`.
* At end of literal, `1000.00_`.
* Before and after decimal point, `1000_.00` or `1000._00`.