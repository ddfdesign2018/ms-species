package com.ddfdesign.msspecies.service;

import com.ddfdesign.msspecies.rest.dto.SpecyDTO;

import java.util.List;

public interface IGestionSpecies {
    List<SpecyDTO> getAllSpecies();
    SpecyDTO getSpecyById(Long idSpecy);
    SpecyDTO createSpecyById(SpecyDTO specyDTO);
    boolean deleteSpecyById(Long idSpecy);
    boolean updateSpecyById(SpecyDTO animalDTO);
}
