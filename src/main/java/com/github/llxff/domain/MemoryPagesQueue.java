package com.github.llxff.domain;

// Класс реализации очереди страниц памяти
public class MemoryPagesQueue {
  // Страницы памяти
  private MemoryPage[] pages;
  // Максимальный очереди
  private int capacity;
  // Индекс последнего добавленного элемента
  private int begins;
  // Индекс последнего выкинутого элемента
  private int ends;
  // Количество элементов
  private int length;

  public MemoryPagesQueue(int capacity) {
    this.pages = new MemoryPage[capacity];
    this.capacity = capacity;
    this.length = 0;
    this.begins = -1;
    this.ends = -1;
  }

  // Добавить элемент в очередь
  public void enqueue(MemoryPage page) {
    if(isFull()) return;

    this.pages[++this.begins] = page;
    this.length++;
  }

  // Извлечь элемент из очереди
  public MemoryPage dequeue() {
    if(isEmpty()) return null;

    this.length--;
    return this.pages[++this.ends];
  }

  // Пустая ли очередь?
  public boolean isEmpty() {
    return this.length == 0;
  }

  // Полная ли очередь?
  public boolean isFull() {
    return this.begins == (capacity - 1);
  }

  // Получить размер очереди
  public int getLength() {
    return this.length;
  }

  public MemoryPage[] getPages() {
    return this.pages;
  }
}
