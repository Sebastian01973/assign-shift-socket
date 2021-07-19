package views.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JModelButton extends JButton{

	private int arcW;
	private int arcH;
	private static final long serialVersionUID = 1L;

	/**
	 * @descprtion Este metodo nos pone un botton
	 * @param text
	 * @param imagePath
	 * @param font
	 * @param
	 */
	public JModelButton(String text,String imagePath,Font font, Color...colors) {
		super(text);
		this.setFont( font );
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )) );
		this.setBorderPainted( false );
		this.setFocusable( false );
		this.setOpaque(false);
		this.setHorizontalTextPosition( SwingConstants.CENTER );
		this.setVerticalTextPosition( SwingConstants.BOTTOM );
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(colors[0]);
		this.setForeground(colors[1]);
	}

	public JModelButton(int arcW, int arcH,String imagePath,int width,int height,Color bg,Color fg) {
		ImageIcon imagen = new ImageIcon(getClass().getResource(imagePath));
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		this.setIcon(icon);
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBorderPainted( false );
		this.setFocusable( false );
		this.setOpaque(false);
		this.setBackground(bg);
		this.setForeground(fg);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public JModelButton(String imagePath) {
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )) );
		this.setBorderPainted( false );
		this.setFocusable( false );
		this.setOpaque(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public JModelButton(String imagePath,int width,int height) {
		ImageIcon imagen = new ImageIcon(getClass().getResource(imagePath));
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		this.setIcon(icon);
		this.setBorderPainted( false );
		this.setFocusable( false );
		this.setOpaque(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public JModelButton( int arcW, int arcH, String text, Color codeColorBackground, Color codeColorForeground, String command, ActionListener listener) {
		super( text );
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground( codeColorBackground );
		this.setContentAreaFilled( false );
		this.setForeground(  codeColorForeground );
		this.setActionCommand( command );
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.addActionListener( listener );
	}
	
	public JModelButton( int arcW, int arcH, String text, Color codeColorBackground, Color codeColorForeground, Font font, String command, ActionListener listener) {
		super( text );
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground( codeColorBackground );
		this.setContentAreaFilled( false );
		this.setForeground(  codeColorForeground );
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setFont( font );
		this.setActionCommand( command );
		this.addActionListener( listener );
	}

	public void generateJoption(String text,int type) {
		this.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				switch (type) {
				case 0:
					break;
				case 1:
					JOptionPane.showMessageDialog(null,text);
				default:
					break;
				}
			}
		});
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; 
		g2.setColor(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);           
		g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getBackground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
	}

}
