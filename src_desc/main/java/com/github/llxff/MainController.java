package com.github.llxff;

// Контроллер приложения
public class MainController {
  // Компонент дерева процессов
  @FXML
  private TreeView<Object> processesTree;

  // Таблица страниц памяти процесса
  @FXML
  private TableView<MemoryPage> memoryTable;

  // Колонка номера страницы памяти
  @FXML
  private TableColumn<MemoryPage, Integer> numberColumn;

  // Колонка статуса страницы памяти
  @FXML
  private TableColumn<MemoryPage, MemoryStatus> statusColumn;

  // Данные таблицы страниц памяти
  private ObservableList<MemoryPage> memoryData = FXCollections.observableArrayList();

  // Кнопка сохранения списка процессов
  @FXML
  private Button saveButton;

  // Кнопка загрузки списка процессов
  @FXML
  private Button loadButton;

  // Диалог выбора файла
  private FileChooser fileChooser = new FileChooser();

  // Список процессов
  private ProcessesList processesList;

  // Обработка нажатия на кнопку сохранения списка процессов
  @FXML
  public void saveProcessesList() {}

  // Обработка нажатия на кнопку загрузки списка процессов
  @FXML
  public void loadProcessesList() {}

  // Инициализация компонентов
  @FXML
  private void initialize() {}

  // Обновить список процессов
  public void refreshProcessesList() {}

  // Добавить страницу памяти в таблицу страниц
  public void addMemoryToTable(MemoryPage page) {}

  // Удалить страницу памяти из таблицы страниц
  public void removeMemoryFromTable(int i) {}

  // Очистить таблицу страниц памяти
  public void cleadMemoryTable() {}

  // Показать диалог ошибки
  public void showError(String header, String message) {}
}
