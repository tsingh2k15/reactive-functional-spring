##  Reactive Spring Boot

There are many projects like RxJava2, Akka streams, Spring WebFlux, Spring Reactive Data, Spring Reactive Web, Spring Reactive Integration etc.. which implement reactive streams specification. All these projects are interoperable as long as they use standard reactive streams types.

This project demonstrates key types of reactive programming with Spring Boot using Kotlin and Java.
In this example, a websocket connection is configured on server using spring managed beans. Once the connection is established via
client(ping.html), messages can then be exchanged in a functional reactive manner.

Types from Reactive Streams Specification:
<LI> Publisher
<LI> Subscriber
<LI> Subscription
<LI> Processor

Types from Reactor:
<LI> Flux
<LI> Mono


### Software Requirements

<LI> IntelliJIDE
<LI> JDK 8
