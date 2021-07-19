package views;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainPanel extends JPanel {

	private JLeftPanel jLeftPanel;
	private JCenterPanel jCenterPanel;
	private JNorthPanel jNorthPanel;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public JMainPanel(ActionListener actionListener) {
		this.setLayout(new BorderLayout(0, 0));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setBackground(Constant.COLOR_WHITE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jNorthPanel = new JNorthPanel(actionListener);
		this.add(jNorthPanel,BorderLayout.NORTH);

		jLeftPanel = new JLeftPanel(actionListener);
		this.add(jLeftPanel,BorderLayout.WEST);

		jCenterPanel = new JCenterPanel(actionListener);
		this.add(jCenterPanel,BorderLayout.CENTER);

		JSouthPanel jSouthPanel = new JSouthPanel();
		this.add(jSouthPanel,BorderLayout.SOUTH);
	}

	public void labelsFalse(){
		jLeftPanel.labelsFalse();
	}

	public void setUser(String user,String code){
		jNorthPanel.setUser(code,user);
	}

	public void setLastClient(String code,String name){
		jCenterPanel.setLastClient(code,name);
	}

	public void setValues(){
		jCenterPanel.setValues();
	}

	public Object[] createClient(){
		return jCenterPanel.createClient();
	}

	public void setLabels(String[] users,String[] code){
		jLeftPanel.setLabels(users,code);
	}
}
