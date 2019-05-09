
package com.oe.chillerstaging;

import com.oe.controller.Controller;
import com.oe.model.Model;
import com.oe.view.MainFrame;


public class GlueCode {

    public GlueCode() {
        Model model = new Model();
        MainFrame view = new MainFrame();
        Controller controller = new Controller();

        controller.tellControllerAboutTheModel(model);
        controller.tellTheControllerAboutTheView(view);

        view.setController(controller);
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        controller.initModel();

    }
}
