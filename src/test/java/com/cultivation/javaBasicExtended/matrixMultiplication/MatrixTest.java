package com.cultivation.javaBasicExtended.matrixMultiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void should_throws_if_matrix_array_is_null() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Matrix(null));
        assertEquals("Raw matrix is null", exception.getMessage());
    }

    @Test
    void should_throws_if_matrix_array_contains_0_rows() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Matrix(new int[0][]));
        assertEquals("Raw matrix contains 0 row", exception.getMessage());
    }

    @Test
    void should_throws_if_matrix_array_contains_null_row() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Matrix(new int[][] {
                new int[3],
                null
            }));
        assertEquals("Raw matrix contains null row", exception.getMessage());
    }

    @Test
    void should_throws_if_matrix_array_contains_0_length_row() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Matrix(new int[][] {
                new int[0],
                new int[0]
            }));
        assertEquals("At least one row of raw matrix contains 0 column", exception.getMessage());
    }

    @Test
    void should_throws_if_matrix_array_is_not_rectangle() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Matrix(new int[][] {
                new int[2],
                new int[1]
            }));
        assertEquals("Raw matrix is not rectangle", exception.getMessage());
    }

    @Test
    void should_throws_if_matrix_is_null() {
        final int[][] rawMatrix = new int[][] {
            new int[2],
            new int[2]
        };

        assertThrows(IllegalArgumentException.class, () -> Matrix.multiply(null, null));
        assertThrows(IllegalArgumentException.class, () -> Matrix.multiply(new Matrix(rawMatrix), null));
        assertThrows(IllegalArgumentException.class, () -> Matrix.multiply(null, new Matrix(rawMatrix)));
    }

    @Test
    void should_throws_if_matrix_dimension_not_correct() {
        int left[][] = { {3,2,3}, {5,9,8} };
        int right[][] = { {4,7}, {9,3}, {8,1}, {1, 1} };

        assertThrows(
            IllegalArgumentException.class,
            () -> Matrix.multiply(new Matrix(left), new Matrix(right)));
    }

    @Test
    void should_clone_1domin() {
        int left[] = {3,2,3};
        int[] clone = left.clone();
        clone[0] = 2;
        assertEquals(3, left[0]);
        assertEquals(2, clone[0]);



        String[] strings = {"H", "W"};
        String[] stringsClone = strings.clone();

        assertNotSame(strings, stringsClone);
        assertSame(strings[0], stringsClone[0]);
    }

    @Test
    void should_clone_matrix() {
        int left[][] = { {3,2,3}, {5,9,8} };

        int[][] clone = left.clone();
        assertNotEquals(clone, left);
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[i].length; j++) {
                assertEquals(left[i][j], clone[i][j]);
            }
            assertSame(left[i], clone[i]);
        }
    }

    @Test
    void should_multiply_matrix() {
        int left[][] = { {3,2,3}, {5,9,8} };
        int right[][] = { {4,7}, {9,3}, {8,1} };

        // 3 2 3   4 7
        // 5 9 8   9 3
        //         8 1

        final int[][] expected = {
            {12 + 18 + 24, 21 + 6 + 3},
            {20 + 81 + 64, 35 + 27 + 8}
        };

        Matrix result = Matrix.multiply(new Matrix(left), new Matrix(right));
        assertEquals(new Matrix(expected), result);
    }
}
