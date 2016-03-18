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

    public String getIdsession() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) fc.getExternalContext().getSession(false);
        String id=sesion.getAttribute("idsession").toString();
        return id;
    }
    public String getIp(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest hs=(HttpServletRequest )fc.getExternalContext().getRequest();
        String ip=hs.getLocalAddr();
        return ip;
    }
    public String getPort(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest hs=(HttpServletRequest )fc.getExternalContext().getRequest();
        int port=hs.getLocalPort();
        String portString=String.valueOf(port);
        return portString;
    }
}
