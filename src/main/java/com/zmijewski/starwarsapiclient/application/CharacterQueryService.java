package com.zmijewski.starwarsapiclient.application;

import com.zmijewski.starwarsapiclient.api.model.CharacterModel;
import com.zmijewski.starwarsapiclient.api.model.PageModel;
import com.zmijewski.starwarsapiclient.application.exceptions.EntityNotFoundException;
import com.zmijewski.starwarsapiclient.application.mapper.CharacterMapper;
import com.zmijewski.starwarsapiclient.domain.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CharacterQueryService {
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    @Transactional(readOnly = true)
    public CharacterModel getCharacterById(Long id) {
        return characterRepository.findById(id)
                .map(characterMapper::map)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public PageModel<CharacterModel> getAll(Pageable pageable) {
        var characterDomainPage = characterRepository.findAll(pageable)
                .map(characterMapper::map);

        return new PageModel<>(characterDomainPage);
    }
}
