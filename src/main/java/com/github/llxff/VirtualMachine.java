package com.github.llxff;

import java.io.File;

// ����� ��� ����������/�������� ���������
public class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;

  public VirtualMachine(String fileName) {
    this.fileName = fileName;
  }

  // �������� �������� �����, � ������� �������� ���������
  public String getFileName() {
    return this.fileName;
  }
  // ���������� ���������
  public void save(ProcessesList processes) {

  }
  // �������� ���������
  public ProcessesList load() {
    return null;
  }
}
