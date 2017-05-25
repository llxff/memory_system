package com.github.llxff;

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
}
