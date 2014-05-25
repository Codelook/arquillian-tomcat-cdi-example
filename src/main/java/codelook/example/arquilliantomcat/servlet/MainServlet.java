package codelook.example.arquilliantomcat.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codelook.example.arquilliantomcat.service.MessageProvider;

import java.io.IOException;

@WebServlet(value = "/")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageProvider messageProvider;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(messageProvider.getOutputMessage());
    }
}