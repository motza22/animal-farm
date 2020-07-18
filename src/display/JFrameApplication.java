package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JFrame;

public class JFrameApplication extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JFrameApplication sApplication = null;
	public static final int sWidth = 1500;
	public static final int sHeight = 1000;
	private Vector<Sprite> mSprites = new Vector<Sprite>();

	public static JFrameApplication getInstance() {
		if(sApplication == null) {
			sApplication = new JFrameApplication();
		}
		return sApplication;
	}

	private JFrameApplication() {
		setSize(sWidth, sHeight);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setVisible(true);
		setTitle("Animal Farm");
	}

	public void addSprite(Sprite aSprite) {
		mSprites.addElement(aSprite);
	}

	public void clear() {
		mSprites.clear();
	}

	public void redrawCanvas() {
		repaint();
	}

	public void removeSprite(Sprite aSprite) {
		mSprites.remove(aSprite);
	}

	@Override
	public void paint(Graphics aGraphics) {
		// Throw away aGraphics...
		Image image = createImage(getWidth(), getHeight());
		Graphics background = image.getGraphics();
		for(int i=0; i<mSprites.size(); i++) {
			Sprite sprite = mSprites.get(i);
			sprite.redraw(background);
		}
		aGraphics.drawImage(image, 0, 0, this);
	}
}
