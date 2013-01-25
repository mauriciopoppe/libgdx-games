package me.maurizzzio.base;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "me-maurizzzio-base";
		cfg.useGL20 = false;
		cfg.width = (int) Constants.SCREEN_WIDTH;
		cfg.height = (int) Constants.SCREEN_HEIGHT;
		
		new LwjglApplication(new GdxGame(), cfg);
	}
}
