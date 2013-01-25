package me.maurizzzio.base.models;

import me.maurizzzio.base.views.WorldRenderer;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Gdx;

public class Trap extends Particle{

	private static boolean animationStarted = false;
	private float start_y;
	
	public Trap(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		start_y = y;		
	}
	
	public void update(float delta) {
		if (!animationStarted) {
			Gdx.app.log("update", "entering once!");
			// animation 
			// InputController.X and InputController.Y are screen relative
			Timeline.createSequence()
			.push(
					Tween.to(this, ParticleAccesor.POSITION_Y, 0.25f)
					 	 .target(0f)
			)
			.push(
					Tween.to(this, ParticleAccesor.POSITION_Y, 1f)
						 .target(start_y)
			)
			.repeat(10000, 2f)
			.start(WorldRenderer.tweenParticle);
			animationStarted = true;
		}
	}
}
