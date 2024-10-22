package co.edu.uptc.interfaces;

public interface ViewInterface {
    public void setPresenter(PresenterInterface presenter);
    public void  run();
    public String getResourceLangage();

    public void setResult(String value);
}
