package me.maurizzzio.base.views;

import me.maurizzzio.base.Constants;
import me.maurizzzio.base.models.Particle;
import me.maurizzzio.base.models.ParticleAccesor;
import me.maurizzzio.base.models.Trap;
import me.maurizzzio.base.models.TrapAccesor;
import me.maurizzzio.base.models.World;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorldRenderer {

	/**
	 * Reference to the world this worldRenderer belongs to
	 */
	private World world;
	
	/**
	 * Camera used in this renderer
	 */
	public static OrthographicCamera camera;
	
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
	private ShapeRenderer shapeRenderer;
	
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
	 * Instance of the class TweenManager (static)
	 */
	public static TweenManager tweenParticle;
	public static TweenManager tweenTrap;
	
	public WorldRenderer(World world) {
		this.world = world;
		
		// *** spriteBatch ***
		spriteBatch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		
		// *** TweenEngine ***
		WorldRenderer.tweenParticle = new TweenManager();
		WorldRenderer.tweenTrap = new TweenManager();
		// register the class Particle and its accesor
		Tween.registerAccessor(Particle.class, new ParticleAccesor());
		Tween.registerAccessor(Trap.class, new TrapAccesor());
		
		// *** Camera ***
		// create the instance of OrthographicCamera(width, height) of the view port
		this.camera = new OrthographicCamera(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
		// center the camera
		this.camera.position.set(Constants.CAMERA_WIDTH / 2f, Constants.CAMERA_HEIGHT / 2f, 0f);		
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
		// initialize the camera, the sprite batch and the shapeRenderer
		initCamera();
		
		// render logic goes here...
		renderParticle(delta);
		
		// tween interpolations go here..
		
		// finally update the tween manager
		tweenParticle.update(delta);
	}

	private void renderParticle(float delta) {
		// TODO Auto-generated method stub
		Particle particle = this.world.particle;
		Trap trap = (Trap) this.world.trap;

		// TODO move this to particle.update()
		// update its position using tween engine
		particle.update(delta);
		trap.update(delta);
		
		// render shape
		shapeRenderer.begin(ShapeType.Rectangle);
			shapeRenderer.rect(particle.shape.x, particle.shape.y, particle.shape.width, particle.shape.height);
			shapeRenderer.rect(trap.shape.x, trap.shape.y, trap.shape.width, trap.shape.height);
		shapeRenderer.end();
	}
	
	private void initCamera () {
		// update camera here...
		
		// the debugger uses the same projection matrix as the camera
		shapeRenderer.setProjectionMatrix(camera.combined);
//		spriteBatch.getProjectionMatrix().setToOrtho2D(0f, 0, Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);				
//		Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}
}
