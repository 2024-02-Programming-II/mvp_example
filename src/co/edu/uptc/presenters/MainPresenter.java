package co.edu.uptc.presenters;

import java.math.BigInteger;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class MainPresenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void calculate(Long value) {
       model.setValue(value);
       model.process();
    }

    @Override
    public void updateRestul(BigInteger value) {
      String aux = value.toString();  
      view.setResult(aux);
    }
    
}
