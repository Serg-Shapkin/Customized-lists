package customArrayList;

import interfaces.CustomList;

import java.util.Arrays;

/**
 * Класс кастомной реализации ArrayList с полями array, size и capacity
 * @param <T> объект любого типа
 * @author Сергей Шапкин
 * @version 1.0
 */
public class CustomArrayList<T> implements CustomList<T> {
    /** Массив типа Т */
    private T[] array;

    /** Размер массива */
    private int size;

    /** Вместимость массива по умолчанию*/
    private int capacity = 10;

    /**
     * Конструктор - создание нового объекта CustomArrayList с определенным значением capacity
     * @param capacity вместимость массива
     * @throws IllegalArgumentException если размер будущего CustomArrayList <= 0
     */
    public CustomArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The size of the list cannot be <= 0");
        } else {
            this.capacity = capacity;
            array = (T[]) new Object[capacity];
        }
    }

    /**
     * Конструктор - создание нового объекта CustomArrayList без параметров
     */
    public CustomArrayList() {
        array = (T[]) new Object[capacity];
    }

    /**
     * Метод для добавления элемента в коллекцию
     * @param elem элемент, который необходимо добавить
     */
    @Override
    public void add(T elem) {
        if (size == capacity) {
            resize();
        }
        array[size++] = elem;
    }

    /**
     * Метод для добавления элемента в коллекцию по индексу
     * @param index место в коллекции, на которое необходимо поместить элемент
     * @param elem элемент, который необходимо добавить
     * @throws IndexOutOfBoundsException если индекс элемента больше размера списка
     */
    @Override
    public void add(int index, T elem) {
        if (size == capacity) {
            resize();
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("It is not possible to add an element. Index: " + index + ", Size: " + size);
        }
        for (int i = size; i > index ; i--) {
            array[i] = array[i - 1];
        }

        array[index] = elem;
        size++;
    }

    /**
     * Метод для получения элемента по индексу
     * @param index индекс элемента, который необходимо получить
     * @return возвращает элемент по запрашиваемому индексу
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Метод для удаления элемента по индексу
     * @param index индекс элемента, который необходимо удалить
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    /**
     * Метод для удаления элемента по значению
     * @param elem элемент, который необходимо удалить
     * @throws IndexOutOfBoundsException если индекс элемента не был найден
     */
    @Override
    public void remove(T elem) {
        int index = getIndex(elem);
        if (index < 0) {
            throw new IndexOutOfBoundsException("The index of the element was not found");
        } else {
            remove(index);
        }
    }

    /**
     * Метод для сортировки массива
     * Если размер массива меньше вместимости, то вызывается приватный метод для обрезки массива
     * После производится сортировка с помощью Arrays.sort()
     */
    @Override
    public void sort() {
        if (size < capacity) {
            trimToSize();
        }
        Arrays.sort(array);
    }

    /**
     * Метод для очистки всей коллекции
     */
    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Метод для получения размера коллекции
     * @return возвращает размер коллекции
     */
    @Override
    public int size() {
        return this.size;
    }

    private void resize() {
        int newCapacity = capacity * 3 / 2 + 1;
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
        System.out.println("Capacity increased to " + newCapacity + " cells");
    }

    private int getIndex(T elem) {
        if (elem == null) {
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if (elem.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index > capacity - 1 || index > size - 1) {
            throw new IndexOutOfBoundsException("Invalid element index. Size: " + size + " Index: " + index);
        }
    }

    private void trimToSize() {
        int newCapacity = size;
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }

    /**
     * Переопределенный метод для вывода элементов массива на экран
     * @return возвращает строку с элементами списка
     */
    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        for (T elem : array) {
            if (elem != null) {
                elements.append(elem).append(", ");
            }
        }

        if (elements.length() > 2) {
            return "CustomArrayList: [" + elements.substring(0, elements.length() - 2) + "]";
        } else {
            return "CustomArrayList: [" + elements.substring(0, elements.length()) + "]";
        }
    }
}
