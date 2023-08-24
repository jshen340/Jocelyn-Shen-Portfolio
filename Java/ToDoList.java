/**
 * To-Do List.
 * @author jocelyn shen
 * @version JDK 11.0.2
 * Command to run: javac --module-path=*filepath* --add-modules=javafx.controls ToDoList.java 
 * Please ensure you have JavaFX downloaded.
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
import java.util.*;
/**
 * Overide "unchecked".
 * @author jocelyn shen
 * @version JDK 11.0.3
 */
@SuppressWarnings("unchecked")
/**
 * ToDoList overriding.
 */
public class ToDoList extends Application {
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
        Text text = new Text(0, 170, "        Today's To-Do List");
        Font f = Font.font("Verdana", 33);
        text.setFont(f);

        //root.setConstraints(text, 3, 1);
        root.addRow(0, text);
        Rectangle newRectangle = new Rectangle(35, 0, 0, 60);
        newRectangle.setFill(Color.TRANSPARENT);
        HBox hbox = new HBox(text);
        root.getChildren().add(hbox);


        //Type task here:
        TextField textField1 = new TextField();
        textField1.setPromptText("Type task here:");
        textField1.setPrefWidth(100);

        //Type priority here:
        TextField textField2 = new TextField();
        textField2.setPromptText("Type priority here:");
        textField2.setPrefWidth(150);

        //species
        ComboBox comboBox = new ComboBox();
        TaskType[] enumArray = TaskType.values();
        for (int i = 0; i < enumArray.length; i++) {
            comboBox.getItems().addAll(enumArray[i].name());
        }
        comboBox.setPromptText("Select task type");

        ArrayList<ArrayList<String>> set = new ArrayList<ArrayList<String>>();

        //Add Task
        Button button1 = new Button("Add Task");
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


        primaryStage.setTitle("Today's To-Do Lists");
        primaryStage.setScene(scene);
        primaryStage.show();

        
        button1.setOnAction(e -> {
            String type = "";
            String priority = "";
            ArrayList<String> list = new ArrayList<String>();
            list.add(Integer.toString(set.size() + 1));
            list.add(textField2.getText());

            // first line: task name
            if (!textField1.getText().isEmpty()) {
                type += textField1.getText() + "\n";
            } else {
                type += "No Name \n Yet \n";
            }
            // second line: task type
            type += comboBox.getValue() + "\n";
            // third line: priority
            if (textField2.getText().equals("1") || textField2.getText().equals("2")
                || textField2.getText().equals("3") || textField2.getText().equals("4")
                || textField2.getText().equals("5")) {
                type += "Priority:" + textField2.getText();
            } else {
                type += "5";
            }
            list.add(type);
            set.add(list);

            ListComparator compare = new ListComparator();
            Collections.sort(set, compare);

            button2.setText("Empty");
            button3.setText("Empty");
            button4.setText("Empty");
            button5.setText("Empty");
            button6.setText("Empty");
            button7.setText("Empty");

            for (ArrayList<String> entry : set) {
                System.out.println(entry);
                
                if (button2.getText().equals("Empty")) {
                    button2.setText(entry.get(2));
                    button2.setStyle("-fx-base: #b6e7c9;");
                } else if (button3.getText().equals("Empty")) {
                    button3.setText(entry.get(2));
                    button3.setStyle("-fx-base: #b6e7c9;");
                } else if (button4.getText().equals("Empty")) {
                    button4.setText(entry.get(2));
                    button4.setStyle("-fx-base: #b6e7c9;");
                } else if (button5.getText().equals("Empty")) {
                    button5.setText(entry.get(2));
                    button5.setStyle("-fx-base: #b6e7c9;");
                } else if (button6.getText().equals("Empty")) {
                    button6.setText(entry.get(2));
                    button6.setStyle("-fx-base: #b6e7c9;");
                } else if (button7.getText().equals("Empty")) {
                    button7.setText(entry.get(2));
                    button7.setStyle("-fx-base: #b6e7c9;");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "There is no more room!");
                    alert.showAndWait();
                }
            }
        });

        // Empty buttons when they are pressed on
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

    public static class ListComparator implements Comparator<ArrayList<String>> {
        @Override
        public int compare(ArrayList<String> firstArrayList, ArrayList<String> secondArrayList) {
            return Integer.compare(Integer.valueOf(firstArrayList.get(1)), Integer.valueOf(secondArrayList.get(1)));
        }

    }
}