package com.company;
public class QuickSelect {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 2, 5, 2, 2 };
        // find 8th smallest
        int smallest = quickSelect(arr, 0, arr.length - 1, 8);
        System.out.println(smallest);
    }

    public static int quickSelect(int[] arr, int startIndex, int endIndex, int k) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }
        int pivot = partition(arr, startIndex, endIndex);
        if (pivot == k) {
            return arr[pivot];
        } else if (k < pivot) {
            return quickSelect(arr, startIndex, pivot - 1, k);
        } else {
            return quickSelect(arr, pivot + 1, endIndex, k);
        }
    }

    public static int quickSelectV2(int[] arr, int startIndex, int endIndex, int k) {

        if (startIndex == endIndex) {
            return arr[startIndex];
        }

        while (true) {
            int pivot = partition(arr, startIndex, endIndex);
            if (pivot == k) {
                return arr[pivot];
            } else if (k < pivot) {
                endIndex = pivot - 1;
            } else {
                startIndex = pivot + 1;
            }
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = endIndex;
        int partitionIndex = startIndex;
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, partitionIndex);

                partitionIndex++;
            }
        }

        swap(arr, partitionIndex, pivot);

        // partitionIndex will be the rearranged pivot
        return partitionIndex;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

}