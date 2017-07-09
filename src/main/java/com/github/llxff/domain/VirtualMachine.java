package com.github.llxff.domain;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

// ����� ��� ����������/�������� ���������
public class VirtualMachine {
  // �������� �����, � ������� �������� ���������
  private String fileName;
  private XStream processor;

  public VirtualMachine(String fileName) {
    this.fileName = fileName;
    this.processor = new XStream();
    this.processor.alias("processes", ProcessesList.class);
    this.processor.alias("page", MemoryPage.class);
  }

  // �������� �������� �����, � ������� �������� ���������
  public String getFileName() {
    return this.fileName;
  }

  // ���������� ���������
  public void save(ProcessesList processes) throws FileNotFoundException {
    try(PrintStream ps = new PrintStream(this.fileName)) {
      ps.println(this.processor.toXML(processes));
    }
  }

  // �������� ���������
  public ProcessesList load() throws FileNotFoundException {
    return (ProcessesList) this.processor.fromXML(new File(this.fileName));
  }
}
