package ch10_GrpahTheory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch10_Graph Theory Questions")
public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup(){
        solution = new Solution();
    }

    @DisplayName("Test Q1.")
    @ParameterizedTest
    @MethodSource
    void testQuestion01(int n, int m, int[][] calculations, String actualResult){
        // Act
        String expectedResult = solution.question01(n,m,calculations);
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q2. ")
    @ParameterizedTest
    @MethodSource
    void testQuestion02(int n, int m, int[][] information, int actualResult){
        // Act
        int expectedResult = solution.question02(n,m,information);
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Q3. ")
    @ParameterizedTest
    @MethodSource
    void testQuestion03(int n, int[][] classes, int[] actualResult){
        // Act
        int[] expectedResult = solution.question03(n, classes);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> testQuestion01(){
        return Stream.of(
                Arguments.of(7, 8, new int[][]{{0,1,3},{1,1,7},{0,7,6},{1,7,1},{0,3,7},{0,4,2},{0,1,1},{1,1,1}}, "NO\nNO\nYES\n")
        );
    }

    static Stream<Arguments> testQuestion02(){
        return Stream.of(
                Arguments.of(
                        7,12,new int[][]{{1,2,3},{1,3,2},{3,2,1},{2,5,2},{3,4,4},{7,3,6},{5,1,5},{1,6,2},{6,4,1},{6,5,3},{4,5,3},{6,7,4}},8
                )
        );
    }

    static Stream<Arguments> testQuestion03(){
        return Stream.of(
                Arguments.of(
                        5, new int[][]{{10}, {10, 1}, {4,1}, {4,3,1}, {3,3}}, new int[]{10, 20, 14, 18, 17}
                )
        );
    }
}