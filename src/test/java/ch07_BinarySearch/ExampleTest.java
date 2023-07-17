package ch07_BinarySearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ch07_BinarySearch.BinarySearchExample.BinarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
    @DisplayName("Test BinarySearch")
    @ParameterizedTest
    @MethodSource
    void testBinarySearchExample(int[] arr, int target, int actualResult){
        // Act
        int expectedResult = BinarySearch(arr, target, 0, arr.length-1);
        
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test BinarySearchTree")
    @ParameterizedTest
    @MethodSource
    void testBinarySearchTreeExample(int key, int actualResult){
        // Arrange
        BinarySearchTreeExample.BinarySearchTree<Integer> binarySearchTree = new BinarySearchTreeExample.BinarySearchTree<>();
        binarySearchTree.add(15);
        binarySearchTree.add(5);
        binarySearchTree.add(16);
        binarySearchTree.add(3);
        binarySearchTree.add(12);
        binarySearchTree.add(20);
        binarySearchTree.add(10);
        binarySearchTree.add(13);
        binarySearchTree.add(18);
        binarySearchTree.add(23);
        binarySearchTree.add(6);
        binarySearchTree.add(7);
        // Act
        int exceptedResult = binarySearchTree.delete(key).key;
        // Assert
        assertEquals(exceptedResult, actualResult);
    }

    static Stream<Arguments> testBinarySearchExample(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,10}, 5, 4),
                Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,10}, 1, 0),
                Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,10}, 11, -1));
    }

    static Stream<Arguments> testBinarySearchTreeExample(){
        return Stream.of(
                Arguments.of(13,13),
                Arguments.of(16,16),
                Arguments.of(5,5));
    }
}
