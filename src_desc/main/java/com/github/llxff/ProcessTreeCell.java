package com.github.llxff;

// Обработчик элемента процесса в дереве процессов
public class ProcessTreeCell extends TreeCell<Object> {
  // Список процессов
  private ProcessesList processesList;
  // Контроллер приложения
  private MainController controller;

  // Контекстное меню добавления процесса
  private ContextMenu mainMenu = new ContextMenu();
  // Контекстное меню управления процессом
  private ContextMenu processesMenu = new ContextMenu();
  // Контекстное меню управления памятью
  private ContextMenu memoryMenu = new ContextMenu();

  public ProcessTreeCell(ProcessesList processesList, MainController controller) {}

  // Обработчик отрисовки процесса в дереве процессов
  @Override
  public void updateItem(Object item, boolean empty) {}
}