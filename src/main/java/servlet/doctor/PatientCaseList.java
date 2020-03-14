package servlet.doctor;

import bean.Doctor;
import bean.Integrity;
import bean.Patient;
import bean.PatientCase;
import dao.IntegrityDao;
import dao.PatientCaseDao;
import dao.PatientDao;
import dao.RecodeDao;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/doctor/patientCaseList")
public class PatientCaseList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = Util.nullToString(req.getParameter("pid"));
        PatientCaseDao patientCaseDao = new PatientCaseDao();
        /*String where="where pid=? order by ordertime desc";
        List<Recode> list = recodeDao.query(where, new Object[]{patient.getId()});*/
        List<PatientCase> patientCasesList = patientCaseDao.query("pid", pid);
        req.setAttribute("list",patientCasesList);
        req.setAttribute("pid",pid);
        req.getRequestDispatcher("patientCaseList.jsp").forward(req,resp);
    }
}
