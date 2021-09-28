package janelas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundJTextField extends JTextField {
    private Shape shape;
    private int roundDosCantos;
	private String hexCorDaBorda;
    public RoundJTextField(String texto, int arredondamento, String hexCorDaBorda) {
        super.setText(texto);
        roundDosCantos = arredondamento;
        this.hexCorDaBorda = hexCorDaBorda;
        setOpaque(false); 
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, roundDosCantos, roundDosCantos);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(Color.decode(hexCorDaBorda));
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, roundDosCantos, roundDosCantos);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1,roundDosCantos, roundDosCantos);
         }
         return shape.contains(x, y);
    }
}