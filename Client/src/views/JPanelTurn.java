package views;

import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;

public class JPanelTurn extends JPanel {

    private JModelLabel jMLCode,jMLName,jMLImage;

    public JPanelTurn(String imgPath) {
        this.setBorder(BorderFactory.createEmptyBorder(10,5,10,3));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Constant.COLOR_BLUE_RIGHT);
        initComponents(imgPath);
    }

    private void initComponents(String imgPath) {
        jMLCode = new JModelLabel("",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_BLUE_RIGHT,Constant.COLOR_WHITE);
        this.add(jMLCode);

        jMLImage = new JModelLabel(imgPath,35,35);
        this.add(jMLImage);

        jMLName = new JModelLabel("",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_BLUE_RIGHT,Constant.COLOR_WHITE);
        this.add(jMLName);
    }

    public void setBorders(int top, int left, int bottom,int right){
        this.setBorder(BorderFactory.createEmptyBorder(top,left,bottom,right));
    }

    public void setValues(String code,String name){
        jMLName.setText(name);
        jMLCode.setText(code);
    }

    public void setFgFirst(Color bg){
        this.setForeground(bg);
        jMLCode.setForeground(bg);
        jMLName.setForeground(bg);
    }

    public void setBgFirst(Color bg){
        this.setBackground(bg);
        jMLCode.setBackground(bg);
        jMLName.setBackground(bg);
    }
}
