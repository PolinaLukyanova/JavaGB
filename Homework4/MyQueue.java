package Homework4;

import java.util.Arrays;

public class MyQueue {
    private Integer[] arr = new Integer[10];
    private int size = 0;

    int first(){
        return arr[0];
    }
    void enqueue(int item){
        if(size == arr.length){
            Integer[] newArr = new Integer[arr.length + 10];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[size++] = item;
    }
    int dequeue(){
        int firstElement = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return firstElement;
    }
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null){
                continue;
            }
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}