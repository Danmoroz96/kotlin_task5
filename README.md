# kotlin_task5
This Kotlin program simulates the core logic and state management required for a multi-counter application, implemented as a console program due to platform constraints.
Program Description

The program demonstrates the principles of independent state and object-oriented programming in Kotlin by managing three separate counters:

Counter Class: A class is defined to encapsulate the state (count) and behavior (increment, decrement, setStartValue) of a single counter.

Initialization: Three instances of the Counter class are created, simulating three independent UI components displayed in a column.

Starting Value Input: The setStartValue method simulates the user input field, setting a distinct initial value for each counter.

Counting: A sequence of actions (increment and decrement) are performed on the independent objects, demonstrating that changing one counter does not affect the others.

Output: The state of all three counters is displayed after initialization and after the actions are performed.
