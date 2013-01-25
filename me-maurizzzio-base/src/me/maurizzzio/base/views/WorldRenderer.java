package me.maurizzzio.base.views;

import me.maurizzzio.base.Constants;
import me.maurizzzio.base.models.Particle;
import me.maurizzzio.base.models.ParticleAccesor;
import me.maurizzzio.base.models.World;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class WorldRenderer {

	/**
	 * Reference to the world this worldRenderer belongs to
	 */
	private World world;
	
	/**
	 * Camera used in this renderer
	 */
	private OrthographicCamera camera;
	
	/**
	 * Debug shape used for rendering
	 * Example of use:
	 * 
	 * 		// in the method render
	 * 		debugShape.setProjectionMatrix(camera.combined);		// use the matrix provided by the camera as the projection matrix
	 * 		debugShape.begin(ShapeType.Rectangle);				// each shape renderer will be a rectangle
	 * 			debugShape.rect(x, y, width, height);				// draw a rectangle at (x, y)
	 * 		debugShape.end();										// end render process
	 */
	private ShapeRenderer debugShape;
	
	/**
	 * Sprite batch used to render textures
	 */
	private SpriteBatch spriteBatch;
	
	/**
	 * Asset manager used to load resources http://code.google.com/p/libgdx/wiki/AssetManager
	 * Works for: Textures, Sounds, Music, TextureAtlases, TiledAtlased, PixMaps
	 * 
	 * 		// e.g.
	 * 		assetManager = new AssetManager();
	 * 		assetManager.load("data/mytexture.png", Texture.class);
	 * 		assetManager.load("music/mymusic.ogg", Music.class);
	 * 
	 * 		Texture tex = assetManager.get("data/mytexture.png", Texture.class);
	 */
	private AssetManager assetManager;
	
	/**
	 * Instance of the class TweenManager
	 */
	private TweenManager tweenManager;
	
	public WorldRenderer(World world) {
		this.world = world;
		
		// *** TweenEngine ***
		this.tweenManager = new TweenManager();
		// register the class Particle and its accesor
		Tween.registerAccessor(Particle.class, new ParticleAccesor());
		
		// *** Camera ***
		// create the instance of OrthographicCamera(width, height) of the view port
		this.camera = new OrthographicCamera(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
		// center the camera
		this.camera.position.set(Constants.GAME_WIDTH / 2f, Constants.GAME_HEIGHT / 2f, 0f);		
		// camera's values have been updated, so update the camera
		this.camera.update();
		
		// *** Assets ***
		// load assets
		this.assetManager = new AssetManager();
		loadAssets();
	}
	
	private void loadAssets() {
		// load assets here...
	}

	public void render(float delta) {
		// render logic goes here...
		
		// tween interpolations go here..
		
		// finally update the tween manager
		tweenManager.update(delta);
	}
}
