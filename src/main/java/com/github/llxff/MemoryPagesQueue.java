package com.github.llxff;

import java.util.ArrayList;

// Класс реализации очереди страниц памяти
public class MemoryPagesQueue {
  // Массив элементов
  private ArrayList<MemoryPage> pages;

  public MemoryPagesQueue() {
    this.pages = new ArrayList<>();
  }

  // Добавить элемент в очередь
  public void enqueue(MemoryPage page) {
    this.pages.add(page);
  }

  // Извлечь элемент из очереди
  public MemoryPage dequeue() {
    if(isEmpty()) return null;

    return this.pages.remove(0);
  }

  // Пустая ли очередь?
  public boolean isEmpty() {
    return this.pages.isEmpty();
  }

  // Получить размер очереди
  public int getLength() {
    return this.pages.size();
  }

  // Получить страницу памяти по индексу
  public MemoryPage get(int index) {
    if(isValidIndex(index)) {
      return this.pages.get(index);
    }
    else {
      return null;
    }
  }

  // Проверка, входит ли индекс в диапазон доступных элементов
  private boolean isValidIndex(int index) {
    return 0 <= index && index < this.pages.size();
  }

  // Удалить страницу памяти по индексу
  public void remove(int index) {
    if(isValidIndex(index)) this.pages.remove(index);
  }
}
