## Instructions

### Starting a Gym

1. Open `Gym.java`. This is where you will define the core logic of your gym system.
2. Declare two instance variables:
   - A private final `int` called `totalGymMembers`.
   - A private `Map<MachineType, Integer>` called `availableMachines`.
3. Add the required import for `Map`.
4. Create a constructor for `Gym` that takes two parameters and initializes the instance variables.

### Opening a Gym

5. Define a public method `openForTheDay()` that returns void.
6. Inside the method, declare a `List<Thread>` called `gymMembersRoutines` without initializing it.
7. Use an `IntStream.rangeClosed()` from 1 to `totalGymMembers` to simulate member IDs.
8. Chain `mapToObj()` to map each ID to a new thread.
9. Use `Collectors.toList()` to collect the resulting threads.
10. Inside the `mapToObj()` lambda:
    - Instantiate a new `Member` using the ID.
    - Return a new `Thread` that wraps a lambda.
    - Inside the thread lambda, use a try-catch block.
    - In the try block, call `performRoutine()` on the member.
    - In the catch block, print the exception.
11. Use `forEach()` and method referencing to start each thread.

### Supervising The Gym Members

12. Create a private method `createSupervisor()` that returns a `Thread` and takes a `List<Thread>`.
13. Inside, define a new `Thread` with a lambda that:
    - Contains a `while(true)` loop.
    - Builds a list of running thread names using a stream:
      - Use `.stream()`
      - Filter with `.isAlive()`
      - Map to `.getName()`
      - Collect to list
    - Print the current thread’s name, number of active members, and list of thread names.
    - Break the loop if the list is empty.
    - Include a try-catch around `Thread.sleep(1000)` to pause between checks.
    - After the loop, print that all threads have completed.
14. Before returning the thread, set its name to `"Gym Staff"`.

### Adding Staff to the Gym

15. In `openForTheDay()`, before starting the member threads:
    - Declare a new `Thread` called `supervisor`.
    - Initialize it using `createSupervisor()` with `gymMembersRoutines`.
    - Start the `supervisor` thread.

### Main Method

16. Define a `main()` method.
17. Instantiate a `Gym` with a name and number of members.
18. Pass in a `HashMap<MachineType, Integer>` for the machines.
19. Add the required import for `HashMap`.
20. Call `openForTheDay()` on your gym instance.
21. Compile with `javac *.java` and run with `java Gym`.

### Additional Challenges

- Implement synchronization mechanisms to manage limited machine availability.
- Prevent multiple members from using the same machine at once.
- Consider using `synchronized` blocks or `ReentrantLock`.
- Implement logic to make members wait if machines are in use.

