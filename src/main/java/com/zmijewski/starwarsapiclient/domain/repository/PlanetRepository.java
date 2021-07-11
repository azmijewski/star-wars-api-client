package com.zmijewski.starwarsapiclient.domain.repository;

import com.zmijewski.starwarsapiclient.domain.entity.PlanetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<PlanetEntity, Long> {
}
