package bean;
import java.io.Serializable;
public class Duration implements Serializable{
	private int h;
	private int m;
	private int s;
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public Duration(int h, int m, int s) {
		super();
		this.h = h;
		this.m = m;
		this.s = s;
	}
	
	public Duration(int totaltime) {
		this.h = totaltime/3600;
		this.m = (totaltime-h*3600)/60;
		this.s = totaltime%60;
	}
	public Duration(){}
	
	@Override
	public String toString() {
		 String result="";
		 result=result+padLeadingZero(h)+":";
		 result=result+padLeadingZero(m)+":";
		 result=result+padLeadingZero(s);
		 return result;
            }
 public String padLeadingZero(int number){
		 String result="";
		 if(number<10){
			 result="0";
		 }
		 result=result+Integer.toString(number);
		 return result;
	 }
}
