package views;

import rojeru_san.RSLabelFecha;
import rojeru_san.RSLabelHora;
import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JSouthPanel extends JPanel {

    private RSLabelFecha rsLabelFecha;
    private RSLabelHora rsLabelHora;

    public JSouthPanel() {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
        initComponents();
    }

    private void initComponents() {

        JPanel jPanel0 = new JPanel();
        jPanel0.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel0.setBorder(new EmptyBorder(0,0,0,0));
        jPanel0.setBackground(Constant.COLOR_WHITE);

        JModelLabel weather = new JModelLabel(Constant.WEATHER,25,25);
        jPanel0.add(weather);

        JModelLabel weather1 = new JModelLabel(" 20 °C",Constant.FONT_ARIAL_15_B,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        weather1.setBorder(new EmptyBorder(0,10,0,10));
        jPanel0.add(weather1);

        this.add(jPanel0);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel.setBorder(new EmptyBorder(0,100,0,100));
        jPanel.setBackground(Constant.COLOR_WHITE);

        JModelLabel calendar = new JModelLabel(Constant.CALENDAR,25,25);
        jPanel.add(calendar);

        rsLabelFecha = new RSLabelFecha();
        rsLabelFecha.setBackground(Constant.COLOR_WHITE);
        rsLabelFecha.setForeground(Constant.COLOR_BLACK);
        jPanel.add(rsLabelFecha);

        this.add(jPanel);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel1.setBorder(new EmptyBorder(0,0,0,0));
        jPanel1.setBackground(Constant.COLOR_WHITE);

        JModelLabel clock = new JModelLabel(Constant.CLOCK,25,25);
        jPanel1.add(clock);

        rsLabelHora = new RSLabelHora();
        rsLabelHora.setBackground(Constant.COLOR_WHITE);
        rsLabelHora.setForeground(Constant.COLOR_BLACK);
        jPanel1.add(rsLabelHora);

        this.add(jPanel1);

    }
}
