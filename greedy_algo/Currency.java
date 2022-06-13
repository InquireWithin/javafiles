package greedy_algo;

/**
 * Enumeration representing common currency denominations.
 */
public enum Currency {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25),
    DOLLAR(1.0);

    /**
     * The value (in dollars) if the denomination.
     */
    private final double value;

    /**
     * Creates a denomination with the specified value.
     * 
     * @param value The value for this denomination.
     */
    private Currency(double value) {
        this.value = value;
    }

    /**
     * returns the value of the denomination.
     * 
     * @return The value of the denomination.
     */
    public double getValue() {
        return value;
    }
}
