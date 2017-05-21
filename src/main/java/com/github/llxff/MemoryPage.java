package com.github.llxff;

// Класс страницы памяти
public class MemoryPage {
  // Номер страницы
  private int number;
  // Статус
  private String status;

  // Конструктор
  public MemoryPage(int number, String status) {
    this.number = number;
    this.status = status;
  }

  // Получить номер страницы
  public int getNumber() {
    return this.number;
  }

  // Получить статус страницы
  public String getStatus() {
    return this.status;
  }
}
