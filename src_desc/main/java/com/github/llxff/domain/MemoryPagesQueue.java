package com.github.llxff.domain;

// Класс реализации очереди страниц памяти
public class MemoryPagesQueue {
  // Страницы памяти
  private MemoryPage[] pages;
  // Максимальный размер очереди
  private int capacity;
  // Количество элементов
  private int length;

  public MemoryPagesQueue(int capacity) {}

  // Добавить элемент в очередь
  public void enqueue(MemoryPage page) throws IllegalStateException {}

  // Извлечь элемент из очереди
  public MemoryPage dequeue() throws IllegalStateException {}

  // Сдвинуть элементы влево
  private void shiftPages() {}

  // Пустая ли очередь?
  public boolean isEmpty() {}

  // Полная ли очередь?
  public boolean isFull() {}

  // Получить размер очереди
  public int getLength() {}

  // Получить элементы очереди
  public MemoryPage[] getPages() {}
}
