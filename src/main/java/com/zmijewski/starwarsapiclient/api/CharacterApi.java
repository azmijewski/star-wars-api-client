package com.zmijewski.starwarsapiclient.api;

import com.zmijewski.starwarsapiclient.api.model.CharacterModel;
import com.zmijewski.starwarsapiclient.api.model.PageModel;
import com.zmijewski.starwarsapiclient.application.CharacterService;
import com.zmijewski.starwarsapiclient.application.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterApi {
    private final CharacterService characterService;

    @GetMapping
    public PageModel<CharacterModel> getAll(@PageableDefault Pageable pageable) {
        return characterService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public CharacterModel getById(@PathVariable("id") Long id) {
        return characterService.getCharacterById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String onException(EntityNotFoundException ex) {
        return ex.getMessage();
    }
}
