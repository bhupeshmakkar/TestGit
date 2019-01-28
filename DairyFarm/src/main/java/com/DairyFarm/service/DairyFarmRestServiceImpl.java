package com.DairyFarm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DairyFarm.Bean.CommonBean;
import com.DairyFarm.dao.DairyFarmRestDao;
import com.DairyFarm.model.Products;
@Service("dairyFarmRestService")
@Transactional
public class DairyFarmRestServiceImpl implements DairyFarmRestService {

	@Autowired
	DairyFarmRestDao dairyFarmRestDao;

	@Override
	public List<CommonBean> findById(String webSite, String compWebSite, String category, String product, String date) {
		return dairyFarmRestDao.findById(webSite, compWebSite, category, product, date);
	}

	@Override
	public List<Products> findAllByCategory(Integer categoryIdd) {
		return dairyFarmRestDao.findAllByCategory(categoryIdd);
	}

}
