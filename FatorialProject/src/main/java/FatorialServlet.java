

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FatorialServlet
 */
public class FatorialServlet extends HttpServlet {
	
	 /**
     * Serial ID
     */
	private static final long serialVersionUID = 1L;
	
	 /**
     * Mensagem de resposta de erro
     */
	private static final String ERROR = "Gentileza informar um número valido(Inteiro positivo).";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FatorialServlet() {
        super();
    }
    
	private int calcularFatorial(int n) {
		if(n <= 1) {
			return 1;
		}
		int result = n;
		for(int i = 1; i < n; i++) {
			result = result * i;
		}
		return result;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
	
		String result = "";
		int n = 0;
		String paramNumber = request.getParameter("entrada");
		if(paramNumber == null) {
			result = ERROR;
		}else {
			try {
				n = Integer.parseInt(paramNumber);
				if(n <= 0) {
					result = ERROR;
				}else {
					result = "Resultado: " + calcularFatorial(n);
				}
			} catch (NumberFormatException e) {
				result = ERROR;			}
		}
		
		out.println("<html><head><title>");
		out.println("Calculo de Fatorial");
		out.println("</title></head><body>");
		out.println("<h1>Calculo de Fatorial</h1>");
		out.println("<p> "+result+"</p>");
		out.println("<a href=\"fatorial.html\">Voltar</a>");
		out.println("</body></html>");
		out.close();
	}




}
