package timetable.servlet.subject;

import timetable.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListOfSubjectServlet", urlPatterns = {"/listOfSubject"})
public class ListOfSubjectServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubjectService subjectService = new SubjectService();
        request.setAttribute("subjects", subjectService.getAllSubjects());
        request.getRequestDispatcher("jsp/subject/listOfSubjects.jsp").forward(request, response);
    }
}
