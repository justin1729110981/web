package Dao;

public class Star {
	private String raceId;
	private String starNumber;
	private String name;
	public Star(String raceId, String starNumber, String name) {
		super();
		this.raceId = raceId;
		this.starNumber = starNumber;
		this.name = name;
	}
	public Star() {
		super();
	}
	public String getRaceId() {
		return raceId;
	}
	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}
	public String getStarNumber() {
		return starNumber;
	}
	public void setStarNumber(String starNumber) {
		this.starNumber = starNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Star [raceId=" + raceId + ", starNumber=" + starNumber
				+ ", name=" + name + "]";
	}
	
}
