package net;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Set;
import frame.TheadFrame;
import bean.Data;

public class Musicserver {
	public static void main(String[] args) {
	try {
			ServerSocket server=new ServerSocket(8888);
			System.out.println("等待客户端连接waiting...");
                        boolean f1=true;
                        Data bo = new Data();
			bo.dataInit();	
                       
                        while(f1){
		        Socket client=	server.accept();
			System.out.println("客户端已连接!!!OK!");
			System.out.println("获得专辑个数："+bo.getData().keySet().size()+" 个");
			   Set<String> se=bo.getData().keySet();
                           System.out.print("正在返回地区信息...");
                            ArrayList<String> zones=new ArrayList<String>(se);//获得key值
			   ObjectOutputStream  o1=new ObjectOutputStream(client.getOutputStream());
                           o1.writeObject(zones);
                           System.out.println("OK");
		           TheadFrame T=new TheadFrame(client,bo,o1 );
			   T.start();
		       }
		}
                catch (IOException e) {
				e.printStackTrace();
			}
             }
}
