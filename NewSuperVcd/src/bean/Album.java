package bean;
import java.io.Serializable;
import java.util.Vector;
public class Album implements Serializable{
	private String singer;
	private String name;
	private String zone;
	private String picture;
	private Vector<Song> songs;//歌曲集合
	public Album() {
		super();
	}
      public Album(String singer, String name, String zone, String picture) {
		super();
		this.singer = singer;
		this.name = name;
		this.zone = zone;
		this.picture = picture;
	}
    public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

        public Vector<Song> getSongs() {
		return songs;
	}

	public void setSongs(Vector<Song> songs) {
		this.songs = songs;
	}

	//@Override下面的方法名是否是你父类中所有的
	public String toString() {
		return this.getSinger()+" - "+this.getName();
	}

}

