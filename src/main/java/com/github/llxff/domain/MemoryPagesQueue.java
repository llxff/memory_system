package com.github.llxff.domain;

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

  public MemoryPage[] getPages() {
    return this.pages;
  }
}
