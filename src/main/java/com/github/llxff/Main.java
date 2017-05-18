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

    public Item(T subject) { }

    // ��������� ������� ������
    public T getSubject() { return null; }
    // ��������� ���������� ��������
    public Item getNext() { return null; }
    // ����� ��������� ���� ��������� ��� �������������� ������
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

// ����� ���������� �������
class Queue<T> {
  private T[] items;

  public void enqueue(T item) {}
  public T dequeue() { return null; }
  public boolean isEmpty() { return false; }
}

// ����� ��� ���������� ����������
class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;

  // ������ ���������
  private OrderedLinkedList<Process> processes;

  // �������� ���������
  public static VirtualMachine load(String fileName) { return null; }

  // �������� ������ ��������
  public Process addProcess() { return null; }

  // ���������� ��������
  public void killProcess(int pid) {}

  // ���������� ���������
  public void save() {}

  public String getFileName() { return fileName; }
}

// ����� ��������
class Process {
  // ������������� ��������
  private int id;

  // ������������ ������� ������
  private Queue<MemoryPage> pages;

  // �����������
  public Process(int id) {}

  public int getId() { return id; }

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

  public int getNumber() { return number; }

  public String getStatus() { return status; }
}
