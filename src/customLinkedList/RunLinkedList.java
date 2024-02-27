package customLinkedList;

/**
 * Класс Main - класс для проверки функциональности CustomLinkedList
 */
public class RunLinkedList {
    /**
     * Метод main - точка входа в программу
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        System.out.println("\nСписок после создания и добавления элементов в начало: ");
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        linkedList.addLast(3);
        linkedList.addLast(4);

        System.out.println("\nСписок после добавления элементов в конец: ");
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nПолучить первый элемент списка.");
        System.out.println("Первый элемент: " + linkedList.getFirst());

        System.out.println("\nПолучить последний элемент списка.");
        System.out.println("Последний элемент: " + linkedList.getLast());

        System.out.println("\nСписок после добавления элемента 5 по индексу 1");
        linkedList.addByIndex(5, 1);
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nПолучить элемент списка по индексу.");
        System.out.println("Запрашиваемый элемент: " + linkedList.get(0));

        System.out.println("\nУдаление первого элемента из коллекции");
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nУдаление последнего элемента из коллекции");
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после удаления элемента 5 по ключу");
        linkedList.remove((Integer) 5);
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("\nСписок после очистки:");
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("Размер списка: " + linkedList.size());
    }
}
