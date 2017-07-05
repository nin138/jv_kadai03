import jp.ac.hal.DB.Dao.OrderDao;
import jp.ac.hal.DB.Dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try(UserDao userDao = new UserDao(); OrderDao orderDao = new OrderDao()) {
      request.setAttribute("users", userDao.getAllUser());
      request.setAttribute("orders", orderDao.getAllOrderWithDetail());
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
