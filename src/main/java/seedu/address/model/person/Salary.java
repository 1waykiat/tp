package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Salary in the employee book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSalary(String)}
 */
public class Salary {

    public static final String MESSAGE_CONSTRAINTS =
            "Salary should only contain positive integers, and it should not be blank";

    public final int value;

    /**
     * Constructs a {@code Salary}.
     *
     * @param amount A valid salary amount.
     */
    public Salary(String amount) {
        requireNonNull(amount);
        checkArgument(isValidSalary(amount), MESSAGE_CONSTRAINTS);
        this.value = Integer.parseInt(amount);
    }

    /**
     * Returns true if a given numerical string is non-negative.
     */
    public static boolean isValidSalary(String test) {
        try {
            int amount = Integer.parseInt(test);
            return amount >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Salary // instanceof handles nulls
                && value == ((Salary) other).value); // state check
    }

}

