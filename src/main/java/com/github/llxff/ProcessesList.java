package com.github.llxff;

// ����� �������������� ����������������� ���������� ������, ���������� ��������
public class ProcessesList {
  // ������ ������� ������
  private ProcessesListItem headProcess;
  // ���������� ���������
  private int length;

  public ProcessesList() {
    this.length = 0;
    this.headProcess = null;
  }

  // �������� ������ ������� ������
  public ProcessesListItem getHead() {
    return this.headProcess;
  }

  // ������ �� ������?
  public boolean isEmpty() {
    return this.headProcess == null;
  }

  // �������� ���������� ��������� � ������
  public int getLength() {
    return this.length;
  }

  // �������� ������� � ������
  public void add(Process process) {
    ProcessesListItem newItem = new ProcessesListItem(process);

    if(isEmpty()) {
      this.headProcess = newItem;
    }
    else {
      ProcessesListItem parent = getHead();
      ProcessesListItem next = parent.getNext();

      while(parent.isSmallerThan(newItem)) {
      }
    }

    this.length++;
  }

  // ������� ������� �� ������
  public void remove(int index) {
    if(indexIsInvalid(index)) return;

    if (index == 0) {
      this.headProcess = this.headProcess.getNext();
    }
    else {
      ProcessesListItem parent = get(index - 1);
      ProcessesListItem itemForRemove = parent.getNext();

      parent.setNext(itemForRemove.getNext());
    }

    this.length--;
  }

  private boolean indexIsInvalid(int index) {
    return index < 0 || index >= getLength();
  }

  public ProcessesListItem get(int index) {
    if(indexIsInvalid(index)) return null;

    int iterations = 0;
    ProcessesListItem currentItem = getHead();

    while(iterations < index) {
      iterations++;
      currentItem = currentItem.getNext();
    }

    return currentItem;
  }
}
