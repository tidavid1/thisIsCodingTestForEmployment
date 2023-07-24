package ch08_DP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch08_DP Questions")
public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup(){
        solution = new Solution();
    }

    @DisplayName("Test Q1. ")
    @Test
    void testQuestion01(){
        // Arrange
        int n = 26;
        int actualResult = 3;

        // Act
        int expectedResult = solution.question01(n);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q2. ")
    @Test
    void testQuestion02(){
        // Arrange
        int n = 4;
        int[] arr = {1,3,1,5};
        int actualResult= 8;

        // Act
        int expectedResult = solution.question02(n, arr);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q3. ")
    @Test
    void testQuestion03(){
        // Arrange
        int n = 3;
        int actualResult= 5;

        // Act
        int expectedResult = solution.question03(n);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q4. ")
    @ParameterizedTest
    @MethodSource
    void testQuestion04(int[] arr, int n, int actualResult){
        // Act
        int expectedResult = solution.question04(arr, n);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> testQuestion04(){
        return Stream.of(
                Arguments.of(new int[]{2,3}, 15, 5),
                Arguments.of(new int[]{3,5,7}, 4, -1));
    }
}
