package me.maurizzzio.base.screens;

import me.maurizzzio.base.controllers.InputController;
import me.maurizzzio.base.controllers.WorldController;
import me.maurizzzio.base.models.World;
import me.maurizzzio.base.views.WorldRenderer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class MainScreen implements Screen {

	// models
	private World world;
	
	// views
	private WorldRenderer renderer;
	
	// controllers
	private WorldController worldController;
	private InputController inputController;		// singleton
	
	// reference to the instance of the class GdxGame
	private Game game;
	
	public MainScreen(Game game) {
		this.game = game;
		this.world = new World();
		this.renderer = new WorldRenderer(this.world);
		this.worldController = new WorldController(this.world);
		
		// register the input controller
		this.inputController = InputController.getInstance();
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this.inputController);
		Gdx.input.setInputProcessor(multiplexer);		
	}

	@Override
	public void show() {
		// called from game.setScreen();		
	}
	
	@Override
	public void render(float delta) {
		// clear the screen
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// update the world through the controller
		worldController.update(delta);
		
		// render the world
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// called from game.dispose()

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
