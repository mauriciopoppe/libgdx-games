package me.maurizzzio.base.models;

public class World {
	
	// world objects declarations...
	public Particle particle;
	
	public World() {
		// create a demo world
		createDemoWorld();
	}
	
	private void createDemoWorld() {
		// create the demo world...
		particle = new Particle(0f, 0f, 50f, 50f);
	}
}
