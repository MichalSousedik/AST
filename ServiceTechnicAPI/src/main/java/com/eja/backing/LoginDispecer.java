package com.eja.backing;

import com.eja.facade.DispecerFacadeREST;
import com.eja.facade.MestoFacadeREST;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("loginDispecer")
@RequestScoped
public class LoginDispecer {

    @Inject
    DispecerFacadeREST dispecerData;

    public List<Dispecer> getDispecer() {

        return dispecerData.findAll();
    }
    

}
