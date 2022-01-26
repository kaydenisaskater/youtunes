package youtunes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import java.util.ArrayList;

public class JdbcAlbumDao implements AlbumDao {
	JdbcManager db;
	
	public JdbcAlbumDao() {
		db = new JdbcManager();
	}

	@Override
	public void add(Album entity) {
		// TODO Auto-generated method stub
		Connection con = db.getConn();
		Album newAlbum = entity;
		
		if (con != null) {
			try {
				Statement addAlbumStmt = con.createStatement();
				String sqlStmt = String.format("INSERT INTO album(title, price, genre, img_url, artist_id) values('%s', %s, '%s', '%s', %s);", 
						newAlbum.getTitle(), newAlbum.getPrice(), newAlbum.getGenre(), newAlbum.getImgUrl(), newAlbum.getArtistId());

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

	@Override
	public List<Album> list() {
		// TODO Auto-generated method stub
		Connection con = db.getConn();
		ArrayList<Album> albums = new ArrayList<Album>();
		
		if (con != null) {
			try {
				Statement listAlbums = con.createStatement();
				String sqlStmt = "SELECT album_id, title, price, img_url, genre FROM album;";
				
				try {
					ResultSet rs = listAlbums.executeQuery(sqlStmt);
					
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
		return albums;
	}

	@Override
	public Album find(Long key) {
		// TODO Auto-generated method stub
		Connection con = db.getConn();
		Album album = null;
		
		if (con != null) {
			try {
				Statement findAlbums = con.createStatement();
				String sqlStmt = "SELECT album_id, title, price, img_url, genre, artist_id FROM album WHERE album_id = " + key;
				
				try {
					ResultSet rs = findAlbums.executeQuery(sqlStmt);
					
					try {
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
		return album;
	}

	@Override
	public void update(Album entity) {
		// TODO Auto-generated method stub
		Connection con = db.getConn();
		Album updatedAlbum = entity;
		
		if (con != null) {
			try {
				Statement updateAlbum = con.createStatement();
				String sqlStmt = String.format("UPDATE album SET title = '%s', price= '%s', genre = '%s', img_url = '%s', artist_id = %s WHERE album_id = %s", 
					updatedAlbum.getTitle(), updatedAlbum.getPrice(), updatedAlbum.getGenre(), updatedAlbum.getImgUrl(), updatedAlbum.getArtistId(), updatedAlbum.getAlbumId());
				
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

	@Override
	public void remove(Long key) {
		// TODO Auto-generated method stub
		Connection con = db.getConn();
		
		if (con != null) {
			try {
				Statement removeAlbum = con.createStatement();
				String sqlStmt = String.format("DELETE FROM album WHERE album_id = %s", key);
				
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
