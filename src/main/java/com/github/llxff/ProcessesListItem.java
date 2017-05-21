package com.github.llxff;

// Класс элемента списка
public class ProcessesListItem {
  // Непосредственно объект данных
  private Process process;
  // Следующий элемент списка
  private ProcessesListItem next;

  public ProcessesListItem(Process process) {
    this.process = process;
    this.next = null;
  }

  // Получение объекта данных
  public Process getProcess() {
    return this.process;
  }

  // Получение следующего элемента
  public ProcessesListItem getNext() {
    return this.next;
  }

  // Установить следующий элемент
  public void setNext(ProcessesListItem next) {
    this.next = next;
  }

  // Метод сравнения двух элементов
  public boolean isSmallerThan(ProcessesListItem anotherItem) {
    return Integer.compare(process.getId(), anotherItem.getProcess().getId()) < 1;
  }
}
