package com.eja.backing;

import com.eja.facade.MestoFacadeREST;
import com.eja.model.Mesto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("indexMesto")
@RequestScoped
public class IndexMesto {

    @Inject
    MestoFacadeREST mestoData;

    public List<Mesto> getMesto() {

        return mestoData.findAll();
    }

}
