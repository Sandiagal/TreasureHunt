
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class MyButton extends JPanel implements MouseListener {
	ActionListener a;
	Boolean b = false;
	String s = null;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		if (s == null) {
			g2.setColor(new Color(102, 155, 255));
			g2.fill3DRect(0, 0, this.getWidth(), this.getHeight(), true);
		} else {
			Image img = Toolkit.getDefaultToolkit().getImage(s);
			if (img.getSource() == null)
				return;
			g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		if (b == true) {
			float thick = 2.5f;
			Stroke s = g2.getStroke();
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
			g2.drawRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
			g2.setStroke(s);
		}
	}

	public void SetIcon(String s) {
		this.s = s;
		repaint();
	}

	public void addActionListener(ActionListener a) {
		this.a = a;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(((MouseEvent) e).getButton() == MouseEvent.BUTTON3))
			a.actionPerformed(null);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		b = true;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		b = false;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
