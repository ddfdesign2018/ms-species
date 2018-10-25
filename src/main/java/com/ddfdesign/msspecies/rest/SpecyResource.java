package com.ddfdesign.msspecies.rest;

import com.ddfdesign.msspecies.rest.dto.SpecyDTO;
import com.ddfdesign.msspecies.service.IGestionSpecies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class SpecyResource {
    @Autowired
    IGestionSpecies gestionSpecies;

    @RequestMapping(value = "specy", method = RequestMethod.GET)
    public ResponseEntity<List<SpecyDTO>> getAllSpecies() {
        List<SpecyDTO> listaSpecies = gestionSpecies.getAllSpecies();
        return ResponseEntity.ok(listaSpecies);
    }

    @RequestMapping(value = "specy/{idSpecy}", method = RequestMethod.GET)
    public ResponseEntity<SpecyDTO> getSpecyByIdSpecy(@PathVariable Long idSpecy) {
        SpecyDTO listaSpecy = gestionSpecies.getSpecyById(idSpecy);
        return ResponseEntity.ok(listaSpecy);
    }

    @RequestMapping(value = "specy", method = RequestMethod.POST)
    public ResponseEntity<Void> createSpecy(@RequestBody SpecyDTO specyDTO) {
        SpecyDTO resultado = gestionSpecies.createSpecyById(specyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "specy/{idSpecy}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSpecy(@PathVariable Long idSpecy) {
        String resultado = "";
        if (gestionSpecies.deleteSpecyById(idSpecy))
            resultado = "La specy con id " + idSpecy + " Ha sido eliminado correctamente";
        else
            resultado = "La specy con id " + idSpecy + " No se ha podido borrar";
        return ResponseEntity.ok(resultado);
    }

    @RequestMapping(value = "specy", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSpecy(@RequestBody SpecyDTO specyDTO) {
        boolean resultado = gestionSpecies.updateSpecyById(specyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "saludo", method = RequestMethod.GET)
    public String saludo() {
        return "Saludo desde Species";
    }

    @RequestMapping(value = "specyList", method = RequestMethod.GET)
    public List<SpecyDTO> getAllSpeciesList() {
        List<SpecyDTO> listaSpecies = gestionSpecies.getAllSpecies();
        return listaSpecies;
    }

}
