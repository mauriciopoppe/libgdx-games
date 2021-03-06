package me.maurizzzio.base.controllers;

import me.maurizzzio.base.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class InputController implements InputProcessor {

	private static InputController instance = null;
	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean screenTouched = false;
	public static int X = 0;
	public static int Y = 0;
	
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
		switch (keycode) {
			case Keys.UP:
				up = true;
				break;
			case Keys.DOWN:
				down = true;
				break;
			case Keys.LEFT:
				left = true;
				break;
			case Keys.RIGHT:
				right = true;
				break;
		}
//		Gdx.app.log("keyDown", keycode + "");
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		switch (keycode) {
			case Keys.UP:
				up = false;
				break;
			case Keys.DOWN:
				down = false;
				break;
			case Keys.LEFT:
				left = false;
				break;
			case Keys.RIGHT:
				right = false;
				break;
		}
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
		screenTouched = true;
		X = screenX;
		Y = (int) (Constants.SCREEN_HEIGHT - screenY);
		Gdx.app.log("touchDown", screenX + " " + screenY);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// IMPORTANT! top left corner is 0, 0
		screenTouched = false;
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
