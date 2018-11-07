package by.aip.servlet;

import by.aip.dao.model.Officer;
import by.aip.service.OfficerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class OfficerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Officer> officerService = OfficerService.getInstance().getOfficerService();

        for (Officer officer : officerService) {
            System.out.println(officer.getId() + " " + officer.getFirstName() + " " + officer.getLastName() + " " +officer.getMiddleName());
        }

        req.setAttribute("officer", officerService);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }
}
