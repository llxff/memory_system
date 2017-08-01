package com.github.llxff.domain;

// Класс упорядоченного однонаправленного связанного списка, содержащий процессы
public class ProcessesList {
  // Класс элемента списка
  public class ListItem {
    // Непосредственно объект данных
    private Process process;
    // Следующий элемент списка
    private ListItem next;

    public ListItem(Process process) {}

    // Получение объекта данных
    public Process getProcess() {}

    // Получение следующего элемента
    public ListItem getNext() {}

    // Установить следующий элемент
    public void setNext(ListItem next) {}

    // Метод сравнения двух элементов
    public boolean isSmallerThan(ListItem anotherItem) {}
  }

  // Первый элемент списка
  private ListItem headItem;
  // Количество элементов
  private int length;

  public ProcessesList() {}

  // Получить первый элемент списка
  public ListItem getHead() {}

  // Пустой ли список?
  public boolean isEmpty() {}

  // Получить количество элементов в списке
  public int getLength() {}

  // Добавить элемент в список
  public void add(Process process) {}

  // Установить корневой элемент
  private void setHead(ListItem newHead) {}

  // Внести элемент между соседними элементами
  private void addInTheMiddle(ListItem currentItem, ListItem newItem) {}

  // Удалить элемент из списка
  public void remove(int index) throws IndexOutOfBoundsException {}

  // Получить индекс процесса
  public int getIndex(Process process) {}

  // Входит ли индекс в диапазон доступных элементов
  private boolean isWrongIndex(int index) {}

  // Получить элемент по индексу
  public ListItem get(int index) {}
}
