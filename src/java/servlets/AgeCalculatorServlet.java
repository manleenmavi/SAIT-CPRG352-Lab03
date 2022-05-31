package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

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
        String ageInput = request.getParameter("user_age");
        String outputMessage = "";

        if (ageInput == null || ageInput.equals("")) {
            outputMessage = "You must give your current age.";

        } else {
            int ageInteger;
            
            try{
                ageInteger = Integer.parseInt(ageInput);
                
                // Checking if age is positive
                if (ageInteger < 0) {
                   outputMessage = "Please enter your correct age.";
                } else {
                
                    // Incrementing the age
                    ageInteger++;
                
                   //Displaying new birthday
                   outputMessage = "Your age next birthday will be " + ageInteger;
                }
            } catch (NumberFormatException e) {
                outputMessage = "You must enter a number.";
            }
            
        }
        
        request.setAttribute("output_message", outputMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

    }

}
