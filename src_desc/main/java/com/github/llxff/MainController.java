package com.github.llxff;

// ���������� ����������
public class MainController {
  // ��������� ������ ���������
  @FXML
  private TreeView<Object> processesTree;

  // ������� ������� ������ ��������
  @FXML
  private TableView<MemoryPage> memoryTable;

  // ������� ������ �������� ������
  @FXML
  private TableColumn<MemoryPage, Integer> numberColumn;

  // ������� ������� �������� ������
  @FXML
  private TableColumn<MemoryPage, MemoryStatus> statusColumn;

  // ������ ������� ������� ������
  private ObservableList<MemoryPage> memoryData = FXCollections.observableArrayList();

  // ������ ���������� ������ ���������
  @FXML
  private Button saveButton;

  // ������ �������� ������ ���������
  @FXML
  private Button loadButton;

  // ������ ������ �����
  private FileChooser fileChooser = new FileChooser();

  // ������ ���������
  private ProcessesList processesList;

  // ��������� ������� �� ������ ���������� ������ ���������
  @FXML
  public void saveProcessesList() {}

  // ��������� ������� �� ������ �������� ������ ���������
  @FXML
  public void loadProcessesList() {}

  // ������������� �����������
  @FXML
  private void initialize() {}

  // �������� ������ ���������
  public void refreshProcessesList() {}

  // �������� �������� ������ � ������� �������
  public void addMemoryToTable(MemoryPage page) {}

  // ������� �������� ������ �� ������� �������
  public void removeMemoryFromTable(int i) {}

  // �������� ������� ������� ������
  public void cleadMemoryTable() {}

  // �������� ������ ������
  public void showError(String header, String message) {}
}
