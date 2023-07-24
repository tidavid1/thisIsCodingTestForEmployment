package ch05_DFSBFS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ch05_DFSBFS.BFSExample.BFS;
import static ch05_DFSBFS.DFSExample.DFS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch05_DFS/BFS Examples")
public class ExampleTest {
    int[][] graph;
    boolean[] visited;

    @BeforeEach
    void setup(){
        graph = new int[][]{{1,2},{0,3,4},{0,5,6},{1,7},{1,7},{2,7},{2,7},{3,4,5,6}};
        visited = new boolean[graph.length];
    }

    @DisplayName("DFS Example")
    @Test
    void testDFSExample(){
        // Arrange
        String actualResult = "0-1-3-7-4-5-2-6";

        // Act
        String expectedResult = DFS(graph, 0, visited);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("BFS Example")
    @Test
    void testBFSExample(){
        // Arrange
        String actualResult = "0-1-2-3-4-5-6-7";

        // Act
        String expectedResult = BFS(graph, 0, visited);

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}
