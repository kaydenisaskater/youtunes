package youtunes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YoutunesServlet
 */
@WebServlet(name = "YoutunesServlet", urlPatterns = {"/", "/youtunes/*"})
public class YoutunesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutunesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String base = "/jsp/";
		String url = base + "index.jsp";
		String action = request.getParameter("action");
		
		if (action != null) {
			switch (action) {
			case "homepage":
				url = base + "index.jsp";
				break;
			case "showContactUs":
				url = base + "Contact_Us.jsp";
				break;
			case "showAboutUs":
				url = base + "About_Us.jsp";
				break;
			case "showArtists":
				url = base + "Artists/List.jsp";
				break;
			case "newArtist":
				url = base + "Artists/New.jsp";
				break;
			case "artistDetails":
				url = base + "Artists/Details.jsp";
				break;
			case "updateArtist":
				updateArtist(request, response);
				url = base + "Artists/List.jsp";
				break;
			case "deleteArtist":
				deleteArtist(request, response);
				url = base + "Artists/List.jsp";
				break;
			case "createArtist":
				createArtist(request, response);
				url = base + "Artists/List.jsp";
				break;
			case "newAlbum":
				url = base + "Album/Details.jsp";
				break;
			case "albumDetails":
				url = base + "Album/Details.jsp";
				break;
			case "createAlbum":
				createAlbum(request, response);
				url = base + "index.jsp";
				break;
			case "updateAlbum":
				updateAlbum(request, response);
				url = base + "index.jsp";
				break;
			case "showAlbums":
				url = base + "index.jsp";
				break;
			case "deleteAlbum":
				deleteAlbum(request, response);
				url = base + "index.jsp";
				break;
			}
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		
		rd.forward(request, response);
	}
	
	private void updateArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String artistId = request.getParameter("artistId");
		
		Artist artistToUpdate = new Artist();
		artistToUpdate.setArtistId(Long.parseLong(artistId));
		artistToUpdate.setFirstName(firstName);
		artistToUpdate.setLastName(lastName);
		
		JdbcArtistDao artistDao = new JdbcArtistDao();
		artistDao.update(artistToUpdate);
		
	}
	
	private void deleteArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String artistId = request.getParameter("artistId");
		
		JdbcArtistDao artistDao = new JdbcArtistDao();
		artistDao.remove(Long.parseLong(artistId));
	}
	
	private void createArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		JdbcArtistDao artistDao = new JdbcArtistDao();
		artistDao.add(new Artist(firstName, lastName));
	}
	
	private void createAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String genre = request.getParameter("genre");
		String imgUrl = request.getParameter("imgUrl");
		String artistId = request.getParameter("artist");
		
		Album newAlbum = new Album();
		newAlbum.setTitle(title);
		newAlbum.setPrice(Double.parseDouble(price));
		newAlbum.setGenre(genre);
		newAlbum.setImgUrl(imgUrl);
		newAlbum.setArtistId(Long.parseLong(artistId));
		
		JdbcAlbumDao albumDao = new JdbcAlbumDao();
		albumDao.add(newAlbum);
	}
	
	private void updateAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String albumId = request.getParameter("albumId");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String imgUrl = request.getParameter("imgUrl");
		String genre = request.getParameter("genre");
		String artistId = request.getParameter("artist");
		
		Album updatedAlbum = new Album();
		updatedAlbum.setAlbumId(Long.parseLong(albumId));
		updatedAlbum.setTitle(title);
		updatedAlbum.setPrice(Double.parseDouble(price));
		updatedAlbum.setGenre(genre);
		updatedAlbum.setImgUrl(imgUrl);
		updatedAlbum.setArtistId(Long.parseLong(artistId));
		
		JdbcAlbumDao albumDao = new JdbcAlbumDao();
		albumDao.update(updatedAlbum);
	}
	
	private void deleteAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String albumId = request.getParameter("albumId");
		
		JdbcAlbumDao albumDao = new JdbcAlbumDao();
		albumDao.remove(Long.parseLong(albumId));
	}

}
