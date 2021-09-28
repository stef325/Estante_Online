package janelas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

import javax.swing.JPopupMenu;
import javax.swing.border.AbstractBorder;

public class RoundComboBox extends AbstractBorder{
	private Shape shape;
	private int roundDosCantos;
	private String hexCorDaBorda;
	public RoundComboBox(int arredondamento, String hexCorDaBorda) {

		roundDosCantos = arredondamento;
		this.hexCorDaBorda = hexCorDaBorda;
		

	}

	public void paintBorder(
			Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int r = 40;
		int w = width  - 1;
		int h = height - 1;

		Area round = new Area(new RoundRectangle2D.Float(x, y, w, h, r, r));
		if (c instanceof JPopupMenu) {
			g2.setPaint(c.getBackground());
			g2.fill(round);
		} else {
			Container parent = c.getParent();
			if (Objects.nonNull(parent)) {
				g2.setPaint(Color.decode("#FFFFFF"));
				Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
				corner.subtract(round);
				g2.fill(corner);
			}
		}
		g2.setPaint(c.getForeground());
		g2.draw(round);
		g2.dispose();
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(4, 8, 4, 8);

	}
}




