package com.github.llxff;

import java.io.File;

// Класс для сохранения/загрузки процессов
public class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;

  public VirtualMachine(String fileName) {
    this.fileName = fileName;
  }

  // Получить название файла, в котором хранится состояние
  public String getFileName() {
    return this.fileName;
  }
  // Сохранение процессов
  public void save(ProcessesList processes) {

  }
  // Загрузка процессов
  public ProcessesList load() {
    return null;
  }
}
