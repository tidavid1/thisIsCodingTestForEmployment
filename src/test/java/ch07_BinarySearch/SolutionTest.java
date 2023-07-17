package ch07_BinarySearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource
    void testQuestion02(int m, int[] arr, int actualResult){
        // Act
        int exceptedResult = solution.question02(m, arr);
        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    static Stream<Arguments> testQuestion02(){
        return Stream.of(
                Arguments.of(6, new int[]{19,15,10,17}, 15));
    }
}
