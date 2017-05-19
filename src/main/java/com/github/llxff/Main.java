package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

// Класс упорядоченного однонаправленного связанного списка, содержащий объекты типа T
class OrderedLinkedList<T> {
  // Класс элемента списка
  class Item {
    // Непосредственно объект данных
    private T subject;
    // Следующий элемент списка
    private Item next;

    public Item(T subject) {}

    // получение объекта данных
    public T getSubject() {}
    // получение следующего элемента
    public Item getNext() {}
    // метод сравнения двух элементов для упорядочивания списка
    public int compareTo(Item subject) {}
  }

  // Первый элемент списка
  private Item head;
  // Количество элементов
  private int length;

  // Получить первый элемент списка
  public Item getHead() {}
  // Пустой ли список?
  public boolean isEmpty() {}
  // Получить количество элементов в списке
  public int getLength() {}
  // Добавить элемент в список
  public void add(T item) {}
  // Удалить элемент из списка
  public void remove(int index) {}
}

// Класс реализации очереди
class Queue<T> {
  // Массив элементов
  private T[] items;

  // Добавить элемент в очередь
  public void enqueue(T item) {}
  // Извлечь элемент из очереди
  public T dequeue() {}
  // Пустая ли очередь?
  public boolean isEmpty() {}
}

// Класс для управления процессами
class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;

  // Список процессов
  private OrderedLinkedList<Process> processes;

  // Загрузка состояния
  public static VirtualMachine load(String fileName) {}

  // Создание нового процесса
  public Process addProcess() {}

  // Завершение процесса
  public void killProcess(int pid) {}

  // Сохранение состояния
  public void save() {}

  // Получить название файла, в котором хранится состояние
  public String getFileName() {}
}

// Класс процесса
class Process {
  // Идентификатор процесса
  private int id;

  // Используемые страниц памяти
  private Queue<MemoryPage> pages;

  // Конструктор
  public Process(int id) {}

  public int getId() {}

  // Добавление новой страницы памяти процессу
  public void addMemoryPage() {}

  // Удаление страницы памяти процесса
  public void removeMemoryPage() {}

  // Завершить процесс и высвободить память
  public void die() {}
}

// Класс страницы памяти
class MemoryPage {
  // Номер страницы
  private int number;

  // Статус
  private String status;

  // Конструктор
  public MemoryPage(int number) {}

  // Получить номер страницы
  public int getNumber() {}

  // Получить статус страницы
  public String getStatus() {}
}
