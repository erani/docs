
# Table of Contents

- [Table of Contents](#table-of-contents)
- [Java Building Blocks](#java-building-blocks)
  * [Java Classes vs Files](#java-classes-vs-files)
  * [The entry point](#the-entry-point)
  * [Packages](#packages)
    + [Name convention & rules](#name-convention---rules)
    + [Wildcard](#wildcard)
    + [Redundant Imports](#redundant-imports)
    + [Naming conflicts](#naming-conflicts)
  * [Summary](#summary)
  * [Objects](#objects)
    + [Constructors](#constructors)
    + [Instance Initializer Blocks](#instance-initializer-blocks)
    + [Summary](#summary-1)
  * [Primitve Types](#primitve-types)
    + [Underscore in numbers (Java 7 feature)](#underscore-in-numbers--java-7-feature-)
    + [Summary](#summary-2)
  * [References](#references)
    + [Key differencies with primitives](#key-differencies-with-primitives)
  * [Declaring and Initializing Variables](#declaring-and-initializing-variables)
    + [Local Variables](#local-variables)
    + [Instance and Class Variables](#instance-and-class-variables)
    + [Summary](#summary-3)
  * [Variable Scope](#variable-scope)
    + [Summary](#summary-4)
  * [Order of elements in class](#order-of-elements-in-class)
  * [Destroying Objects](#destroying-objects)
- [Operators and Statements](#operators-and-statements)
  * [Operators](#operators)
  * [Numeric Promotion Rules](#numeric-promotion-rules)
  * [Operators](#operators-1)
    + [Unary Operators](#unary-operators)
    + [Assignment Operator](#assignment-operator)
    + [Casting Primitive Values](#casting-primitive-values)
      - [Overflow](#overflow)
    + [Compound Assignment Operator](#compound-assignment-operator)
    + [Relational Operators](#relational-operators)
    + [Logical Operators](#logical-operators)
    + [Equality Operators](#equality-operators)
  * [Statements](#statements)
    + [The _if_-_then_ Statement](#the--if---then--statement)
    + [The _if_-_then_-_else_ Statement](#the--if---then---else--statement)
    + [Ternary Operator](#ternary-operator)
    + [The _switch_ Statement](#the--switch--statement)
    + [The _while_ Statement](#the--while--statement)
    + [The _do-while_ Statement](#the--do-while--statement)
    + [The _for_ Statements](#the--for--statements)
      - [The basic _for_ statement](#the-basic--for--statement)
      - [The _for-each_ Statement](#the--for-each--statement)
    + [The _break_ Statement](#the--break--statement)
    + [The _continue_ Statement](#the--continue--statement)
- [Core Java APIs](#core-java-apis)
  * [Creating and Manipulating Strings](#creating-and-manipulating-strings)
    + [Concatenation](#concatenation)
    + [Immutablity](#immutablity)
    + [The String Pool](#the-string-pool)
    + [Important String Methods](#important-string-methods)
      - [_length()_](#-length---)
      - [_charAt()_](#-charat---)
      - [_indexOf()_](#-indexof---)
      - [_substring()_](#-substring---)
      - [_toLowerCase()_ and _toUpperCase()_](#-tolowercase----and--touppercase---)
      - [_equals()_ and _equalsIgnoreCase()_](#-equals----and--equalsignorecase---)
      - [_startsWith()_ and _endsWith()_](#-startswith----and--endswith---)
      - [_contains()_](#-contains---)
      - [_replace()_](#-replace---)
      - [_trim()_](#-trim---)
  * [The `StringBuilder`](#the--stringbuilder-)
    + [Main methods](#main-methods)
      - [`append()`](#-append---)
      - [`insert()`](#-insert---)
      - [`delete()`](#-delete---)
      - [`deleteCharAt()`](#-deletecharat---)
      - [`reverse()`](#-reverse---)
      - [`toString()`](#-tostring---)
  * [Equality](#equality)
    + [Primitives equality](#primitives-equality)
    + [Object equality](#object-equality)
      - [String equality](#string-equality)
  * [Java Arrays](#java-arrays)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>

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
A package can be of any length of unicode letter or digit. 
It can begin with letter, dollar sign (`$`) or underscore (`_`).

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

The number value presented in the code is called *literal*. 
By default number value defined by literal is of type *int*.
For example:

```java
long max = 3123456789; // Does not compile, the defined value is out of boundary for an int
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

### Summary
1. Java have 8 types of primitives.
2. The default value defined by literal is *int*.
3. The literals can be written in few bases, default one being decimal.
4. Starting with Java 7, the underscore can bu used to simplify the read of literal.

## References
A reference point to an object by storing the memory address where the object is located.
* A reference can be assigned to another object of same type.
* A reference can be assigned to a new object using the `new` keyword.

### Key differencies with primitives
* The reference types can be assigned `null` value
* Primitives do not have methods
* All primitives has lowercase names

## Declaring and Initializing Variables
Declaration of variable require the type and name to be stated.
```java
int size;
String name;
```

A variable can be initialized during declaration:
```java
int size = 10;
String name = "John";
```

Multiple variables can be declared and initialized in the same statement:
```java
int size, length = 10;
String firstName, lastName = "Doe";
```
It is not possible to declare multiple variables of different type in one statment:
```java
int size, String name; // Does not compile
```

Multiple statements can be on one line:
```java
int size; String name;
```

The identifier naming shoudl follow following rules:
* The name can begin with a letter, `_` or `$`.
* Subsequent character can be number
* Cannot use reserverd word.
* Java is case sensitive, so there can be two identifiers having different case.

### Local Variables

A local variable is a variable defined within a method. 
Local variables must be initialized before use. 
They do not have a default value and contain garbage data until initialized. 
The compiler will not let you read an uninitialized value.

```java
int y = 10;
int x;
int z = y + x; // Does not compile
```

### Instance and Class Variables
Instance variables are also called *fields*.

Class variables are destinguished by `static` keyword in declaration. All class variables are shared accross multiple objects.

Instance and class variables get default value when they are declared and not initialized. In case of references it assign value `null` and in case of primitives `0`/`false`, for `char` it is `\u000` (NUL).

| Variable Type          | Default Value |
|:-----------------------|:--------------|
| boolean                | false         |
| byte, short, int, long | 0 (zero)      |
| float, double          | 0.0           |
| char                   | \u0000        |
| Object references      | NULL          |

### Summary
1. Multiple variables of same type can be declared and initialized in same statement.
2. Uninitialized local variables cannot be read, compilation will fail
3. Instance and class variables which are not initialized, get default value

## Variable Scope
Local variables can never have a scope larger than the method they are defined in.
However, they can have a smaller scope if it is inclosed in currly brackets.
```java
public void foo() {
	int x;

	{
		int y;
	}

	int z = x + y; // Compilation error, variable y is not accessible
}
```

In case of instance variables, they available as soon as they are defined (Take in consideration initializers blocks) and leaves till the end of the object.

For class variables, the rule same, avaialable as soon as defined and lives till end of the program.

### Summary
1. Local variables - in scope from declaration till end of block.
2. Instance variables - in scope from declaration until object garbage collected.
3. Class variables - in scope from declaration until program ends.

## Order of elements in class
The following table define the rule:

| Element             | Required | Where does it go                       |
|:--------------------|:---------|:---------------------------------------|
| Package declaration | No       | First line in file                     |
| Import statements   | No       | Immediatelly after package declaration |
| Class declaration   | Yes      | Immediatelly after import              |
| Fields declaration  | No       | Anywere inside a class                 |
| Methods declaration | No       | Anywere inside a class                 |
| Comments            | No       | Anywere inside the file                |

## Destroying Objects
An object's memory is eligible for cleaning by GC when one of following condition occur:
* The object no longer has any references pointing to it. 
* All references to the object have gone out of scope. 

Java API provide following API related to GC:
* The system call `System.gc()` which do not guaranty Garbage Collection kick out, but suggest that is best time to do.
* The `Object`'s method `finalize()` which **may** be called during Garbage Collection.
Is it definitily this method will **not** be called twice.

# Operators and Statements

## Operators
Java offer three flavours of operators:
* Unary operator
* Binary operator
* Ternary operator

Order of operator precedence:

| Operator                        | Symbols                                   |
|:--------------------------------|:------------------------------------------|
| Post unary operators            | expression++, expression--                |
| Pre-unary operators             | ++expression, --expression                |
| Other unary operators           | +,-,!                                     |
| Multiplication/Division/Modulus | *,/,%                                     |
| Addition/Subtraction            | +,-                                       |
| Shift operators                 | <<, >>, >>>                               |
| Relational operators            | <,>, <=, >=, instanceof                   |
| Equal to/not equal to           | ==, !=                                    |
| Logical operators               | &, ^, !                                   |
| Short-circuit logical operators | &&, \|\|                                  |
| Ternary operators               | boolean expression ? expr 1 : expr 2      |
| Assignment operators            | =, +=, -=, *=, /=, %=, !=, <<=, >>=, >>>= |

## Numeric Promotion Rules
When an aritmetic operation is executed over two different data types than following rules are applied to promote result to proper data type:
1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
```java
long x = 5L;
int y = 3;
x + y; // The result will be of type long
```
2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point values' data type.
```java
long x = 5;
float y = 4.1f;
x + y; // The reuslt will be of type float
```
3. Smaller data types, namely `byte`, `short` and `char` are to `int` any time when they are used with Java binary arithmetic operator, even if neither of operands is `int`. The rule is not applied for unarry operators.
```java
short x = 5;
short y = 10;
x + y; // The result is promoted to int

x++; // The result remain to be short
```
4. After all promotions have occured and the operands have same data type, the resulting value will have same data type as its promoted operands.

## Operators
### Unary Operators
The unary operation is applied only over one single variable:
```java
int x = 5;
int y = +x; // y will be 5
int z = -x; // z will be -5

boolean v = true;
boolean w = !v; // w will false
````
* Negation operator `+/-` reverse the sign of numeric value
* Boolean negation operator `!` revers boolean value

**Note:** It is not possible to mix negation operators between types.
The `!` operator cannot be applied over numeric value as well as `+/-` operator to boolean value.

### Assignment Operator
The assignment operator is a binary operator which assigns value of right hand side to the left side of equation.
```java
int x = 10;
```

* Java will automatically promote from smaller to larger data types
* In case of assignment of larger value to smaller, Java will throw a compiler exception

### Casting Primitive Values
Casting of primitives is required each time when larger value should be assigned to smaller value or converting from a floating-point number to an integer value.
```java
int x = (int) 1.0;
short y = (short) 1921222;
```

#### Overflow
When the larger value which do not fit into smaller value and it is casted to smaller value is also called **Overflow**;
```java
short y = (short) 1_921_222; // Will be stored as 20_678
```

### Compound Assignment Operator
Compound assignment operator is a join between assignment operator and binary operator.

Following two assignments are equivalent:
```java
x = x * z;
x *= z;
```

* Compound operator can be applied only to variable which was defined
* Cannot be used to declare new variable

Compound operators can simplify the primitive casting:
```java
long x = 10;
int y = 5;
y = y * x; // Does not compile, requires cast to int
y *= x; // Compiles
```

### Relational Operators
Relational operators compares two expressions and return `boolean` value.

The operators `<`, `<=`, `>`and `>=`applies over numeric data types. If the two numeric operands are not of the same data type, the smaller one is promoted to higher one.

Another relational operator is `instanceof` which returns `true` if the reference that point to is an instance of a class, subclass or class that implements a particular interface.

### Logical Operators
The _logical operators_ (`&`, `|`, `ˆ`) may be applied on numeric and boolean  data types.
* When applied on _boolean_ data types, they are refered as _logical operators_
* When applied on _numeric_ data types, they are refered as _bitwise operators_

The _conditional operators_ are `&&` and `||`. The difference between _logical_ and _conditional_ operators is that right-hand side of expression may not be evaluated if the result can be determinated from left-hand side.
```java
boolean x == true || y < 4; // The right-hand side is not evaluated
```

### Equality Operators
The equal operators are: `==` and `!=`.

Equality in Java have semantic difference:
* Two objects are the same
* Two objects are equivalent

The above destinction is not present for numeric and boolean primitves.

The equality operators are used in one of following cases:
1. Comparing two numeric primitive values. The numeric promotion rules is applied incase values are not of the same type.
2. Comparing two boolean values
3. Comparing two objects, including `null` and `String` values.

## Statements

### The _if_-_then_ Statement
The _if_-_then_ statement will execute a block of code in case it's boolean expression evaluates to `true`.
```java
if (booleanExpression) {
	// Execute the code when expression evaluates to true
}
```

### The _if_-_then_-_else_ Statement
The _else_ block of the _if_-_then_-_else_ statement will execute in case the boolean expression do not evaluate to `true`.
```java
if (booleanExpression) {
	// Execute the code when expression evaluates to true
} else {
	// Execute the code when expression evaluates to false
}
```

It is possible to have compound _if_-_then_-_else_ statements:
```java
if (firstBooleanExpression) {
	// Execute the code when first expression evaluates to true
} else if (secondBooleanExpression) {
	// Execute the code when second expression evaluates to true
} else {
	// Execute the code when neigher of above expressions evaluates to true
}
```

### Ternary Operator
The conditional operator `booleanExpression ? expression1 : expression2` is known as _ternary operator_.

The first operand must be a _boolean expression_. The second and thrid can be any expression that return **same** value.

**Note:** from Java 7, only one of the righ-hand expression is evaluated.
```java
int y = 1;
int z = 1;

int x = y < 10 ? y++ : z++; // Only y will be incremented

int x = y > 10 ? y++ : z++; // Only z will be incremented
```

### The _switch_ Statement
The `switch` statement supports following data types:
* Numeric primitive types (`byte`, `short`, `char` and `int`)
* Numeric wrapper types (`Byte`, `Short`, `Character`, `Integer`)
* `Enum`
* `String`

**Note**: The `boolean`, `long` and theirs wrapper classes are not supported by `switch` statement.

The values in each `case` statement must be compile-time constant values of the same data type as the `switch` value. By compile-time mean that variable should be `final`, the value cannot be computed in runtime.

If the `break` statement is not present in the end of `case` block, then flow will continue to the next preceeding `case` or `default` block.

Regardles of position within the `switch`, the `default` block will be executed when there is no matching `case` value.

### The _while_ Statement

The `while` loop may terminate at the first evaluation, which mean that statement block may never execute.

### The _do-while_ Statement

The `do`-`while` guarantee that statement block will execute at least once.

### The _for_ Statements

From Java 5.0 there are two types of `for` statement:
* Basic `for` loop
* Enhanced `for` loop or also known as `foreach` loop

#### The basic _for_ statement
The strucutre of the basic `for` statement is:
```
for (<initialization>; <boolean expression>; <update statement>)
```

The _initialization_ and _update_ sections may contain multiple statements separated by commas.

Variables declared in the initialization block of a `for` loop have limited scope and
are only accessible within the `for` loop. 

It is not possible to rediclare the variable inside the `for` statement, for example:
```java
int x = 0;
for (long y = 0, x = 4; x < 5; x++) { // Does not compile, cannot redicalre x variable
	// Code
}
```

It is not possible to declare different types of variables in initialization block, example:
```java
for (long x = 0, int y = 4; y < 5; y++) // Does not compile
```

#### The _for-each_ Statement
The strucutre of the enhanced `for` statement is:
```
for (datatype instance : <collection>)
```

The right-hand side of the _for-each_ statement should be a built-in Java _array_ or an object which implements `java.lang.Iterable`.

The left-hand side should be an instance of a variable, whose type matche the type of member of the array or Iterable in the right-hand side of the statement.

### The _break_ Statement
The `break` statement transfer the flow of control out of the enclosing statement. The statement can be part of `while`, `do`-`while` and `for` loops.

### The _continue_ Statement
The `continue` statement stops execution of current loop . The statement can be part of `while`, `do`-`while` and `for` loops.

# Core Java APIs
## Creating and Manipulating Strings
A `String` in Java is a sequence of characters counted from `0` when indexed.

The `String` class is a special class which does not require `new` keyword to be initialized:
```java
String name = "Fluffy";
String name = new String("Fluffy");
```
Both statements give a reference to a `String` object, but there is a important difference. The first one uses _string pool_ second no.

### Concatenation
The string concatentenation is performed with a help of operator `+`.
```java
String fullName = "John"+ " " + "Doe"; // Produces "John Doe"
```

The Rules:
* If both operands are numeric, `+` means numeric addition
* If either operand is a `String`, `+` means concatenation
* The expression is evaluated left to right

### Immutablity

Once a String object is created:
* It is not allowed to change 
* It cannot be made larger or smaller
* It is not possible to change one of the characters inside it

### The String Pool
 The string pool, also known as the intern pool, is a location in the Java virtual machine (JVM) that collects all common strings which are declared like literals.

 ```java
String name = "Fluffy"; // Uses String pool
String name = new String("Fluffy"); // Does not use String pool
```

Strings not in the string pool are garbage collected.

### Important String Methods
#### _length()_
Returns the count of characters in `String`.
```java
int length();
```

#### _charAt()_
Return the character located at specified index. The method may throw exception in case the an index out of boundary is provided.
```java
char charAt(int index);
```

#### _indexOf()_
The method will return the index of the first occurence of provided value.
```java
int indexOf(char ch); // Returns index of first occurence of ch
int indexOf(char ch, int fromIndex); // Return index of first occurence of ch after index fromIndex
int indexOf(String str); // Return index of first occurence of provided String
int indexOf(String str, int fromIndex); // Returns index of first occurence of provided String after index fromIndex
```

In case the occurence is not found, the method will return `-1`.

#### _substring()_
A part of the original `String` is returned.
```java
String substring(int beginIndex); // Returns part of String from provided index
String substring(int beginIndex, int endIndex); // Return part of String from provided beginIndex till endIndex (exclusive)
```
The method may throw exception in case boundaries are exceeded or if the `endIndex` is less then `beginIndex`.

**Trick:** The `string.substring(3, 3)` will return empty `String`.

#### _toLowerCase()_ and _toUpperCase()_
Both methods returns new `String` with respective case changed.
```java
"hello".toUpperCase(); // Will produce "HELLO"
"HELLO".toLowerCase(); // Will produce "hello"
```

#### _equals()_ and _equalsIgnoreCase()_
The method will verify the equality of base `String` with provided one.
```java
boolean equals(String str);
boolean equalsIgnoreCase(String str);
```

#### _startsWith()_ and _endsWith()_
The method will return `boolean` value which indicate if `String` starts with provided value, respectivily ends with provided value.
```java
boolean startsWith(String str);
boolean endsWith(String str);
```

#### _contains()_
Verify if provided `String` is part of the base `String`.
```java
boolean contains(String str);
```

#### _replace()_
Return new object of type `String` which has replaced `char`/`CharSequence` with provided `char`/`CharSequence`.
```java
String replace(char oldChar, char newChar);
String replace(CharSequence oldChar, CharSequence newChar);
```

#### _trim()_
The method returns new `String` object without white characters in the beginning and end of the provided `String`.

As white characters are considered `\n`, `\t` and  `\r`.

```java
String trim()
```

## The `StringBuilder`
The `StringBuilder` is mutable class which does not create new object when each time it is modified. 

The class has tow main properties:
* __size__ - which indicate how many characters are added into the builder
* __capacity__ - the number of characters the sequence can currently hold

### Main methods

The methods `charAt()`, `indexOf()`, `length()` and `substring()` works the same as for `String`.

#### `append()`
The method appends provided value to the existing content. The are more then 10 method signatures.
```java
StringBuilder append(String str)
```

#### `insert()`
Adds characters to the `StringBuilder` at the requested index and returns a reference to the current `StringBuilder`.
```java
StringBuilder insert(int pos, String str)
```
Throws `IndexOutOfBoundsException` - if the offset is invalid.

#### `delete()`
Removes characters from the sequence and returns a reference to the current `StringBuilder`.
```java
StringBuilder delete(int start, int end)
```
Throws `StringIndexOutOfBoundsException` - if start is negative, greater than length(), or greater than end.

#### `deleteCharAt()`
Removes character at provided position.
```java
StringBuilder deleteCharAt(int pos)
```
Throws `StringIndexOutOfBoundsException` - if the index is negative or greater than or equal to length().

#### `reverse()`
Reverses the characters in the sequences and returns a reference to the current `StringBuilder`.
```java
StringBuilder reverse()
```

#### `toString()`
Converts the content of `StringBuilder` to `String`.
```java
String toString()
```

## Equality
### Primitives equality
The operator `==` is used to check the primitive values for equality. 
```java
int x = 5;
int y = 5;

System.out.println(x == y); // Prints true
```

### Object equality
In case of objects, the operator `==` would test the reference of the object, not the value of the object. 
```java
Integer x = 5;
Integer y = 5;

System.out.println(x == y); // Prints false
```

The `Object` type defines the method `public boolean equals(Object o)` which is supposed to return `true` in case the
value of objects is equal or not. The inherited object should override the implementation of the method in order to implement
proper test.
```java
Integer x = 5;
Integer y = 5;

System.out.println(x.equals(y)); // Prints true
```

#### String equality
In case of `String` type, the equality by reference differs because of internal String pool. 
For performance reason and memory savings Java will reuse same object from String Pool in case the literal is the same.
```java
String x = "Hello World";
String y = "Hello World";

System.out.println(x == y); // prints true
System.out.println(x.equals(y)); // prints true
```

However, the `new` operator or runtime manipulation which would result in same String value will not reuse the String pool.
```java
String x = "Hello World";
Stirng y = new String("Hello World");
String z = " Hello World ".trim();

System.out.println(x == y); // prints false
System.out.println(x == z); // prints false
System.out.println(y == z); // prints false
```

In above case the method `equals()` can be used.

## Java Arrays

A Java array is a sequence of elements of same base type.

A variable of type array, is declared as:
```java
int[] iArray;
```