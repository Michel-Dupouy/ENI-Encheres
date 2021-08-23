package fr.eni.formation.ENIEncheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListeEnchereConnecte
 */
@WebServlet("/ListeEnchereConnecte")
public class ListeEnchereConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEnchereConnecte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/WEB-INF/accueilConnecte.jsp";
		
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("NoUtilisateur") != null ){  
            session.invalidate();
            this.getServletContext().getRequestDispatcher("/AccueilServlet").forward(request, response);
        }
		
		if (request.getParameter("profil") != null) {
			nextPage = "/WEB-INF/afficherMonProfil.jsp";
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}