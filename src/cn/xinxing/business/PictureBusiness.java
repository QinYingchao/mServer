package cn.xinxing.business;

import java.sql.ResultSet;      
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.Pictures;

/**
 * 从数据库中获取数据
 */
public class PictureBusiness {

	/**
	 * 获取所有的学生数据
	 * @return
	 */
	public static List<Pictures> getAllPictures() {
		List<Pictures> list = new ArrayList<Pictures>();//list对象
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from pictures";// SQL
		db1 = new DBHelper(sql);//创建DBHelper对象
		ResultSet ret = null;//创建结果集对象，执行SQL后返回的数据集合
		try {
			ret = db1.pst.executeQuery();//这个方法类似于执行了select语句一样
			while (ret.next()) {
				int id = ret.getInt(1);//第一列是id
				String name = ret.getString(2);//第二列name
				String imgSrc=ret.getString(3);//imgSrc
				Pictures pictures = new Pictures();//创建student对象
				pictures.setId(id);//设置id
				pictures.setName(name);//设置name
				pictures.setImgSrc(imgSrc);
				list.add(pictures);//将students对象放置到列表中
			} //循环从结果集中获取数据并设置到list列表对象中
			ret.close();//关闭对象
			db1.close();//关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return list;//返回结果
	}

	/**
	 * 通过id来获取某个学升数据
	 * @param _id
	 * @return
	 */
	public static Pictures getPictureInfoById(String _id) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from pictures where id =" + _id;// 
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		Pictures pictures = new Pictures();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				int id = ret.getInt(1);
				String name = ret.getString(2);
				String imgSrc=ret.getString(3);//imgSrc
				pictures.setId(id);
				pictures.setName(name);
				pictures.setImgSrc(imgSrc);
				
				
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return pictures;
	}
}
