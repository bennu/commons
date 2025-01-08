package cl.bennu.commons.domain;

import cl.bennu.commons.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Example extends BaseDomain implements Serializable {

    private Long id;
    private String name;
    private Boolean active;

}
