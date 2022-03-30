package data;

public class kysymys {
	private int id;
	private String kysymykset;
	public kysymys(String id, String kysymykset) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.kysymykset=kysymykset;
	}
	public kysymys() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getkysymykset() {
		return kysymykset;
	}
	public void setkysymykset(String kysymykset) {
		this.kysymykset = kysymykset;
	}
}