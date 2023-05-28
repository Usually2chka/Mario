package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MarioBros;

public class StartScreen implements Screen {
    private Viewport viewport;
    private Stage stage;
    private Game game;
    private Texture backGroung;

    public StartScreen(Game game){
        backGroung = new Texture("F:\\AnS\\Project\\MarioGame\\assets\\NewTexure\\ImgForBackGround\\backGroung.png");
        this.game = game;
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((MarioBros) game).batch);
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);


        Skin skin = new Skin();
        TextureAtlas atlas = new TextureAtlas("Кнопочка.png");
        skin.addRegions(atlas);
        skin.load(Gdx.files.internal(""));

        Button StartPlayButton = new Button(skin, "default");
        stage.addActor(StartPlayButton);


        Table table1 = new Table();
        table1.center();
        table1.setFillParent(true);

        Label buttonExit = new Label("Exit", font);

        table1.row();
        table1.add(buttonExit).expandX();

        stage.addActor(table1);



        //1-я кнопка   (просто надпись....) (Тут нет кнопок, есть только надписи)
        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label playAgainLabel = new Label("Click to play", font);

        table.row();
        table.add(playAgainLabel).expandX();

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if(Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen((MarioBros) game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();




    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
