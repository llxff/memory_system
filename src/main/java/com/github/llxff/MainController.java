package com.github.llxff;

import com.github.llxff.domain.MemoryPage;
import com.github.llxff.domain.Process;
import com.github.llxff.domain.ProcessesList;
import com.github.llxff.domain.VirtualMachine;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class MainController {
  @FXML
  private TreeView<Object> processesTree;

  @FXML
  private TableView<MemoryPage> memoryTable;

  @FXML
  private TableColumn<MemoryPage, Integer> numberColumn;

  @FXML
  private TableColumn<MemoryPage, MemoryStatus> statusColumn;

  private ObservableList<MemoryPage> memoryData = FXCollections.observableArrayList();

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
        showError(
          "Не удалось загрузить файл",
          "Не переживайте, с другим файлом всё получится!"
        );
      }
    }
  }

  @FXML
  private void initialize() {
    this.processesList = new ProcessesList();
    fileChooser.setInitialFileName("processes.xml");
    processesTree.addEventHandler(MouseEvent.MOUSE_CLICKED, this::processSelected);

    initializeMemoryTable();

    showProcessesList(header());
  }

  private void initializeMemoryTable() {
    numberColumn.setCellValueFactory(new PropertyValueFactory<MemoryPage, Integer>("number"));
    statusColumn.setCellValueFactory(param -> {
      MemoryPage page = param.getValue();
      String value = page.getStatus();
      MemoryStatus status = MemoryStatus.getByCode(value);

      return new SimpleObjectProperty(status);
    });

    ObservableList<MemoryStatus> statusList = FXCollections.observableArrayList(MemoryStatus.values());

    statusColumn.setCellFactory(ComboBoxTableCell.forTableColumn(statusList));

    statusColumn.setOnEditCommit((TableColumn.CellEditEvent<MemoryPage, MemoryStatus> event) -> {
      TablePosition<MemoryPage, MemoryStatus> pos = event.getTablePosition();

      MemoryStatus newStatus = event.getNewValue();

      int row = pos.getRow();
      MemoryPage page = event.getTableView().getItems().get(row);

      page.setStatus(newStatus.getCode());
    });

    memoryTable.setItems(memoryData);
  }

  private void processSelected(MouseEvent event) {
    Node node = event.getPickResult().getIntersectedNode();
    if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
      Object value = processesTree.getSelectionModel().getSelectedItem().getValue();
      if (value instanceof Process) {
        memoryData.clear();

        Process process = (Process) value;
        MemoryPage[] pages = process.getPages();

        memoryData.addAll(Arrays.asList(pages).subList(0, process.getPagesCount()));
      }
      else if (value instanceof String) {
        memoryData.clear();
      }
    }
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

      processTreeItem.setExpanded(true);
      rootItem.getChildren().add(processTreeItem);
      addProcessToTree(rootItem, processItem.getNext());
    }
  }

  public void addMemoryToTable(MemoryPage page) {
    memoryData.add(page);
  }

  public void removeMemoryFromTable(int i) {
    memoryData.remove(i);
  }

  public void cleadMemoryTable() {
    memoryData.clear();
  }

  public void showError(String header, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Что-то пошло не так...");
    alert.setHeaderText(header);
    alert.setContentText(message);

    alert.showAndWait();
  }
}
