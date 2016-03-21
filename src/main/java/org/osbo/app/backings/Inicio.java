package org.osbo.app.backings;

import java.util.Map;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author programmercito
 *
 */
@ViewScoped
@ManagedBean(name = "inicio")
public class Inicio {

    public String entrar() {
        System.out.println("entrando nueva version");
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext externalContext = fc.getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        UUID idOne = UUID.randomUUID();
        String codigo = idOne.toString();
        sessionMap.put("idsession", codigo);
        System.out.println("id sesion creado:" + codigo);
        return "/app/menu.xhtml";
    }

}
