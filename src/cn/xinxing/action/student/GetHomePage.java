package cn.xinxing.action.student;

import java.io.FileInputStream;  
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinxing.business.PictureBusiness;
import cn.xinxing.business.PictureBusiness_2;
import cn.xinxing.json.core.ListObject;
import cn.xinxing.json.responseUtils.ResponseUtils;
import cn.xinxing.json.status.StatusHouse;
import cn.xinxing.json.utils.JackJsonUtils;
import cn.xinxing.model.Pictures;

/**
 * Servlet implementation class StudentInq
 */
public class GetHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Pictures> list = PictureBusiness.getAllPictures();//从数据库获取学生数据列表
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
	 public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	    	doGet(request,response);
	    }  

}
