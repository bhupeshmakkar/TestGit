package com.DairyFarm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.DairyFarm.model.Category;
import com.DairyFarm.model.Products;

@RepositoryRestResource
public interface DairyFarmProductRepository extends CrudRepository<Products, Integer> {
	public List<Products> findAll();

	public List<Products> findAllByCategory(Category category);

}
