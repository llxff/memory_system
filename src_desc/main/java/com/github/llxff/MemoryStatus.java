package com.github.llxff;

// �������� �������� �������� ������
public enum MemoryStatus {
  ACTIVE("active", "�������"), DISABLED("disabled", "�� �������");

  // �������� ������������� �������
  public String getCode() {}

  // �������� �������� �������
  public String getText() {}

  // �������� ������ �� ����
  public static MemoryStatus getByCode(String code) {}

  // �������� ������ �� ��������
  public static MemoryStatus getByText(String text) {}
}