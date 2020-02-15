package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main extends Application {

    Stage window;
    TableView<Employee> table;
    TextField firstNameInput, lastNameInput, isActiveInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Employee List");
        window.setWidth(1000);
        window.setHeight(600);

        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setMinWidth(200);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, Double> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, String> isActiveColumn = new TableColumn<>("Is Active, Yes or No");
        isActiveColumn.setMinWidth(50);
        isActiveColumn.setCellValueFactory(new PropertyValueFactory<>("isActive"));

        firstNameInput = new TextField();
        firstNameInput.setPromptText("First Name");
        firstNameInput.setMinWidth(100);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("Last Name");

        isActiveInput = new TextField();
        isActiveInput.setPromptText("Is Active, Yes or No");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,0,10,0));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(firstNameInput, lastNameInput, isActiveInput, addButton, deleteButton, clearButton);

        table = new TableView<>();
        table.setItems(getEmployee());
        table.getColumns().addAll(firstNameColumn, lastNameColumn, isActiveColumn);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 350, 0, 10));
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked(){
            Employee employee = new Employee();
            employee.setFirstName(firstNameInput.getText());
            employee.setLastName(lastNameInput.getText());
            employee.setIsActive(isActiveInput.getText());
            table.getItems().add(employee);
            firstNameInput.clear();
            lastNameInput.clear();
            isActiveInput.clear();
        }

    public void deleteButtonClicked(){
        ObservableList<Employee> employeeSelected, allEmployees;
        allEmployees = table.getItems();
        employeeSelected = table.getSelectionModel().getSelectedItems();
        employeeSelected.forEach(allEmployees::remove);
    }

    public void clearButtonClicked(){
        firstNameInput.clear();
        lastNameInput.clear();
        isActiveInput.clear();

    }
    public ObservableList<Employee> getEmployee(){
        ObservableList<Employee> employee = FXCollections.observableArrayList();
        employee.add(new Employee("Clint", "Hernandez", "Yes"));
        employee.add(new Employee("Johnathan", "Johnson", "No"));
        employee.add(new Employee("Tom", "Williams", "No"));
        employee.add(new Employee("Sam", "Gomez", "Yes"));
        employee.add(new Employee("Abraham", "Perez", "No"));
        return employee;
    }


}
