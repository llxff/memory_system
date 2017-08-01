package com.github.llxff.domain;

// ����� �������������� ����������������� ���������� ������, ���������� ��������
public class ProcessesList {
  // ����� �������� ������
  public class ListItem {
    // ��������������� ������ ������
    private Process process;
    // ��������� ������� ������
    private ListItem next;

    public ListItem(Process process) {}

    // ��������� ������� ������
    public Process getProcess() {}

    // ��������� ���������� ��������
    public ListItem getNext() {}

    // ���������� ��������� �������
    public void setNext(ListItem next) {}

    // ����� ��������� ���� ���������
    public boolean isSmallerThan(ListItem anotherItem) {}
  }

  // ������ ������� ������
  private ListItem headItem;
  // ���������� ���������
  private int length;

  public ProcessesList() {}

  // �������� ������ ������� ������
  public ListItem getHead() {}

  // ������ �� ������?
  public boolean isEmpty() {}

  // �������� ���������� ��������� � ������
  public int getLength() {}

  // �������� ������� � ������
  public void add(Process process) {}

  // ���������� �������� �������
  private void setHead(ListItem newHead) {}

  // ������ ������� ����� ��������� ����������
  private void addInTheMiddle(ListItem currentItem, ListItem newItem) {}

  // ������� ������� �� ������
  public void remove(int index) throws IndexOutOfBoundsException {}

  // �������� ������ ��������
  public int getIndex(Process process) {}

  // ������ �� ������ � �������� ��������� ���������
  private boolean isWrongIndex(int index) {}

  // �������� ������� �� �������
  public ListItem get(int index) {}
}
