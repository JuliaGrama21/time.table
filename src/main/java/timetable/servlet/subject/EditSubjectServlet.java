package timetable.servlet.subject;

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

@WebServlet(name = "EditSubjectServlet", urlPatterns = {"/editSubject"})
public class EditSubjectServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubjectService subjectService = new SubjectService();
        Subject subject = new Subject();
        subject.setId(Long.valueOf(request.getParameter("id")));
        subject.setName(request.getParameter("name"));
        boolean isSubjectUpdated = subjectService.updateSubject(subject);
        if (isSubjectUpdated) {
            request.getSession().setAttribute("subject", subject);
            List<Subject> subjects = subjectService.getAllSubjects();
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("jsp/subject/listOfSubjects.jsp").forward(request, response);
        } else {
            request.setAttribute("error", SUBJECT_EXISTS);
            request.getRequestDispatcher("jsp/subject/editSubject.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubjectService subjectService = new SubjectService();
        Long id = Long.valueOf(request.getParameter("id"));
        Subject subject = subjectService.findSubjectById(id);
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("jsp/subject/editSubject.jsp").forward(request, response);
    }


}
