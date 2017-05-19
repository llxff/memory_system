package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

// ����� �������������� ����������������� ���������� ������, ���������� ��������
class ProcessesList {
  // ����� �������� ������
  class ProcessItem {
    // ��������������� ������ ������
    private Process process;
    // ��������� ������� ������
    private ProcessItem next;

    public ProcessItem(Process process) {}

    // ��������� ������� ������
    public Process getProcess() {}
    // ��������� ���������� ��������
    public ProcessItem getNext() {}
    // ���������� ��������� �������
    public void setNext(ProcessItem next) {}
    // ����� ��������� ���� ��������� ��� �������������� ������
    public int compareTo(Process process) {}
  }

  // ������ ������� ������
  private Process headProcess;
  // ���������� ���������
  private int length;

  // �������� ������ ������� ������
  public ProcessItem getHead() {}
  // ������ �� ������?
  public boolean isEmpty() {}
  // �������� ���������� ��������� � ������
  public int getLength() {}
  // �������� ������� � ������
  public void add(Process process) {}
  // ������� ������� �� ������
  public void remove(int index) {}
}

// ����� ��������
class Process {
  // ������������� ��������
  private int id;
  // ������������ ������� ������
  private MemoryPagesQueue pages;

  // �����������
  public Process(int id) {}

  // �������� ������������� ��������
  public int getId() {}
  // ���������� ����� �������� ������ ��������
  public void addMemoryPage(MemoryPage page) {}
  // �������� �������� ������ ��������
  public void removeMemoryPage(int index) {}
}

// ����� ���������� ������� ������� ������
class MemoryPagesQueue {
  // ������ ���������
  private MemoryPage[] pages;

  // �������� ������� � �������
  public void enqueue(MemoryPage page) {}
  // ������� ������� �� �������
  public MemoryPage dequeue() {}
  // ������ �� �������?
  public boolean isEmpty() {}
  // �������� ������ �������
  public int getLength() {}
  // �������� �������� ������ �� �������
  public MemoryPage get(int index) {}
  // ������� �������� ������ �� �������
  public void remove(int index) {}
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

// ����� ��� ����������/�������� ���������
class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;

  public VirtualMachine(String fileName) {}

  // �������� �������� �����, � ������� �������� ���������
  public String getFileName() {}
  // ���������� ���������
  public void save(ProcessesList processes) {}
  // �������� ���������
  public ProcessesList load() {}
}
