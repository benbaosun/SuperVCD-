package bean;

import java.io.Serializable;

public class Song implements Serializable{
	
	private String name;
	private Duration duration;
	
	public Song() {
		super();
	}

	public Song(String name, Duration duration) {
		super();
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	
	@Override
	public String toString() {
		return this.getName()+","+this.getDuration();
	}

}

