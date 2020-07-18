package display;

import java.awt.Graphics;

public abstract class Sprite {
	private static int sIdKey = 0;
	public final int mId;

	Sprite() {
		mId = sIdKey++;
	}

	Sprite(Sprite aSprite) {
		mId = aSprite.mId;
	}

	public abstract void redraw(Graphics aGraphics);
}
