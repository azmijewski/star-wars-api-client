package com.zmijewski.starwarsapiclient.domain.repository;

import com.zmijewski.starwarsapiclient.domain.entity.CharacterEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends PagingAndSortingRepository<CharacterEntity, Long> {
}
