package com.github.llxff;

import java.util.ArrayList;

// ����� ���������� ������� ������� ������
public class MemoryPagesQueue {
  // ������ ���������
  private ArrayList<MemoryPage> pages;

  public MemoryPagesQueue() {
    this.pages = new ArrayList<>();
  }

  // �������� ������� � �������
  public void enqueue(MemoryPage page) {
    this.pages.add(page);
  }

  // ������� ������� �� �������
  public MemoryPage dequeue() {
    if(isEmpty()) return null;

    return this.pages.remove(0);
  }

  // ������ �� �������?
  public boolean isEmpty() {
    return this.pages.isEmpty();
  }

  // �������� ������ �������
  public int getLength() {
    return this.pages.size();
  }

  // �������� �������� ������ �� �������
  public MemoryPage get(int index) {
    if(isValidIndex(index)) {
      return this.pages.get(index);
    }
    else {
      return null;
    }
  }

  // ��������, ������ �� ������ � �������� ��������� ���������
  private boolean isValidIndex(int index) {
    return 0 <= index && index < this.pages.size();
  }

  // ������� �������� ������ �� �������
  public void remove(int index) {
    if(isValidIndex(index)) this.pages.remove(index);
  }
}
