package com.petar.asistent.controller;

import com.petar.asistent.data.Imenik;
import com.petar.asistent.exception.AsistentException;
import com.petar.asistent.service.ImenikService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImenikServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AsistentException {
        
        String action = request.getParameter("action"); 
        TIpAkcije tipAkcije = TIpAkcije.getForAction(action);
       

        try {
            switch (tipAkcije) {
                case ADD: {
                    String imePrezime = request.getParameter("imePrezime");
                    Integer brojTelefona = Integer.parseInt(request.getParameter("brojTelefona"));

                    Imenik imenik = new Imenik(imePrezime, brojTelefona);

                    ImenikService.getInstance().add(imenik);

                    request.setAttribute("message", "Imenik " + imenik.getImePrezime()+ " uspesno dodata.");
                    break;
                }
                case EDIT: {
                    String imePrezime = request.getParameter("imePrezime");
                    Integer brojTelefona = Integer.parseInt(request.getParameter("brojTelefona"));
                    Integer idImenik = Integer.parseInt(request.getParameter("idImenik"));

                    Imenik imenik = new Imenik(idImenik, imePrezime, brojTelefona);

                    ImenikService.getInstance().edit(imenik);

                    request.setAttribute("message", "Imenik " + imenik.getImePrezime()+ " uspesno izmenjena.");
                    break;
                }
                case DELETE: {
                    Integer idImenik = Integer.parseInt(request.getParameter("idImenik"));
                    Imenik imenik = new Imenik(idImenik);
                    ImenikService.getInstance().delete(imenik);
                    
                    request.setAttribute("message", "Imenik je uspesno izbrisan.");
                    break;
                }
            }
        } catch (AsistentException ex) {
            request.setAttribute("errors", ex.getErrorMessages());
        }

        List<Imenik> imenici = ImenikService.getInstance().findAll();
       
        
        
        request.setAttribute("imenici", imenici);
        
        //treba napraviti da se izbacuje na section filmovi
        request.getRequestDispatcher("/WEB-INF/pages/imenik.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (AsistentException ex) {
            Logger.getLogger(ImenikServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (AsistentException ex) {
            Logger.getLogger(ImenikServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
