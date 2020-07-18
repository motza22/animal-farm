package display;

import java.util.Vector;

public class ConsoleManager {
	private static final int sRowHeight = 12;
	private int mX = 0;
	private int mY = 0;
	private int mHeight = 0;
	private Vector<JString> mStrings = new Vector<JString>();

	public ConsoleManager(int aX, int aY, int aHeight) {
		mX = aX;
		mY = aY;
		mHeight = aHeight;
	}

	private void addString(JString aJString) {
		JFrameApplication.getInstance().addSprite(aJString);
		mStrings.addElement(aJString);
	}

	public void print(String aString) {
		JString jString = new JString(0, 0, aString);
		addString(jString);

		int count = 0;
		for(int i = mStrings.size() - 1; i >= 0; i--) {
			if(sRowHeight * count < mHeight) {
				mStrings.elementAt(i).mX = mX;
				mStrings.elementAt(i).mY = (mY + mHeight) - (sRowHeight * count);
				count++;
			} else {
				removeString(mStrings.elementAt(i));
			}
		}
		JFrameApplication.getInstance().redrawCanvas();
	}

	private void removeString(JString aJString) {
		JFrameApplication.getInstance().removeSprite(aJString);
		mStrings.remove(aJString);
	}
}
