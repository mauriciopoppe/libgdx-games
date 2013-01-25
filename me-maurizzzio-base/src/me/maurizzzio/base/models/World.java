package me.maurizzzio.base.models;

public class World {
	
	// world objects declarations...
	public Particle particle;
	public Particle trap;
	
	public World() {
		// create a demo world
		createDemoWorld();
	}
	
	private void createDemoWorld() {
		// create the demo world...
		particle = new Particle(0f, 0f, 50f, 50f);
		trap = new Trap(100f, 100f, 50f, 100f);
	}
}
