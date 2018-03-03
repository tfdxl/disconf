package com.monlie;

public class FindInMatrix {

    static boolean find(int[] matrix, int rows, int cols, int number) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        boolean found = false;
        if (rows > 0 && cols > 0) {

            int row = 0;
            int col = cols - 1;

            while (row < rows && col >= 0) {

                if (matrix[row * cols + col] == number) {
                    found = true;
                    break;
                } else if (matrix[row * cols + col] > number) {
                    --col;
                } else {
                    row++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
        System.err.println(find(arr, 4, 4, 7));
    }
}
