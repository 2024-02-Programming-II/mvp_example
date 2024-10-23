package co.edu.uptc.models.modelv1;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import java.math.BigInteger;

public class MainModelBasic implements ModelInterface {

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
    public void process() throws ArithmeticException {
         Long aux = 2000L;
         Long tmp = 0L;
         tmp = aux/value;
        result = BigInteger.valueOf(tmp);
         
       presenter.updateRestul(result);
    }

    // public void process() {
    //     for (long i = 1; i <= value; i++) {
    //         result = result.add(BigInteger.valueOf(i));
    //     }

    //    presenter.updateRestul(result);
    // }



}