package youtunes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import youtunes.Artist;
import youtunes.ArtistDao;

public class JdbcArtistDao implements ArtistDao {
	JdbcManager db;
	
	//default constructor to implement the JdbcManager class
	public JdbcArtistDao() {
		db = new JdbcManager();
	}

	//method to add an artist to the database
	@Override
	public void add(Artist entity) {
		//Initialize the database connection
		Connection con = db.getConn();
		//initialize the artist with the entity parameter
		Artist newArtist = entity;
		
		if (con != null) {
			//try adding the artist
			try {
				//create the sql statement
				Statement addArtistStatement = con.createStatement();
				//initialize the sql command to insert a new artist
				String sqlStmt = "INSERT INTO artist(first_name, last_name) VALUES('" + newArtist.getFirstName() + "', '" + newArtist.getLastName() + "')";
				
				//try adding the new artist
				try {
					addArtistStatement.executeUpdate(sqlStmt);
				}
				catch(SQLException e) {
					System.out.print(e);
				}
				finally {
					addArtistStatement.close();
				}
			}
			catch(SQLException e) {
				System.out.print("An error has occurred adding the new artist.");
				System.out.println(e);
			}
		}
		
	}

	//method to list out all artists
	@Override
	public List<Artist> list() {
		//Initialize the database connection
		Connection con = db.getConn();
		//Initialize the array list to hold artists
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		if (con != null) {
			//try locating all artists
			try {
				//create the sql statement
				Statement listArtistStatement = con.createStatement();
				//initialize the sql command to find all artists
				String sqlStmt = "SELECT * FROM artist";
				
				//try finding all artists and adding them to the result set
				try {
					ResultSet rs = listArtistStatement.executeQuery(sqlStmt);
					
					//try adding each artist to the array list
					try {
						while(rs.next()) {
							Artist artist = new Artist();
							artist.setArtistId(rs.getLong(1));
							artist.setFirstName(rs.getString(2));
							artist.setLastName(rs.getString(3));
							artists.add(artist);
						}
					}
					finally {
						rs.close();
					}
				}
				finally {
					listArtistStatement.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
			finally {
				db.closeConn(con);
			}
		}
		//return the array list of artists
		return artists;
	}

	//method to find a specific artist
	@Override
	public Artist find(Long key) {
		//Initialize the database connection
		Connection con = db.getConn();
		//initialize the artist to be located
		Artist artist = null;
		
		if (con != null) {
			//try locating the artist
			try {
				//create the sql statement
				Statement findArtist = con.createStatement();
				//initialize the sql command to find a specific artist using artist_id
				String sqlStmt = "SELECT artist_id, first_name, last_name FROM artist WHERE artist_id =" + key;
				
				//try locating the artist and storing it in the result set
				try {
					ResultSet rs = findArtist.executeQuery(sqlStmt);
					
					//try adding the artist to the artist variable
					try {
						if (rs.next()) {
							artist = new Artist(rs.getLong(1), rs.getString(2), rs.getString(3));
						}
					}
					finally {
						rs.close();
					}
				}
				finally {
					findArtist.close();
				}
			}
			catch (SQLException e) {
				System.out.print(e);
			}
		}
		//return the found artist
		return artist;
	}

	//method to update a specific artist
	@Override
	public void update(Artist artist) {
		//initialize the database connection
		Connection con = db.getConn();
		
		if (con != null) {
			//try updating the single artist
			try {
				//create the sql statement
				Statement updateArtist = con.createStatement();
				//initialize the sql command to update an artist by using the artist_id
				String sqlStmt = "UPDATE artist SET first_name = '" + artist.getFirstName() + "', last_name = '" + artist.getLastName() + "' WHERE artist_id =" + artist.getArtistId();
				
				//try executing the update for artist
				try {
					updateArtist.executeUpdate(sqlStmt);
				}
				finally {
					updateArtist.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	//method to remove a specific artist from the database
	@Override
	public void remove(Long key) {
		//initialize the database connection
		Connection con = db.getConn();
		
		if (con != null) {
			//try removing the artist
			try {
				//create the sql statement
				Statement removeArtist = con.createStatement();
				//initialize the sql command to delete an artist using artist_id
				String sqlStmt = "DELETE FROM artist WHERE artist_id = " + key;
				
				//try executing the sql command to remove the artist
				try {
					removeArtist.executeUpdate(sqlStmt);
				}
				finally {
					removeArtist.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

}
