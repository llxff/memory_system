package com.github.llxff;

import com.github.llxff.domain.MemoryPage;
import com.github.llxff.domain.Process;
import com.github.llxff.domain.ProcessesList;
import com.github.llxff.domain.VirtualMachine;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;

public class MainController {
  @FXML
  private TreeView<Object> processesTree;

  @FXML
  private Button saveButton;

  @FXML
  private Button loadButton;

  private FileChooser fileChooser = new FileChooser();

  private ProcessesList processesList;

  @FXML
  public void saveProcessesList() {
    File file = fileChooser.showSaveDialog(saveButton.getScene().getWindow());
    if (file != null) {
      try {
        VirtualMachine machine = new VirtualMachine(file.getAbsolutePath());

        machine.save(processesList);

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  public void loadProcessesList() {
    File file = fileChooser.showOpenDialog(loadButton.getScene().getWindow());
    if (file != null) {
      try {
        VirtualMachine machine = new VirtualMachine(file.getAbsolutePath());

        this.processesList = machine.load();

        showProcessesList(renderProcessesList(processesList));

      } catch (Exception e) {
        initialize();
      }
    }
  }

  @FXML
  private void initialize() {
    this.processesList = new ProcessesList();
    fileChooser.setInitialFileName("processes.xml");
    showProcessesList(header());
  }

  public void refreshProcessesList() {
    showProcessesList(renderProcessesList(processesList));
  }

  private void showProcessesList(TreeItem header) {
    processesTree.setRoot(header);
    MainController controller = this;

    processesTree.setCellFactory(new Callback<TreeView<Object>,TreeCell<Object>>(){
      @Override
      public TreeCell call(TreeView p) {
        return new ProcessTreeCell(processesList, controller);
      }
    });
  }

  private TreeItem header() {
    TreeItem rootItem = new TreeItem ("Список процессов");
    rootItem.setExpanded(true);

    return rootItem;
  }

  private TreeItem renderProcessesList(ProcessesList list) {
    TreeItem rootItem = header();
    ProcessesList.ListItem processItem = list.getHead();

    if(processItem != null) {
      addProcessToTree(rootItem, processItem);
    }

    return rootItem;
  }

  private void addProcessToTree(TreeItem rootItem, ProcessesList.ListItem processItem) {
    if(processItem != null) {
      Process process = processItem.getProcess();

      TreeItem processTreeItem = new TreeItem(process);

      MemoryPage[] pages = process.getPages();

      for (int i = 0; i < process.getPagesCount(); i++) {
        TreeItem pageItem = new TreeItem(pages[i]);

        processTreeItem.getChildren().add(pageItem);
      }
      processTreeItem.setExpanded(true);
      rootItem.getChildren().add(processTreeItem);
      addProcessToTree(rootItem, processItem.getNext());
    }
  }
}
