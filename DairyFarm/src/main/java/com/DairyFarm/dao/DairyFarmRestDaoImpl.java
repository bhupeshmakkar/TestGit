package com.DairyFarm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.DairyFarm.Bean.CommonBean;
import com.DairyFarm.model.Products;

@Repository
public class DairyFarmRestDaoImpl implements DairyFarmRestDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<CommonBean> findById(String webSite, String compWebSite, String category, String product, String date) {

		Integer webSiteTemp = 0;
		Integer compWebSiteTemp = 0;
		Integer categoryTemp = 0;
		Integer productTemp = 0;

		try {
			webSiteTemp = Integer.parseInt(webSite);
			compWebSiteTemp = Integer.parseInt(compWebSite);
			categoryTemp = Integer.parseInt(category);
			productTemp = Integer.parseInt(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuilder builder = new StringBuilder("SELECT p.prd_id , p.prd_name as productName,"
				+ "       p.prd_cat_id ,  c.prd_cat_name as categoryName," + "       c.prd_cat_status ,  p.tanent_id , "
				+ "       w.price_promo  as webSitePP,  comp.price_promo as compWebSitePP, "
				+ "	   case when comp.price_promo <> 0 and w.price_promo =0 then 100  when comp.price_promo =0 and w.price_promo =0 then 0 else  100*(comp.price_promo - w.price_promo)/w.price_promo end as Variance, "
				+ "       CONVERT(VARCHAR, comp.ppr_res_timestamp, 23) AS date FROM   m_product p "
				+ "       JOIN m_product_category c   ON p.prd_cat_id = c.prd_cat_id "
				+ "            AND p.tanent_id = c.tanent_id   JOIN (SELECT ppr_res_timestamp, "
				+ "                    prd_id,  price_promo "
				+ "             FROM   t_product_price_res w    JOIN m_websites s "
				+ "                      ON w.site_id = s.site_id  WHERE  s.site_id = " + webSiteTemp
				+ "    AND w.ppr_res_id = (SELECT Max(a.ppr_res_id) "
				+ " FROM   t_product_price_res a  JOIN m_websites s ON a.site_id = s.site_id "
				+ "   WHERE  a.prd_id = w.prd_id and s.site_id = " + webSiteTemp + "  AND  a.ppr_res_timestamp =  '"
				+ date + "'   GROUP  BY a.prd_id)) w "
				+ "         ON w.prd_id = p.prd_id  JOIN (SELECT ppr_res_timestamp, "
				+ "                    prd_id,  price_promo "
				+ "             FROM   t_product_price_res comp JOIN m_websites s "
				+ "                      ON comp.site_id = s.site_id  WHERE  s.site_id = " + compWebSiteTemp
				+ " AND comp.ppr_res_id = (SELECT Max(a.ppr_res_id) "
				+ "   FROM   t_product_price_res a  JOIN m_websites s ON a.site_id = s.site_id "
				+ "  WHERE  a.prd_id = comp.prd_id and s.site_id = " + compWebSiteTemp
				+ " AND  a.ppr_res_timestamp =  '" + date + "' GROUP  BY a.prd_id)) comp "
				+ "  ON w.prd_id = comp.prd_id " + "WHERE  prd_cat_status = 1 " + "       AND prd_status = 1");

		if (categoryTemp != 0) {
			builder.append(" and p.prd_cat_id = " + categoryTemp);
		}
		if (productTemp != 0) {
			builder.append(" and p.prd_id = " + productTemp);
		}

		builder.append(" ORDER  BY prd_id, prd_cat_id, tanent_id ");

		List<Object[]> objListTemp = entityManager.createNativeQuery(builder.toString()).getResultList();
		List<CommonBean> beanList = new ArrayList<CommonBean>();

		for (Object[] objTemp : objListTemp) {

			CommonBean commonBean = new CommonBean();
			commonBean.setProductName(objTemp[1].toString());
			commonBean.setCategoryName(objTemp[3].toString());
			commonBean.setWebSitePP(objTemp[6].toString());
			commonBean.setCompWebSitePP(objTemp[7].toString());
			commonBean.setVarience(objTemp[8].toString());
			commonBean.setDate(objTemp[9].toString());
			beanList.add(commonBean);
		}

		return beanList;
	}

	@Override
	public List<Products> findAllByCategory(Integer categoryIdd) {

		List<Products> productList = entityManager.createQuery("from Products where category = " + categoryIdd)
				.getResultList();

		return productList;
	}

}
