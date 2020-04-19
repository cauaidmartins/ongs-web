/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martins
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operation = request.getParameter("operetion");
        
        UsuarioBean user = new UsuarioBean();
        
        user.setNome(request.getParameter("nome"));
        user.setCpf(request.getParameter("cpf"));
        user.setEmail(request.getParameter("email"));
        user.setSenha(request.getParameter("senha"));
        
        
        ServletContext context = getServletContext();

        List<UsuarioBean> userList;

        if (context.getAttribute("userList") == null) {
            userList = new LinkedList<>();
        } else {
            userList = (List<UsuarioBean>) context.getAttribute("userList");
        }

        if (operation == null) {
            userList.add(user);
            context.setAttribute("user", user);
        }

        if (operation != null && operation.equalsIgnoreCase("PUT")) {
            String id = request.getParameter("id");
            for (UsuarioBean customerFromList : userList) {
                if (customerFromList.getId().equalsIgnoreCase(id)) {
                    customerFromList.setNome(user.getNome());
                    customerFromList.setEmail(user.getEmail());
                    customerFromList.setCpf(user.getCpf());
                    break;
                }

            }
        }   
        
        context.setAttribute("userList", userList);
        response.sendRedirect("listaUsuario.jsp");
    }
      // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
