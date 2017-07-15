package com.github.llxff;

import com.github.llxff.domain.MemoryPage;
import com.github.llxff.domain.Process;
import com.github.llxff.domain.ProcessesList;
import javafx.scene.control.*;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessTreeCell extends TreeCell<Object> {
  private ProcessesList processesList;
  private MainController controller;

  private ContextMenu mainMenu = new ContextMenu();
  private ContextMenu processesMenu = new ContextMenu();
  private ContextMenu memoryMenu = new ContextMenu();

  public ProcessTreeCell(ProcessesList processesList, MainController controller) {
    this.processesList = processesList;
    this.controller = controller;

    initNewProcessAction();
    initProcessesMenu();
    initMemoryMenu();
  }

  private void initNewProcessAction() {
    MenuItem addMenuItem = new MenuItem("�������� �������");
    mainMenu.getItems().add(addMenuItem);
    addMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof String) {
        Process process = new Process(ThreadLocalRandom.current().nextInt(1, 100));
        processesList.add(process);

        addTreeItem(process);
        controller.refreshProcessesList();
      }
    });
  }

  private void initProcessesMenu() {
    MenuItem addMenuItem = new MenuItem("�������� �������� ������");
    addMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        Process process = (Process) getTreeItem().getValue();

        try {
          MemoryPage page = new MemoryPage(ThreadLocalRandom.current().nextInt(1, 100), "active");

          process.addMemoryPage(page);
          addTreeItem(page);
        }
        catch(IllegalStateException e) {
          showError(
            "������ �������� ������ ������!",
            String.format("���� �� ��� %d!", process.getPagesCount())
          );
        }
      }
    });

    MenuItem removeMenuItem = new MenuItem("������� �������");
    removeMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        Process process = (Process) getTreeItem().getValue();

        try {
          int i = processesList.getIndex(process);
          processesList.remove(i);

          getTreeItem().getChildren().remove(getTreeItem());
          controller.refreshProcessesList();
        }
        catch (IndexOutOfBoundsException e) {
          showError(
            "��������� ������� �� ����������",
            "���������� ��� �����, �� ���� ��� �� ���������!"
          );
        }
      }
    });

    MenuItem removeMemoryMenuItem = new MenuItem("������� ������");
    removeMemoryMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        Process process = (Process) getTreeItem().getValue();

        try {
          process.retrieveMemoryPage();

          getTreeItem().getChildren().remove(process.getPagesCount());
          controller.refreshProcessesList();
        }
        catch (IllegalStateException e) {
          showError(
              "������ �� ������ ���!",
              "������ ������� ��, ���� ���! ;)"
          );
        }
      }
    });

    processesMenu.getItems().add(addMenuItem);
    processesMenu.getItems().add(removeMenuItem);
    processesMenu.getItems().add(removeMemoryMenuItem);
  }

  private void initMemoryMenu() {
    MenuItem addMenuItem = new MenuItem("�������� ������");
    addMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof MemoryPage) {
        MemoryPage page = (MemoryPage) getTreeItem().getValue();

        if(page.getStatus() == "active") {
          page.setStatus("disabled");
        }
        else {
          page.setStatus("active");
        }

        setText(getTreeItem().getValue().toString());
      }
    });

    memoryMenu.getItems().add(addMenuItem);
  }

  private void addTreeItem(Object item) {
    getTreeItem().getChildren().add(new TreeItem(item));
    getTreeItem().setExpanded(true);
  }

  @Override
  public void updateItem(Object item, boolean empty) {
    super.updateItem(item, empty);

    if(empty) {
      setText(null);
      setGraphic(null);
    }
    else if(getItem() != null) {
      setText(getItem().toString());

      if (getItem() instanceof String) {
        setContextMenu(mainMenu);
      } else if (getItem() instanceof Process) {
        setContextMenu(processesMenu);
      } else if (getItem() instanceof MemoryPage) {
        setContextMenu(memoryMenu);
      }
    }
  }

  private void showError(String header, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("���-�� ����� �� ���...");
    alert.setHeaderText(header);
    alert.setContentText(message);

    alert.showAndWait();
  }
}