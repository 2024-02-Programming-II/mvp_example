package co.edu.uptc.views.mainViewV1;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;


import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainBasicView extends JFrame implements ViewInterface {
    private final String RESOURCE_LANGAGE="resources.mainViewV1Message";

    private PresenterInterface presenter;
    private JTextField tValue;
    private JLabel labelValue;
    private JButton btnProcess;
    private JLabel resultLabel;
    private JButton btnSpanish;
    private JButton btnEnglish;

    @Override
    public void setPresenter(PresenterInterface presenter) {
       this.presenter = presenter;
    }

    @Override
    public void run() {
        initComponents();
        setVisible(true);
    }


    private JLabel result;

    public MainBasicView() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
       
    }

    private void initComponents() {
        addGetInfo();
        addBtnProcess();
        addBtnResult();
        addBtnsChangelangages();
        updateView();

    }

    private void addGetInfo(){
        JPanel panelInfo = new JPanel();
        panelInfo.setPreferredSize(new Dimension(400,40));
        labelValue = new JLabel();
        panelInfo.add(labelValue);
        tValue = new JTextField();
        tValue.setPreferredSize(new Dimension(100,30));
        panelInfo.add(tValue);
        add(panelInfo);
        
    }

    private void addBtnProcess(){
        JPanel panelBoton = new JPanel();
        panelBoton.setPreferredSize(new Dimension(400,30));
        btnProcess = new JButton();
        panelBoton.add(btnProcess);
        add(panelBoton);

        btnProcess.addActionListener(new ActionListener() {
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
         resultLabel = new JLabel();
        panelResult.add(resultLabel);
        result = new JLabel("0 ");
        panelResult.add(resultLabel);
        add(panelResult);
        add(result);
    }


  private void addBtnsChangelangages(){
    JPanel panelButonLangage = new JPanel();
    panelButonLangage.setPreferredSize(new Dimension(400,30)); 
    
    addBtnSpanish(panelButonLangage);
    addBtnEnglish(panelButonLangage);

    add(panelButonLangage);
  }

  private void addBtnSpanish( JPanel panelButonLangage){
    btnSpanish = new JButton(); 
    panelButonLangage.add(btnSpanish);
    btnSpanish.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.changeLanguage(new Locale("es", "CO"));
            updateView();
        }
        
    });

  }

  private void addBtnEnglish( JPanel panelButonLangage){
    btnEnglish = new JButton(); 
    panelButonLangage.add(btnEnglish);
    btnEnglish.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.changeLanguage(new Locale("en", "US"));
            updateView();
        }
        
    });
  }



    @Override
    public void setResult(String value) {
        result.setText(value);
    }

    @Override
    public String getResourceLangage() {
       return RESOURCE_LANGAGE;
    }

     public void updateView(){
        setTitle(presenter.getLanguageMessage("project.title"));
        labelValue.setText(presenter.getLanguageMessage("mainViewV1.MainBasicView.value"));
        btnProcess.setText(presenter.getLanguageMessage("mainViewV1.MainBasicView.btnProcess"));
        resultLabel.setText(presenter.getLanguageMessage("mainViewV1.MainBasicView.result"));
        btnSpanish.setText(presenter.getLanguageMessage("mainViewV1.MainBasicView.btnSpanish"));
        btnEnglish.setText(presenter.getLanguageMessage("mainViewV1.MainBasicView.btnEnglish"));
     }


}
