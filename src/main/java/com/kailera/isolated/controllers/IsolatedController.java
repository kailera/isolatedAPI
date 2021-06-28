package com.kailera.isolated.controllers;

// urls, user interface and service injection (calls)

import com.kailera.isolated.DTOs.MessageResponseDTO;
import com.kailera.isolated.DTOs.requests.IsolatedDTO;
import com.kailera.isolated.exceptions.IsolatedNotFoundException;
import com.kailera.isolated.services.IsolatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1/isolated")
public class IsolatedController {


    private final IsolatedService isolatedService;

    @Autowired
    public IsolatedController(IsolatedService isolatedService) {
        this.isolatedService = isolatedService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid IsolatedDTO isolatedDTO){
        return  isolatedService.createIsolated(isolatedDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IsolatedDTO> getAllIsolated(){

        return isolatedService.getAllIsolated();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IsolatedDTO findIsolatedById(@PathVariable Long id) throws IsolatedNotFoundException {
        return isolatedService.findById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateIsolated(@RequestBody @PathVariable Long id, @Valid IsolatedDTO isolatedDTO) throws  IsolatedNotFoundException{
        return isolatedService.update(id, isolatedDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIsolated(@PathVariable Long id) throws IsolatedNotFoundException{
        isolatedService.delete(id);
    }

}
