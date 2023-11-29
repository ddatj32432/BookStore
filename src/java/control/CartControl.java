/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import entity.Cart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
@WebServlet(name="CartControl", urlPatterns={"/cart"})
public class CartControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out= response.getWriter()){
            ArrayList<Cart> cartList= new ArrayList<>();
            int pid= Integer.parseInt(request.getParameter("pid"));
            Cart cm=new Cart();
            cm.setId(pid);
            cm.setQuantity(1);
            
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
            
            
            if(cart_list == null){
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                out.println("session add");
            }else{
                cartList=cart_list;
                boolean exits = false;
                
                for(Cart c : cart_list){
                    if(c.getId()==pid){
                        exits=true;
                        out.println("<h3 style'color:crimson; text-algin:center'>Item already exist in Cart<a href='Cart.jsp'>Go to cart</a></h3>");
                    }
                    
                }
                if(!exits){
                        cartList.add(cm);
                        out.println("added");
                        response.sendRedirect("Cart.jsp");
                    }
            
            }
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
