/**
 * Created by Bar on 1/10/2018.
 */

import java.util.Random;
public class MergeSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //start timer for program execution.
        int array[] = new int[500000];    //array to hold 500,000 test variables.
        int length = array.length;         //get length of test array.
        random_test(array);               //fill array with random numbers.
        split_Array(array, 0, length-1);               //split array to single elements.
        display_and_check(array);         //display and check array is in sorted order.
        long endTime = System.nanoTime();   //stop timer for program execution.
        long time = (endTime - startTime);  //difference from starting to finishing time.
        System.out.println("Program Execution time took: "+ time/1000000 + "  milliseconds");  //time taken to execute.
    }

    public static int[] random_test(int[] array) {  //randomly generate a number and fill array.


        Random rand = new Random(); //generate new random seed.

        for (int i = 0; i < 500000; ++i) {

            array[i] = rand.nextInt(500000) + 1; //generate random number between 1:500000.
        }

        return array;
    }


    public static void split_Array(int[] array, int left, int right){   //split array into individual elements.

        if(left < right ) {

            int middle = (left+right)/2;

            split_Array(array,left,middle);
            split_Array(array,middle+1, right);
            merge_Array(left, right, middle, array);
        }
    }

    public static int merge_Array(int left, int right, int middle, int[]array){

        int i = 0;  //left array index.
        int j = 0;  //right array index.
        int k = left;  //main array index.

        int temp1 = middle-left +1;
        int temp2 = right - middle;

        int[] left_array = new int[temp1];
        int[] right_array = new int[temp2];


        for(int x=0; x<temp1; ++x){ //fill temporary left array.

            left_array[x] = array[left + x];
        }

        for(int y=0; y<temp2; ++y) {    //fill temporary right array.
            right_array[y] = array[middle + 1 + y];

        }

        while(i < temp1 && j < temp2){ //while we are not at the end of the arrays.
            if(left_array[i] <= right_array[j]){     //find smallest of left and right array.
                array[k] = left_array[i];      //copy smallest into original array.
                ++i;                     //increment left index.
            }
            else{                        //else copy right smallest into original array.
                array[k] = right_array[j];     //copy smallest into original array.
                ++j;                     //increment right index.
            }
            ++k;
        }
        while(i < temp1){               //any remaining left variables.
            array[k] = left_array[i];
            ++i;
            ++k;
        }
        while(j < temp2){               //any remaining right variables.
            array[k] = right_array[j];
            ++j;
            ++k;
        }

        return 1;
    }

    public static int display_and_check(int[] array){   //display array and check for errors.

        int errors = 0;
        for(int i=0;i<array.length;++i){

            System.out.println(array[i]);


            if(i == 499999){    //once we hit the end of the array exit.
                System.out.println("Number of Errors: " + errors);
                return 1;
            }
            else if(array[i] > array[i+1]){ //check to make sure array is in sorted order.

                System.out.println("Error");
                System.out.println(array[i-1]);
                System.out.println("is bigger than");
                System.out.println(array[i]);
                ++errors;
            }

        }

        return 1;
    }
}


