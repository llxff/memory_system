package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

// ����� �������������� ����������������� ���������� ������, ���������� ������� ���� T
class OrderedLinkedList<T> {
  // ����� �������� ������
  class Item {
    // ��������������� ������ ������
    private T subject;
    // ��������� ������� ������
    private Item next;

    public Item(T subject) {}

    // ��������� ������� ������
    public T getSubject() {}
    // ��������� ���������� ��������
    public Item getNext() {}
    // ����� ��������� ���� ��������� ��� �������������� ������
    public int compareTo(Item subject) {}
  }

  // ������ ������� ������
  private Item head;
  // ���������� ���������
  private int length;

  // �������� ������ ������� ������
  public Item getHead() {}
  // ������ �� ������?
  public boolean isEmpty() {}
  // �������� ���������� ��������� � ������
  public int getLength() {}
  // �������� ������� � ������
  public void add(T item) {}
  // ������� ������� �� ������
  public void remove(int index) {}
}

// ����� ���������� �������
class Queue<T> {
  // ������ ���������
  private T[] items;

  // �������� ������� � �������
  public void enqueue(T item) {}
  // ������� ������� �� �������
  public T dequeue() {}
  // ������ �� �������?
  public boolean isEmpty() {}
}

// ����� ��� ���������� ����������
class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;

  // ������ ���������
  private OrderedLinkedList<Process> processes;

  // �������� ���������
  public static VirtualMachine load(String fileName) {}

  // �������� ������ ��������
  public Process addProcess() {}

  // ���������� ��������
  public void killProcess(int pid) {}

  // ���������� ���������
  public void save() {}

  // �������� �������� �����, � ������� �������� ���������
  public String getFileName() {}
}

// ����� ��������
class Process {
  // ������������� ��������
  private int id;

  // ������������ ������� ������
  private Queue<MemoryPage> pages;

  // �����������
  public Process(int id) {}

  public int getId() {}

  // ���������� ����� �������� ������ ��������
  public void addMemoryPage() {}

  // �������� �������� ������ ��������
  public void removeMemoryPage() {}

  // ��������� ������� � ����������� ������
  public void die() {}
}

// ����� �������� ������
class MemoryPage {
  // ����� ��������
  private int number;

  // ������
  private String status;

  // �����������
  public MemoryPage(int number) {}

  // �������� ����� ��������
  public int getNumber() {}

  // �������� ������ ��������
  public String getStatus() {}
}
