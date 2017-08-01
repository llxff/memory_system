package com.github.llxff;

// Описание статусов страницы памяти
public enum MemoryStatus {
  ACTIVE("active", "Активна"), DISABLED("disabled", "Не активна");

  // Получить идентификатор статуса
  public String getCode() {}

  // Получить название статуса
  public String getText() {}

  // Получить статус по коду
  public static MemoryStatus getByCode(String code) {}

  // Получить статус по названию
  public static MemoryStatus getByText(String text) {}
}