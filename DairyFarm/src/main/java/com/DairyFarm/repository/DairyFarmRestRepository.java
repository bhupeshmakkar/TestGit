package com.DairyFarm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.DairyFarm.model.Category;

@RepositoryRestResource
public interface DairyFarmRestRepository extends CrudRepository<Category, Integer> {
	public List<Category> findAll();

}
