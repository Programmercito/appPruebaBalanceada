/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.osbo.app.backings;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            ExternalContext externalContext = fc.getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            id = sessionMap.get("idsession").toString();
            System.out.println("recueprando ID:" + id);
        } catch (Exception Ex) {
            throw new Exception("SESSION NO INICIADA !!!");
        }
        return id;
    }

    public String getIps() throws SocketException {
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        String ips = "";
        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                //System.out.println(i.getHostAddress());
                ips = ips + ";" + i.getHostAddress();
            }
        }
        return ips;
    }

    public String getIp() throws SocketException {
        /*InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ips = ip.toString();*/
        return this.getIps();
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
        return "/app/menu.xhtml";
    }

    public String menu2() {
        System.out.println("ENTRANDO A LA OPCION2");
        return "/app/menu2.xhtml";
    }

    public String cerrar() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse hre = (HttpServletResponse) fc.getExternalContext().getResponse();
        hre.sendRedirect("/appbalanceada/faces/index.xhtml");
        fc.responseComplete();
        /*
        HttpSession sesion = (HttpSession) fc.getExternalContext().getSession(false);
        try {
            sesion.invalidate();
        } catch (Exception e) {
            System.out.println("no se invalida la session ya que ya esta cerrada");
        }
        System.out.println("SALIENDO");
        return "/index.xhtml";*/
        return null;
    }
}
