package com.github.llxff;

import com.thoughtworks.xstream.XStream;
import java.io.*;

// ����� �������� ������
public class MemoryPage {
  // ����� ��������
  private int number;
  // ������
  private String status;

  // �����������
  public MemoryPage(int number, String status) {
    this.number = number;
    this.status = status;
  }

  // �������� ����� ��������
  public int getNumber() {
    return this.number;
  }

  // �������� ������ ��������
  public String getStatus() {
    return this.status;
  }
}

// ����� ���������� ������� ������� ������
public class MemoryPagesQueue {
  // �������� ������
  private MemoryPage[] pages;
  // ������������ �������
  private int capacity;
  // ������ ���������� ������������ ��������
  private int begins;
  // ������ ���������� ���������� ��������
  private int ends;
  // ���������� ���������
  private int length;

  public MemoryPagesQueue(int capacity) {
    this.pages = new MemoryPage[capacity];
    this.capacity = capacity;
    this.length = 0;
    this.begins = -1;
    this.ends = -1;
  }

  // �������� ������� � �������
  public void enqueue(MemoryPage page) {
    if(isFull()) return;

    this.pages[++this.begins] = page;
    this.length++;
  }

  // ������� ������� �� �������
  public MemoryPage dequeue() {
    if(isEmpty()) return null;

    this.length--;
    return this.pages[++this.ends];
  }

  // ������ �� �������?
  public boolean isEmpty() {
    return this.length == 0;
  }

  // ������ �� �������?
  public boolean isFull() {
    return this.begins == (capacity - 1);
  }

  // �������� ������ �������
  public int getLength() {
    return this.length;
  }
}

// ����� ��������
public class Process {
  // ������������� ��������
  private int id;
  // ������������ ������� ������
  private MemoryPagesQueue pages;

  // �����������
  public Process(int id) {
    this.id = id;
    this.pages = new MemoryPagesQueue(6);
  }

  // �������� ������������� ��������
  public int getId() {
    return this.id;
  }

  // ���������� ����� �������� ������ ��������
  public void addMemoryPage(MemoryPage page) {
    this.pages.enqueue(page);
  }

  // ��������� �������� ������ ��������
  public MemoryPage retrieveMemoryPage() {
    return this.pages.dequeue();
  }
}

// ����� �������������� ����������������� ���������� ������, ���������� ��������
public class ProcessesList {
  // ����� �������� ������
  class ListItem {
    // ��������������� ������ ������
    private Process process;
    // ��������� ������� ������
    private ListItem next;

    public ListItem(Process process) {
      this.process = process;
      this.next = null;
    }

    // ��������� ������� ������
    public Process getProcess() {
      return this.process;
    }

    // ��������� ���������� ��������
    public ListItem getNext() {
      return this.next;
    }

    // ���������� ��������� �������
    public void setNext(ListItem next) {
      this.next = next;
    }

    // ����� ��������� ���� ���������
    public boolean isSmallerThan(ListItem anotherItem) {
      return Integer.compare(process.getId(), anotherItem.getProcess().getId()) < 1;
    }
  }

  // ������ ������� ������
  private ListItem headItem;
  // ���������� ���������
  private int length;

  public ProcessesList() {
    this.headItem = null;
    this.length = 0;
  }

  // �������� ������ ������� ������
  public ListItem getHead() {
    return this.headItem;
  }

  // ������ �� ������?
  public boolean isEmpty() {
    return this.headItem == null;
  }

  // �������� ���������� ��������� � ������
  public int getLength() {
    return this.length;
  }

  // �������� ������� � ������
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

  // ���������� �������� �������
  private void setHead(ListItem newHead) {
    this.headItem = newHead;
  }

  // ������ ������� ����� ��������� ����������
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

  // ������� ������� �� ������
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

  // ������ �� ������ � �������� ��������� ���������
  private boolean isWrongIndex(int index) {
    return index < 0 || index >= getLength();
  }

  // �������� ������� �� �������
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

// ����� ��� ����������/�������� ���������
public class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;
  private XStream processor;

  public VirtualMachine(String fileName) {
    this.fileName = fileName;
    this.processor = new XStream();
    this.processor.alias("processes", ProcessesList.class);
    this.processor.alias("page", MemoryPage.class);
  }

  // �������� �������� �����, � ������� �������� ���������
  public String getFileName() {
    return this.fileName;
  }

  // ���������� ���������
  public void save(ProcessesList processes) throws FileNotFoundException {
    try(PrintStream ps = new PrintStream(this.fileName)) {
      ps.println(this.processor.toXML(processes));
    }
  }

  // �������� ���������
  public ProcessesList load() {
    return (ProcessesList) this.processor.fromXML(new File(this.fileName));
  }
}