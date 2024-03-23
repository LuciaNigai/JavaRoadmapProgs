package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.Matrices.GivenMatrix;
import maven.project.JavaRoadmap.Matrices.GivenSparseMatrix;
import maven.project.JavaRoadmap.Matrices.MatricesAddition;
import maven.project.JavaRoadmap.Matrices.MatricesEqualityCheck;
import maven.project.JavaRoadmap.Matrices.MatricesMultiplication;
import maven.project.JavaRoadmap.Matrices.OddEvenElements;
import maven.project.JavaRoadmap.Matrices.RowColSum;
import maven.project.JavaRoadmap.Matrices.TransposeMatrix;

class MatricesTest {
	/*
	 * Matrix columns/roes elements sum
	 */

    @Test
    public void testCalculateSums() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Map<String, Map<Integer, Integer>> result = RowColSum.calculateSums(matrix);
        
        // Check row sums
        Map<Integer, Integer> rowSums = result.get("Row");
        assertEquals(6, (int) rowSums.get(0)); // Row 0 sum = 6
        assertEquals(15, (int) rowSums.get(1)); // Row 1 sum = 15
        assertEquals(24, (int) rowSums.get(2)); // Row 2 sum = 24
        
        // Check column sums
        Map<Integer, Integer> colSums = result.get("Col");
        assertEquals(12, (int) colSums.get(0)); // Col 0 sum = 12
        assertEquals(15, (int) colSums.get(1)); // Col 1 sum = 15
        assertEquals(18, (int) colSums.get(2)); // Col 2 sum = 18
    }
    
    /*
     * Count Odd and even numbers
     */
    
    @Test
    public void testGetOddEvenFrequency() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Map<String, Integer> result = OddEvenElements.getOddEvenFrequency(matrix);
        
        assertEquals(4, (int) result.get("Even")); // Expected number of even elements
        assertEquals(5, (int) result.get("Odd")); // Expected number of odd elements
    }
    
    /*
     * Matrices equality
     */
    
    @Test
    public void testCheckMatricesEquality_SameMatrices() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {1, 2},
            {3, 4}
        };
        
        assertTrue(MatricesEqualityCheck.checkMatricesEquality(matrix1, matrix2));
    }
    
    @Test
    public void testCheckMatricesEquality_DifferentMatrices() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {1, 2},
            {3, 5} // Different element
        };
        
        assertFalse(MatricesEqualityCheck.checkMatricesEquality(matrix1, matrix2));
    }
    
    @Test
    public void testCheckMatricesEquality_DifferentDimensions() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {1, 2, 3}, // Different dimensions
            {3, 4, 5}
        };
        
        try {
            MatricesEqualityCheck.checkMatricesEquality(matrix1, matrix2);
            fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("The matrix should have the same dimensions", e.getMessage());
        }
    }
    
    /*
     * Matrices multiplication
     */
    @Test
    public void testMultiplyMatrices_ValidInput() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {5, 6},
            {7, 8}
        };
        
        int[][] expected = {
            {19, 22},
            {43, 50}
        };
        
        int[][] result = MatricesMultiplication.multiplyMatrices(matrix1, matrix2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testMultiplyMatrices_InvalidInput() {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] matrix2 = {
            {7, 8},
            {9, 10}
        };
        
        try {
            MatricesMultiplication.multiplyMatrices(matrix1, matrix2);
            fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Matrices of those sizes cannot be multiplied", e.getMessage());
        }
    }
    
    /*
     * Matrices sum
     */
  
    @Test
    public void testAddMatrices_ValidInput() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {5, 6},
            {7, 8}
        };
        
        int[][] expected = {
            {6, 8},
            {10, 12}
        };
        
        int[][] result = MatricesAddition.addMatrices(matrix1, matrix2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddMatrices_InvalidInput() {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] matrix2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            MatricesAddition.addMatrices(matrix1, matrix2);
        });

        assertEquals("The matrices should have the same dimensions", exception.getMessage());
    }
    
    /*
     * Transpose matrix
     */
    @Test
    public void testFindTranspose_ValidInput() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] expected = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        int[][] result = TransposeMatrix.findTranspose(matrix);
        
        assertArrayEquals(expected, result);
    }
    
    /*
     * Given Matrix
     */
    @Test
    public void testCheckGivenMatrix_ValidSquareMatrix() {
        int[][] matrix = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        
        assertTrue(GivenMatrix.checkGivenMatrix(matrix));
    }
    
    @Test
    public void testCheckGivenMatrix_ValidNonSquareMatrix() {
        int[][] matrix = {
            {1, 0, 0},
            {0, 1, 0}
        };
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GivenMatrix.checkGivenMatrix(matrix);
        });

        assertEquals("The matrix should be square", exception.getMessage());
    }
    
    @Test
    public void testCheckGivenMatrix_InvalidMatrix() {
        int[][] matrix = {
            {1, 0, 1},
            {0, 1, 0},
            {0, 0, 1}
        };
        
        assertFalse(GivenMatrix.checkGivenMatrix(matrix));
    }
    
    /*
     * Given matrix is sparse
     */
    @Test
    public void testCheckSparse_ValidSparseMatrix() {
        int[][] matrix = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        
        assertTrue(GivenSparseMatrix.checkSparse(matrix));
    }
    
    @Test
    public void testCheckSparse_ValidNonSparseMatrix() {
        int[][] matrix = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 1, 0}
        };
        
        assertFalse(GivenSparseMatrix.checkSparse(matrix));
    }
    
    @Test
    public void testCheckSparse_NonSquareMatrix() {
        int[][] matrix = {
            {1, 0, 0},
            {0, 1, 0}
        };
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GivenSparseMatrix.checkSparse(matrix);
        });

        assertEquals("The matrix should be square", exception.getMessage());
    }
}
