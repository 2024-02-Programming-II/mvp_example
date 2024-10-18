package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.models.modelv1.MainModelBasic;
import co.edu.uptc.models.modelv2.MainModelAdvanced;
import co.edu.uptc.views.viewMainV2.AdvancedMainView;
import co.edu.uptc.views.viewv1.MainBasicView;

public class Runner {
    private ViewInterface view;
    private PresenterInterface presenter;
    private ModelInterface model;

    public void start(){
        makeMVP();    
        view.run();
       

    }

    private void makeMVP(){
         view = AdvancedMainView.getInstance();
         presenter = new MainPresenter();
         model = new MainModelBasic();
  
        view.setPresenter(presenter);
        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }
    
}
