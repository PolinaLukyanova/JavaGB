package Homework3;


import java.util.*;

public class homework {
    public static void main(String[] args) {
        // Задание 1. Пусть дан произвольный список целых чисел, удалить из него четные числа
        task01();
        //Задание 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из
        //этого списка.
        task02();
        //Задание 3. Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
        //Вывести название каждой планеты и количество его повторений в списке.
        task03();
        //Реализовать алгоритм сортировки слиянием
        task04();
    }
    static int[] createArray(int arraySize){
        Random random = new Random();
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 11);
        }
        return array;
    }
    static void printPlanets(int listSize) {
        Random random = new Random();
        String[] list = {"Меркурий","Венера","Земля","Марс","Юпитер","Сатурн","Уран","Нептун"};
        List<String> newList = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            newList.add(list[random.nextInt(list.length)]);
        }
        System.out.println(newList);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " встречается " + Collections.frequency(newList, list[i]) + " раз(а)");
        }
        System.out.println();
    }
    static int findMin(List<Integer> list){
        return Collections.min(list);
    }
    static int findMax(List<Integer> list){
        return Collections.max(list);
    }
    static double findAverage(List<Integer> list){
        int sum = 0;
        for (int i :
                list) {
            sum += i;
        }
        return sum / (double) list.size();
    }
    static List<Integer> createList(int size, int min, int max) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max + 1));
        }
        return list;
    }
    static void delEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }
    static void task01 () {
        System.out.println("-----Задание 1-----");
        List<Integer> list = createList(10, 0, 5);
        System.out.printf("Начальный список: %s", list + "\n");
        delEvenNumbers(list);
        System.out.printf("Список без чётных чисел: %s", list + "\n\n");
    }
    static void task02(){
        System.out.println("-----Задание 2-----");
        List<Integer> list2 = createList(10, 0, 10);
        System.out.println(list2);
        System.out.println("Максимальное значение списка: " + findMax(list2));
        System.out.println("Минимальное значение списка: " + findMin(list2));
        System.out.println("Среднее арифметическое значение списка: " + findAverage(list2) + "\n");
    }
    static void task03(){
        System.out.println("-----Задание 3-----");
        printPlanets(20);
    }
    static void task04(){
        System.out.println("-----Задание 4-----");
        int[] array = createArray(10);
        System.out.printf("Исходный массив: %s", Arrays.toString(array) + "\n");
        int[] result = mergeSort(array);
        System.out.printf("Отсортированный массив: %s", Arrays.toString(result) + "\n");
    }
    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        return mergeSortInner(buffer1, buffer2, 0, sortArr.length);
    }
}