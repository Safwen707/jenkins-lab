package com.exemple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet qui reçoit les requêtes HTTP et retourne les résultats
 */
@WebServlet("/calculer")
public class CalculatriceServlet extends HttpServlet {
    
    private CalculatriceService service = new CalculatriceService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Récupérer les paramètres du formulaire
        String nombre1Str = request.getParameter("nombre1");
        String nombre2Str = request.getParameter("nombre2");
        String operation = request.getParameter("operation");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // Convertir les strings en nombres
            double nombre1 = Double.parseDouble(nombre1Str);
            double nombre2 = Double.parseDouble(nombre2Str);
            
            // Calculer le résultat
            double resultat = service.calculer(nombre1, nombre2, operation);
            
            // Envoyer la réponse HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Résultat</title>");
            out.println("<link rel='stylesheet' href='style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Résultat</h1>");
            out.println("<div class='result'>");
            out.println(nombre1 + " " + operation + " " + nombre2 + " = " + resultat);
            out.println("</div>");
            out.println("<a href='index.html'>Nouveau calcul</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (NumberFormatException e) {
            out.println("<h1>Erreur</h1>");
            out.println("<p>Veuillez entrer des nombres valides</p>");
            out.println("<a href='index.html'>Retour</a>");
        } catch (IllegalArgumentException e) {
            out.println("<h1>Erreur</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='index.html'>Retour</a>");
        }
    }
}