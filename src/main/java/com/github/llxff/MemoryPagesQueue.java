package com.github.llxff;

// ����� ���������� ������� ������� ������
public class MemoryPagesQueue {
  // ������ ���������
  private MemoryPage[] pages;

  // �������� ������� � �������
  public void enqueue(MemoryPage page) {}
  // ������� ������� �� �������
  public MemoryPage dequeue() { return null; }
  // ������ �� �������?
  public boolean isEmpty() { return false; }
  // �������� ������ �������
  public int getLength() { return 0; }
  // �������� �������� ������ �� �������
  public MemoryPage get(int index) { return null; }
  // ������� �������� ������ �� �������
  public void remove(int index) {}
}
