package data;

public class candidate {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String candidateLastName;
	private String candidateParty;
	public String getCandidateLastName() {
		return candidateLastName;
	}
	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}
	public String getCandidateParty() {
		return candidateParty;
	}
	public void setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}
	public String getCandidateFirstName() {
		return candidateFirstName;
	}
	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}
	private String candidateFirstName;
}
