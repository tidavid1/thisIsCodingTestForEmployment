package ch06_Sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static ch06_Sort.BubbleSortExample.BubbleSort;
import static ch06_Sort.CountSortExample.CountSort;
import static ch06_Sort.HeapSortExample.HeapSort;
import static ch06_Sort.InsertionSortExample.InsertionSort;
import static ch06_Sort.QuickSortExample.QuickSort;
import static ch06_Sort.SelectionSortExample.SelectionSort;
import static ch06_Sort.ShellSortExample.ShellSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Test Ch06_Sort Examples")
public class ExampleTest {

    @DisplayName("Test Selection Sort")
    @Test
    void testSelectionSortExample(){
        // Arrange
        int[] arr = {9,6,7,3,5};
        int[] actualResult = {3,5,6,7,9};

        // Act
        int[] expectedResult = SelectionSort(arr);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Insertion Sort")
    @Test
    void testInsertionSortExample(){
        // Arrange
        int[] arr = {8,5,6,2,4};
        int[] actualResult = {2,4,5,6,8};

        // Act
        int[] expectedResult = InsertionSort(arr);

        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Quick Sort")
    @Test
    void testQuickSortExample(){
        // Arrange
        int[] arr = {5,3,8,4,9,1,6,2,7};
        int[] actualResult = {1,2,3,4,5,6,7,8,9};

        // Act
        int[] expectedResult = QuickSort(arr, 0, arr.length-1);

        // Assert
        assertArrayEquals(expectedResult,actualResult);
    }

    @DisplayName("Test Count Sort")
    @Test
    void testCountSortExample(){
        // Arrange
        int[] arr = {0,4,1,3,1,2,4,1};
        int[] actualResult = {0,1,1,1,2,3,4,4};

        // Act
        int[] expectedResult = CountSort(arr);

        assertArrayEquals(expectedResult,actualResult);
    }

    @DisplayName("Test Bubble Sort")
    @Test
    void testBubbleSortExample(){
        // Arrange
        int[] arr = {7,4,5,1,3};
        int[] actualResult = {1,3,4,5,7};

        // Act
        int[] expectedResult = BubbleSort(arr);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Shell Sort")
    @Test
    void testShellSortExample() {
        // Arrange
        int[] arr = {10,8,6,20,4,3,22,1,0,15,16};
        int[] actualResult = {0,1,3,4,6,8,10,15,16,20,22};

        // Act
        int[] expectedResult = ShellSort(arr);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Test Heap Sort")
    @Test
    void testHeapSortExample(){
        // Arrange
        int[] arr = {9,7,6,5,4,3,2,2,1,3,8};
        int[] actualResult = {1,2,2,3,3,4,5,6,7,8,9};

        // Act
        int[] expectedResult = HeapSort(arr);
        // Assert
        assertArrayEquals(expectedResult, actualResult);
    }
}
