package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    /**
     * Возвращает true, если число простое.
     * Числа меньше 2 не являются простыми.
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает true, если строка является палиндромом.
     * Регистр и пробелы учитываются.
     * @throws IllegalArgumentException если text == null
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Возвращает среднее арифметическое элементов массива.
     * Исходный массив не изменяется.
     * @throws IllegalArgumentException если values == null или массив пустой
     */
    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
    /**
     * Возвращает минимальный элемент массива.
     * Исходный массив не изменяется.
     * @throws IllegalArgumentException если values == null или массив пустой
     */
    public static int min(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        int minimum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minimum) {
                minimum = values[i];
            }
        }
        return minimum;
    }

    /**
     * Возвращает максимальный элемент массива.
     * Исходный массив не изменяется.
     * @throws IllegalArgumentException если values == null или массив пустой
     */
    public static int max(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        int maximum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maximum) {
                maximum = values[i];
            }
        }
        return maximum;
    }
}