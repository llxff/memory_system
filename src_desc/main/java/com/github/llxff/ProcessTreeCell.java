package com.github.llxff;

// ���������� �������� �������� � ������ ���������
public class ProcessTreeCell extends TreeCell<Object> {
  // ������ ���������
  private ProcessesList processesList;
  // ���������� ����������
  private MainController controller;

  // ����������� ���� ���������� ��������
  private ContextMenu mainMenu = new ContextMenu();
  // ����������� ���� ���������� ���������
  private ContextMenu processesMenu = new ContextMenu();
  // ����������� ���� ���������� �������
  private ContextMenu memoryMenu = new ContextMenu();

  public ProcessTreeCell(ProcessesList processesList, MainController controller) {}

  // ���������� ��������� �������� � ������ ���������
  @Override
  public void updateItem(Object item, boolean empty) {}
}