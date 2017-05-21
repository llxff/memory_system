package com.github.llxff;

// Класс процесса
public class Process {
  // Идентификатор процесса
  private int id;
  // Используемые страниц памяти
  private MemoryPagesQueue pages;

  // Конструктор
  public Process(int id) {}

  // Получить идентификатор процесса
  public int getId() { return 0; }
  // Добавление новой страницы памяти процессу
  public void addMemoryPage(MemoryPage page) {}
  // Удаление страницы памяти процесса
  public void removeMemoryPage(int index) {}
}
