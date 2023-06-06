package ch04_Implementation;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SolutionTest {
    Solution solution;
    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @DisplayName("Q1. n=5, moves='R R R U D D'")
    @ParameterizedTest
    @CsvSource({"5, 'R R R U D D', '3 4'"})
    void testQuestion01(int n, String moves, String exceptedResult){
        // Act
        String actualResult = solution.question01(n, moves);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q2. n=5")
    @ParameterizedTest
    @CsvSource({"5, 11475"})
    void testQuestion02(int n, int exceptedResult){
        // Act
        int actualResult = solution.question02(n);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q3. pos='a1'")
    @Test
    void testQuestion03(){
        // Arrange
        String pos = "a1";
        int exceptedResult = 2;
        // Act
        int actualResult = solution.question03(pos);
        // Assert
        assertEquals(exceptedResult, actualResult
        );
    }

    @DisplayName("Q4")
    @Test
    void testQuestion04(){
        // Arrange
        String size = "4 4";
        int[] player = {1,1,0};
        int[][] map = {{1,1,1,1}, {1,0,0,1}, {1,1,0,1}, {1,1,1,1}};
        int exceptedResult = 3;
        // Act
        int actualResult = solution.question04(size, player, map);
        // Assert
        assertEquals(exceptedResult, actualResult);
    }
}
