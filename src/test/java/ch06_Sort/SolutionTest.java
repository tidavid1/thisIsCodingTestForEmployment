package ch06_Sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup(){
        solution = new Solution();
    }

    @DisplayName("Test Q1.")
    @Test
    void testQuestion01(){
        // Arrange
        String numbers = "15 27 12";
        int[] actualResult = {12,15,27};

        // Act
        int[] expectedResult = solution.question01(3, numbers);

        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q2. ")
    @Test
    void testQuestion02(){
        // Arrange
        String values = "홍길동 95\n이순신 77";
        int n = 2;
        String[] actualResult = {"홍길동", "이순신"};

        // Act
        String[] expectedResult = solution.question02(n, values);

        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q3. ")
    @Test
    void testQuestion03(){
        // Arrange
        int n = 5;
        int k = 3;
        int[] arr1 = {1,2,5,4,3};
        int[] arr2 = {5,5,6,6,5};
        int actualResult = 26;

        // Act
        int expectedResult = solution.question03(n,k,arr1,arr2);

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}
