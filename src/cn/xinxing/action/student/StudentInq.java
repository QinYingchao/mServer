package cn.xinxing.action.student;

import java.io.IOException;  
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinxing.business.StudentBusiness;
import cn.xinxing.json.core.ListObject;
import cn.xinxing.json.responseUtils.ResponseUtils;
import cn.xinxing.json.status.StatusHouse;
import cn.xinxing.json.utils.JackJsonUtils;
import cn.xinxing.model.Students;

/**
 * Servlet implementation class StudentInq
 */
public class StudentInq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Students> list = StudentBusiness.getAllStudents();//从数据库获取学生数据列表
		ListObject listObject=new ListObject();//创建一个返回对象
		listObject.setItems(list);//将数据列表设置给返回对象的items属性
		listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);//设置返回对象的响应状态码
		String responseText = JackJsonUtils.toJson(listObject);//将返回对象转换为json字符串
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		ResponseUtils.renderJson(response, responseText); //将结果返回给调用者
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
