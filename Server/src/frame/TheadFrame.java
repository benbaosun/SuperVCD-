
package frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import  bean.Album;
import bean.Data;

public class TheadFrame extends Thread {
	private Socket client;
	private Data bo;
	private ObjectOutputStream  o1;
	public TheadFrame(Socket client,Data bo,ObjectOutputStream  o1){
		this.client=client;
		this.bo=bo;
		this.o1=o1;
	}
	@Override
	public void run() {
		try {
			 
				System.out.println("客户端已连接!");
				Set<String> se=bo.getData().keySet();
				ArrayList<String> zones=new ArrayList<String>(se);//获得key值
		boolean f=true;
		while(f){
                    System.out.print("等待接收地区信息...");
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String zone=br.readLine();
                        System.out.println(zone);
                        System.out.print("返回相应的专辑信息...");
			Vector<Album> v=bo.getData().get(zone);
			o1.writeObject(v);
                        System.out.println("OK");
		}
		o1.flush();
		o1.close();
		}	
		 catch (IOException e) {
				//e.printStackTrace();
			}
		
 }
	 
public static void main(String[] args) {
	
		
	}

}
