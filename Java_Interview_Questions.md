# General principles of software development
Basically here we can put all the question that are not fit to the following categories. By having answers from candidate on questions from this category, we can evaluate his level and filter the set of questions from the following categories.

## Version Control Systems
* What is Version Control System (VCS)?
* Try to describe the workflow of a VCS.
* Explain what are trunk, branches and tags.
* What is merging? And in which case you can get a merging conflict?
* What VCSs do you know/use?
* Try to describe the differences between centralized and distributed VCS (SVN vs GIT)
* How does the SVN stores the files in repository? and how it is doing the GIT?

## Bug/Task tracking systems
* What is Bug/Task tracking system?
* Does a Bug/Task tracking system is useful for a company?
* What Bug/Task tracking systems do you know/use?

## Software testing
* Why the software testing is important?
* What is the unit testing?
* What is mock object? or What is mocking?
* What is integration testing and how it differ from unit testing?
* What is automated testing and why it is important?
* What is continuous integration? Why it is important? What tools do you know?
* What is stress test? What tools do you know for doing it?
* What is monkey testing?
* What is smoke testing?

## Software development methodologies and process
* What kind of software development methodologies do you know?
* Describe the Waterfall methodology.
* Describe the Agile methodology.
* Describe the SCRUM practice.
* What is code review? What you think about? and why it is important?
* What is Test-Driven Development?


# Java Core
This section contains questions which should show the level of knowledge about the Java programming language.

## Basics OOP
* What it is an object?
* What it is an interface?
* What is the difference between the interface and an abstract object? What are advantages and disadvantages of using one or another?
* What kind of access modifiers does Java provide?
* Does Java support multiple inheritance?

## Basics Java
* Does Java is dynamic typed language?
* What is the difference between JRE, JDK and JVM?
* Is a Java compiled language? If so, what is the result of compilation?
* Does a pure Java application require to be compiled for each computer architecture?
* What is the serialization? Where you can apply it?
* What is JavaDoc?
* What is enum? Give an example of usage?
* What is the purpose of equals() and hashCode() methods?
* What is the immutable object? Name an immutable object.
* What is checked and unchecked exception? Name at least one of them for both types.
* What is garbage collection?
* What is volatile keyword?
* What is transient keyword?
* What is varargs parameter?
* What is an inner, local and anonymous class?

## Strings
* Does the String type object is mutable?
* What is the purpose of StringBuffer/StringBuilder? And what is the difference between them?

## Collections
* What are the base Collections API interfaces?
* Does the Map extends Collection interface? Why do(not)?
* What is the main difference between ArrayList and Vector?
* What is the main difference between ArrayList and LinkedList?
* What is a MultiMap?

## Generics
* What is the generics?
* Can you have a generic method in a non-generic class?
* Are Java arrays covariant or invariant?
* What are wildcards in Java's generics mechanism?

## Multithreading
* What it is multithreading?
* What is deadlock?
* What mechanism are used in Java for preventing deadlock?
* What is monitor and mutex?
* Why it is a bad practice to use the synchronize key everywhere?
* What are the ways of creating a thread? From JDK 5 what is the preferable mechanism?
* How you can write a thread safe singleton? Explain.

# Analysis and Design
Candidate will be asked about the basics principles of  software analysis and design.

## Basics
* What is UML? Give example of some diagrams and describe their purpose.

## Design patterns
* What is design pattern? Name a few.
* Can you describe one creational design pattern? [AbstractFactory, Builder, Factory Method, Prototype, Singleton]
* Can you describe one structural design pattern? [Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy]
* Can you describe one behavioral design pattern? [Chain of resp., Command, Interpreter, Iterator, 
* Mediator, Memento, Observer, State, Strategy, Template Method]
* What is an architectural design pattern?
* What is MVC pattern? Do you heard about MVP and MVCS?

## ???
* What is a fluent interface?
* What is a marker interface?
* What is a defensive copy?
* What is lazy initialization?
* What is loose coupling?
* What is Dependency Injection and describe methods of implementation.

# Databases and data types
So the section will address question related to databases and a few questions to two types of data widely used.

## Database basics
* What is a relational database?
* What is noSQL database?
* What is a LDAP (graph) database?
* What is a database index?
* How an index influence on read/write operations? Why not indexing all columns?
* What is a foreign key?
* How to sort a result of a query?
* What is purpose of GROUP BY?
* What is a JOIN? Enumerate and describe types of JOIN.
* What is a UNION?
* Enumerate table relationship types and describe them.
* What is a database trigger?
* What is a database view?

## Database transactions
* What is a transaction? Describe a workflow.
* What are ACID properties of database transaction?
* What is transaction isolation?

## Data types
* What it is a XML document and describe the structure.
* How a XML document can be validated?
* What it is a JSON?

# Enterprise development and enterprise frameworks
A lot of questions about technologies used in many companies.

## Spring framework
* What is a Spring bean? How do you declare one with XML and with annotations?
* What is ApplicationContext (BeanFactory)?
* What is scoping? What are the default scopes provided by Spring?
* What is autowiring? How does it work?
* Do you know some other SpringSource projects like Spring Integration, Spring Security, Spring 
* Data or others?
* What are the default stereotype annotations provided by Spring?
* What is Spring Expression Language?
* Can you have a working Spring application completely without XML?
* Do you know Spring MVC? If yes, can you define Dispatcher Servlet, Controller and 
* RequestMapping?
* What is @Transactional annotation? How is it used?
* What is HttpInvoker and when it should be favored over standard XML/JSON approach?
* What is an aspect? Can you tell some good use cases for aspects?
* What are the differences between advice, join points, pointcuts and aspects?

## Java EE
* What Java EE 6 compliant application servers do you know?
* What is Facelet? 
* What is Expression Language?
* What is EJB?
* What is JPA? How does it relate to Hibernate?
* What is Entity Manager?
* What is JMS?
* How has EJB specification had improved as of version 3 or newer?
* What kind of EJBs do you know?
* Can you describe lifecycle of a stateful EJB?
* What is CDI? How does it relate to JSR-330 (Dependency Injection spec.)?
* In JMS, what is the difference between a Queue and a Topic?
* What is a passivation? What kinds of EJBs can be passivated?
* Why have Facelets replaced JSPs as default view technology in JSF?

## Hibernate
* What is an ORM? When is it useful?
* What are the advantages of annotation mappings over XML and vice-versa?
* What are the differences between HQL and Criteria API?
* What is the identity of a table in relational database? What is identity of an object in Java? How 
* does Hibernate solve this mismatch?
* What strategies do you know for mapping class inheritance?
* In relational database tables have foreign keys. In Java, objects have references. How does Hibernate solve this mismatch?
* Can you explain the problem of N+1 selects? What approaches does Hibernate offer to solve such a 
* problem?
* What is optimistic locking? What mechanism is Hibernate using for handling optimistic locking?

## Systems integration
* What kind of technologies can you name for implementing a communication between two software systems?
* What are the advantages of Web Services? What is SOAP?
* Is XML a good format for data transfer? Why?
* Is JSON a good format for data transfer? Why?
* What are the core principles of REST and how does it differ from standard RPC-style mechanisms?
* What is RMI?

## Web development
How do you deploy a Java web application to a servlet container / application server?
* What is the difference between a web container and a fully Java-EE compliable application server?
* What is a Servlet?
* What is AJAX? Why is it so popular?
* What is your favorite Web framework and why?
* Can you describe lifecycle of Servlet?
* What is the relationship between JSP and Servlet?
* What is a Filter component from the Servlet specification?
* Can you name some mechanisms of keeping state in web application?
* What is the difference between GET and POST? What other HTTP verbs can you name? Which are?
* HTML5-only compliant?
* Your application returns 404 error code. What does it mean? How would you fix it?
* What is COMET?
* Can you name some common security issues that web applications have?
* What mechanisms can Java web applications utilize for managing security?

## Build tools
* Why don't we build Java applications just from an IDE with default make tool?
* What is Maven? What simplifications does it introduce over Ant?
* Where does Maven put compilation results?
* What is a Maven repository?
* What are the default lifecycle phases of Maven build?
* How can you use Maven for dependency management?
* What is a build profile? Why would you need more than one build profile?

# Personal development and self training
The scope of questions under this category is to know if candidate is also involved in some extra work activities which can increase his professionalism and knowledge.

* Are you working on some personal project, whatever is commercial or done just for fun?
* Are you working on some open source project or were working in past?
* About what was your bachelor/master thesis? Describe mostly the technical part.
* What was your last technical book that you read?
* What book you most liked and with pleasure will re-read?
* Recommend some book
* Are you following some IT social groups, blogs, etc?