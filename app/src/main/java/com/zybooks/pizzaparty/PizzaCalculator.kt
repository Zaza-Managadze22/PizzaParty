package com.zybooks.pizzaparty

import kotlin.math.ceil

// Constant representing the number of slices per pizza
const val SLICES_PER_PIZZA = 8

/**
 * A class that calculates the number of pizzas needed for a pizza party based on the party size and hunger level.
 *
 * @property partySize The size of the party, representing the number of people.
 * @property hungerLevel The hunger level of the party, influencing the number of slices each person consumes.
 */
class PizzaCalculator(partySize: Int, private var hungerLevel: HungerLevel) {
    // Ensuring that partySize is non-negative
    private var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    /**
     * Enumeration representing different hunger levels with corresponding number of slices each person consumes.
     *
     * @property numSlices Number of slices each person consumes based on the hunger level.
     */
    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    /**
     * Calculates the total number of pizzas needed for the party based on party size and hunger level.
     *
     * @return The total number of pizzas required for the party.
     */
    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    //  Initializes the PizzaCalculator with the given party size.
    init {
        this.partySize = partySize
    }
}