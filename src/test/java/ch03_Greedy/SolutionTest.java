package ch03_Greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch03_Greedy Questions")
public class SolutionTest {
    Solution solution;
    @BeforeEach
    void beforeEachTestMethod(){
        solution = new Solution();
    }

    @DisplayName("Q1. input=1260, return=6")
    @Test
    void testQuestion01_WhenMoneyGiven1260_ShouldReturnSix(){
        // Arrange
        int money = 1260;
        int exceptedResult = 6;

        // Act
        int actualResult = solution.question01(money);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q2. input=5, 8, 3, [2,4,5,4,6], return 46")
    @Test
    void testQuestion02_WhenNis5Mis8Kis3Arr24546_ShouldReturn46(){
        // Arrange
        int n = 5;
        int m = 8;
        int k = 3;
        int[] arr = new int[]{2,4,5,4,6};
        int exceptedResult = 46;

        // Act
        int actualResult = solution.question02(n,m,k,arr);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q3. input n=3, m=3, [[3,1,2],[4,1,4],[2,2,2]] return 2")
    @Test
    void testQuestion03_When3x3arrayGiven_ShouldReturn2(){
        // Arrange
        int n = 3;
        int m = 3;
        int[][] arr = new int[][]{{3,1,2},{4,1,4},{2,2,2}};
        int exceptedResult = 2;

        // Act
        int actualResult = solution.question03(n,m,arr);

        // Assert
        assertEquals(exceptedResult,actualResult);
    }

    @DisplayName("Q3. input n=2, m=4, [[7,3,1,8],[3,3,3,4]] return 3")
    @Test
    void testQuestion03_When2x4arrayGiven_ShouldReturn2(){
        // Arrange
        int n = 2;
        int m = 4;
        int[][] arr = new int[][]{{7,3,1,8},{3,3,3,4}};
        int exceptedResult = 3;

        // Act
        int actualResult = solution.question03(n,m,arr);

        // Assert
        assertEquals(exceptedResult,actualResult);
    }

    @DisplayName("Q4. input n=25, k=5, return 2")
    @Test
    void testQuestion4_WhenNis25Kis5_ShouldReturn2(){
        // Arrange
        int n = 25;
        int k = 5;
        int exceptedResult = 2;

        // Act
        int actualResult = solution.question04(n,k);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q4. input n=25, k=3, return 6")
    @Test
    void testQuestion4_WhenNis25Kis3_ShouldReturn6(){
        // Arrange
        int n = 25;
        int k = 3;
        int exceptedResult = 6;

        // Act
        int actualResult = solution.question04(n,k);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }
}
