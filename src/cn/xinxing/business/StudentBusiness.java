package cn.xinxing.business;

import java.sql.ResultSet;   
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.Students;

/**
 * 从数据库中获取数据
 */
public class StudentBusiness {

	/**
	 * 获取所有的学生数据
	 * @return
	 */
	public static List<Students> getAllStudents() {
		List<Students> list = new ArrayList<Students>();//list对象
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from student";// SQL
		db1 = new DBHelper(sql);//创建DBHelper对象
		ResultSet ret = null;//创建结果集对象，执行SQL后返回的数据集合
		try {
			ret = db1.pst.executeQuery();//这个方法类似于执行了select语句一样
			while (ret.next()) {
				int id = ret.getInt(1);//第一列是id
				String name = ret.getString(2);//第二列name
				int age = ret.getInt(3);//第三列是age
				int sex = ret.getInt(4); //第四列是sex
				Students students = new Students();//创建student对象
				students.setId(id);//设置id
				students.setName(name);//设置name 
				students.setAge(age);//设置age
				students.setSex(sex);//设置sex
				list.add(students);//将students对象放置到列表中
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
	public static Students getStudentInfoById(String _id) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from student where id =" + _id;// 
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		Students students = new Students();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				int id = ret.getInt(1);
				String name = ret.getString(2);
				int age = ret.getInt(3);
				int sex = ret.getInt(4);
				int mobile = ret.getInt(5);
				students.setId(id);
				students.setName(name);
				students.setAge(age);
				students.setSex(sex);
				students.setMobile(mobile);
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return students;
	}
}
