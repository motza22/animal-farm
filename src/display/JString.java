package display;

import java.awt.Color;
import java.awt.Graphics;

public class JString extends Sprite {
	private String mString;
	public int mX;
	public int mY;

	public JString(int aX, int aY, String aString) {
		mString = aString;
		mX = aX;
		mY = aY;
	}

	public JString(JString aJString) {
		mString = aJString.mString;
		mX = aJString.mX;
		mY = aJString.mY;
	}

	public void setText(String aString) {
		mString = aString;
	}

	@Override
	public void redraw(Graphics aGraphics) {
		aGraphics.setColor(Color.BLACK);
		aGraphics.drawString(mString, mX, mY);
	}
}
