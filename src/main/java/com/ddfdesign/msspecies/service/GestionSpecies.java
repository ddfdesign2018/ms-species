package com.ddfdesign.msspecies.service;

import com.ddfdesign.msspecies.entity.Specy;
import com.ddfdesign.msspecies.repository.ISpeciesRepository;
import com.ddfdesign.msspecies.rest.dto.SpecyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionSpecies implements IGestionSpecies{

    @Autowired
    ISpeciesRepository speciesRepository;

    @Override
    public List<SpecyDTO> getAllSpecies () {
        List<SpecyDTO> lista = speciesRepository.findAll()
                .stream()
                .map(
                        specyEntity -> new SpecyDTO(
                                specyEntity.getId(),
                                specyEntity.getName(),
                                specyEntity.getType()
                                )
                ).collect(Collectors.toList());
        return lista;
    }

    @Override
    public SpecyDTO getSpecyById(Long idSpecy){
        Optional<Specy> specyOptional = speciesRepository.findById(idSpecy);
        Specy specy = specyOptional.get();
        SpecyDTO specyDTO = new SpecyDTO(
                specy.getId(),
                specy.getName(),
                specy.getType()
        );
        return specyDTO;
    }

    @Override
    public SpecyDTO createSpecyById(SpecyDTO specyDTO){
        Specy specy = new Specy(
                null,
                specyDTO.getName(),
                specyDTO.getType()
                );
        Specy resultado = speciesRepository.save(specy);
        return new SpecyDTO(specy.getId(),
                resultado.getName(),
                resultado.getType()
                );
    }

    @Override
    public boolean deleteSpecyById(Long idSpecy){

        boolean resultado = false;
        speciesRepository.deleteById(idSpecy);
        Optional<Specy> specyOptional = speciesRepository.findById(idSpecy);
        if (!specyOptional.isPresent())
            resultado = true;
        return resultado;
    }

    @Override
    public boolean updateSpecyById(SpecyDTO specyDTO){
        Specy specy = new Specy(
                specyDTO.getId(),
                specyDTO.getName(),
                specyDTO.getType()
        );
        speciesRepository.save(specy);
        return true;
    }



}
