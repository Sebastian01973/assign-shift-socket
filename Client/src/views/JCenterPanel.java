package views;

import controllers.Command;
import views.models.JModelButton;
import views.models.JModelComboBox;
import views.models.JModelLabel;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JCenterPanel extends JPanel {

    private JButton jBTurn;
    private JModelTextField jTFNameStore;
    public JPanelTurn jBLastTurn;
    private JModelComboBox<Object> jCBcustomer;
    private JModelLabel jLcode,jshowCode;


    public JCenterPanel(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_WHITE);
        GridLayout grid = new GridLayout(7, 1);
        this.setBorder(new EmptyBorder(25, 25, 0, 25));
        grid.setVgap(15);
        this.setLayout(grid);
        initComponent(actionListener);
    }

    private void initComponent(ActionListener actionListener) {

        JModelLabel generateShift = new JModelLabel(Constant.GENERATE_TURN,Constant.FONT_ARIAL_25,Constant.COLOR_BLUE_RIGHT,Constant.COLOR_WHITE);
        generateShift.setBorder(BorderFactory.createEmptyBorder(20,130,20,90));
        this.add(generateShift);

        jTFNameStore = new JModelTextField(Constant.CUSTOMER_CLIENT, Constant.ENTER_NAME, Constant.FONT_ARIAL_ROUNDER_15, Constant.COLOR_WHITE);
        jTFNameStore.validateText(jTFNameStore);
        this.add(jTFNameStore);

        jCBcustomer = new JModelComboBox<Object>(Constant.OPTIONS, Constant.ASSIGN_OPTION, Constant.FONT_ARIAL_ROUNDER_17);
        this.add(jCBcustomer);

        jBTurn = new JModelButton(15, 15, Constant.ASSIGN, Constant.COLOR_BLUE_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_25, Command.TURN_CREATE.toString(), actionListener);
        this.add(jBTurn);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel1.setBackground(Constant.COLOR_WHITE);

        JModelLabel lastClient = new JModelLabel(Constant.LAST_SHIFT,Constant.FONT_ARIAL_ROUNDER_25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        jPanel1.add(lastClient);

        this.add(jPanel1);

        jBLastTurn = new JPanelTurn(Constant.IMG_LINE);
        jBLastTurn.setBackground(Constant.COLOR_WHITE);
        jBLastTurn.setBorders(0,0,0,0);
        this.add(jBLastTurn);

        jshowCode = new JModelLabel("",Constant.COLOR_DARK_BLUE,Constant.FONT_ARIAL_ROUNDER_30);
        jshowCode.setBorder(new EmptyBorder(0,100,0,0));
        this.add(jshowCode);
    }

    public void setLastClient(String code,String name){
        jBLastTurn.setFgFirst(Constant.COLOR_BLACK);
        jBLastTurn.setBgFirst(Constant.COLOR_WHITE);
        jBLastTurn.setValues(code,name);
    }

    public void setValues(){
        jCBcustomer.setItems(Constant.OPTIONS);
        jTFNameStore.setText("");
    }

    public Object[] createClient(){
        if (jCBcustomer.getSelectedIndex() == 0 || jTFNameStore.getText().isEmpty()){
            jCBcustomer.setItems(Constant.OPTIONS);
            return null;
        }else{
            int size = jTFNameStore.getText().length();
            if (size <= 9){
                return  new Object[]{jTFNameStore.getText().substring(0,size),
                        jCBcustomer.getSelectedIndex()};
            }else {
                return  new Object[]{jTFNameStore.getText().substring(0,9),
                        jCBcustomer.getSelectedIndex()};
            }
        }
    }
}
