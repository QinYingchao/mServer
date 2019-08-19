package cn.xinxing.service.student.impl;

import java.util.List;

import cn.xinxing.business.PictureBusiness;
import cn.xinxing.model.Pictures;
import cn.xinxing.service.student.PictureService;

/**
 * 
 */
public class PictureServiceImpl implements PictureService{

	@Override
	public List<Pictures> getAllPictures() {
		// TODO Auto-generated method stub
		return PictureBusiness.getAllPictures();
	}

}
