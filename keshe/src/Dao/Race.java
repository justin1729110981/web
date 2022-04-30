package Dao;

public class Race {
	private String raceId;
	private String raceName;
	public Race(String raceId, String raceName) {
		super();
		this.raceId = raceId;
		this.raceName = raceName;
	}
	public Race() {
		super();
	}
	public String getRaceId() {
		return raceId;
	}
	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	@Override
	public String toString() {
		return "Race [raceId=" + raceId + ", raceName=" + raceName + "]";
	}
	

}
