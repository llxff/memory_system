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

    public Item(T subject) { }

    // получение объекта данных
    public T getSubject() { return null; }
    // получение следующего элемента
    public Item getNext() { return null; }
    // метод сравнения двух элементов для упорядочивания списка
    public int compareTo(Item subject) { return 0; }
  }

  private Item head;
  private int length;

  public Item getHead() { return null; }
  public boolean isEmpty() { return false; }
  public int getLength() { return length; }
  public void add(T item) {}
  public void remove(T item) {}
}

// Класс реализации очереди
class Queue<T> {
  private T[] items;

  public void enqueue(T item) {}
  public T dequeue() { return null; }
  public boolean isEmpty() { return false; }
}

// Класс для управления процессами
class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;

  // Список процессов
  private OrderedLinkedList<Process> processes;

  // Загрузка состояния
  public static VirtualMachine load(String fileName) { return null; }

  // Создание нового процесса
  public Process addProcess() { return null; }

  // Завершение процесса
  public void killProcess(int pid) {}

  // Сохранение состояния
  public void save() {}

  public String getFileName() { return fileName; }
}

// Класс процесса
class Process {
  // Идентификатор процесса
  private int id;

  // Используемые страниц памяти
  private Queue<MemoryPage> pages;

  // Конструктор
  public Process(int id) {}

  public int getId() { return id; }

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

  public int getNumber() { return number; }

  public String getStatus() { return status; }
}
