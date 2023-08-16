package ch10_GrpahTheory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Ch10_Graph Theory Examples")
class ExampleTest {

    @DisplayName("Test Union Example")
    @Test
    void testUnionExample(){
        // Arrange
        int[] expectedResult = new int[]{0,1,1,1,1,5,5};
        int node = 6;
        int edge = 4;
        int[][] unions = new int[][]{{1,4},{2,3},{2,4},{5,6}};
        // Act
        int[] actualResult = UnionExample.unionExample(node, edge, unions);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Kruskal Example")
    @Test
    void testKruskalExample(){
        // Arrange
        int expectedResult = 11;
        Graph graph = new Graph();
        Graph.setup(graph);
        // Act
        int actualResult = KruskalExample.kruskalExample(graph);
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Prim Example")
    @Test
    void testPrimExample(){
        // Arrange
        int expectedResult  = 11;
        String startNode = "c";
        Graph graph = new Graph();
        Graph.setup(graph);
        // Act
        int actualResult = PrimExample.primExample(graph, startNode);
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Topology Example")
    @Test
    void testTopologyExample(){
        // Arrange
        int[] expectedResult = {1,2,5,3,6,4,7};
        TopologyExample.Graph graph = new TopologyExample.Graph();
        TopologyExample.setup(graph);
        // Act
        int[] actualResult = TopologyExample.topologySort(graph);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }
}