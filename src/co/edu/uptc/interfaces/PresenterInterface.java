package co.edu.uptc.interfaces;

import java.math.BigInteger;

public interface PresenterInterface {
    public void setView(ViewInterface view);
    public void setModel(ModelInterface model);

    public void calculate(Long value);

    public void updateRestul(BigInteger value);
}
