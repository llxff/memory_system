package com.github.llxff.domain;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

// Класс для сохранения/загрузки процессов
public class VirtualMachine {
  // Название файла, в котором хранится состояние
  private String fileName;
  private XStream processor;

  public VirtualMachine(String fileName) {
    this.fileName = fileName;
    this.processor = new XStream();
    this.processor.alias("processes", ProcessesList.class);
    this.processor.alias("page", MemoryPage.class);
  }

  // Получить название файла, в котором хранится состояние
  public String getFileName() {
    return this.fileName;
  }

  // Сохранение процессов
  public void save(ProcessesList processes) throws FileNotFoundException {
    try(PrintStream ps = new PrintStream(this.fileName)) {
      ps.println(this.processor.toXML(processes));
    }
  }

  // Загрузка процессов
  public ProcessesList load() throws FileNotFoundException {
    return (ProcessesList) this.processor.fromXML(new File(this.fileName));
  }
}
