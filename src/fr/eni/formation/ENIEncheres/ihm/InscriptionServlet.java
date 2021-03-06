package fr.eni.formation.ENIEncheres.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.formation.ENIEncheres.bll.BLLException;
import fr.eni.formation.ENIEncheres.bll.UtilisateurManager;
import fr.eni.formation.ENIEncheres.bll.UtilisateurManagerSingl;
import fr.eni.formation.ENIEncheres.bo.Utilisateur;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/WEB-INF/inscription.jsp";

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "InscriptionServlet";
		UtilisateurModel model = null;
		boolean valide = true;
		boolean isForward = false;
		try {
			model = new UtilisateurModel(new Utilisateur(), manager.getAllUtilisateurs());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (request.getParameter("pseudo") != null) {
			model.getUtilisateur().setPseudo(request.getParameter("pseudo"));
			model.getUtilisateur().setNom(request.getParameter("nom"));
			model.getUtilisateur().setPrenom(request.getParameter("prenom"));
			model.getUtilisateur().setEmail(request.getParameter("email"));
			model.getUtilisateur().setTelephone(request.getParameter("telephone"));
			model.getUtilisateur().setRue(request.getParameter("rue"));
			model.getUtilisateur().setCodePostal(request.getParameter("codepostal"));
			model.getUtilisateur().setVille(request.getParameter("ville"));
			model.getUtilisateur().setMotDePasse(request.getParameter("motdepasse"));

			if (manager.isAlphanumeric(request.getParameter("pseudo"))) {
				request.setAttribute("message", "Le pseudo ne peut contenir de caract?res sp?ciaux");
				isForward = true;

			} else {
				if (request.getParameter("pseudo") == null) {
					request.setAttribute("message", "Veuillez remplir tous les champs");
					isForward = true;
				} else {
					try {
						manager.addUtilisateur(model.getUtilisateur());
					} catch (BLLException e) {
						request.setAttribute("message", e.getMessage());
						System.out.println("pas cr??");
						isForward = true;
						valide = false;

					}
					if (valide) {
						try {
							model.setLstUtilisateurs(manager.getAllUtilisateurs());
							HttpSession session = request.getSession();
							session.setAttribute("NoUtilisateur", model.getUtilisateur().getNoUtilisateur());
							nextPage = "AccueilServlet";
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
		request.setAttribute("model", model);
		if (isForward) {
			request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		} else {
			response.sendRedirect(nextPage);
		}
	}

}
