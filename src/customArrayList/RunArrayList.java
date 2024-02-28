package customArrayList;

public class RunArrayList {
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>(20);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("\nСписок после создания и добавления элементов: ");
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        arrayList.add(10);
        arrayList.add(9);
        arrayList.add(8);
        arrayList.add(7);
        arrayList.add(6);
        arrayList.add(5);

        System.out.println("\nСписок после создания и добавления элементов (расширение):");
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        System.out.println("\nСписок после добавления элемента 10 по индексу 3:");
        arrayList.add(3, 10);
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        System.out.println("\nСписок после добавления элемента 15 по индексу 6:");
        arrayList.add(6, 15);
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        System.out.println("\nПолучить элемент списка по индексу 3:");
        System.out.println("Элемент по индексу: " + arrayList.get(3));

        System.out.println("\nСписок после удаления элемента по индексу 3:");
        arrayList.remove(3);
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        System.out.println("\nСписок после удаления элемента по значению 1:");
        arrayList.remove((Integer) 1);
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        System.out.println("\nСписок после сортировки:");
        arrayList.sort();
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());

        System.out.println("\nСписок после очистки:");
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("Размер списка: " + arrayList.size());
    }
}
