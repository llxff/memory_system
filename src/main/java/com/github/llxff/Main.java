package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

// Класс для сохранения и загрузки состояния процессов и памяти
class MachineStorage {
  // Название файла, в котором хранится состояние
  private String filename;

  // Загрузка состояния
  public VirtualMachine load() {}
  // Сохранение состояния
  public void save(VirtualMachine machine) {}
}

// Класс для управления процессами
class VirtualMachine {
  // Список процессов
  private LinkedList<Process> processes;

  // Объект для управления памятью
  private Memory memory;

  // Создание нового процесса
  public Process add() {}
  // Завершение процесса
  public void kill(int pid) {}
}

// Класс процесса
class Process implements Serializable {
  // Идентификатор процесса
  private int id;

  // Массив используемыех страниц памяти
  private ArrayList<MemoryPage> pages;

  // Объект для управления памятью
  private Memory memory;

  // Конструктор
  public Process(int id, Memory memory) {}

  // Добавление новой страницы памяти процессу
  public void addMoreMemory(int amount) {}

  // Завершить процесс и высвободить память
  public void die() {}
}

// Класс для управления памятью
class Memory implements Serializable {
  // Объем памяти
  private int size;

  // Выделенные страницы
  private ArrayList<MemoryPage> pages;

  // Конструктор
  public Memory(int size) {}

  // Выделить новую страницу памяти
  public MemoryPage allocate() {}

  // Высвободить указанную страницу
  public void free(MemoryPage page) {}

  // Использованный объем памяти
  public int usedAmount() {}

  // Свободный объем памяти
  public int freeAmount() {}
}

// Класс страницы памяти
class MemoryPage implements Serializable {
  // Номер страницы
  private int number;

  // Статус
  private String status;

  // Размер
  private int size;

  // Конструктор
  public MemoryPage(int number, int size) {}
}
