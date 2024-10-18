package co.edu.uptc.models.modelv2;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import java.math.BigInteger;

public class MainModelAdvanced implements ModelInterface {

    private PresenterInterface presenter;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    private long value;
    private BigInteger result = BigInteger.ZERO;



    @Override
    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public void process() {
  
        BigInteger n = BigInteger.valueOf(value);
        result = n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2)); 
       presenter.updateRestul(result);
    }

}