package com.zmijewski.starwarsapiclient.domain.repository;

import com.zmijewski.starwarsapiclient.domain.entity.HomeWorldEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorldRepository extends CrudRepository<HomeWorldEntity, Long> {
}
