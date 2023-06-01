package ch11_Greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch11_Greedy Questions")
public class SolutionTest {
    Solution solution;
    @BeforeEach
    void beforeEachTestMethod(){
        solution = new Solution();
    }

    @DisplayName("Q1. input=[2,3,1,2,2], return=2")
    @Test
    void testQuestion01_WhenInputGivenArr_ShouldReturn2(){
        // Arrange
        int[] arr = {2,3,1,2,2};
        int exceptedResult = 2;

        // Act
        int actualResult = solution.question01(arr);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q2. input=\"02984\", return=576")
    @Test
    void testQuestion02_WhenInputGiven02984_ShouldReturn576(){
        // Arrange
        String numbers = "02984";
        int exceptedResult = 576;

        // Act
        int actualResult = solution.question02(numbers);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q2. input=\"567\", return=210")
    @Test
    void testQuestion02_WhenInputGiven567_ShouldReturn210(){
        // Arrange
        String numbers = "567";
        int exceptedResult = 210;

        // Act
        int actualResult = solution.question02(numbers);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q3. input=\"0001100\", return=1")
    @Test
    void testQuestion03_WhenInputGiven0001100_ShouldReturn1(){
        // Arrange
        String s = "0001100";
        int exceptedResult = 1;

        // Act
        int actualResult = solution.question03(s);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q4. input={3,2,1,1,9}, return=8")
    @Test
    void testQuestion04_WhenInputGivenArr_ShouldReturn8(){
        // Arrange
        int[] coins = {3,2,1,1,9};
        int n = coins.length;
        int exceptedResult = 8;

        // Act
        int actualResult = solution.question04(n, coins);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q4. input={3,5,7}, return=1")
    @Test
    void testQuestion04_WhenInputGivenArr_ShouldReturn1(){
        // Arrange
        int[] coins = {3,5,7};
        int n = coins.length;
        int exceptedResult = 1;

        // Act
        int actualResult = solution.question04(n, coins);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q5. input={1,3,2,3,2}, return=8")
    @Test
    void testQuestion05_WhenInputGivenArr_ShouldReturn8(){
        // Arrange
        int[] balls = {1,3,2,3,2};
        int n = balls.length;
        int m = 3;
        int exceptedResult = 8;

        // Act
        int actualResult = solution.question05(n,m,balls);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q5. input={1,5,4,3,2,4,5,2}, return=25")
    @Test
    void testQuestion05_WhenInputGivenArr_ShouldReturn25(){
        // Arrange
        int[] balls = {1,5,4,3,2,4,5,2};
        int n = balls.length;
        int m = 5;
        int exceptedResult = 25;

        // Act
        int actualResult = solution.question05(n,m,balls);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    @DisplayName("Q6. input={3,1,2}, 5, return =1")
    @Test
    void testQuestion06_WhenInputGivenArr5_ShouldReturn1(){
        // Arrange
        int[] food_times = {3,1,2};
        long k = 5;
        int exceptedResult = 1;

        // Act
        int actualResult = solution.question06(food_times, k);

        // Assert
        assertEquals(exceptedResult, actualResult);
    }
}
