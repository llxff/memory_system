package com.github.llxff.domain;

// ����� ���������� ������� ������� ������
public class MemoryPagesQueue {
  // �������� ������
  private MemoryPage[] pages;
  // ������������ ������ �������
  private int capacity;
  // ���������� ���������
  private int length;

  public MemoryPagesQueue(int capacity) {
    this.pages = new MemoryPage[capacity];
    this.capacity = capacity;
    this.length = 0;
  }

  // �������� ������� � �������
  public void enqueue(MemoryPage page) throws IllegalStateException {
    if(isFull()) throw new IllegalStateException("Queue is full");

    this.pages[this.length++] = page;
  }

  // ������� ������� �� �������
  public MemoryPage dequeue() throws IllegalStateException {
    if(isEmpty()) throw new IllegalStateException("Queue is empty");

    MemoryPage page = this.pages[0];

    shiftPages();

    this.length--;

    return page;
  }

  // �������� �������� �����
  private void shiftPages() {
    for(int i = 1; i < this.capacity; i++) {
      if(i < this.length) {
        this.pages[i-1] = this.pages[i];
      }
      else {
        this.pages[i-1] = null;
      }
    }
  }

  // ������ �� �������?
  public boolean isEmpty() {
    return this.length == 0;
  }

  // ������ �� �������?
  public boolean isFull() {
    return this.length == this.capacity;
  }

  // �������� ������ �������
  public int getLength() {
    return this.length;
  }

  public MemoryPage[] getPages() {
    return this.pages;
  }
}
