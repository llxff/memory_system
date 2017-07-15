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
  }

  private void initNewProcessAction() {
    MenuItem addMenuItem = new MenuItem("Добавить процесс");
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
    MenuItem addMenuItem = new MenuItem("Добавить страницу памяти");
    addMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        Process process = (Process) getTreeItem().getValue();

        try {
          MemoryPage page = new MemoryPage(ThreadLocalRandom.current().nextInt(1, 100), "active");

          process.addMemoryPage(page);
          addToTable(page);
        }
        catch(IllegalStateException e) {
          showError(
            "Нельзя добавить больше памяти!",
            String.format("Ведь их уже %d!", process.getPagesCount())
          );
        }
      }
    });

    MenuItem removeMenuItem = new MenuItem("Удалить процесс");
    removeMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        Process process = (Process) getTreeItem().getValue();

        try {
          int i = processesList.getIndex(process);
          processesList.remove(i);

          getTreeItem().getChildren().remove(getTreeItem());
          controller.cleadMemoryTable();
          controller.refreshProcessesList();
        }
        catch (IndexOutOfBoundsException e) {
          showError(
            "Выбранный процесс не существует",
            "Попробуйте ещё разок, на этот раз всё получится!"
          );
        }
      }
    });

    MenuItem removeMemoryMenuItem = new MenuItem("Удалить память");
    removeMemoryMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        Process process = (Process) getTreeItem().getValue();

        try {
          process.retrieveMemoryPage();

          controller.removeMemoryFromTable(0);
        }
        catch (IllegalStateException e) {
          showError(
              "Памяти то больше нет!",
              "Нельзя удалить то, чего нет! ;)"
          );
        }
      }
    });

    processesMenu.getItems().add(addMenuItem);
    processesMenu.getItems().add(removeMenuItem);
    processesMenu.getItems().add(removeMemoryMenuItem);
  }

  private void addTreeItem(Object item) {
    getTreeItem().getChildren().add(new TreeItem(item));
    getTreeItem().setExpanded(true);
  }

  private void addToTable(MemoryPage page) {
    controller.addMemoryToTable(page);
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
    controller.showError(header, message);
  }
}