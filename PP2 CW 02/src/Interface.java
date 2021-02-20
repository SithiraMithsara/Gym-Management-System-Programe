import com.mongodb.client.MongoCollection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import java.util.Observable;

public class Interface extends Application {
    
    TableView<Object> table;
    public String searchMemberID;
    
    public static MongoCollection<Document> input = MyGymManager.database.getCollection("gymMember");

    public ObservableList<Object> getTableData() {
        ObservableList<Object> observableList = FXCollections.observableArrayList();
        for (Document document : input.find()) {
            Data addData = new Data();
            addData.setMemberID((Integer) document.get("Member ID"));
            addData.setfstName((String.valueOf(document.get("First name"))));
            observableList.add(addData);

        }
        return observableList;
    }

    public ObservableList<Object> getTableSearch() {
        ObservableList<Object> search = FXCollections.observableArrayList();
        for (Document document : input.find(eq("First name", searchMemberID))){
            Data addData = new Data();
            addData.setMemberID((Integer) document.get("Member ID"));
            addData.setfstName(String.valueOf(document.get("First name")));
            addData.setlstName(String.valueOf(document.get("Last name")));
            search.add(addData);

        }
        return search;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Gym Manager System");

        Label lblTitle = new Label("Gym Management System");
        lblTitle.setStyle("-fx-font: normal bold 25px 'serif'");
        lblTitle.setLayoutX(270);
        lblTitle.setLayoutY(40);

        TableColumn<Object, Integer> Column1 = new TableColumn<>("Member ID");
        Column1.setCellValueFactory(new PropertyValueFactory<>("Member ID"));
        
        TableColumn<Object, String> Column2 = new TableColumn<>("First name");
        Column2.setCellValueFactory(new PropertyValueFactory<>("First name"));
        Column2.setMinWidth(200);

        TableColumn<Object, String> Column3 = new TableColumn<>("Last name");
        Column3.setCellValueFactory(new PropertyValueFactory<>("Last name"));
        Column3.setMinWidth(200);

        TextField txtsearch = new TextField();
        txtsearch.setPromptText("First name");
        txtsearch.setLayoutX(460);
        txtsearch.setLayoutY(570);
        txtsearch.setOnMouseExited(event -> searchMemberID = txtsearch.getText());

        Button btnsearch = new Button("Search");
        btnsearch.setLayoutX(620);
        btnsearch.setLayoutY(570);
        btnsearch.setOnAction(event -> searchTable());

        table = new TableView<>();
        table.setLayoutX(140);
        table.setLayoutY(80);
        table.setItems(getTableData());
        table.getColumns().addAll(Column1, Column2, Column3);
        

        Pane root = new Pane();
        root.getChildren().add(txtsearch);
        root.getChildren().add(btnsearch);
        root.getChildren().add(table);

        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.show();

    }

    void searchTable() {table.setItems(getTableSearch());}
    public static void Interface(String[] args) {
        launch(args);
    }
}