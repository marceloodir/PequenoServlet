package servets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cabecalhos")
@SuppressWarnings("serial")
public class MeuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> cabecalho = req.getHeaderNames();
		
		resp.setContentType("text/html");
		PrintWriter out  = resp.getWriter();
		out.println("<html><body>Cabeçalhos HTML</h1>");
		
		while(cabecalho.hasMoreElements()) {
			String header = cabecalho.nextElement();
			out.println("<li>"+header+" = "+req.getHeader(header)+"</li>");
		}
		out.println("<h2>"+req.getRemoteUser()+"</h2>");
		out.println("</body></html>");
	}
}
