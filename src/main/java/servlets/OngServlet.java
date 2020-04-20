/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.OngBean;
import bean.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Rasec
 */
@WebServlet(name = "OngServlet", urlPatterns = {"/OngServlet"})
public class OngServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operetion");
        
        OngBean ong = new OngBean();
       
        ong.setName(request.getParameter("name"));
        ong.setNumber(request.getParameter("number"));
        ong.setEmail(request.getParameter("email"));
        ong.setDesc(request.getParameter("desc"));
        

        ServletContext context = getServletContext();

        List<OngBean> ongList;

        if (context.getAttribute("ongList") == null) {
            ongList = new LinkedList<>();
        } else {
            ongList = (List<OngBean>) context.getAttribute("ongList");
        }

        if (operation == null) {
            ongList.add(ong);
            context.setAttribute("ong", ong);
        }

        if (operation != null && operation.equalsIgnoreCase("PUT")) {
            String id = request.getParameter("id");
            for (OngBean ongFromList : ongList) {
                if (ongFromList.getId().equalsIgnoreCase(id)) {
                    ongFromList.setName(ong.getName());
                    ongFromList.setNumber(ong.getNumber());
                    ongFromList.setEmail(ong.getEmail());
                    
                    break;
                }

            }
        }

        context.setAttribute("ongList", ongList);
        response.sendRedirect("listaOngs.jsp");
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ongId = req.getParameter("ongId");

        ServletContext context = getServletContext();
        
          List<OngBean> ongList = (List<OngBean>) getServletContext()
                .getAttribute("ongList");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("atualizar.jsp");

        for (OngBean ong : ongList) {
            if (ong.getId().equalsIgnoreCase(ongId)) {
                req.setAttribute("ongToUpdate", ong);
                break;
            }
        }
        
        requestDispatcher.forward(req, resp);

   }
}
