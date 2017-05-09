package com.eja.backing;

import com.eja.facade.DispecerFacadeREST;
import com.eja.facade.MestoFacadeREST;
import com.eja.facade.TechnikFacadeREST;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Technik;
import com.eja.model.Trasa;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginTechnik {

    private String jmeno;
    private String prijmeni;
    private String prezdivka;
    private Long id;
    private Technik tech;

    @Inject
    TechnikFacadeREST technikData;

    public List<Technik> getTechnik() {

        return technikData.findAll();
    }

    public String logIn() {

        if (findTechnik()) {

            HttpSession hs = Util.getSession();
            return "indexTechnik?faces-redirect=true";

        }

        return "doesNotExist?faces-redirect=true";
    }

    public String doLogout() {
        HttpSession hs = Util.getSession();
        hs.invalidate();
        return "/index?faces-redirect=true";
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        this.prezdivka = prezdivka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Technik getTech() {
        return tech;
    }

    public void setTech(Technik tech) {
        this.tech = tech;
    }

    

    private boolean findTechnik() {
        for (Technik x : getTechnik()) {
            if (x.getPrezdivka().equals(prezdivka)) {
                jmeno = x.getJmeno();
                prijmeni = x.getPrijmeni();
                prezdivka = x.getPrezdivka();
                id = x.getIdDispecer();
                tech = x;
                return true;
            }
        }
        return false;
    }

}
