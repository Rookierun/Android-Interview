package com.rookie.ai.al_structure.test_03_05;

/**
 * 一、题目
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到
 * 下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断
 * 数组中是否含有该整数。
 */
public class FindInTwoDimensionArray {
    public static void main(String[] args) {
        int target = 6;
        int[][] arrays = new int[3][3];
        arrays[0] = new int[]{1, 2, 3};
        arrays[1] = new int[]{4, 5, 6};
        arrays[2] = new int[]{7, 8, 9};
        boolean find = findTargetNumInArray(target, arrays);
        System.out.println(find);
    }


    private static boolean findTargetNumInArray(int target, int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return false;
        }
        int length = arrays.length;
        //由于是递增的，所以第一个是最小，最后一个元素是最大
        int[] array_first = arrays[0];
        if (array_first != null && array_first.length != 0) {
            int first_num_in_array_first = array_first[0];
            //比第一个元素还小
            if (target < first_num_in_array_first) {
                return false;
            }
        }
        int[] array_last = arrays[length - 1];
        if (array_last != null && array_last.length != 0) {
            int last_num_in_array_last = array_last[array_last.length - 1];
            //比最后一个元素还大
            if (target > last_num_in_array_last) {
                return false;
            }
        }
        int count = 0;
        //第一种办法：直接暴力循环
//        for (int i = 0; i < length; i++) {
//            int[] inner_array = arrays[i];
//            if (inner_array == null || inner_array.length == 0) {
//                continue;
//            }
//            int inner_length = inner_array.length;
//            for (int index = 0; index < inner_length; index++) {
//                count += 1;
//                if (target == inner_array[index]) {
//                    System.out.println("跑了几次："+count);
//                    return true;
//                }
//            }
//        }
        //第二种，每一次都像边界条件一样，比较第一个元素和最后一个元素与目标元素的大小
        for (int i = length - 1; i >= 0; i--) {
            int[] array = arrays[i];
            if (array == null || array.length == 0) {
                continue;
            }
            if (array[0] > target) {
                continue;
            }
            if (array[array.length - 1] < target) {
                return false;
            }
            for (int index = 0; index < array.length; index++) {
                count += 1;
                if (array[index] == target) {
                    System.out.println("跑了几次：" + count);
                    return true;
                }
            }
        }
        return false;

    }
}
