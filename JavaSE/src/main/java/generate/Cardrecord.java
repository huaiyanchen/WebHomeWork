package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cardrecord
 * @author 
 */
@Data
public class Cardrecord implements Serializable {
    private Integer id;

    private Integer empid;

    private Date cardtime;

    private Integer isnormal;

    private static final long serialVersionUID = 1L;
}