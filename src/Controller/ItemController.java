package Controller;

import GUI_Client.ClientMain;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import GUI_Client.MyListener;
import model.Fruit;


public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(fruit);
    }

    private Fruit fruit;
    private MyListener myListener;

    public void setData(Fruit fruit, MyListener myListener) {
        this.fruit = fruit;
        this.myListener = myListener;
        nameLabel.setText(fruit.getName());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        img.setImage(image);
    }
}
