package ch05_DFSBFS;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup(){
        solution = new Solution();
    }

    @DisplayName("Q1.")
    @ParameterizedTest
    @MethodSource
    void testQuestion01(int n, int m, String board, int actualResult){
        // Act
        int expectedResult = solution.question01(n,m,board);

        // Arrange
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Q2.")
    @ParameterizedTest
    @MethodSource
    void testQuestion02(int n, int m, String board, int actualResult){
        // Act
        int expectedResult = solution.question02(n,m,board);

        // Arrange
        assertEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> testQuestion01(){
        return Stream.of(
                Arguments.of(4, 5, "00110\n00011\n11111\n00000", 3),
                Arguments.of(3, 3, "001\n010\n101", 3),
                Arguments.of(15, 14, "00000111100000\n11111101111110\n11011101101110\n11011101100000\n11011111111111\n11011111111100\n11000000011111\n01111111111111\n00000000011111\n01111111111000\n00011111111000\n00000001111000\n11111111110011\n11100011111111\n11100011111111", 8));
    }

    static Stream<Arguments> testQuestion02(){
        return Stream.of(
                Arguments.of(5, 6, "101010\n111111\n000001\n111111\n111111", 10),
                Arguments.of(3, 3, "110\n010\n011", 5)
        );
    }
}
