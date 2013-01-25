package me.maurizzzio.base;

import me.maurizzzio.base.screens.MainScreen;

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GdxGame extends Game {
	
	// define the screens
	private Screen main;
//	private Screen game = new GameScreen(this);
//	private Screen end = new EndScreen(this);
	
	@Override
	public void create() {
		// log level (usage: Gdx.app.Log())
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		// instantiate the screens
		main = new MainScreen(this);
				
		// this.screen = main
		setScreen(main);
	}

}
