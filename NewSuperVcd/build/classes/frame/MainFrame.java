package frame;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import bean.Album;



public class MainFrame extends JFrame{
	private Socket client;
    private ObjectInputStream o2;
	public  void MainFrameSet() {
		
		final JFrame jf=new JFrame("欢迎使用Stone Frorest SuperVCD应用");
		 
		 try {
			client= new Socket ("localhost",8888);
			o2 = new ObjectInputStream(client.getInputStream());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		Container c=jf.getContentPane();
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT)) ;
		JLabel jl=new JLabel("选择音乐目录:");
		final JComboBox jcb=new JComboBox();
		jcb.addItem("--------");
		try {
		    ArrayList<String> zones=((ArrayList<String>) o2.readObject());
		    Iterator<String> it = zones.iterator();
			while(it.hasNext()){
				String key = it.next();
				jcb.addItem(key);
			}
			} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
			}
		    catch (IOException e1) {
			e1.printStackTrace();
		    }
		
		
		
		
		
		/*Vector<String> v=new Vector<String>();
		v.add("大陆");v.add("港台");v.add("欧美");v.add("新加坡");
		for(String s:v){
			jcb.addItem(s);
		}*/
		p1.add(jl); p1.add(jcb);
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("音乐", p1);
		
		JLabel jl2 = new JLabel("下载电影");
		jtp.addTab("电影", jl2);

		c.add(jtp,BorderLayout.NORTH);
		
		
		
		   Menu wenjian=new Menu("FILE");
	         Menu open =new Menu("OPEN");
	         MenuItem m1=new MenuItem("DISK...");
	         MenuItem m2=new MenuItem("NETWORK...");
	         MenuItem m3=new MenuItem("INTERNET...");
	         open.add(m1);open.add(m2);open.add(m3);
	         MenuItem m4=new MenuItem("SAVE");
	         MenuItem m5=new MenuItem("EXIT");
	         wenjian.add(open);
	         wenjian.addSeparator();
	         wenjian.add(m4);
	         wenjian.addSeparator();
	         wenjian.add(m5);
	         
	    Menu xuanxiang=new Menu("OPTION");
	        MenuItem me1=new MenuItem("VIEW1");
	        MenuItem me2=new MenuItem("VIEW2");
	        MenuItem me3=new MenuItem("VIEW3");
	        xuanxiang.add(me1);
	        xuanxiang.add(me2);
	        xuanxiang.add(me3);
	       
                 Menu bangzhu=new Menu("HELP");
	         MenuItem me4=new MenuItem("ABOUT");
	         bangzhu.add(me4);
	         MenuBar mb=new MenuBar();
	         mb.add(wenjian);
	         mb.add(xuanxiang);
	         mb.add(bangzhu);
	         jf.setMenuBar(mb);
		
		//中部
	         final JList jlist = new JList();
                        c.add(jlist);
                        JPanel jp2 = new JPanel();
			final JButton b1 = new JButton("详细");
			b1.setEnabled(false);
			final JButton b2 = new JButton("清空");
			b2.setEnabled(false);
			final JButton b3 = new JButton("退出");
			
			jp2.add(b1);jp2.add(b2);jp2.add(b3);
			c.add(jp2,BorderLayout.SOUTH);  
			
			jcb.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED){
					if(jcb.getSelectedIndex()==0){
						jlist.setListData(new Vector());
						b1.setEnabled(false);
						b2.setEnabled(false);	
					}	
					else{
						String zone = (String)jcb.getSelectedItem();
						
						jlist.setListData(new Vector());
						
					try{	
					String diqu=(String)jcb.getSelectedItem();
					PrintWriter pw = new PrintWriter(client.getOutputStream());
					pw.println(diqu);
					pw.flush();
					Vector<String> v=(Vector<String>) o2.readObject();
					 jlist.setListData(v);
					 
						
					}	
						catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						
					   catch (IOException e2) {
						e2.printStackTrace();
					  }
                                        b2.setEnabled(true);
					b1.setEnabled(false);
					}	
				jlist.addListSelectionListener(new ListSelectionListener(){
                                               @Override
						public void valueChanged(ListSelectionEvent e) {
					        b1.setEnabled(true);
						}
						
					});
					
					
					b1.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							
							Album title =(Album)jlist.getSelectedValue();
							MusicDialog md=new MusicDialog();
							md.MusicDialog(jf,title);	
						}
						
					});
					
					
						
					
		
		b2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						jcb.setSelectedIndex(0);
						
					}
				});	
				}
				}
			});
			
		b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jf.setVisible(false);
					jf.dispose();
					System.exit(1);	
				}
			});
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(200, 200, 400, 400);
		jf.setVisible(true);
	}
	
	
	
	
	

}


