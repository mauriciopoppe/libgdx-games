package me.maurizzzio.base.models;

import aurelienribon.tweenengine.TweenAccessor;

public class TrapAccesor implements TweenAccessor<Trap> {

	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;
	public static final int POSITION_XY = 3;
	
	@Override
	public int getValues(Trap target, int tweenType, float[] returnValues) {
		// TODO Auto-generated method stub
		switch (tweenType) {
        case POSITION_X: 
        	returnValues[0] = target.shape.x;
        	return 1;
        case POSITION_Y: 
        	returnValues[0] = target.shape.y;
        	return 1;
        case POSITION_XY:
            returnValues[0] = target.shape.x;
            returnValues[1] = target.shape.y;
            return 2;
        default: assert false; return -1;
    }
	}

	@Override
	public void setValues(Trap target, int tweenType, float[] newValues) {
		// TODO Auto-generated method stub
		switch (tweenType) {
        case POSITION_X: 
        	target.shape.x = newValues[0]; 
        	break;
        case POSITION_Y: 
        	target.shape.y = newValues[0]; 
        	break;
        case POSITION_XY:
            target.shape.x = newValues[0];
            target.shape.y = newValues[1];
            break;
        default: assert false; break;
    }
	}

}
