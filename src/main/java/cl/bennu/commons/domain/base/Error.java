package cl.bennu.commons.domain.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Error {

    private String type;
    private Integer code;
    private String error;
    private List<StackTrace> stackTraces;

}
