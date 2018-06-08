package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //.csv - comma seperated values

        int[][] my_arr = new int[20][20];
        String file_name = "src/solutions/11.csv";

        build2DArrayFromCSV(file_name, my_arr);

        int result = max(maxProductRows(my_arr), maxProductColumns(my_arr), maxProductDiagonalLeft(my_arr), maxProductDiagonalRight(my_arr));
        System.out.println(result);
    }

    /**
     * Finds the largest int in an unknown amount of ints.
     *
     * @param params The ints to calculate.
     * @return Returns the largest int within a given group of ints.
     */
    public static int max(int... params) {
        int max = params[0];
        for (int i = 0; i < params.length; i++) {
            if (params[i] > max)
                max = params[i];
        }
        return max;
    }

    /**
     * Finds the largest product of 4 elements next to each other in a 2D array (a grid), searching row by row.
     *
     * @param arr The 2D array to search in.
     * @return The largest product of 4 elements next to each other in a row.
     */
    public static int maxProductRows(int[][] arr) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int max_product = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 3; j++) {
                first = arr[i][j];
                second = arr[i][j + 1];
                third = arr[i][j + 2];
                fourth = arr[i][j + 3];

                if (first * second * third * fourth > max_product)
                    max_product = first * second * third * fourth;
            }
        }
        //System.out.println(first+" "+second+" "+third+" "+fourth+" "+max_product);
        return max_product;
    }

    /**
     * Finds the largest product of 4 elements next to each other in a 2D array (a grid), searching column by column.
     *
     * @param arr The 2D array to search in.
     * @return The largest product of 4 elements next to each other in a column.
     */
    public static int maxProductColumns(int[][] arr) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int max_product = 0;

        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 3; i++) {
                //System.out.println(i + " " + j);
                first = arr[i][j];
                second = arr[i + 1][j];
                third = arr[i + 2][j];
                fourth = arr[i + 3][j];

                if (first * second * third * fourth > max_product)
                    max_product = first * second * third * fourth;
            }
        }
        //System.out.println(first+" "+second+" "+third+" "+fourth+" "+max_product);
        return max_product;
    }

    /**
     * Finds the largest product of 4 elements next to each other in a 2D array (a grid), searching by left diagonal.
     *
     * @param arr The 2D array to search in.
     * @return The largest product of 4 elements next to each other in a left diagonal.
     */
    public static int maxProductDiagonalLeft(int[][] arr) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int max_product = 0;

        for (int i = 3; i < arr.length; i++) {
            for (int j = 3; j < arr.length; j++) {
                first = arr[i][j];
                second = arr[i - 1][j - 1];
                third = arr[i - 2][j - 2];
                fourth = arr[i - 3][j - 3];

                if (first * second * third * fourth > max_product)
                    max_product = first * second * third * fourth;
            }
        }
        //System.out.println(first+" "+second+" "+third+" "+fourth+" "+max_product);
        return max_product;
    }

    /**
     * Finds the largest product of 4 elements next to each other in a 2D array (a grid), searching by right diagonal.
     *
     * @param arr The 2D array to search in.
     * @return The largest product of 4 elements next to each other in a right diagonal.
     */
    public static int maxProductDiagonalRight(int[][] arr) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int max_product = 0;

        for (int i = 3; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 3; j++) {
                first = arr[i][j];
                second = arr[i - 1][j + 1];
                third = arr[i - 2][j + 2];
                fourth = arr[i - 3][j + 3];

                if (first * second * third * fourth > max_product)
                    max_product = first * second * third * fourth;
            }
        }
        //System.out.println(first+" "+second+" "+third+" "+fourth+" "+max_product);
        return max_product;
    }


    /**
     * Prints a 2D array to the screen with System.out.print.
     *
     * @param arr The 2D array to print.
     */
    public static void printDoubleArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                if (arr[i][j] < 10)
                    System.out.print(arr[i][j] + ", \t");
                if (arr[i][j] >= 10 && arr[i][j] < 100)
                    System.out.print(arr[i][j] + ",\t");
            }
            if (arr[i].length > 0)
                System.out.print(arr[i][arr[i].length - 1]);
            System.out.println();
        }
    }

    /**
     * Prints an array of ints to the screen with System.out.print.
     *
     * @param arr The array to print.
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    /**
     * Replaces a string of numbers, seperated with commas, to an array of ints.
     *
     * @param row Represents the string of numbers with commas
     * @return Returns an int[] with the number values.
     */
    public static int[] stringRowToIntArray(String row) {

        int commas = 0;

        for (int i = 0; i < row.length(); i++) {

            if (row.charAt(i) == ',')
                commas++;

        }
        int value_amount = commas + 1;
        int[] row_value_arr = new int[value_amount];

        int leftSideTrackingIndex = 0;
        int arr_index = 0;
        for (int i = 0; i < row.length(); i++) {

            if (row.charAt(i) == ',') {

                String str = row.substring(leftSideTrackingIndex, i);
                int value = Integer.parseInt(str);
                row_value_arr[arr_index] = value;
                leftSideTrackingIndex = i + 1;
                arr_index++;
            }
        }
        row_value_arr[row_value_arr.length - 1] = Integer.parseInt(row.substring(leftSideTrackingIndex, row.length()));

        return row_value_arr;
    }

    /**
     * Recives a refernce to a 2D array, and inserts values that were found in CSV file.
     *
     * @param file_name string that represents the file path.
     * @param arr       the reference passed to the original 2D array.
     */
    public static void build2DArrayFromCSV(String file_name, int[][] arr) {
        File file = new File(file_name);

        try {
            Scanner inputStream = new Scanner(file);

            int i = 0;
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                int[] row_arr = stringRowToIntArray(data);
                arr[i] = row_arr;
                i++;
            }

//            printDoubleArray(arr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
