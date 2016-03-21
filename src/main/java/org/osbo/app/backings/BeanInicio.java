/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.osbo.app.backings;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joaquin
 */
@ManagedBean(name = "beanInicio")
@RequestScoped
public class BeanInicio {

    public void onload() {
        //ejecutado al cargar la pagina
        // se mata la session por prevencion 
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext externalContext = fc.getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            sessionMap.put("idsession",null);
            System.out.println("Se mato la session para prevenir errores");
        } catch (Exception ex) {
            //ignoramos ya que si da error es porque no habia session
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
        }
    }
}
