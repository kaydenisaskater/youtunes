package youtunes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import java.util.ArrayList;

public class JdbcAlbumDao implements AlbumDao {
	JdbcManager db;
	
	
	//default constructor to implement the JdbcManager class
	public JdbcAlbumDao() {
		db = new JdbcManager();
	}

	//add method to add albums to the database
	@Override
	public void add(Album entity) {
		//initialize the database connection
		Connection con = db.getConn();
		
		//set an album object to the entity parameter
		Album newAlbum = entity;
		
		if (con != null) {
			//try adding the album to the database
			try {
				//create and initialize the sql statement
				Statement addAlbumStmt = con.createStatement();
				//write the sql command to add an album
				String sqlStmt = String.format("INSERT INTO album(title, price, genre, img_url, artist_id) values('%s', %s, '%s', '%s', %s);", 
						newAlbum.getTitle(), newAlbum.getPrice(), newAlbum.getGenre(), newAlbum.getImgUrl(), newAlbum.getArtistId());

				//try adding the album to the database
				try {
					addAlbumStmt.executeUpdate(sqlStmt);
				}
				finally {
					addAlbumStmt.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
				System.out.println("Error is here");		
			}
		}
	}

	//list method to list the albums
	@Override
	public List<Album> list() {
		//initialize the database connection
		Connection con = db.getConn();
		//initialize the array list to hold all albums
		ArrayList<Album> albums = new ArrayList<Album>();
		
		if (con != null) {
			//try locating all albums to add to the array list
			try {
				//create the sql statement
				Statement listAlbums = con.createStatement();
				//write the sql command to locate all albums in the album table
				String sqlStmt = "SELECT album_id, title, price, img_url, genre FROM album;";
				
				//try adding the albums to a result set 
				try {
					ResultSet rs = listAlbums.executeQuery(sqlStmt);
					
					//try adding each located album to the array list
					try {
						while (rs.next()) {
							Album album = new Album();
							album.setAlbumId(rs.getLong(1));
							album.setTitle(rs.getString(2));
							album.setPrice(rs.getDouble(3));
							album.setImgUrl(rs.getString(4));
							album.setGenre(rs.getString(5));
							albums.add(album);
						}
					}
					finally {
						rs.close();
					}
				}
				finally {
					listAlbums.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
			finally {
				db.closeConn(con);
			}
		}
		//return the array list of albums
		return albums;
	}

	//find method to locate a specific album
	@Override
	public Album find(Long key) {
		//create the database connection
		Connection con = db.getConn();
		//initialize the album that will be located
		Album album = null;
		
		if (con != null) {
			//try locating an album
			try {
				//create the sql statement
				Statement findAlbums = con.createStatement();
				//initialize the sql statement to find the album by album_id
				String sqlStmt = "SELECT album_id, title, price, img_url, genre, artist_id FROM album WHERE album_id = " + key;
				
				//try adding the album to the result set if it has the requested album_id
				try {
					ResultSet rs = findAlbums.executeQuery(sqlStmt);
					
					try {
						//add the located album to the album variable
						if (rs.next()) {
							album = new Album(rs.getLong(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getLong(6));
						}
					}
					finally {
						rs.close();
					}
				}
				finally {
					findAlbums.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		//return the requestd album
		return album;
	}

	//update method to update an album record in the database
	@Override
	public void update(Album entity) {
		//initialize the database connection
		Connection con = db.getConn();
		//initialize the album with the provided entity parameter
		Album updatedAlbum = entity;
		
		if (con != null) {
			//try updating the record
			try {
				//create the sql statement
				Statement updateAlbum = con.createStatement();
				//write the sql command to update the specified record using album_id
				String sqlStmt = String.format("UPDATE album SET title = '%s', price= '%s', genre = '%s', img_url = '%s', artist_id = %s WHERE album_id = %s", 
					updatedAlbum.getTitle(), updatedAlbum.getPrice(), updatedAlbum.getGenre(), updatedAlbum.getImgUrl(), updatedAlbum.getArtistId(), updatedAlbum.getAlbumId());
				
				//try executing the update
				try {
					updateAlbum.executeUpdate(sqlStmt);
				}
				finally {
					updateAlbum.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	//remove method to delete the requested album from the database
	@Override
	public void remove(Long key) {
		//initialize the database connection
		Connection con = db.getConn();
		
		if (con != null) {
			//try removing the album from the table
			try {
				//create the sql statement
				Statement removeAlbum = con.createStatement();
				//initialize the sql command to remove an album from the table
				String sqlStmt = String.format("DELETE FROM album WHERE album_id = %s", key);
				
				//try removing the album
				try {
					removeAlbum.executeUpdate(sqlStmt);
				}
				finally {
					removeAlbum.close();
				}
			}
			catch (SQLException e) {
				System.out.print(e);
			}
		}
		
	}
	
}
