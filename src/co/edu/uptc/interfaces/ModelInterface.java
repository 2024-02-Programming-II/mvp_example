package co.edu.uptc.interfaces;

public interface ModelInterface {
    public void setPresenter(PresenterInterface presenter);
    
   public void setValue(Long value);
   public void process() throws ArithmeticException;
}
