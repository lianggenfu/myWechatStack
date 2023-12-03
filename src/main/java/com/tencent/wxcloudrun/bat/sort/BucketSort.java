package com.tencent.wxcloudrun.bat.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {


        int x = 3;
        int y = 4;
        int res = Math.addExact(x,y);
        System.out.println("111");

        /*int[] arr = new int[100000];
        for (int i = 0; i <100000 ; i++) {
            int randomValue = (int) (Math.random() * 1000);
            arr[i] = randomValue;
        }
        //int[] arr = {34,42,3,41,6,23,2,11,12,76,23,24,2,38,88,4,33,21,74,23,65,54,21,18};
        long t1 = System.currentTimeMillis();
        Arrays.sort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("duration : " + (t2-t1));
        int[] sortedArr = bucketSort(arr);*/

    }

    private static int[] bucketSort(int[] arr) {
        List<Integer> buckets[] = new ArrayList[3];
        for (int i = 0; i <buckets.length ; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<330){
                buckets[0].add(arr[i]);
            }else if(arr[i]<660){
                buckets[1].add(arr[i]);
            }else{
                buckets[2].add(arr[i]);
            }
        }
        for (int i = 0; i <buckets.length ; i++) {
            buckets[i].sort(null);
            System.out.println("第" + i + " 个桶");
            System.out.println(buckets[i]);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("duration : " + (t2-t1));
        return null;
    }
}
