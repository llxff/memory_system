package com.github.llxff.domain;

// Класс реализации очереди страниц памяти
public class MemoryPagesQueue {
  // Страницы памяти
  private MemoryPage[] pages;
  // Максимальный размер очереди
  private int capacity;
  // Количество элементов
  private int length;

  public MemoryPagesQueue(int capacity) {
    this.pages = new MemoryPage[capacity];
    this.capacity = capacity;
    this.length = 0;
  }

  // Добавить элемент в очередь
  public void enqueue(MemoryPage page) throws IllegalStateException {
    if(isFull()) throw new IllegalStateException("Queue is full");

    this.pages[this.length++] = page;
  }

  // Извлечь элемент из очереди
  public MemoryPage dequeue() throws IllegalStateException {
    if(isEmpty()) throw new IllegalStateException("Queue is empty");

    MemoryPage page = this.pages[0];

    shiftPages();

    this.length--;

    return page;
  }

  // Сдвинуть элементы влево
  private void shiftPages() {
    for(int i = 1; i < this.capacity; i++) {
      if(i < this.length) {
        this.pages[i-1] = this.pages[i];
      }
      else {
        this.pages[i-1] = null;
      }
    }
  }

  // Пустая ли очередь?
  public boolean isEmpty() {
    return this.length == 0;
  }

  // Полная ли очередь?
  public boolean isFull() {
    return this.length == this.capacity;
  }

  // Получить размер очереди
  public int getLength() {
    return this.length;
  }

  public MemoryPage[] getPages() {
    return this.pages;
  }
}
