package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcella
 */
@WebServlet(name = "addContact", urlPatterns = {"/addContact"})
public class addContact extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();

        String name = request.getParameter("nome");
        String address = request.getParameter("endereco");
        String email = request.getParameter("email");
        String birthDate = request.getParameter("dataNasc");
        Calendar dataNascimento = null;
        try {
            
            // fazendo a conversão da data
            try {
                
                Date date = new SimpleDateFormat("ddMMyyyy").parse(birthDate);
                dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(date);
            } catch (ParseException e) {
                out.println("Erro de conversão da data");
                return; //para a execução do método
            }


        
        
            Contact contact = new Contact();

            contact.setName(name);
            contact.setEmail(email);
            contact.setAddress(address);
            contact.setBirthDate(dataNascimento);
            out.println("Testing!");

            ContactDAO dao = new ContactDAO();

            dao.addContact(contact);

            out.println("REGISTERED!");

        }catch(RuntimeException e){
            out.println("Erro: " + e);
            
        } finally {
            out.close();
        }
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
