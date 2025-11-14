/**
 * Task 5: Counter App Simulation
 * This program simulates the functionality of a counter app with independent
 * counters, showing the use of classes and methods to manage mutable state.
 * Since this must run as a console application, the "buttons" and "text field"
 * UI elements are simulated by function calls and initial setup.
 */

// Class to manage the state and logic for a single independent counter
class Counter(private val name: String, initialValue: Int = 0) {
    // Mutable state property for the current count
    var count: Int = initialValue
        private set // count can only be changed internally by the class methods

    // Method to set the starting value (simulating the text field input)
    fun setStartValue(value: Int) {
        count = value
        println("-> $name starting value set to: $count")
    }

    // Method to increment the counter (simulating the '+' button)
    fun increment() {
        count++
    }

    // Method to decrement the counter (simulating the '-' button)
    fun decrement() {
        count--
    }

    // Method to display the counter state
    fun display() {
        println("[$name] Current Count: $count")
    }
}

fun main() {
    // --- 1. Initialize and Set Starting Values (Simulating Text Field Input) ---

    // Create three independent counters (in a column)
    val counter1 = Counter("Counter 1")
    val counter2 = Counter("Counter 2")
    val counter3 = Counter("Counter 3")

    // Set starting values
    counter1.setStartValue(10) // Simulate user entering 10
    counter2.setStartValue(50) // Simulate user entering 50
    counter3.setStartValue(-5) // Simulate user entering -5

    println("\n--- Initial State ---")
    counter1.display()
    counter2.display()
    counter3.display()
    
    // --- 2. Perform Counting Operations (Simulating Button Clicks) ---

    println("\n--- Performing Actions ---")
    
    // Counter 1: Count Up
    counter1.increment() // + button click
    counter1.increment() // + button click
    println("-> Counter 1: ++")
    
    // Counter 2: Count Down
    counter2.decrement() // - button click
    counter2.decrement() // - button click
    counter2.decrement() // - button click
    println("-> Counter 2: ---")

    // Counter 3: Count Up and Down
    counter3.increment() // + button click
    counter3.increment() // + button click
    counter3.decrement() // - button click
    println("-> Counter 3: ++-")

    // --- 3. Final State Display ---
    
    println("\n--- Final State ---")
    counter1.display()
    counter2.display()
    counter3.display()
}
