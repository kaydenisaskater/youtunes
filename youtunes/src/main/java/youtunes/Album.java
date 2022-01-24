package youtunes;

public class Album {
	//variables
	private long albumId;
	private String title;
	private double price;
	private String genre;
	private String imgUrl;
	private long artistId;
	
	//constructor when all variables are present
	public Album(long albumId, String title, double price, String imgUrl, String genre, long artistId) {
		this.albumId = albumId;
		this.title = title;
		this.price = price;
		this.genre = genre;
		this.imgUrl = imgUrl;
		this.artistId = artistId;
	}
	
	//constructor when imgUrl is the only variable missing
	public Album(long albumId, String title, double price, String genre, long artistId) {
		this.albumId = albumId;
		this.title = title;
		this.price = price;
		this.genre = genre;
		this.artistId = artistId;
	}
	
	//default constructor
	public Album() {}

	//getter for albumId
	public long getAlbumId() {
		return albumId;
	}
	
	//setter for albumId
	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	//getter for title
	public String getTitle() {
		return title;
	}

	//setter for title
	public void setTitle(String title) {
		this.title = title;
	}

	//getter for price
	public double getPrice() {
		return price;
	}

	//setter for price
	public void setPrice(double price) {
		this.price = price;
	}

	//getter for genre
	public String getGenre() {
		return genre;
	}

	//setter for genre
	public void setGenre(String genre) {
		this.genre = genre;
	}

	//getter for imgUrl
	public String getImgUrl() {
		return imgUrl;
	}

	//setter for imgUrl
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	//getter for artistId
	public long getArtistId() {
		return artistId;
	}

	//setter for artistId
	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	@Override
	public String toString() {
		return String.format("Album{albumId=%s, title=%s, price=%s, genre=%s, imgUrl=%s, artistId=%s}", albumId, title, price, genre, imgUrl, artistId);
	}
	

}
