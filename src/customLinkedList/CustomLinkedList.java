package customLinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Класс кастомной реализации LinkedList с полями head, tail и size и вложенным классом Node
 * @param <T> объект любого типа
 * @author Сергей Шапкин
 * @version 1.0
 */
public class CustomLinkedList<T> {
    /** Указатель на первый элемент списка*/
    private Node<T> head;

    /** Указатель на последний элемент списка*/
    private Node<T> tail;

    /** Размер коллекции*/
    private int size = 0;

    /** Вложенный класс "Узел"*/
    static class Node<E> {
        /** Ссылка на элемент*/
        public E elem;

        /** Ссылка на следующий элемент*/
        public Node<E> next;

        /** Ссылка на предыдущий элемент*/
        public Node<E> prev;

        /** Конструктор - создание нового узла*/
        public Node(E elem) {
            this.elem = elem;
        }
    }

    /**
     * Метод для добавления элемента в начало коллекции
     * @param elem элемент, который необходимо добавить
     */
    public void addFirst(T elem) {
        Node<T> node = new Node<>(elem);
        if (isEmpty()) {
            tail = node;
        } else {
            head.prev = node;
        }

        node.next = head;
        head = node;
        size++;
    }

    /**
     * Метод для добавления элемента в конец коллекции
     * @param elem элемент, который необходимо добавить
     */
    public void addLast(T elem) {
        Node<T> node = new Node<>(elem);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }

        node.prev = tail;
        tail = node;
        size++;
    }

    /**
     * Метод для добавления элемента по индексу
     * @param elem элемент, который необходимо добавить
     * @param index индекс, на место которого необходимо вставить элемент
     */
    public void addByIndex(T elem, int index) {
        Node<T> current = head;
        int indexSearch = 0; // дополнительная переменная, служит для нахождения индекса

        while (current != null && indexSearch != index) {
            current = current.next;
            indexSearch++;
        }

        Node<T> node = new Node<>(elem);

        current.prev.next = node;
        node.prev = current.prev;
        current.prev = node;
        node.next = current;
        size++;
    }

    /** Метод для получения первого элемента из коллекции
     * @return возвращает первый элемент из коллекции
     */
    public T getFirst() {
        Node<T> current = head;
        if (current == null)
            throw new NoSuchElementException();
        return head.elem;
    }

    /** Метод для получения последнего элемента из коллекции
     * @return возвращает последний элемент из коллекции
     */
    public T getLast() {
        Node<T> current = tail;
        if (current == null)
            throw new NoSuchElementException();
        return tail.elem;
    }

    /**
     * Метод для получения элемента из по индексу
     * @param index индекс элемента, который необходимо получить
     * @return возвращает элемент по запрашиваемому индексу
     */
    public T get(int index) {
        checkIndex(index);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.elem;
    }

    /**
     * Метод для удаления первого элемента из коллекции
     */
    public void removeFirst() {
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        size--;
    }

    /**
     * Метод для удаления последнего элемента из коллекции
     */
    public void removeLast() {
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        size--;
    }

    /**
     * Метод для удаления элемента по значению
     * @param elem элемент, который необходимо удалить
     */
    public void remove(T elem) {
        Node<T> current = head;
        while (!current.elem.equals(elem)) {
            current = current.next;

            if (current == null) {
                return;
            }
        }

        if (current == head) {
            removeFirst();
        } else {
            current.prev.next = current.next;
        }

        if (current == tail) {
            removeLast();
        } else {
            current.next.prev = current.prev;
        }
        size--;
    }

    /**
     * Метод для сортировки коллекции
     * Внутри метода создается новый массив в который копируются все элементы CustomLinkedList
     * После производится сортировка с помощью Arrays.sort() и очистка текущего CustomLinkedList
     * Далее все элементы копируются из отсортированного массива в новый CustomLinkedList
     */
    public void sort() {
        T[] array = (T[]) new Object[size];
        Node<T> node = head;

        for (int i = 0; i < size; i++) {
            array[i] = node.elem;
            node = node.next;
        }

        Arrays.sort(array);

        clear();

        for (int i = 0; i < array.length; i++) {
            addLast(array[i]);
        }
    }

    /**
     * Метод для очистки всей коллекции
     */
    public void clear() {
        for (Node<T> i = head; i != null; ) {
            Node<T> next = i.next;
            i.elem = null;
            i.prev = null;
            i.next = null;
            i = next;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * Метод для получения размера коллекции
     * @return возвращает размер коллекции
     */
    public int size() {
        return this.size;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void checkIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("The index of the element does not exist");
        }
    }

    /**
     * Переопределенный метод для вывода элементов массива на экран
     * @return возвращает строку с элементами списка
     */
    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        Node<T> node = head;

        while (node != null) {
            elements.append(node.elem).append(", ");
            node = node.next;
        }

        if (elements.length() > 2) {
            return "CustomLinkedList: [" + elements.substring(0, elements.length() - 2) + "]";
        } else {
            return "CustomLinkedList: [" + elements.substring(0, elements.length()) + "]";
        }
    }
}
