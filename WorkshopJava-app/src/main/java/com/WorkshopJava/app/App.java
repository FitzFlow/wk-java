package com.WorkshopJava.app;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import java.util.Map;
import javafx.scene.text.Text;

public class App extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("WorkshopJava");
    }
    private Entity player;
    private Entity ennemy;
    @Override
    protected void initGame() {
        int pos_x = 0;
        int pos_y = 0;
        FXGL.getGameWorld().addEntityFactory(new Factory());
        player = FXGL.entityBuilder()
            .at(pos_x, pos_y)
            .view("cube.png")
            .buildAndAttach();
        ennemy = FXGL.spawn("enemy", 5, 5);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved","Salut");
    }

    protected void initUI() {
        Text textPixels = new Text("Salut");
        textPixels.setTranslateX(50);
        textPixels.setTranslateY(100);
        FXGL.getGameScene().addUINode(textPixels);
        /*textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());*/
        textPixels.textProperty().bind(FXGL.getWorldProperties().stringProperty("pixelsMoved"));
    }

    @Override
    protected void initInput() {
        Input input = FXGL.getInput();

        FXGL.onKey(KeyCode.LEFT, () -> {
            player.translateX(-5);
            ennemy.translateX(-3);
        });
        FXGL.onKey(KeyCode.RIGHT, () -> {
            player.translateX(5);
            ennemy.translateX(3);
        });
        FXGL.onKey(KeyCode.UP, () -> {
            player.translateY(-5);
            ennemy.translateY(-3);
        });
        FXGL.onKey(KeyCode.DOWN, () -> {
            player.translateY(5);
            ennemy.translateY(3);
        });
    }
}
