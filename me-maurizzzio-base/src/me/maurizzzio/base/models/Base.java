package me.maurizzzio.base.models;

import com.badlogic.gdx.math.Rectangle;

public class Base {
	
	public Rectangle shape;
	
	public Base(float x, float y, float width, float height) {
		this.shape = new Rectangle(x, y, width, height);		
	}
		
}
