package com.DairyFarm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DairyFarm.Bean.CommonBean;
import com.DairyFarm.model.Category;
import com.DairyFarm.model.CompWebSites;
import com.DairyFarm.model.Products;
import com.DairyFarm.model.WebSites;
import com.DairyFarm.repository.DairyFarmProductRepository;
import com.DairyFarm.repository.DairyFarmRestRepository;
import com.DairyFarm.repository.DairyFarmWebSiteRepository;
import com.DairyFarm.service.DairyFarmRestService;
import com.DairyFarm.utility.ApplicationContextAwareImpl;

@RestController
public class DairyFarmRestController {

	@Autowired
	DairyFarmRestRepository dairyFarmRestRepository;
	@Autowired
	DairyFarmProductRepository dairyFarmProductRepository;
	@Autowired
	DairyFarmWebSiteRepository dairyFarmWebSiteRepository;
	@Autowired
	ApplicationContextAwareImpl applicationContextAware;

	@GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getCategories() {
		List<Category> catList = new ArrayList<Category>();
		catList = dairyFarmRestRepository.findAll();
		return catList;
	}

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Products> getProducts() {
		List<Products> productList = new ArrayList<Products>();
		productList = dairyFarmProductRepository.findAll();
		return productList;
	}

	@GetMapping(value = "/webSites", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WebSites> getWebSites() {
		List<WebSites> webSitesList = new ArrayList<WebSites>();
		webSitesList = dairyFarmWebSiteRepository.findAll();
		return webSitesList;
	}

	@GetMapping(value = "/compWebSites", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompWebSites> getCompWebSites() {
		List<CompWebSites> compWebSitesList = new ArrayList<CompWebSites>();
		compWebSitesList.add(new CompWebSites(1, "Red Mart"));
		compWebSitesList.add(new CompWebSites(2, "Fair Price"));
		compWebSitesList.add(new CompWebSites(3, "All For You"));
		return compWebSitesList;
	}

	@GetMapping(value = "/masterData", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = { "http://192.168.3.24:8080","http://192.168.3.24", "http://localhost:4200" })
	public Map<String, Object[]> getMastersData() {
		List<Category> catList = new ArrayList<Category>();
		catList = dairyFarmRestRepository.findAll();
		List<Products> productList = new ArrayList<Products>();
		productList = dairyFarmProductRepository.findAll();
		List<WebSites> webSitesList = new ArrayList<WebSites>();
		webSitesList.add(new WebSites(2, "Giant Online"));
		webSitesList.add(new WebSites(5, "Cold Storage"));
		List<Object> compWebSitesList = new ArrayList<Object>();
		compWebSitesList.add(new CompWebSites(1, "Red Mart"));
		compWebSitesList.add(new CompWebSites(4, "All For You"));
		compWebSitesList.add(new CompWebSites(6, "Fair Price"));

		Map<String, Object[]> map = new HashMap<String, Object[]>();
		map.put("category", catList.toArray());
		map.put("product", productList.toArray());
		map.put("webSites", webSitesList.toArray());
		map.put("compWebSites", compWebSitesList.toArray());
		return map;
	}

	@GetMapping(value = "/varianceList", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = { "http://192.168.3.24:8080","http://192.168.3.24", "http://localhost:4200" })
	public List<CommonBean> getVarianceList(@RequestParam String webSite, @RequestParam String compWebSite,
			@RequestParam String category, @RequestParam String product, @RequestParam String date) {

		List<CommonBean> beanList = new ArrayList<CommonBean>();
		ApplicationContext context = applicationContextAware.getApplicationContext();
		DairyFarmRestService dairyFarmRestService = (DairyFarmRestService) context.getBean("dairyFarmRestService");
		beanList = dairyFarmRestService.findById(webSite, compWebSite, category, product, date);
		return beanList;

	}

	@GetMapping(value = "/productList", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = { "http://192.168.3.24:8080","http://192.168.3.24", "http://localhost:4200" })
	public List<Products> getProductList(@RequestParam String categoryId) {

		Integer categoryIdd = categoryId != null && !categoryId.isEmpty() ? Integer.parseInt(categoryId) : 0;
		List<Products> productList = new ArrayList<Products>();
		if (categoryIdd != 0) {
			ApplicationContext context = applicationContextAware.getApplicationContext();
			DairyFarmRestService dairyFarmRestService = (DairyFarmRestService) context.getBean("dairyFarmRestService");
			productList = dairyFarmRestService.findAllByCategory(categoryIdd);
		}else {
			productList = dairyFarmProductRepository.findAll();
		}

		return productList;

	}
}