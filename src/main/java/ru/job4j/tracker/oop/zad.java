package ru.job4j.tracker.oop;

public class zad {
 static public int[] nums  =  new int[] {4, 6, 5, 7, 2, 4, 9, 1};
    static public int[] out = new int[4];
   static int size=0;
    public static void main(String[] args) {
            while (out.length != 1) {
                for (int i = 0; i < nums.length - 1; i = i + 2) {
                    if (nums[i] < nums[i + 1]) {
                        out[size] = nums[i + 1];
                        size++;
                    } else {
                        out[size] = nums[i];
                        size++;
                    }
                }

                for (int i = 0; i < out.length; i++) {

                }
            }
    }
}
