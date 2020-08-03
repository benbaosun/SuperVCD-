package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import bean.Album;
import bean.Song;
public class MusicDialog extends JDialog{
public static MainFrame MainFrame;
	public  void MusicDialog(Frame fa,Album title) {
   
	final JDialog jd = new JDialog(fa,"专辑的详细信息："+title,true);
		
		//北部   图片
	
	
	Container con = this.getContentPane();
	
	con.setLayout(new BorderLayout());
	
           JPanel p1 =new JPanel();
           p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
   		JPanel jpa = new JPanel();
   		jpa.setBorder(new EmptyBorder(10, 10, 0, 10));

   		jpa.setLayout(new GridBagLayout());
   		GridBagConstraints c = new GridBagConstraints();
   		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 10.0;
		c.weighty = 0.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(10, 0, 2, 10);
		JLabel artistLabel = new JLabel("歌手:  " +title.getSinger());
		artistLabel.setForeground(Color.black);
		jpa.add(artistLabel, c);
		
		c.gridy = GridBagConstraints.RELATIVE;
		c.insets = new Insets(2, 0, 10, 10);
		JLabel titleLabel = new JLabel("专辑名:  " +title.getName());
		titleLabel.setForeground(Color.black);
		jpa.add(titleLabel, c);

		JLabel categoryLabel = new JLabel("地区:  "+title.getZone());
		c.insets = new Insets(2, 0, 2, 0);
		categoryLabel.setForeground(Color.black);
		jpa.add(categoryLabel, c);
		p1.add(jpa);
		
   		c.gridx = 3;
   		c.gridy = 1;
   		c.gridwidth = GridBagConstraints.REMAINDER;
   		c.gridheight = 5;
   		c.fill = GridBagConstraints.NONE;
   		c.weightx =10.0;
   		c.weighty = 10;
   		
   		if(title.getPicture().trim().length()!=0){
		ImageIcon img = new ImageIcon("images/"+title.getPicture());
		JLabel jl = new JLabel(img);
		p1.add(jl,c);
   		}
   		else{
   			ImageIcon img1 = new ImageIcon("images/暂无图片.jpg");
   			JLabel jl1 = new JLabel(img1);	
   			p1.add(jl1,c);
   		}
   		
		
		
		   jd.add(p1,BorderLayout.NORTH);
		   
		   c.weightx=0.0;
		   JPanel p3 =new JPanel();

			 
	       
	       
		   
		   
		   
		//中间   JList
		JList jlist = new JList();
		Vector<Song> vs=title.getSongs();
		
		jlist.setListData(vs);
		
		/*
		 * JList当区域不能完整显示列表数据时，不会自动出现滚动条
		 * 我们需要将JList组件放在一个滚动区中JScrollPane
		 * 注意：JScrollPane有一个view可视区    组件放在可视区才能显示
		 * 2种方式
		 * 	（1）构造滚动区对象时，直接将被显示组件放入构造方法
		 *  （2）getViewport()获得可视区对象JViewport,再使用可视区对象添加组件
		 */
		
		//JScrollPane jsp = new JScrollPane(jlist);
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.getViewport().add(jlist);
		
		
		//给滚动区设置边框
		jsp.setBorder(new TitledBorder("歌曲列表："));
		
		
		jd.add(jsp);
		
		//南部  按钮
		
		
		 JPanel p2=new JPanel();
			JButton a1=new JButton("确定");
			p2.add(a1);
			jd.add(p2,BorderLayout.SOUTH);
			
			a1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				jd.setVisible(false);	
				jd.dispose();
				}
			});
                jd.setBounds(200, 200,400, 500);
		jd.setVisible(true);
		
	}

}
