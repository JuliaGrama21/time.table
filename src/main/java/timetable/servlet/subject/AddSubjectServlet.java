package timetable.servlet.subject;

import timetable.constant.ErrorConstants;
import timetable.model.Subject;
import timetable.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static timetable.constant.ErrorConstants.SUBJECT_EXISTS;

@WebServlet(name = "AddSubjectServlet", urlPatterns = {"/addSubject"})
public class AddSubjectServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Subject subject = new Subject();
        SubjectService subjectService = new SubjectService();
        subject.setName(request.getParameter("name"));
        request.getSession().setAttribute("subject", subject);
        boolean isSubjectAdded = subjectService.addSubject(subject);
        if (isSubjectAdded) {
            List<Subject> subjects = subjectService.getAllSubjects();
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("jsp/subject/listOfSubjects.jsp").forward(request, response);
        } else {
            request.setAttribute("error", SUBJECT_EXISTS);
            request.getRequestDispatcher("jsp/subject/addSubject.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubjectService subjectService = new SubjectService();
        List<Subject> subjects = subjectService.getAllSubjects();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("jsp/subject/addSubject.jsp").forward(request, response);
    }
}
