package com.monlie;

public class FindNumber {

    static boolean duplicate(int[] numbers, int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        //check
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; ++i) {

            //当前数组存放的数据和这个索引不同
            while (numbers[i] != i) {

                //只要numbers[i] == numbers[numbers[i]]表示找到了,否则交换一下
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }

        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        final int[] arr = {2, 3, 1, 0, 2, 5, 3};
        final int[] duplicate = new int[1];
        final boolean res = duplicate(arr, arr.length, duplicate);
        if (res) {
            System.err.println("res = " + duplicate[0]);
        } else {
            System.err.println("no res");
        }
    }
}
