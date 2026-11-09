package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }
    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);
        assertTrue(result);
    }

    // ========== isPrime ==========

    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
        assertFalse(CourseToolkit.isPrime(-5));
    }

    @Test
    void isPrimeReturnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void isPrimeReturnsTrueForPrimeNumbers() {
        assertTrue(CourseToolkit.isPrime(3));
        assertTrue(CourseToolkit.isPrime(5));
        assertTrue(CourseToolkit.isPrime(17));
        assertTrue(CourseToolkit.isPrime(97));
    }

    @Test
    void isPrimeReturnsFalseForCompositeNumbers() {
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(9));
        assertFalse(CourseToolkit.isPrime(15));
        assertFalse(CourseToolkit.isPrime(25));
        assertFalse(CourseToolkit.isPrime(49)); // квадрат простого
    }

    // ========== isPalindrome ==========

    @Test
    void isPalindromeReturnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("aba"));
        assertTrue(CourseToolkit.isPalindrome("level"));
        assertTrue(CourseToolkit.isPalindrome("a"));
        assertTrue(CourseToolkit.isPalindrome(""));
    }

    @Test
    void isPalindromeReturnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("abc"));
        assertFalse(CourseToolkit.isPalindrome("hello"));
        assertFalse(CourseToolkit.isPalindrome("Ab a")); // регистр и пробел значимы
    }

    @Test
    void isPalindromeThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    // ========== average ==========

    @Test
    void averageReturnsCorrectValue() {
        int[] values = {1, 2, 3, 4, 5};
        assertEquals(3.0, CourseToolkit.average(values), 1e-9);
    }

    @Test
    void averageWorksWithNegativeNumbers() {
        int[] values = {-2, -4, 6};
        assertEquals(0.0, CourseToolkit.average(values), 1e-9);
    }

    @Test
    void averageThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
    }

    @Test
    void averageThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[0]));
    }

    @Test
    void averageDoesNotModifyInputArray() {
        int[] values = {10, 20, 30};
        int[] copy = values.clone();
        CourseToolkit.average(values);
        assertArrayEquals(copy, values);
    }
// ========== min / max (дополнительная часть) ==========

    @Test
    void minReturnsSmallestValue() {
        int[] values = {5, 2, 9, 1, 7};
        assertEquals(1, CourseToolkit.min(values));
    }

    @Test
    void minWorksWithNegativeNumbers() {
        int[] values = {-3, -10, 0, 4};
        assertEquals(-10, CourseToolkit.min(values));
    }

    @Test
    void minThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(null));
    }

    @Test
    void minThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(new int[0]));
    }

    @Test
    void minDoesNotModifyInputArray() {
        int[] values = {8, 3, 5};
        int[] copy = values.clone();
        CourseToolkit.min(values);
        assertArrayEquals(copy, values);
    }

    @Test
    void maxReturnsLargestValue() {
        int[] values = {5, 2, 9, 1, 7};
        assertEquals(9, CourseToolkit.max(values));
    }

    @Test
    void maxWorksWithNegativeNumbers() {
        int[] values = {-3, -10, 0, 4};
        assertEquals(4, CourseToolkit.max(values));
    }

    @Test
    void maxThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(null));
    }

    @Test
    void maxThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(new int[0]));
    }

    @Test
    void maxDoesNotModifyInputArray() {
        int[] values = {8, 3, 5};
        int[] copy = values.clone();
        CourseToolkit.max(values);
        assertArrayEquals(copy, values);
    }
}
