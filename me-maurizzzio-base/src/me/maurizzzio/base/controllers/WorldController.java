package me.maurizzzio.base.controllers;

import me.maurizzzio.base.models.Particle;
import me.maurizzzio.base.models.Trap;
import me.maurizzzio.base.models.World;

public class WorldController {
	
	/**
	 * Reference to the world
	 */
	private World world;
	
	public WorldController(World world) {
		this.world = world;
	}
	
	/**
	 * Updates the world and its object (method called from screen.render())
	 * @param delta
	 */
	public void update(float delta) {
		// updates the world and its objects
		// TODO Auto-generated method stub
		Particle particle = this.world.particle;
		Trap trap = (Trap) this.world.trap;

		// TODO move this to particle.update()
		// update its position using tween engine
		particle.update(delta);
		trap.update(delta);
	}
}
