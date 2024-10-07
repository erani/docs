# SOLID
* **S** - ***Single responsability***<br />
"There should never be more than one reason for a class to change."[2] In other words, every class should have only one responsibility.
* **O** - ***Open/Closed principle***<br />
"Software entities ... should be open for extension, but closed for modification."
* **L** - ***Liskov substitution principle***<br />
"Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it."
* **I** - ***Interface segregation principle***<br />
"Clients should not be forced to depend upon interfaces that they do not use."

# ACID
* **A** - ***Atomicity***<br />
Atomicity guarantees that each transaction is treated as a single "unit", which either succeeds completely or fails completely
* **C** - ***Concistency***<br />
Consistency ensures that a transaction can only bring the database from one consistent state to another, preserving database invariants
* **I** - ***Isolation***<br />
Isolation ensures that concurrent execution of transactions leaves the database in the same state that would have been obtained if the transactions were executed sequentially.
* **D** - ***Durability***<br />
Durability guarantees that once a transaction has been committed, it will remain committed even in the case of a system failure (e.g., power outage or crash)

# Database Isolation Levels
* **READ UNCOMMITTED**
    * The weakest level of isolation in a database
    * No shared locks are issued and no exclusive locks are honored
    * Allows dirty reads, i.e., where a transaction may see uncommitted changes made by some other transaction.
    * The one and only time it ever makes sense is when you are reading data that will never be modified in any way.

* **READ COMMITTED**
    * The weakest isolation level implemented by most databases. It is the default isolation level in most Postgres databases, and older SQL databases in general.
    * Restricts the reader from seeing any intermediate, uncommitted, ‘dirty’ read during a transaction and guarantees that any data read was committed at the moment it was read.

* **REPEATABLE READ**
    * This isolation level ensures that if a row is read twice in the same transaction, it will return the same value each time, preventing the nonrepeatable read anomaly mentioned above. 

* **SERIALIZABLE**
    * The highest level of isolation
    * Transactions are completely isolated from each other, effectively serializing access to the database to prevent dirty reads, non-repeatable reads, and phantom reads.
    * Isolation is absolutely necessary when a transaction executes several successive commands that all must see identical views of the database