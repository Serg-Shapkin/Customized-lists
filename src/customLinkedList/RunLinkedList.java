package customLinkedList;

import interfaces.CustomListAll;

public class RunLinkedList {
    public static void main(String[] args) {
        CustomListAll<Integer> linkedList = new CustomLinkedList<>();

        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(6);

        System.out.println("\nСписок после создания добавления элементов:");
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println("\nСписок после и добавления элементов в начало:");
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после добавления элемента 10 по индексу 1:");
        linkedList.add(1, 10);
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nПолучить элемент списка по индексу 5:");
        System.out.println("Запрашиваемый элемент: " + linkedList.get(5));

        System.out.println("\nПолучить первый элемент списка");
        System.out.println("Первый элемент: " + linkedList.getFirst());

        System.out.println("\nПолучить последний элемент списка");
        System.out.println("Последний элемент: " + linkedList.getLast());

        System.out.println("\nСписок после удаления элемента по индексу 3:");
        linkedList.remove(3);
        System.out.println(linkedList);

        System.out.println("\nСписок после удаления элемента 4 по значению:");
        linkedList.remove((Integer) 4);
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после удаления первого элемента:");
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после удаления последнего элемента:");
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после сортировки:");
        linkedList.sort();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после очистки:");
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());
    }
}
