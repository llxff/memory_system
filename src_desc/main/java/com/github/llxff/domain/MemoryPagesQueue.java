package com.github.llxff.domain;

// ����� ���������� ������� ������� ������
public class MemoryPagesQueue {
  // �������� ������
  private MemoryPage[] pages;
  // ������������ ������ �������
  private int capacity;
  // ���������� ���������
  private int length;

  public MemoryPagesQueue(int capacity) {}

  // �������� ������� � �������
  public void enqueue(MemoryPage page) throws IllegalStateException {}

  // ������� ������� �� �������
  public MemoryPage dequeue() throws IllegalStateException {}

  // �������� �������� �����
  private void shiftPages() {}

  // ������ �� �������?
  public boolean isEmpty() {}

  // ������ �� �������?
  public boolean isFull() {}

  // �������� ������ �������
  public int getLength() {}

  // �������� �������� �������
  public MemoryPage[] getPages() {}
}
