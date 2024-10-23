package co.edu.uptc.presenters;

import java.math.BigInteger;
import java.util.Locale;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.helpers.InternationalizationManager;

public class MainPresenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;
    private InternationalizationManager internationalizationManager;

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
        internationalizationManager = new InternationalizationManager(this.view.getResourceLangage());
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void calculate(Long value) {
       model.setValue(value);
       try {
           model.process();
           
       } catch ( ArithmeticException e) {         
         view.showMessage(getLanguageMessage("model.divZero"));

       } 
    }

    @Override
    public void updateRestul(BigInteger value) {
      String aux = value.toString();  
      view.setResult(aux);
    }

    @Override
    public void changeLanguage(Locale locale) {
       internationalizationManager.changeLanguage(locale);
    }

    @Override
    public String getLanguageMessage(String key) {
       return  internationalizationManager.getResourceBundle().getString(key);
    }
    

}
