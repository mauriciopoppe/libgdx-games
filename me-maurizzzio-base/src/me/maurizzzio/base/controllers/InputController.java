package me.maurizzzio.base.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputController implements InputProcessor {

	private static InputController instance = null;
	
	// this class is a singleton so it has a private constructor
	private InputController() {		
	}
	
	public static InputController getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new InputController();
		}
		return instance;
	}	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		Gdx.app.log("keyDown", keycode + "");
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// IMPORTANT! top left corner is 0, 0
		Gdx.app.log("touchDown", screenX + " " + screenY);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// IMPORTANT! top left corner is 0, 0
		Gdx.app.log("touchUp", screenX + " " + screenY);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
