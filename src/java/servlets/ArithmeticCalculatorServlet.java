package servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArithmeticCalculatorServlet extends HttpServlet {

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
        // Showing initial result
        request.setAttribute("ac_result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

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
        
        //Getting values
        String firstInput = request.getParameter("ac_firstv");
        String secInput = request.getParameter("ac_secondv");
        String outResult = "";
        
        //Initializing Double variables
        double firstValue;
        double secValue;

        
        //Checking if the input is invalid
        if(firstInput == null || secInput == null || firstInput.equals("") || secInput.equals("")) {
            outResult = "invalid";
        } else {
            try {
                firstValue = Double.parseDouble(firstInput);
                secValue = Double.parseDouble(secInput);
                
                double calculatedResult = 0;
            
                switch(request.getParameter("ac_calculate").charAt(0)) {
                    case '+': calculatedResult = firstValue + secValue; break;
                    case '-': calculatedResult = firstValue - secValue; break;
                    case '*': calculatedResult = firstValue * secValue; break;
                    case '%': calculatedResult = firstValue % secValue; break;
                }
            
                //Decimal format
                outResult = new DecimalFormat("0.#############").format(calculatedResult);
            } catch(NumberFormatException e) {
                outResult = "invalid";
            }
        }

        //Presrving previous values
        request.setAttribute("p_fst_value", firstInput);
        request.setAttribute("p_sec_value", secInput);
        
        //Providing output
        request.setAttribute("ac_result", outResult);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

    }

}
