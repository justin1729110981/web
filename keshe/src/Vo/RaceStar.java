package Vo;

public class RaceStar {
	private String raceId;
	private String starNumber;
	private String raceName;
	private String name;
	public RaceStar(String raceId, String starNumber, String raceName,
			String name) {
		super();
		this.raceId = raceId;
		this.starNumber = starNumber;
		this.raceName = raceName;
		this.name = name;
	}
	public RaceStar() {
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
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RaceStar [raceId=" + raceId + ", starNumber=" + starNumber
				+ ", raceName=" + raceName + ", name=" + name + "]";
	}
	
}
