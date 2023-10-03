package base.mod1;

public class task2 {
    public static int findMinElementArr(int[][] array) {
        int arr [][] = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        return (min);
    }
    public static void main(String[] args){
        int[][] arr = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };
        System.out.println(findMinElementArr(arr));
    }
}