package com.github.llxff;

// ����� �������� ������
public class ProcessesListItem {
  // ��������������� ������ ������
  private Process process;
  // ��������� ������� ������
  private ProcessesListItem next;

  public ProcessesListItem(Process process) {
    this.process = process;
    this.next = null;
  }

  // ��������� ������� ������
  public Process getProcess() {
    return this.process;
  }

  // ��������� ���������� ��������
  public ProcessesListItem getNext() {
    return this.next;
  }

  // ���������� ��������� �������
  public void setNext(ProcessesListItem next) {
    this.next = next;
  }

  // ����� ��������� ���� ���������
  public boolean isSmallerThan(ProcessesListItem anotherItem) {
    return Integer.compare(process.getId(), anotherItem.getProcess().getId()) < 1;
  }
}
