package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 747787
 */
public class ShoppingListServlet extends HttpServlet {

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        try {
            if (action.equals("logout")) {
                list.clear();
                session.invalidate();

                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
        }

        if (session.getAttribute("name") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("user");
        String action = request.getParameter("action");
        String item = request.getParameter("addItem");
        String delete = request.getParameter("deleteItem");
        if (action.equals("add")) {
            list.add(item);
            session.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        }

        if (action.equals("register")) {
            session.setAttribute("name", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        if (action.equals("delete")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(delete)) {
                    list.remove(i);
                }
            }
            session.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

    }

}
