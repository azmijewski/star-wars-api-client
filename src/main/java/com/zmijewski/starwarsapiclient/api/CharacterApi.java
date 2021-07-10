package com.zmijewski.starwarsapiclient.api;

import com.zmijewski.starwarsapiclient.api.model.CharacterModel;
import com.zmijewski.starwarsapiclient.api.model.PageModel;
import com.zmijewski.starwarsapiclient.application.CharacterService;
import com.zmijewski.starwarsapiclient.application.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
@Api("Characters")
public class CharacterApi {
    private final CharacterService characterService;

    @GetMapping
    @ApiOperation("Get characters page")
    @ApiResponse(code = 200, message = "Page was received successfully")
    public PageModel<CharacterModel> getAll(@PageableDefault Pageable pageable) {
        return characterService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get character by his id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Character was found"),
            @ApiResponse(code = 404, message = "Characters with id not found")
    })
    public CharacterModel getById(@PathVariable("id") Long id) {
        return characterService.getCharacterById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String onException(EntityNotFoundException ex) {
        return ex.getMessage();
    }
}
