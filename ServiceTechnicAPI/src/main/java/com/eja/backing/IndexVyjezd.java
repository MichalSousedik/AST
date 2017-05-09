package com.eja.backing;

import com.eja.facade.TrasaFacadeREST;
import com.eja.facade.VyjezdFacadeREST;
import com.eja.model.Mesto;
import com.eja.model.Technik;
import com.eja.model.Trasa;
import com.eja.model.Vyjezd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("indexVyjezd")
@RequestScoped
public class IndexVyjezd {

    @Inject
    VyjezdFacadeREST vyjezdData;

    private int iterator;

    @PostConstruct
    void init(){
        iterator = 1;
    }
    
    public List<Vyjezd> getVyjezd() {
        List<Vyjezd> sorted = vyjezdData.findAll();
        Collections.sort(sorted, Vyjezd.getCompByTime());
        return sorted;
    }

    public List<Vyjezd> getTechnikVyjezd(Technik technik) {
        List<Vyjezd> sorted = vyjezdData.findAll();
        Collections.sort(sorted, Vyjezd.getCompByTime());
        List<Vyjezd> dst = new ArrayList<>();
        for (Vyjezd x : sorted) {
            if (x.getIdTechnik().getIdDispecer()== technik.getIdDispecer()) {
                dst.add(x);
            }
        }

        return dst;
    }

    public void delete(Long id) {
        vyjezdData.remove(id);
    }

    public int getIterator() {
        return iterator++;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }

}
