package com.github.llxff.domain;

// ����� ��������
public class Process {
  // ������������� ��������
  private int id;
  // ������������ ������� ������
  private MemoryPagesQueue pages;

  // �����������
  public Process(int id) {}

  // �������� ������������� ��������
  public int getId() {}

  // ���������� ����� �������� ������ ��������
  public void addMemoryPage(MemoryPage page) throws IllegalStateException {}

  // ��������� �������� ������ ��������
  public MemoryPage retrieveMemoryPage() throws IllegalStateException {}

  // �������� �������� ������ ��������
  public MemoryPage[] getPages() {}

  // �������� ���������� ������� ������ ��������
  public int getPagesCount() {}
}
