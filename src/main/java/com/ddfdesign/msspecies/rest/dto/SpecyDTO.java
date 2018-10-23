package com.ddfdesign.msspecies.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecyDTO {
    private Long id;
    private String name;
    private String type;
}
