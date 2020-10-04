package servlets;

import model.Book;
import org.hibernate.tool.schema.Action;
import repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    BookRepository bookRepository = new BookRepository();

//    @Override
    protected void doPost(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException {
        Action action = Action.valueOf(request.getParameter("action"));
        Long bookId = Long.valueOf(request.getParameter("bookId"));

        switch (action){
            case ADD:
                response.sendRedirect("/AddBookServlet");
                break;
        }




    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        bookRepository.cleanUp();
        List<Book> books = bookRepository.findAll();
        request.setAttribute("books",books);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
