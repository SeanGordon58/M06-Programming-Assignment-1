import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.HashMap;

public class App extends Application {

    private TextField idField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField miField = new TextField();
    private TextField addressField = new TextField();
    private TextField cityField = new TextField();
    private TextField stateField = new TextField();
    private TextField telephoneField = new TextField();
    private TextField emailField = new TextField();

    private HashMap<String, Staff> database = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("ID:"), 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(new Label("Last Name:"), 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(new Label("First Name:"), 0, 2);
        gridPane.add(firstNameField, 1, 2);
        gridPane.add(new Label("MI:"), 0, 3);
        gridPane.add(miField, 1, 3);
        gridPane.add(new Label("Address:"), 0, 4);
        gridPane.add(addressField, 1, 4);
        gridPane.add(new Label("City:"), 0, 5);
        gridPane.add(cityField, 1, 5);
        gridPane.add(new Label("State:"), 0, 6);
        gridPane.add(stateField, 1, 6);
        gridPane.add(new Label("Telephone:"), 0, 7);
        gridPane.add(telephoneField, 1, 7);
        gridPane.add(new Label("Email:"), 0, 8);
        gridPane.add(emailField, 1, 8);

        Button viewButton = new Button("View");
        viewButton.setOnAction(e -> viewRecord());
        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> insertRecord());
        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateRecord());

        HBox buttonsBox = new HBox(10, viewButton, insertButton, updateButton);
        gridPane.add(buttonsBox, 1, 9);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Management");
        primaryStage.show();
    }

    private void viewRecord() {
        String id = idField.getText();
        Staff staff = database.get(id);
        if (staff != null) {
            lastNameField.setText(staff.getLastName());
            firstNameField.setText(staff.getFirstName());
            miField.setText(staff.getMi());
            addressField.setText(staff.getAddress());
            cityField.setText(staff.getCity());
            stateField.setText(staff.getState());
            telephoneField.setText(staff.getTelephone());
            emailField.setText(staff.getEmail());
        } else {
            System.out.println("Record not found!");
        }
    }

    private void insertRecord() {
        String id = idField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String mi = miField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String telephone = telephoneField.getText();
        String email = emailField.getText();

        Staff staff = new Staff(lastName, firstName, mi, address, city, state, telephone, email);
        database.put(id, staff);
        System.out.println("Record inserted successfully!");
    }

    private void updateRecord() {
        String id = idField.getText();
        if (database.containsKey(id)) {
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String mi = miField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String telephone = telephoneField.getText();
            String email = emailField.getText();

            Staff staff = new Staff(lastName, firstName, mi, address, city, state, telephone, email);
            database.put(id, staff);
            System.out.println("Record updated successfully!");
        } else {
            System.out.println("Record not found!");
        }
    }

    private static class Staff {
        private String lastName;
        private String firstName;
        private String mi;
        private String address;
        private String city;
        private String state;
        private String telephone;
        private String email;

        public Staff(String lastName, String firstName, String mi, String address, String city, String state, String telephone, String email) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.mi = mi;
            this.address = address;
            this.city = city;
            this.state = state;
            this.telephone = telephone;
            this.email = email;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMi() {
            return mi;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getTelephone() {
            return telephone;
        }

        public String getEmail() {
            return email;
        }
    }
}