package br.com.devmos.model;

public class Kid {
	private String name;
	private String region;
	private int distance;

	public Kid(String name, String region, int distance) {
		this.name = name;
		this.region = region;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
