
package bean;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
        public class Data {

	private Map<String,Vector<Album>> data = new HashMap<>();
	
	public Map<String, Vector<Album>> getData() {
		return data;
	}

        public void setData(Map<String, Vector<Album>> data) {
		this.data = data;
	}
	
        /**
	 * music.db文件使用io进行读取封装工作
	 */
	public void dataInit(){
		try {
			//创建读文件的流
			BufferedReader br = new BufferedReader(new FileReader("src/a/music.db"));
			String str = "";
			while((str = br.readLine())!=null){
				//张学友,给我亲爱的, 港台, 张学友.jpg, 10
				String[] strs = str.split(",");
				//封装专辑  String singer, String name, String zone, String picture trim去空格
				Album al = new Album(strs[0],strs[1],strs[2].trim(),strs[3].trim());
				//该专辑歌曲数量     下面应该使用流读取count行  每行都是歌曲具体歌词 
				int count = Integer.parseInt(strs[4].trim());//整形对象Integer转换成基本数据类型int（整数）。
				Vector<Song> v = new Vector<Song>();
				for(int i=0;i<count;i++){
					//不准点火,273
					String s = br.readLine();//都是一个歌曲
					String [] ss = s.split(",");
					Song song = new Song(ss[0],new Duration(Integer.parseInt(ss[1].trim())));
                                        v.add(song);
				}
				
				//将v设置给专辑
				al.setSongs(v);//才正在封装完专辑对象
				//将封装完成的专辑al  合理的     放入Map中
				//如果 al专辑   地区在map不存在      
				if(!data.containsKey(al.getZone())){//不包含
					//创建一个Vector<Album>
					Vector<Album> va = new Vector<Album>();
					va.add(al);
					data.put(al.getZone(),va);
				}else{//包含  // al专辑   地区在map存在  
					//取出存在的Vector<Album>
					Vector<Album> va = data.get(al.getZone());
					va.add(al);
				}
				//将专辑放入map完成
				//读取下一行 ---------------  
				br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
