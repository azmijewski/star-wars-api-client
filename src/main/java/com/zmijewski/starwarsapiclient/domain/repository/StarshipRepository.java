package com.zmijewski.starwarsapiclient.domain.repository;

import com.zmijewski.starwarsapiclient.domain.entity.StarshipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends CrudRepository<StarshipEntity, Long> {
}
