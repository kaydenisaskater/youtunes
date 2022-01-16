//file for Artist info
package youtunes;

public class Artist {
	//private variables initialized
	private long artistId;
	private String firstName;
	private String lastName;
	
	//default constructor with artist ID
	public Artist(long artistId, String firstName, String lastName) {
		this.artistId = artistId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//default constructor without artist ID
	public Artist(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//default constructor with zero args
	public Artist() {}
	
	//set artist ID
	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	
	//get artist ID
	public long getArtistId() {
		return artistId;
	}
	
	//set artist first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//get artist first name
	public String getFirstName() {
		return firstName;
	}
	
	//set artist last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//get artist last name
	public String getLastName() {
		return lastName;
	}
	
	//toString method to output artist informaiton with artistID, first name, and last name
	@Override
	public String toString() {
		return String.format("Artist{artistId=%s, firstName=%s, lastName=%s}", artistId, firstName, lastName);
	}
}
