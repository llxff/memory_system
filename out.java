package com.github.llxff;

import com.thoughtworks.xstream.XStream;
import java.io.*;

// Класс страницы памяти
public class MemoryPage {
  // Номер страницы
  private int number;
  // Статус
  private String status;

  // Конструктор
  public MemoryPage(int number, String status) {
    this.number = number;
    this.status = status;
  }

  // Получить номер страницы
  public int getNumber() {
    return this.number;
  }

  // Получить статус страницы
  public String getStatus() {
    return this.status;
  }
}

// Класс реализации очереди страниц памяти
public class MemoryPagesQueue {
  // Страницы памяти
  private MemoryPage[] pages;
  // Максимальный очереди
  private int capacity;
  // Индекс последнего добавленного элемента
  private int begins;
  // Индекс последнего выкинутого элемента
  private int ends;
  // Количество элементов
  private int length;

  public MemoryPagesQueue(int capacity) {
    this.pages = new MemoryPage[capacity];
    this.capacity = capacity;
    this.length = 0;
    this.begins = -1;
    this.ends = -1;
  }

  // Добавить элемент в очередь
  public void enqueue(MemoryPage page) {
    if(isFull()) return;

    this.pages[++this.begins] = page;
    this.length++;
  }

  // Извлечь элемент из очереди
  public MemoryPage dequeue() {
    if(isEmpty()) return null;

    this.length--;
    return this.pages[++this.ends];
  }

  // Пустая ли очередь?
  public boolean isEmpty() {
    return this.length == 0;
  }

  // Полная ли очередь?
  public boolean isFull() {
    return this.begins == (capacity - 1);
  }

  // Получить размер очереди
  public int getLength() {
    return this.length;
  }
}

// Класс процесса
public class Process {
  // Идентификатор процесса
  private int id;
  // Используемые страниц памяти
  private MemoryPagesQueue pages;

  // Конструктор
  public Process(int id) {
    this.id = id;
    this.pages = new MemoryPagesQueue(6);
  }

  // Получить идентификатор процесса
  public int getId() {
    return this.id;
  }

  // Добавление новой страницы памяти процессу
  public void addMemoryPage(MemoryPage page) {
    this.pages.enqueue(page);
  }

  // Получение страницы памяти процесса
  public MemoryPage retrieveMemoryPage() {
    return this.pages.dequeue();
  }
}

// Класс упорядоченного однонаправленного связанного списка, содержащий процессы
public class ProcessesList {
  // Класс элемента списка
  class ListItem {
    // Непосредственно объект данных
    private Process process;
    // Следующий элемент списка
    private ListItem next;

    public ListItem(Process process) {
      this.process = process;
      this.next = null;
    }

    // Получение объекта данных
    public Process getProcess() {
      return this.process;
    }

    // Получение следующего элемента
    public ListItem getNext() {
      return this.next;
    }

    // Установить следующий элемент
    public void setNext(ListItem next) {
      this.next = next;
    }

    // Метод сравнения двух элементов
    public boolean isSmallerThan(ListItem anotherItem) {
      return Integer.compare(process.getId(), anotherItem.getProcess().getId()) < 1;
    }
  }

  // Первый элемент списка
  private ListItem headItem;
  // Количество элементов
  private int length;

  public ProcessesList() {
    this.headItem = null;
    this.length = 0;
  }

  // Получить первый элемент списка
  public ListItem getHead() {
    return this.headItem;
  }

  // Пустой ли список?
  public boolean isEmpty() {
    return this.headItem == null;
  }

  // Получить количество элементов в списке
  public int getLength() {
    return this.length;
  }

  // Добавить элемент в список
  public void add(Process process) {
    ListItem newItem = new ListItem(process);

    if(isEmpty()) {
      setHead(newItem);
    }
    else if (newItem.isSmallerThan(this.headItem)) {
      newItem.setNext(getHead());
      setHead(newItem);
    }
    else {
      addInTheMiddle(getHead(), newItem);
    }

    this.length++;
  }

  // Установить корневой элемент
  private void setHead(ListItem newHead) {
    this.headItem = newHead;
  }

  // Внести элемент между соседними элементами
  private void addInTheMiddle(ListItem currentItem, ListItem newItem) {
    if (currentItem.getNext() == null) {
      currentItem.setNext(newItem);
    }
    else if(newItem.isSmallerThan(currentItem.getNext())) {
      newItem.setNext(currentItem.getNext());
      currentItem.setNext(newItem);
    }
    else {
      addInTheMiddle(currentItem.getNext(), newItem);
    }
  }

  // Удалить элемент из списка
  public void remove(int index) {
    if(isWrongIndex(index)) return;

    if (index == 0) {
      setHead(getHead().getNext());
    }
    else {
      ListItem parent = get(index - 1);
      ListItem itemForRemove = parent.getNext();

      parent.setNext(itemForRemove.getNext());
    }

    this.length--;
  }

  // Входит ли индекс в диапазон доступных элементов
  private boolean isWrongIndex(int index) {
    return index < 0 || index >= getLength();
  }

  // Получить элемент по индексу
  public ListItem get(int index) {
    if(isWrongIndex(index)) return null;

    int iterations = 0;
    ListItem currentItem = getHead();

    while(iterations < index) {
      currentItem = currentItem.getNext();
      iterations++;
    }

    return currentItem;
  }
}

// Класс для сохранения/загрузки процессов
public class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;
  private XStream processor;

  public VirtualMachine(String fileName) {
    this.fileName = fileName;
    this.processor = new XStream();
    this.processor.alias("processes", ProcessesList.class);
    this.processor.alias("page", MemoryPage.class);
  }

  // Получить название файла, в котором хранится состояние
  public String getFileName() {
    return this.fileName;
  }

  // Сохранение процессов
  public void save(ProcessesList processes) throws FileNotFoundException {
    try(PrintStream ps = new PrintStream(this.fileName)) {
      ps.println(this.processor.toXML(processes));
    }
  }

  // Загрузка процессов
  public ProcessesList load() {
    return (ProcessesList) this.processor.fromXML(new File(this.fileName));
  }
}