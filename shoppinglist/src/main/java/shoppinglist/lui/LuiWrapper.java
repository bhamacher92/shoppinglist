package shoppinglist.lui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shoppinglist.App;
import shoppinglist.uiBoundary.ILui;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LuiWrapper extends Application implements ILui {

    static ApplicationContext applicationContext;   


    public void setApplicationContext(ApplicationContext context){
        applicationContext=context;
    }

    @Autowired
    StartScreenController startScreenController;

    private static Scene scene;

    public LuiWrapper(){
        
    }

    @Override
    public void start(Stage stage) throws IOException {
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
        scene = new Scene(loadFXML("startScreen",startScreenController), 640, 480);
        scene.getStylesheets().add(getClass().getResource("demo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    static public void setRoot(String fxml,Object controller) throws IOException {
        scene.setRoot(loadFXML(fxml,controller));
    }

    private static Parent loadFXML(String fxml,Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/shoppinglist/lui/"+fxml + ".fxml"));
        if(controller != null){
            fxmlLoader.setController(controller);
        }
        return fxmlLoader.load();
    }

    public void exec(){
       launch();
    }

}
