package co.edu.uptc.views.viewv1;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import javax.swing.JFrame;

    
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainBasicView extends JFrame implements ViewInterface {

    private PresenterInterface presenter;
    private JTextField tValue;
    
    @Override
    public void setPresenter(PresenterInterface presenter) {
       this.presenter = presenter;
    }

    @Override
    public void run() {
        setVisible(true);
    }


    private JLabel result;

    public MainBasicView() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
               presenter.calculate(aux);
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

    @Override
    public void setResult(String value) {
        result.setText(value);
    }


}
