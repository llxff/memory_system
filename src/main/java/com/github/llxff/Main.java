package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

// Класс упорядоченного однонаправленного связанного списка, содержащий процессы
class ProcessesList {
  // Класс элемента списка
  class ProcessItem {
    // Непосредственно объект данных
    private Process process;
    // Следующий элемент списка
    private ProcessItem next;

    public ProcessItem(Process process) {}

    // Получение объекта данных
    public Process getProcess() {}
    // Получение следующего элемента
    public ProcessItem getNext() {}
    // Установить следующий элемент
    public void setNext(ProcessItem next) {}
    // Метод сравнения двух элементов для упорядочивания списка
    public int compareTo(Process process) {}
  }

  // Первый элемент списка
  private Process headProcess;
  // Количество элементов
  private int length;

  // Получить первый элемент списка
  public ProcessItem getHead() {}
  // Пустой ли список?
  public boolean isEmpty() {}
  // Получить количество элементов в списке
  public int getLength() {}
  // Добавить элемент в список
  public void add(Process process) {}
  // Удалить элемент из списка
  public void remove(int index) {}
}

// Класс процесса
class Process {
  // Идентификатор процесса
  private int id;
  // Используемые страниц памяти
  private MemoryPagesQueue pages;

  // Конструктор
  public Process(int id) {}

  // Получить идентификатор процесса
  public int getId() {}
  // Добавление новой страницы памяти процессу
  public void addMemoryPage(MemoryPage page) {}
  // Удаление страницы памяти процесса
  public void removeMemoryPage(int index) {}
}

// Класс реализации очереди страниц памяти
class MemoryPagesQueue {
  // Массив элементов
  private MemoryPage[] pages;

  // Добавить элемент в очередь
  public void enqueue(MemoryPage page) {}
  // Извлечь элемент из очереди
  public MemoryPage dequeue() {}
  // Пустая ли очередь?
  public boolean isEmpty() {}
  // Получить размер очереди
  public int getLength() {}
  // Получить страницу памяти по индексу
  public MemoryPage get(int index) {}
  // Удалить страницу памяти по индексу
  public void remove(int index) {}
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

// Класс для сохранения/загрузки процессов
class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;

  public VirtualMachine(String fileName) {}

  // Получить название файла, в котором хранится состояние
  public String getFileName() {}
  // Сохранение процессов
  public void save(ProcessesList processes) {}
  // Загрузка процессов
  public ProcessesList load() {}
}
