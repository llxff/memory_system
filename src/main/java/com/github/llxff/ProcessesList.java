package com.github.llxff;

// Класс упорядоченного однонаправленного связанного списка, содержащий процессы
public class ProcessesList {
  // Класс элемента списка
  class ListItem {
    // Непосредственно объект данных
    private Process process;
    // Следующий элемент списка
    private ListItem next;

    public ListItem(Process process) {
      this.process = process;
      this.next = null;
    }

    // Получение объекта данных
    public Process getProcess() {
      return this.process;
    }

    // Получение следующего элемента
    public ListItem getNext() {
      return this.next;
    }

    // Установить следующий элемент
    public void setNext(ListItem next) {
      this.next = next;
    }

    // Метод сравнения двух элементов
    public boolean isSmallerThan(ListItem anotherItem) {
      return Integer.compare(process.getId(), anotherItem.getProcess().getId()) < 1;
    }
  }

  // Первый элемент списка
  private ListItem headItem;
  // Количество элементов
  private int length;

  public ProcessesList() {
    this.headItem = null;
    this.length = 0;
  }

  // Получить первый элемент списка
  public ListItem getHead() {
    return this.headItem;
  }

  // Пустой ли список?
  public boolean isEmpty() {
    return this.headItem == null;
  }

  // Получить количество элементов в списке
  public int getLength() {
    return this.length;
  }

  // Добавить элемент в список
  public void add(Process process) {
    ListItem newItem = new ListItem(process);

    if(isEmpty()) {
      setHead(newItem);
    }
    else if (newItem.isSmallerThan(this.headItem)) {
      newItem.setNext(getHead());
      setHead(newItem);
    }
    else {
      addInTheMiddle(getHead(), newItem);
    }

    this.length++;
  }

  private void setHead(ListItem newHead) {
    this.headItem = newHead;
  }

  private void addInTheMiddle(ListItem currentItem, ListItem newItem) {
    if (currentItem.getNext() == null) {
      currentItem.setNext(newItem);
    }
    else if(newItem.isSmallerThan(currentItem.getNext())) {
      newItem.setNext(currentItem.getNext());
      currentItem.setNext(newItem);
    }
    else {
      addInTheMiddle(currentItem.getNext(), newItem);
    }
  }

  // Удалить элемент из списка
  public void remove(int index) {
    if(isWrongIndex(index)) return;

    if (index == 0) {
      setHead(getHead().getNext());
    }
    else {
      ListItem parent = get(index - 1);
      ListItem itemForRemove = parent.getNext();

      parent.setNext(itemForRemove.getNext());
    }

    this.length--;
  }

  private boolean isWrongIndex(int index) {
    return index < 0 || index >= getLength();
  }

  public ListItem get(int index) {
    if(isWrongIndex(index)) return null;

    int iterations = 0;
    ListItem currentItem = getHead();

    while(iterations < index) {
      currentItem = currentItem.getNext();
      iterations++;
    }

    return currentItem;
  }
}
