package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

// ����� ��� ���������� � �������� ��������� ��������� � ������
class MachineStorage {
  // �������� �����, � ������� �������� ���������
  private String filename;

  // �������� ���������
  public VirtualMachine load() {}
  // ���������� ���������
  public void save(VirtualMachine machine) {}
}

// ����� ��� ���������� ����������
class VirtualMachine {
  // ������ ���������
  private LinkedList<Process> processes;

  // ������ ��� ���������� �������
  private Memory memory;

  // �������� ������ ��������
  public Process add() {}
  // ���������� ��������
  public void kill(int pid) {}
}

// ����� ��������
class Process implements Serializable {
  // ������������� ��������
  private int id;

  // ������ ������������� ������� ������
  private ArrayList<MemoryPage> pages;

  // ������ ��� ���������� �������
  private Memory memory;

  // �����������
  public Process(int id, Memory memory) {}

  // ���������� ����� �������� ������ ��������
  public void addMoreMemory(int amount) {}

  // ��������� ������� � ����������� ������
  public void die() {}
}

// ����� ��� ���������� �������
class Memory implements Serializable {
  // ����� ������
  private int size;

  // ���������� ��������
  private ArrayList<MemoryPage> pages;

  // �����������
  public Memory(int size) {}

  // �������� ����� �������� ������
  public MemoryPage allocate() {}

  // ����������� ��������� ��������
  public void free(MemoryPage page) {}

  // �������������� ����� ������
  public int usedAmount() {}

  // ��������� ����� ������
  public int freeAmount() {}
}

// ����� �������� ������
class MemoryPage implements Serializable {
  // ����� ��������
  private int number;

  // ������
  private String status;

  // ������
  private int size;

  // �����������
  public MemoryPage(int number, int size) {}
}
