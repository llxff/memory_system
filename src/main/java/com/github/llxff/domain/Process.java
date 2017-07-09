package com.github.llxff.domain;

// Класс процесса
public class Process {
  // Идентификатор процесса
  private int id;
  // Используемые страниц памяти
  private MemoryPagesQueue pages;

  // Конструктор
  public Process(int id) {
    this.id = id;
    this.pages = new MemoryPagesQueue(6);
  }

  // Получить идентификатор процесса
  public int getId() {
    return this.id;
  }

  // Добавление новой страницы памяти процессу
  public void addMemoryPage(MemoryPage page) {
    this.pages.enqueue(page);
  }

  // Получение страницы памяти процесса
  public MemoryPage retrieveMemoryPage() {
    return this.pages.dequeue();
  }

  public MemoryPage[] getPages() {
    return this.pages.getPages();
  }

  public int getPagesCount() {
    return this.pages.getLength();
  }

  public String toString() {
    return String.format("Процесс №%d", getId());
  }
}
