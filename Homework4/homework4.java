package Homework4;


import java.util.*;


public class homework4 {
    public static void main(String[] args) {
        ex0();
        ex1();
        ex2();

    }

    static void ex2() {
        /*
        Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
         */
        System.out.println("Задание 3. Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке.");
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);
        System.out.println("Сумма элементов коллекции: " + sumOfElements(list));
    }

    static int sumOfElements(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.listIterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    static void ex1() {
        /*
        Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
        dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди,
        не удаляя.
        *реализовать вторую задачу через собственный класс используя в основе массив
         */
        System.out.println("Задание 2. Реализуйте очередь через собственный класс используя в основе массив");
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 6; i++) {
            myQueue.enqueue(i);
        }
        myQueue.print();
        System.out.println(myQueue.dequeue());
        myQueue.print();
        System.out.println(myQueue.dequeue());
        myQueue.print();
        System.out.println(myQueue.first());

    }

    static void ex0() {
        /*
        Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        Постараться не обращаться к листу по индексам.
         */
        System.out.println("Задание 1. Реализуйте метод, который вернет “перевернутый” список.");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i + 1);
        }
        System.out.println(linkedList);
        LinkedList<Integer> newList = listRevers(linkedList);
        System.out.println(newList);
    }

    static LinkedList<Integer> listRevers(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            newList.add(iterator.previous());
        }
        return newList;
    }
}