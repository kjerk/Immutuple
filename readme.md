# Immutuple

A simple tuples/util library for immutable, type safe tuples, that tries to avoid some common pitfalls and annoyances of similar libraries.

## tl;dr Usage

#### Simple Instantiation
```java
final Tuple3<String, String, String> fullNameTuple1 = Tuples.of("John", "Missing", "Doe");
final Tuple3<String, String, String> fullNameTuple2 = Tuples.of("Jane", "Absent",  "Doe"); 
```
#### Grouping / Streaming
```java
@Data
public class Person {
    public final String PersonId;
    public final String Name;
}
@Data
public class PersonTransaction {
    public final String Id;
    public final Double TransactionAmount;
}

final List<Person> persons = getPersons();
		
final List<Tuple3<Person, List<PersonTransaction>, Double>> personFinances = persons.stream()
    .map(p -> Tuples.of(p, getPersonTransactions(p.PersonId))) // Group together person object and list of transactions.
    .map(pt -> Tuples.of(pt.Item1, pt.Item2, pt.Item2.stream().mapToDouble(v -> v.TransactionAmount).sum())) // Group on sum of transactions.
    .collect(Collectors.toList());

for(Tuple3<Person, List<PersonTransaction>, Double> personFinance : personFinances) {
    System.out.println(personFinance.Item1); // Person Object
    System.out.println(personFinance.Item2); // List of person's transactions.
    System.out.println(personFinance.Item3); // Precalculated sum of transactions.
}
```
#### Conversion
```java
final Tuple2<String, String> pair = Tuples.of("Mike", "Jones");
final Map<String, Object> pairMap = pair.toMap(); // Unless named, keys become Arity indices.
System.out.println(pairMap.get("First")); // Mike
System.out.println(pairMap.get("Second")); // Jones
```

## Goals
* Immutability: Friendly for working in threaded or stream environments by default.
* No dependencies. (except in addon modules where required IE: Jackson)
* Terse: Immutability means tuple fields can be public. Getters exist but are therefor optional.
* Java 8+ streams and lambdas as first class citizens.
* Predictable names: Centralized static utils.

### Why Another Tuples Library?
There are several other small (and not so small) tuple libraries for the JVM, but they're solving the problem in a less than optimum way (to our tastes). So the attmpt here is to avoid the following

* [Having](http://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-stream-tuple/1.0.0.M4) [Any](http://mvnrepository.com/artifact/com.aol.cyclops/cyclops-tuples/7.2.4) [Dependencies](http://mvnrepository.com/artifact/org.springframework/spring-tuple/1.0.0.RELEASE)
* [Obtuse](http://www.javatuples.org/) or [unpredictable names](https://github.com/mediascience/java-tuple/blob/master/src/main/java/com/msiops/footing/tuple/Triplet.java#L23-L29)
* [Difficult maintenance](https://github.com/mediascience/java-tuple/blob/master/src/main/java/com/msiops/footing/tuple/Triplet.java#L38-L60). Lombok is used to keep code short.
* Being [tied to](http://mvnrepository.com/artifact/org.rapidoid/rapidoid-tuple/4.3.0) an outer project's version march. (And being deprecated) 
* Being [too large](http://mvnrepository.com/artifact/com.speedment.common/tuple/1.0.4) for the provided functionality.
* [Necessitating getters](https://github.com/speedment/speedment/blob/master/common-parent/tuple/src/main/java/com/speedment/common/tuple/Tuple7.java#L35-L49) for what should be immutable objects.
* Not being [Java first](https://github.com/ztellman/clj-tuple).

### Todo
* Add Java 9 module info files to ensure intended compatibility and restrictions.
* Finish Jackson and Gson custom serializer/deserializers for named tuples.

<!--
## Installation
TODO: Describe the installation process

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## History
TODO: Write history

## Credits
TODO: Write credits

-->

## License

See [LICENSE.md](LICENSE.md)
Licensed under [WTFNMFPLv3](https://dittodhole.github.io/licensing/2016/01/08/introducing-wtfnmfplv3/)
