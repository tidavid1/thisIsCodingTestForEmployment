package ch09_ShortestPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch09_Shortest Path Questions")
public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup(){
        solution = new Solution();
    }

    @DisplayName("Test Q1. ")
    @ParameterizedTest
    @MethodSource
    void testQuestion01(int n, int m, int[][] directions, int x, int k, int actualResult){
        // Act
        int expectedResult = solution.question01(n, m, directions, k, x);
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q2. ")
    @ParameterizedTest
    @MethodSource
    void testQuestion02(int n, int m, int c, int[][] directions, int[] actualResult){
        // Act
        int[] expectedResult = solution.question02(n,m,c,directions);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> testQuestion01(){
        return Stream.of(
                Arguments.of(5, 7, new int[][]{{1,2},{1,3},{1,4},{2,4},{3,4},{3,5},{4,5},{4,5}}, 4, 5, 3),
                Arguments.of(4, 2, new int[][]{{1,3},{2,4}}, 3, 4, -1)
        );
    }

    static Stream<Arguments> testQuestion02(){
        return Stream.of(
                Arguments.of(3,2,1,new int[][]{{1,2,4},{1,3,2}}, new int[]{2,4})
        );
    }
}
