package customLinkedList;

public class RunLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println("\nСписок после создания и добавления элементов в начало:");
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        linkedList.addLast(4);
        linkedList.addLast(8);
        linkedList.addLast(6);

        System.out.println("\nСписок после добавления элементов в конец:");
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nПолучить первый элемент списка");
        System.out.println("Первый элемент: " + linkedList.getFirst());

        System.out.println("\nПолучить последний элемент списка");
        System.out.println("Последний элемент: " + linkedList.getLast());

        System.out.println("\nСписок после добавления элемента 10 по индексу 1:");
        linkedList.addByIndex(10, 1);
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nПолучить элемент списка по индексу 5:");
        System.out.println("Запрашиваемый элемент: " + linkedList.get(5));

        System.out.println("\nСписок после удаления первого элемента:");
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после удаления последнего элемента:");
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после удаления элемента 4 по значению:");
        linkedList.remove((Integer) 4);
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
