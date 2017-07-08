package com.github.llxff;

import com.github.llxff.domain.MemoryPage;
import com.github.llxff.domain.Process;
import com.github.llxff.domain.ProcessesList;
import javafx.scene.control.*;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessTreeCell extends TreeCell<Object> {
  private ProcessesList processesList;
  private MainController controller;

  private ContextMenu addProcessMenu = new ContextMenu();
  private ContextMenu addMemoryPageMenu = new ContextMenu();
  private ContextMenu changeStatusMenu = new ContextMenu();

  public ProcessTreeCell(ProcessesList processesList, MainController controller) {
    this.processesList = processesList;
    this.controller = controller;

    initNewProcessAction();
    initNewMemoryPageAction();
    initChangeStatusMenu();
  }

  private void initNewProcessAction() {
    MenuItem addMenuItem = new MenuItem("Добавить процесс");
    addProcessMenu.getItems().add(addMenuItem);
    addMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof String) {
        Process process = new Process(ThreadLocalRandom.current().nextInt(1, 100));
        processesList.add(process);

        addTreeItem(process);
        controller.refreshProcessesList();
      }
    });
  }

  private void initNewMemoryPageAction() {
    MenuItem addMenuItem = new MenuItem("Добавить страницу памяти");
    addMemoryPageMenu.getItems().add(addMenuItem);
    addMenuItem.setOnAction(t -> {
      if(getTreeItem().getValue() instanceof Process) {
        MemoryPage page = new MemoryPage(ThreadLocalRandom.current().nextInt(1, 100), "active");
        Process process = (Process) getTreeItem().getValue();

        process.addMemoryPage(page);
        addTreeItem(page);
      }
    });
  }

  private void initChangeStatusMenu() {
    MenuItem addMenuItem = new MenuItem("Изменить статус");
    changeStatusMenu.getItems().add(addMenuItem);

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
        setContextMenu(addProcessMenu);
      } else if (getItem() instanceof Process) {
        setContextMenu(addMemoryPageMenu);
      } else if (getItem() instanceof MemoryPage) {
        setContextMenu(changeStatusMenu);
      }
    }
  }
}