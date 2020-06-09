# ROCK PAPER SCISSORS 
Models the game of Rock Paper Scissors in OOP Java, in a manner that makes the game extensible and simple to grasp.

# Play a game!

## Requirements
 - JDK12
 - Maven

Get you a jar with 
`./mvnw clean install`
and get busy by running
`java -jar --enable-preview target/rock-paper-scissors-1.0.jar   `
# Design summary 
Kept it super simple, only vanilla Java 12 and good old Junit 4.

- Specific `Game`s should be implementations of a `Game` abstraction. The abstract class should provide room for extensibility. Implementing different game modes or additions should not require a lot of changes in the `Game` class.
- All `Game`s need to be able to bootstrap themselves and keep their own score, as well as some history of what went down and a leaderboard. For now all this is in memory.
- `Player`s are a name and a move producing `Strategy` tied together, along with the option of updating that strategy. Current implementation has no-op in updating, but the scaffolding for that is there.
- `Rule`s, are how a round of a game is judged. How one produces a `Result` and what scores go with what rank.
- `Strategy` is how the next move is produced and optionally a way to sophisticate that even further based on contextual information, like the history of a game.


# Areas of improvement
- Threading
- Logging
- Metrics
- AI
- Security

#Disclaimer
Mocking input for tests and `BoundScanner`s borrow heavily from similar Github implementations of RPS and Stack Overflow.
