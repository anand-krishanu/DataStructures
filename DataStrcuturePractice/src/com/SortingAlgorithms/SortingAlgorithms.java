package com.SortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr1 = {19, 7, 8, 15, 90, 4, 56, 3};
        System.out.println(Arrays.toString(arr1));

        bubbleSort(arr1);
        System.out.println("Bubble Sort:" + Arrays.toString(arr1));

        int[] arr2 = {65, 1, 23, 90, 84, 23, 56};
        selectionSort(arr2);
        System.out.println("Selection Sort: " + Arrays.toString(arr2));

        int[] arr3 = {3, 44, 81, 34, 97, 121, 2};
        insertionSort(arr3);
        System.out.println("Insertion Sort: " + Arrays.toString(arr3));

        int[] arr4 = {45, 56, 88, 90, 101};
        int[] arr5 = {23, 33, 78, 81, 92, 99};
        System.out.println("Merge: " + Arrays.toString(merge(arr4, arr5)));

        int[] arr6 = {74, 2, 48, 11, 54, 82, 24, 54, 32, 89, 1, 143};
        int[] mergeSortedArray = mergeSort(arr6);
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortedArray));

        int[] arr7 = {19, 7, 8, 15, 90, 4, 56, 3};
        System.out.println("Pivot Method: " + pivot(arr7, 0, 7));

        int[] arr8 = {19, 7, 8, 15, 90, 4, 56, 3};
        quickSort(arr8);
        System.out.println(Arrays.toString(arr8));
    }

    //Bubble Sort
    public static void bubbleSort (int[] arr) {
        for(int i = arr.length -1; i>0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort (int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if(i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }
    //Insertion Sort
    public static void insertionSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while(j> -1 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    //Merge Sort
    public static int[] merge (int[] arr1, int[] arr2) {
        int[] combinedArray = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                combinedArray[index] = arr1[i];
                index++;
                i++;
            }
            else {
                combinedArray[index] = arr2[j];
                index++;
                j++;
            }
        }

        while (i < arr1.length) {
            combinedArray[index] = arr1[i];
            index++;
            i++;
        }
        while (j < arr2.length) {
            combinedArray[index] = arr2[j];
            index++;
            j++;
        }

        return combinedArray;
    }

    public static int[] mergeSort (int[] arr) {

        if(arr.length == 1) {
            return arr;
        }

        int minIndex = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, minIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, minIndex, arr.length));

        return merge(left, right);
    }

    //Quick Sort
    public static int pivot (int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pivotIndex, swapIndex);

        return swapIndex;
    }

    public static void quickSortHelper (int[] arr, int left, int right) {
        if(left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
    }

    public static void quickSort (int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    //Swap Method
    public static void swap (int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

}