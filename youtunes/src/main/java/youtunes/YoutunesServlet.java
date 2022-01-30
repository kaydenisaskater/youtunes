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
@WebServlet(name = "YoutunesServlet", urlPatterns = {"/youtunes/*"})
public class YoutunesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//default constructor
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
		//variables for the file structure and http actions
		String base = "/jsp/";
		String url = base + "index.jsp";
		String action = request.getParameter("action");
		
		if (action != null) {
			//switch case to decide what url to provide to the user
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
				url = base + "Album/New.jsp";
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
		
		//a dispatcher to get the url
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		
		//the url is sent back and the display is updated
		rd.forward(request, response);
	}
	
	//method to update an artist
	private void updateArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables that are initialized with values from the jsp page
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String artistId = request.getParameter("artistId");
		
		//initialize an artist and set values
		Artist artistToUpdate = new Artist();
		artistToUpdate.setArtistId(Long.parseLong(artistId));
		artistToUpdate.setFirstName(firstName);
		artistToUpdate.setLastName(lastName);
		
		//initialize the JdbcArtistDao class
		JdbcArtistDao artistDao = new JdbcArtistDao();
		//execute the update
		artistDao.update(artistToUpdate);
		
	}
	
	//method to delete an artist
	private void deleteArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//variable is initialized with the artist id from the jsp page
		String artistId = request.getParameter("artistId");
		
		//initialize the JdbcArtistDao
		JdbcArtistDao artistDao = new JdbcArtistDao();
		//execute the deletion of the artist
		artistDao.remove(Long.parseLong(artistId));
	}
	
	//method to create an artist
	private void createArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//variables initialized with first and last name from the jsp page
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		//initialize the JdbcArtistDao class
		JdbcArtistDao artistDao = new JdbcArtistDao();
		//execute the update to add a new artist
		artistDao.add(new Artist(firstName, lastName));
	}
	
	//method to create an album
	private void createAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//variables initialized with values from the jsp page to add a new album
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String genre = request.getParameter("genre");
		String imgUrl = request.getParameter("imgUrl");
		String artistId = request.getParameter("artist");
		
		//a new album is initialized and values are set
		Album newAlbum = new Album();
		newAlbum.setTitle(title);
		newAlbum.setPrice(Double.parseDouble(price));
		newAlbum.setGenre(genre);
		newAlbum.setImgUrl(imgUrl);
		newAlbum.setArtistId(Long.parseLong(artistId));
		
		//initialize the JdbcAlbumDao class
		JdbcAlbumDao albumDao = new JdbcAlbumDao();
		//execute the update to add a new album
		albumDao.add(newAlbum);
	}
	
	//method to update an album
	private void updateAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//variables initialized with data from the jsp page
		String albumId = request.getParameter("albumId");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String imgUrl = request.getParameter("imgUrl");
		String genre = request.getParameter("genre");
		String artistId = request.getParameter("artist");
		
		//initialize a new album and set values
		Album updatedAlbum = new Album();
		updatedAlbum.setAlbumId(Long.parseLong(albumId));
		updatedAlbum.setTitle(title);
		updatedAlbum.setPrice(Double.parseDouble(price));
		updatedAlbum.setGenre(genre);
		updatedAlbum.setImgUrl(imgUrl);
		updatedAlbum.setArtistId(Long.parseLong(artistId));
		
		//initialize the JdbcAlbumDao class
		JdbcAlbumDao albumDao = new JdbcAlbumDao();
		//execute the update to the album
		albumDao.update(updatedAlbum);
	}
	
	//method to delete an album
	private void deleteAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//variable initialized with album_id from the jsp page
		String albumId = request.getParameter("albumId");
		
		//initialize the JdbcAlbumDao class
		JdbcAlbumDao albumDao = new JdbcAlbumDao();
		//execute the deletion of an album
		albumDao.remove(Long.parseLong(albumId));
	}

}
