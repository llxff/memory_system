package com.github.llxff.domain;

// ����� ��� ����������/�������� ���������
public class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;

  public VirtualMachine(String fileName) {}

  // ���������� ���������
  public void save(ProcessesList processes) throws FileNotFoundException {}

  // �������� ���������
  public ProcessesList load() throws FileNotFoundException {}
}
