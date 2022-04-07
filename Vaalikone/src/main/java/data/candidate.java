package data;

public class candidate {
	private int id;
	private String FirstName;
	private String LastName;
	private String Party;
	
	public candidate(String id, String FirstName, String LastName, String Party) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.FirstName=FirstName;
		this.FirstName=LastName;
		this.FirstName=Party;
	}
	public candidate() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getParty() {
		return Party;
	}

	public void setParty(String party) {
		Party = party;
	}

	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
}
