package com.eja.backing;

import com.eja.facade.TrasaFacadeREST;
import com.eja.model.Mesto;
import com.eja.model.Trasa;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("indexTrasa")
@RequestScoped
public class IndexTrasa {

    @Inject
    TrasaFacadeREST trasaData;

    public List<Trasa> getTrasa() {

        return trasaData.findAll();
    }

}
