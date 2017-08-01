package com.github.llxff.domain;

// Класс процесса
public class Process {
  // Идентификатор процесса
  private int id;
  // Используемые страниц памяти
  private MemoryPagesQueue pages;

  // Конструктор
  public Process(int id) {}

  // Получить идентификатор процесса
  public int getId() {}

  // Добавление новой страницы памяти процессу
  public void addMemoryPage(MemoryPage page) throws IllegalStateException {}

  // Получение страницы памяти процесса
  public MemoryPage retrieveMemoryPage() throws IllegalStateException {}

  // Получить страницы памяти процесса
  public MemoryPage[] getPages() {}

  // Получить количество страниц памяти процесса
  public int getPagesCount() {}
}
