package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * score
 * @author 
 */
@Data
public class Score implements Serializable {
    private Integer id;

    private Integer stuId;

    private String cName;

    private Integer grade;

    private static final long serialVersionUID = 1L;
}