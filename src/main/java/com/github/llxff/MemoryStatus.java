package com.github.llxff;

public enum MemoryStatus {

  ACTIVE("active", "Активна"), DISABLED("disabled", "Не активна");

  private String code;
  private String text;

  private MemoryStatus(String code, String text) {
    this.code = code;
    this.text = text;
  }

  public String getCode() {
    return code;
  }

  public String getText() {
    return text;
  }

  public static MemoryStatus getByCode(String code) {
    for (MemoryStatus m : MemoryStatus.values()) {
      if (m.code.equals(code)) {
        return m;
      }
    }
    return null;
  }

  public static MemoryStatus getByText(String text) {
    for (MemoryStatus m : MemoryStatus.values()) {
      if (m.text.equals(text)) {
        return m;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return this.text;
  }
}