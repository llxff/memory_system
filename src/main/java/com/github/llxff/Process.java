package com.github.llxff;

// ����� ��������
public class Process {
  // ������������� ��������
  private int id;
  // ������������ ������� ������
  private MemoryPagesQueue pages;

  // �����������
  public Process(int id) {}

  // �������� ������������� ��������
  public int getId() { return 0; }
  // ���������� ����� �������� ������ ��������
  public void addMemoryPage(MemoryPage page) {}
  // �������� �������� ������ ��������
  public void removeMemoryPage(int index) {}
}
