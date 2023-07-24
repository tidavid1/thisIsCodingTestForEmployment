package ch09_ShortestPath;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ch09_ShortestPath.DijkstraExample.Dijkstra;
import static ch09_ShortestPath.FloydExample.Floyd;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Ch09_Shortest Path Examples")
public class ExampleTest {

    @DisplayName("Test Dijkstra Algorithm")
    @Test
    void testDijkstraExample(){
        // Arrange
        DijkstraExample.Graph graph = new DijkstraExample.Graph();
        DijkstraExample.setup(graph);
        int[] actualResult = {Integer.MAX_VALUE, 0, 2, 3, 1, 2, 4};

        // Act
        int[] exceptedResult = Dijkstra(1, graph);

        // Assert
        assertArrayEquals(exceptedResult, actualResult);
    }

    @DisplayName("Test Floyd Algorithm")
    @Test
    void testFloydExample(){
        // Arrange
        FloydExample.Graph graph = new FloydExample.Graph();
        FloydExample.setup(graph);
        int[][] actualResult = {{0,4,8,6}, {3,0,7,9}, {5,9,0,4}, {7,11,2,0}};

        // Act
        int[][] exceptedResult = Floyd(graph);

        // Assert
        assertArrayEquals(exceptedResult, actualResult);
    }
}
