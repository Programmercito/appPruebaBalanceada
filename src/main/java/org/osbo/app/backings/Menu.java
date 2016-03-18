/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.osbo.app.backings;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author programmercito
 */
@ViewScoped
@ManagedBean(name = "menu")
public class Menu {

    public String getIdsession() throws Exception {
        String id;
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession sesion = (HttpSession) fc.getExternalContext().getSession(false);
            id = sesion.getAttribute("idsession").toString();
        } catch (Exception Ex) {
            throw new Exception ("SESSION NO INICIADA !!!");
        }
        return id;
    }

    public String getIp() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest hs = (HttpServletRequest) fc.getExternalContext().getRequest();
        String ip = hs.getServerName();
        return ip;
    }

    public String getPort() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest hs = (HttpServletRequest) fc.getExternalContext().getRequest();
        int port = hs.getLocalPort();
        String portString = String.valueOf(port);
        return portString;
    }

    public String menu1() {
        System.out.println("ENTRANDO A LA OPCION1");
        return "menu.xhtml";
    }

    public String menu2() {
        System.out.println("ENTRANDO A LA OPCION2");
        return "menu2.xhtml";
    }

    public String cerrar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) fc.getExternalContext().getSession(false);
        sesion.invalidate();
        System.out.println("SALIENDO");
        return "/index.xhtml";
    }
}
