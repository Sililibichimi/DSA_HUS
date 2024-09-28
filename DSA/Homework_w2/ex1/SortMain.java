package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortMain {

    public static void main(String[] args) {

        SortMaker sortMaker = new SortMaker();

        int[] arr1 = new int[10];
        int[] arr2;
        Sort[] sorts = new Sort[5];

        sorts[0] = new BubbleSort();
        sorts[1] = new InsertSort();
        sorts[2] = new SelectionSort();
        sorts[3] = new MergeSort();
        sorts[4] = new QuickSort();

        int n = 10;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("a)");

        for(int i = 0; i < arr1.length; ++i) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("b)");

        n = rd.nextInt(1, 100);
        arr2 = new int[n];
        for(int i = 0; i < n; ++i) {
            arr2[i] = rd.nextInt(1, 100000);
        }
        System.out.println("c)");
        sortMaker.setArr(arr1);
        for(int i = 0; i < 5; ++i) {
            System.out.println("Using " + sorts[i].toString());
            sorts[i].setPrint(true);
            sortMaker.setSort(sorts[i]);
            sortMaker.sorting();

            System.out.println("After sorting: ");
            System.out.println(Arrays.toString(sortMaker.sortedArr));
            System.out.println("Number of swap :" + sorts[i].getNumberOfSwap());
            System.out.println("Number of compair: " + sorts[i].getNumberOfCompair());
            System.out.println();
        }

        System.out.println("length of arr2 = " + n);
        sortMaker.setArr(arr2);
        for(int i = 0; i < 5; ++i) {
            System.out.println("Using " + sorts[i].toString());
            sorts[i].setPrint(true);
            sortMaker.setSort(sorts[i]);
            sortMaker.sorting();

            System.out.println("After sorting: ");
            System.out.println(Arrays.toString(sortMaker.sortedArr));
            System.out.println("Number of swap :" + sorts[i].getNumberOfSwap());
            System.out.println("Number of compair: " + sorts[i].getNumberOfCompair());
            System.out.println();
        }

        System.out.println("d)");

        int[] sizes = new int[4];
        sizes[0] = 100;
        sizes[1] = 1000;
        sizes[2] = 10000;
        sizes[3] = 100000;

        for(int j = 0; j < 4; ++j) {
            int[] arr = createArrayWithN(sizes[j]);
            sortMaker.setArr(arr);
            System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("With N = " + sizes[j]);

            for(int i = 0; i < 5; ++i) {
                System.out.println("Using " + sorts[i].toString());
                sorts[i].setPrint(false);
                sortMaker.setSort(sorts[i]);
                sortMaker.sorting();

                System.out.println("Time: " + sorts[i].getDuration());
                System.out.println();
            }
        }

    }

    public static int[] createArrayWithN(int n) {
        int[] arr = new int[n];
        Random rd = new Random();
        arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = rd.nextInt(0, 10000);
        }

        return arr;
    }

}

