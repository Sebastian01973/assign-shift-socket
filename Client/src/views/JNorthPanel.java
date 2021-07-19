package views;

import controllers.Command;
import views.models.JModelButton;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JNorthPanel extends JPanel {

    public JPanelTurn userNext;
    public JModelButton jBNextTurn;

    public JNorthPanel(ActionListener actionListener){
        this.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.C_BLUE_LEFT);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        JModelLabel jModelLabel = new JModelLabel(Constant.TITTLE_APP,Constant.FONT_ARIAL_25,Constant.COLOR_BLUE_RIGHT,Constant.COLOR_WHITE);
        this.add(jModelLabel,BorderLayout.WEST);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout(0,0));
        jPanel.setBackground(Constant.COLOR_WHITE);

        JModelLabel next = new JModelLabel(Constant.B_NEXT_USER,Constant.FONT_ARIAL_15_B,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        next.setBorder(BorderFactory.createEmptyBorder(0, 270,0,200));
        jPanel.add(next,BorderLayout.NORTH);

        userNext = new JPanelTurn(Constant.IMG_USER);
        userNext.setBackground(Constant.COLOR_WHITE);
        userNext.setBorders(0,0,0,0);
        jPanel.add(userNext,BorderLayout.CENTER);

        this.add(jPanel);
        jBNextTurn = new JModelButton( 5, 5,Constant.B_NEXT, Constant.C_RED_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_15, Command.DELETE_TURN.toString(), actionListener );
        jBNextTurn.setFont(Constant.FONT_ARIAL_ROUNDER_20);
        this.add( jBNextTurn ,BorderLayout.EAST);
    }

    public void setUser(String user,String code){
        userNext.setValues(code,user);
        userNext.setFgFirst(Constant.COLOR_BLACK);
        userNext.setBgFirst(Constant.COLOR_WHITE);
    }


}
