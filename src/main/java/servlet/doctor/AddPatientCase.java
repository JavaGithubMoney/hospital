package servlet.doctor;

import bean.Doctor;
import bean.PatientCase;
import dao.PatientCaseDao;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/doctor/addPatientCase")
public class AddPatientCase extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Doctor doctor = (Doctor) req.getSession().getAttribute("doctor");
        String id = Util.nullToString(req.getParameter("id"));
        String pid = Util.nullToString(req.getParameter("pid"));
        String pname = Util.nullToString(req.getParameter("pname"));
        String pathogen = Util.nullToString(req.getParameter("pathogen"));
        String suggest = Util.nullToString(req.getParameter("suggest"));
        PatientCaseDao patientCaseDao = new PatientCaseDao();
        PatientCase patientCase = new PatientCase();
        patientCase.setDname(doctor.getDname());
        patientCase.setPid(pid);
        patientCase.setPname(pname);
        patientCase.setPathogen(pathogen);
        patientCase.setSuggest(suggest);
        patientCase.setCreateDate(new Date());
        patientCase.setUpdateDate(new Date());
        if(patientCaseDao.insert(patientCase)){
            req.getRequestDispatcher("/doctor/patientCaseList?pid="+pid).forward(req,resp);
        }
    }
}
