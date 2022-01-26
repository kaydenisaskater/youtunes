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
	
	public JdbcArtistDao() {
		db = new JdbcManager();
	}

	@Override
	public void add(Artist entity) {
		// Write SQL statement to insert new artists to the DB.
		Connection con = db.getConn();
		Artist newArtist = entity;
		
		if (con != null) {
			try {
				Statement addArtistStatement = con.createStatement();
				String sqlStmt = "INSERT INTO artist(first_name, last_name) VALUES('" + newArtist.getFirstName() + "', '" + newArtist.getLastName() + "')";
				
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

	@Override
	public List<Artist> list() {
		//Write SQL statement to select all artists
		Connection con = db.getConn();
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		if (con != null) {
			try {
				Statement listArtistStatement = con.createStatement();
				String sqlStmt = "SELECT * FROM artist";
				
				try {
					ResultSet rs = listArtistStatement.executeQuery(sqlStmt);
					
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
		
		return artists;
	}

	@Override
	public Artist find(Long key) {
		// TODO Auto-generated method stub
		Connection con = db.getConn();
		
		Artist artist = null;
		
		if (con != null) {
			try {
				Statement findArtist = con.createStatement();
				String sqlStmt = "SELECT artist_id, first_name, last_name FROM artist WHERE artist_id =" + key;
				
				try {
					ResultSet rs = findArtist.executeQuery(sqlStmt);
					
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
		return artist;
	}

	@Override
	public void update(Artist artist) {
		// Write SQL to update an artist's record.
		Connection con = db.getConn();
		
		if (con != null) {
			try {
				Statement updateArtist = con.createStatement();
				String sqlStmt = "UPDATE artist SET first_name = '" + artist.getFirstName() + "', last_name = '" + artist.getLastName() + "' WHERE artist_id =" + artist.getArtistId();
				System.out.println(sqlStmt);
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

	@Override
	public void remove(Long key) {
		//Write SQL to remove an artist
		Connection con = db.getConn();
		
		if (con != null) {
			try {
				Statement removeArtist = con.createStatement();
				String sqlStmt = "DELETE FROM artist WHERE artist_id = " + key;
				
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
