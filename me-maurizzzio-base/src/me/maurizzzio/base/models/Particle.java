package me.maurizzzio.base.models;

import me.maurizzzio.base.Constants;
import me.maurizzzio.base.controllers.InputController;
import me.maurizzzio.base.views.WorldRenderer;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Elastic;

import com.badlogic.gdx.Gdx;

public class Particle extends Base{

	public Particle(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void update(float delta) {
		// TODO Auto-generated method stub
		if (Gdx.input.justTouched()) {
			
			Gdx.app.log("update", "Screen touched");
			
			// InputController.X and InputController.Y are screen relative	
			Tween.to(this, ParticleAccesor.POSITION_XY, 0.5f)
			 .target(
					 InputController.X * Constants.StoC_WIDTH,
					 InputController.Y * Constants.StoC_HEIGHT
			  )
			 .ease(Elastic.INOUT)
//			 .delay(1f)
			 .repeatYoyo(1, 0.5f)
			 .start(WorldRenderer.tweenParticle);
		}
	}
	
}
