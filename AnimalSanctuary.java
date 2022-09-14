/**
 * Animal Sanctuary.
 * @author jocelyn shen
 * @version JDK 11.0.2
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * Overide "unchecked".
 * @author jocelyn shen
 * @version JDK 11.0.3
 */
@SuppressWarnings("unchecked")
/**
 * Animal Sanctuary overriding.
 */
public class AnimalSanctuary extends Application {
    /**
     * override.
     * @param primaryStage Stage
     */
    @Override public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(35));
        root.setVgap(5);
        root.setHgap(5);
        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(150);
            root.getColumnConstraints().add(column);
        }
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(80);
            root.getRowConstraints().add(row);
        }
        Scene scene = new Scene(root, 640, 386);

        BackgroundImage bImg = new BackgroundImage(new Image("animalImage.jpg"),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
        root.setBackground(new Background(bImg));

        //rectangle
        Rectangle rectangle1 = new Rectangle(35, 200, 567, 60);
        rectangle1.setFill(Color.WHITE);
        root.setConstraints(rectangle1, 0, 3);
        root.getChildren().add(rectangle1);

        Button button2 = new Button("Empty");
        button2.setPrefWidth(80);
        button2.setPrefHeight(80);
        Button button3 = new Button("Empty");
        button3.setPrefWidth(80);
        button3.setPrefHeight(80);
        Button button4 = new Button("Empty");
        button4.setPrefWidth(80);
        button4.setPrefHeight(80);
        Button button5 = new Button("Empty");
        button5.setPrefWidth(80);
        button5.setPrefHeight(80);
        Button button6 = new Button("Empty");
        button6.setPrefWidth(80);
        button6.setPrefHeight(80);
        Button button7 = new Button("Empty");
        button7.setPrefWidth(80);
        button7.setPrefHeight(80);

        TilePane tilePane = new TilePane(3, 3, button2, button3, button4, button5, button6, button7);
        tilePane.setMaxWidth(307);
        root.setConstraints(tilePane, 1, 1, 3, 3);
        root.getChildren().add(tilePane);

        //Title
        Text text = new Text(0, 170, "        My Animal Sanctuary");
        Font f = Font.font("Verdana", 33);
        text.setFont(f);

        //root.setConstraints(text, 3, 1);
        root.addRow(0, text);
        Rectangle newRectangle = new Rectangle(35, 0, 0, 60);
        newRectangle.setFill(Color.TRANSPARENT);
        HBox hbox = new HBox(text);
        root.getChildren().add(hbox);


        //Type name here:
        TextField textField1 = new TextField();
        textField1.setPromptText("Type name here:");
        textField1.setPrefWidth(100);

        //Type health here:
        TextField textField2 = new TextField();
        textField2.setPromptText("Type health here:");
        textField2.setPrefWidth(150);

        //species
        ComboBox comboBox = new ComboBox();
        Animal[] enumArray = Animal.values();
        for (int i = 0; i < enumArray.length; i++) {
            comboBox.getItems().addAll(enumArray[i].name());
        }
        comboBox.setPromptText("Select animal type");
      //  menuButton.showInputDialog();
        //Add Animal
        Button button1 = new Button("Add Animal");
        button1.setPrefSize(100, 50);

        root.setConstraints(textField1, 0, 3);
        textField1.setMaxWidth(150);
        textField1.setMinWidth(150);
        textField2.setMaxWidth(150);
        textField2.setMinWidth(150);
        root.setConstraints(textField2, 1, 3);
        root.setConstraints(comboBox, 2, 3);
        root.setConstraints(button1, 3, 3);

        root.getChildren().addAll(textField1, textField2, comboBox, button1);


        primaryStage.setTitle("My  Animal Santuary");
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setOnAction(e -> {
            String type = "";
            if (!textField1.getText().isEmpty()) {
                type += textField1.getText() + "\n";
            } else {
                type += "No Name \n Yet \n";
            }
            type += comboBox.getValue() + "\n";
            if (textField2.getText().equals("1") || textField2.getText().equals("2")
                || textField2.getText().equals("3") || textField2.getText().equals("4")
                || textField2.getText().equals("5")) {
                type += textField2.getText();
            } else {
                type += "5";
            }
            if (button2.getText().equals("Empty")) {
                button2.setText(type);
                button2.setStyle("-fx-base: #b6e7c9;");
            } else if (button3.getText().equals("Empty")) {
                button3.setText(type);
                button3.setStyle("-fx-base: #b6e7c9;");
            } else if (button4.getText().equals("Empty")) {
                button4.setText(type);
                button4.setStyle("-fx-base: #b6e7c9;");
            } else if (button5.getText().equals("Empty")) {
                button5.setText(type);
                button5.setStyle("-fx-base: #b6e7c9;");
            } else if (button6.getText().equals("Empty")) {
                button6.setText(type);
                button6.setStyle("-fx-base: #b6e7c9;");
            } else if (button7.getText().equals("Empty")) {
                button7.setText(type);
                button7.setStyle("-fx-base: #b6e7c9;");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "There is no more room!");
                alert.showAndWait();
            }
        });
        button2.setOnAction(e -> {
            if (!button2.getText().equals("Empty")) {
                button2.setText("Empty");
                button2.setStyle("-fx-base: #eae9e9");
            }
        });
        button3.setOnAction(e -> {
            if (!button3.getText().equals("Empty")) {
                button3.setText("Empty");
                button3.setStyle("-fx-base: #eae9e9");
            }
        }); button4.setOnAction(e -> {
            if (!button4.getText().equals("Empty")) {
                button4.setText("Empty");
                button4.setStyle("-fx-base: #eae9e9");
            }
        }); button5.setOnAction(e -> {
            if (!button5.getText().equals("Empty")) {
                button5.setText("Empty");
                button5.setStyle("-fx-base: #eae9e9");
            }
        }); button6.setOnAction(e -> {
            if (!button6.getText().equals("Empty")) {
                button6.setText("Empty");
                button6.setStyle("-fx-base: #eae9e9");
            }
        }); button7.setOnAction(e -> {
            if (!button7.getText().equals("Empty")) {
                button7.setText("Empty");
                button7.setStyle("-fx-base: #eae9e9");
            }
        });
    }
}