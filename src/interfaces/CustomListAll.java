package interfaces;
/**
 * Интерфейс для реализации дополнительных методов в собственном LinkedList
 * @param <T> объект любого типа
 */
public interface CustomListAll<T> extends CustomList<T>{
    /**
     * Метод для добавления элемента в начало коллекции
     * @param elem элемент, который необходимо добавить
     */
    void addFirst(T elem);

    /** Метод для получения первого элемента из коллекции
     * @return возвращает первый элемент из коллекции
     */
    T getFirst();

    /** Метод для получения последнего элемента из коллекции
     * @return возвращает последний элемент из коллекции
     */
    T getLast();

    /**
     * Метод для удаления первого элемента из коллекции
     */
    void removeFirst();

    /**
     * Метод для удаления последнего элемента из коллекции
     */
    void removeLast();
}
