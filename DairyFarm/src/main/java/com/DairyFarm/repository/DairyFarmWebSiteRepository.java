package com.DairyFarm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.DairyFarm.model.WebSites;

@RepositoryRestResource
public interface DairyFarmWebSiteRepository extends CrudRepository<WebSites, Integer> {
	public List<WebSites> findAll();

}
