package co.edu.uptc.views.mainViewV2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProcessView extends JDialog{
      private JLabel result;
      private JTextField tValue;

    public ProcessView(JFrame frame) {
        super(frame,true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        initComponents();
    }

    private void initComponents() {
        addGetInfo();
        addBtnProcess();
        addBtnResult();

    }

    private void addGetInfo(){
        JPanel panelInfo = new JPanel();
        panelInfo.setPreferredSize(new Dimension(400,40));
        JLabel label = new JLabel("Valor: ");
        panelInfo.add(label);
         tValue = new JTextField();
         tValue.setPreferredSize(new Dimension(100,30));
        panelInfo.add(tValue);
        add(panelInfo);
    }

    private void addBtnProcess(){
        JPanel panelBoton = new JPanel();
        panelBoton.setPreferredSize(new Dimension(400,30));
        JButton btn = new JButton("Procesar");
        panelBoton.add(btn);
        add(panelBoton);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long aux = Long.parseLong(tValue.getText());
               AdvancedMainView.getInstance().getPresenter().calculate(aux);

            }
            
        });
    }


    private void addBtnResult(){
        JPanel panelResult = new JPanel();
        panelResult.setPreferredSize(new Dimension(200,30));
        JLabel resultLabel = new JLabel("Resultado: ");
        panelResult.add(resultLabel);
        result = new JLabel("0 ");
        panelResult.add(resultLabel);
        add(panelResult);
        add(result);
    }

   public void setRestult(String value){
   result.setText(value);
   }

}
