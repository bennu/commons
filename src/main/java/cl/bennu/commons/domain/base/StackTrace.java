package cl.bennu.commons.domain.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StackTrace {

    private String clazz;
    private String method;
    private Integer line;
    private String error;

}
