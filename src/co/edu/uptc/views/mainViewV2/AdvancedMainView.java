package co.edu.uptc.views.mainViewV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class AdvancedMainView   extends JFrame implements ViewInterface  {

private ProcessView processView;
private PresenterInterface presenter;

private static AdvancedMainView instance; 
private final String RESOURCE_LANGAGE="resources.mainViewV1Message";
    private AdvancedMainView() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initComponents();
    }


    protected PresenterInterface getPresenter(){
        return presenter;
    }

    public static AdvancedMainView getInstance(){
        if (instance==null){
            instance = new AdvancedMainView();
        }
        return instance;
    }

    private void initComponents() {
        addBtnCal();        
    }

    private void addBtnCal(){

        JPanel panelBoton = new JPanel();
        panelBoton.setBounds(1,1,300,60);
        JButton btn = new JButton("Calculos Generales");
        panelBoton.add(btn);
        add(panelBoton);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               processView = new ProcessView(AdvancedMainView.this);
               processView.setVisible(true);
            }
            
        });
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
       this.presenter = presenter;
    }

    @Override
    public void run() {
        setVisible(true);
    }

    @Override
    public void setResult(String value) {
        processView.setRestult(value);
    }


    @Override
    public String getResourceLangage() {
        return RESOURCE_LANGAGE;
    }


    @Override
    public void showMessage(String value) {
        
    }



    


}
