package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * producttype
 * @author 
 */
@Data
public class Producttype implements Serializable {
    private Integer id;

    private Integer parentid;

    private String typename;

    private Integer flagparent;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}