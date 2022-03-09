package shoppinglist.lui;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ListController  implements Initializable {
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField input;

    @Override
    public void initialize(URL l, ResourceBundle resources) {
        this.listView.setCellFactory(blub -> new ListCellController(this));
    }

    @FXML
    public void handleAddElement(){
        System.out.println("Button clicked");
        this.listView.getItems().add(this.input.getText());
    }

    @FXML
    public void handleBackToStart(){
        try {
            LuiWrapper.setRoot("startScreen", new StartScreenController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleOnKeyPressed(KeyEvent event){
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.listView.getItems().add(this.input.getText());
        }
    }

    public void setList(ArrayList<String> list){

    }

    public void removeElement(int idx){
        listView.getItems().remove(idx);
    }


}