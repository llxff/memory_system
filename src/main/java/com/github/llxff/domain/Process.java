package com.github.llxff.domain;

// ����� ��������
public class Process {
  // ������������� ��������
  private int id;
  // ������������ ������� ������
  private MemoryPagesQueue pages;

  // �����������
  public Process(int id) {
    this.id = id;
    this.pages = new MemoryPagesQueue(6);
  }

  // �������� ������������� ��������
  public int getId() {
    return this.id;
  }

  // ���������� ����� �������� ������ ��������
  public void addMemoryPage(MemoryPage page) {
    this.pages.enqueue(page);
  }

  // ��������� �������� ������ ��������
  public MemoryPage retrieveMemoryPage() {
    return this.pages.dequeue();
  }

  public MemoryPage[] getPages() {
    return this.pages.getPages();
  }

  public int getPagesCount() {
    return this.pages.getLength();
  }

  public String toString() {
    return String.format("������� �%d", getId());
  }
}