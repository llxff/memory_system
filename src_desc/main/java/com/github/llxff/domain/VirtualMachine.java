package com.github.llxff.domain;

// Класс для сохранения/загрузки процессов
public class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;

  public VirtualMachine(String fileName) {}

  // Сохранение процессов
  public void save(ProcessesList processes) throws FileNotFoundException {}

  // Загрузка процессов
  public ProcessesList load() throws FileNotFoundException {}
}
