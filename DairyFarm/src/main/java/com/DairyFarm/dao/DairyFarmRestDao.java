package com.DairyFarm.dao;

import java.util.List;

import com.DairyFarm.Bean.CommonBean;
import com.DairyFarm.model.Products;


public interface DairyFarmRestDao {

	List<CommonBean> findById(String webSite, String compWebSite, String category, String product, String date);

	List<Products> findAllByCategory(Integer categoryIdd);

}
