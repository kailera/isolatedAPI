package com.kailera.isolated.services;

import com.kailera.isolated.DTOs.MessageResponseDTO;
import com.kailera.isolated.DTOs.requests.IsolatedDTO;
import com.kailera.isolated.entities.Isolated;
import com.kailera.isolated.exceptions.IsolatedNotFoundException;
import com.kailera.isolated.mappers.IsolatedMapper;
import com.kailera.isolated.repositories.IsolatedRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IsolatedService {

    private final IsolatedRepository isolatedRepository;

    private final IsolatedMapper isolatedMapper;


    // metodos rest
    // post do isolado
    public MessageResponseDTO createIsolated (IsolatedDTO isolatedDTO){
        Isolated isolatedToSave = isolatedMapper.toModel(isolatedDTO);

        Isolated isolatedSaved = isolatedRepository.save(isolatedToSave);

        MessageResponseDTO successMessageSave = createMessage("isolado criado com id: ", isolatedSaved.getId());

        return successMessageSave;
    }

    public List<IsolatedDTO> getAllIsolated(){
        List<Isolated> allIsolated = isolatedRepository.findAll();
        return allIsolated
                .stream()
                .map(isolatedMapper::toDTO)
                .collect(Collectors.toList());
    }

    public IsolatedDTO findById(Long id) throws IsolatedNotFoundException {
        Isolated isolated = isolatedRepository.findById(id)
                .orElseThrow(()-> new IsolatedNotFoundException(id));
        return isolatedMapper.toDTO(isolated);
    }

    public MessageResponseDTO update (Long id, IsolatedDTO isolatedDTO) throws IsolatedNotFoundException{
        isolatedRepository.findById(id)
                .orElseThrow(()-> new IsolatedNotFoundException(id));

        Isolated update = isolatedMapper.toModel(isolatedDTO);
        Isolated save = isolatedRepository.save(update);
        MessageResponseDTO successUpdate = createMessage("Atualizado o usuario do id: ", save.getId());
        return successUpdate;
    }

    public void delete(Long id) throws IsolatedNotFoundException{
        isolatedRepository.findById(id)
                .orElseThrow(()-> new IsolatedNotFoundException(id));
        isolatedRepository.deleteById(id);
    }

    private MessageResponseDTO createMessage (String message, Long id){
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }




}
