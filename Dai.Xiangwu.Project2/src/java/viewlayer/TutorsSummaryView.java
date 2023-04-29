/* File: TutorsSummaryView.java
 * Author: Xiangwu Dai
 * Date: 2023/3/25
 * Description: Assignment2
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslayer.TutorsBusinessLogic;
import transferobjects.TutorDTO;
import java.util.List;
import transferobjects.CredentialsDTO;

/**
 * presentation class
 * @author Xiangwu Dai
 */
public class TutorsSummaryView extends HttpServlet {
    
    
    private CredentialsDTO creds = new CredentialsDTO();
    
    
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tutors Summary View</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tutors Summary View at " + request.getContextPath() + "</h1>");
          
            creds.setUsername(request.getParameter("username"));
            creds.setPassword(request.getParameter("password"));
            creds.setFirstname(request.getParameter("firstname"));
            creds.setLastname(request.getParameter("lastname"));
            creds.setCoursecode(request.getParameter("coursecode"));
            
//            creds.setUsername("root");
//            creds.setPassword("xiangwu01");
//            creds.setFirstname("Ken");
//            creds.setLastname("Thompson");
//            creds.setCoursecode("CST8101");
            
            TutorsBusinessLogic logic = new TutorsBusinessLogic(creds);
            
            TutorDTO tutor = logic.getTutorByName(creds);
            
            if(tutor.getTutorID() == null)
            {
                out.println("<ul>");
                out.printf("<li><b>FirstName: </b>%s</li>",creds.getFirstname());         
                out.printf("<li><b>LastName: </b>%s</li>", creds.getLastname());
                out.println("</ul>");
                out.println("The person has not registered as a tutor");
            }            
            
            else{
                creds.setTurtorID(tutor.getTutorID());
               if(logic.checkTutorExist(creds))
               {
                out.println("<ul>");
                out.printf("<li><b>FirstName: </b>%s</li>",creds.getFirstname());         
                out.printf("<li><b>LastName: </b>%s</li>", creds.getLastname());
                out.println("</ul>");
                out.println("This person has previously been registered as a tutor for this course.");
                out.println("");               
                   List<TutorDTO> tutors = logic.getAllTutors();
                   if (!tutors.isEmpty()) {
                       out.println("Tutors assigned to " + creds.getCoursecode());
                       out.println();
                       out.println("<table border=\"1\">");
                       out.println("<tr>");
                       out.println("<td>Tutor ID</td>");
                       out.println("<td>First Name</td>");
                       out.println("<td>Last Name</td>");
                       out.println("</tr>");
                       for (TutorDTO atutor : tutors) {
                           out.printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
                                   atutor.getTutorID(), atutor.getFirstName(), atutor.getLastName());
                       }
                       out.println("</table>");
                   }

                
                
                
               }
               
                   else if(!logic.checkCourseGradeExist(creds))
            {
                out.println("<ul>");
                out.printf("<li><b>FirstName: </b>%s</li>",creds.getFirstname());         
                out.printf("<li><b>LastName: </b>%s</li>", creds.getLastname());
                out.printf("<li><b>LastName: </b>%s</li>", creds.getCoursecode());
                out.println("</ul>");
                out.println("This tutor has no grade for this course");
            }   
                   
                   
                   
                   else if (logic.checkQualification(creds)) {
                       logic.assignTutor(creds);
                       List<TutorDTO> tutors = logic.getAllTutors();
                       if (!tutors.isEmpty()) {
                           out.println("Tutors assigned to " + creds.getCoursecode());
                           out.println();
                           out.println("<table border=\"1\">");
                           out.println("<tr>");
                           out.println("<td>Tutor ID</td>");
                           out.println("<td>First Name</td>");
                           out.println("<td>Last Name</td>");
                           out.println("</tr>");
                           for (TutorDTO atutor : tutors) {
                               out.printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
                                       atutor.getTutorID(), atutor.getFirstName(), atutor.getLastName());
                           }
                           out.println("</table>");
                       }
                   }
                else {
                    out.println("<ul>");
                    out.printf("<li><b>FirstName: </b>%s</li>", creds.getFirstname());
                    out.printf("<li><b>LastName: </b>%s</li>", creds.getLastname());
                    out.println("</ul>");
                    out.println("The person does not qualify to tutor this course as the obtained grade is not sufficient");
                }
            }
               

            out.println("</body>");
            out.println("</html>");

           
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
