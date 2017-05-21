package com.github.llxff;

// Класс упорядоченного однонаправленного связанного списка, содержащий процессы
public class ProcessesList {
  // Первый элемент списка
  private ProcessesListItem headProcess;
  // Количество элементов
  private int length;

  public ProcessesList() {
    this.length = 0;
    this.headProcess = null;
  }

  // Получить первый элемент списка
  public ProcessesListItem getHead() {
    return this.headProcess;
  }

  // Пустой ли список?
  public boolean isEmpty() {
    return this.headProcess == null;
  }

  // Получить количество элементов в списке
  public int getLength() {
    return this.length;
  }

  // Добавить элемент в список
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

  // Удалить элемент из списка
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
