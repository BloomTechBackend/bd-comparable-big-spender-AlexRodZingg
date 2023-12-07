package com.amazon.ata.comparable_comparator_sort.bigspender.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer nedflixCustomer;
    private LocalDate nedflixJoinDate;
    private LocalDate laterJoinDate;
    private LocalDate earlierJoinDate;

    @BeforeEach
    void setUp() throws Exception {
        nedflixJoinDate = LocalDate.of(2008, 10, 11);
        laterJoinDate = LocalDate.of(2009, 1, 1);
        earlierJoinDate = LocalDate.of(2007, 1, 11);
        nedflixCustomer = new Customer("nedflix", nedflixJoinDate);
    }

    // PARTICIPANTS: add implementations to these tests of compareTo:

    @Test
    void compareTo_withAnEqualCustomer_returnsZero() {
        // GIVEN
        Customer equalCustomer = new Customer("nedflix", nedflixJoinDate);

        // WHEN
        int result = nedflixCustomer.compareTo(equalCustomer);

        // THEN
        assertEquals(0, result, "Expected compareTo to return 0 for equal customer");
    }

    @Test
    void compareTo_withLaterCustomerName_returnsNegative() {
        // GIVEN
        Customer customerWithLaterName = new Customer("tedflix", nedflixJoinDate);

        // WHEN
        int result = nedflixCustomer.compareTo(customerWithLaterName);

        // THEN
        assertTrue(result < 0, "Expected compareTo to return negative for customer with later name.");
    }

    @Test
    void compareTo_withEarlierCustomerName_returnsPositive() {
        // GIVEN
        Customer earlierCustomer = new Customer("aedflix", nedflixJoinDate);

        // WHEN
        int result = nedflixCustomer.compareTo(earlierCustomer);

        // THEN
        assertTrue(result > 0, "Expected positive return.");
    }

    @Test
    void compareTo_withSameCustomerNameLaterJoinDate_returnsNegative() {
        // GIVEN
        Customer sameNameLaterJoin = new Customer("nedflix", laterJoinDate);

        // WHEN
        int result = nedflixCustomer.compareTo(sameNameLaterJoin);

        // THEN
        assertTrue(result < 0, "Expected compareTo to return negative for customer with same name but later join date.");
    }

    @Test
    void compareTo_withSameCustomerNameEarlierJoinDate_returnsPositive() {
        // GIVEN
        Customer sameNameEarlierJoinDate = new Customer("nedflix", earlierJoinDate);

        // WHEN
        int result = nedflixCustomer.compareTo(sameNameEarlierJoinDate);

        // THEN
        assertTrue(result > 0,
                "Expected compareTo to return positive for same name but earlier join date.");
    }

    // PARTICIPANTS: leave these tests below alone

    @Test
    void equals_inputObjectNull_returnsFalse() throws Exception {
        // WHEN
        boolean result = nedflixCustomer.equals(null);

        // THEN
        assertFalse(result, "Customer should not be equal to null!");
    }

    @Test
    void equals_inputObjectDifferentType_returnsFalse() {
        // WHEN
        boolean result = nedflixCustomer.equals("nedflix");

        // THEN
        assertFalse(result, "Customer should not be equal to a different type!");
    }

    @Test
    void equals_sameObject_returnsTrue() {
        // WHEN
        boolean result = nedflixCustomer.equals(nedflixCustomer);

        // THEN
        assertTrue(result, "Customer should be equal to a itself!");
    }

    @Test
    void equals_equalAttributes_returnsTrue() throws Exception {
        // GIVEN
        Customer same = new Customer("nedflix", nedflixJoinDate);

        // WHEN
        boolean result = nedflixCustomer.equals(same);

        // THEN
        assertTrue(result, "Customer should be equal to one with same attributes!");
    }

    @Test
    void equals_notEqualName_returnsFalse() {
        // GIVEN
        Customer other = new Customer("reddthem", nedflixJoinDate);

        // WHEN
        boolean result = nedflixCustomer.equals(other);

        // THEN
        assertFalse(result, "Customer should not be equal to one with a different name!");
    }

    @Test
    void equals_notEqualDate_returnsFalse() {
        // GIVEN
        Customer other = new Customer("nedflix", laterJoinDate);

        // WHEN
        boolean result = nedflixCustomer.equals(other);

        // THEN
        assertFalse(result, "Customer should not be equal to one with a different join date!");
    }
}