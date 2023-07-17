package ch07_BinarySearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup(){
        solution = new Solution();
    }
    @DisplayName("Test Q1. ")
    @Test
    void testQuestion01(){
        // arrange
        int[] arr1 = {8,3,7,9,2};
        int[] arr2 = {5,7,9};
        String actualResult = "no yes yes";
        // Act
        String exceptedResult = solution.question01(arr1, arr2);
        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Test Q2. ")
    @Test
    void testQuestion02(){
        // arrange
        int m = 6;
        int[] arr = {19,15,10,17};
        int actualResult = 15;
        // Act
        int exceptedResult = solution.question02(m, arr);
        // Assert
        assertEquals(exceptedResult, actualResult);
    }
}
