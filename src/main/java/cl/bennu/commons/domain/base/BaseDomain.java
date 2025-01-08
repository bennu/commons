package cl.bennu.commons.domain.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseDomain {

    private Long id;
    private Boolean active;
    private Boolean inUse;

}
