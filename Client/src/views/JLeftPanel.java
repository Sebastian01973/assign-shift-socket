package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JLeftPanel extends JPanel {
    
    private JPanelTurn[] turns;
    private String[] texts;
    private JPanelTurn jPanelTurn;


    public JLeftPanel(ActionListener actionListener) {
        GridLayout grid = new GridLayout(7, 1);
        grid.setVgap(15);
        this.setLayout(grid);
        this.setBackground(Constant.C_BLUE_LEFT);
        this.setPreferredSize(new Dimension(400,0));
        this.setBorder(new EmptyBorder(10,60,10,40));
        initComponent(actionListener);
    }

    private void initComponent(ActionListener actionListener) {

        jPanelTurn = new JPanelTurn(Constant.IMG_ARROW_RIGHT);
        jPanelTurn.setValues(Constant.TXT_TURN,Constant.TXT_CLIENT);
        jPanelTurn.setBgFirst(Constant.C_BLUE_LIGHT);
        this.add(jPanelTurn);

        texts = new String[6];
        turns = new JPanelTurn[6];
        for (int i = 0; i < 6; i++) {
            turns[i] = new JPanelTurn(Constant.IMG_ARROW_RIGHT);
            this.add(turns[i]);
        }
    }

    public void labelsFalse(){
        for (int i = 5; 0 <= i  ; i--) {
            turns[i].setVisible(false);
        }
    }

    public void setLabels(String[] users,String[] code){
        turns[0].setBgFirst(Constant.C_RED_OPAQUE);
        for (int i = 0; i < 6; i++) {
            turns[i].setValues(code[i],users[i]);
        }
        for (int i = 5; 0 <= i  ; i--) {
            if (users[i] == null && code[i] == null){
                turns[i].setVisible(false);
            }else {
                turns[i].setVisible(true);
            }
        }
    }

}
