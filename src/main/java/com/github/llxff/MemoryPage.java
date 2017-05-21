package com.github.llxff;

// ����� �������� ������
public class MemoryPage {
  // ����� ��������
  private int number;
  // ������
  private String status;

  // �����������
  public MemoryPage(int number, String status) {
    this.number = number;
    this.status = status;
  }

  // �������� ����� ��������
  public int getNumber() {
    return this.number;
  }

  // �������� ������ ��������
  public String getStatus() {
    return this.status;
  }
}
