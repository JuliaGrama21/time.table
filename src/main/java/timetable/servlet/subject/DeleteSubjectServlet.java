package timetable.servlet.subject;

import timetable.constant.ErrorConstants;
import timetable.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSubjectServlet", urlPatterns = {"/deleteSubject"})
public class DeleteSubjectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubjectService subjectService = new SubjectService();
        Long id = Long.valueOf(request.getParameter("id"));
        boolean isSubjectDeleted = subjectService.deleteSubject(id);
        if (isSubjectDeleted) {
            request.getRequestDispatcher("jsp/subject/listOfSubjects.jsp").forward(request, response);
        } else {
            request.setAttribute("error", ErrorConstants.SUBJECT_IS_IN_TIMETABLE);
            request.getRequestDispatcher("jsp/subject/listOfSubjects.jsp").forward(request, response);
        }
    }
}
