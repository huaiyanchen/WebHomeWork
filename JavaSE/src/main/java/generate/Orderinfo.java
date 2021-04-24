package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * orderinfo
 * @author 
 */
@Data
public class Orderinfo implements Serializable {
    private Integer id;

    private Integer vipid;

    private Double price;

    private Date orderdate;

    private Integer paytype;

    private Double money;

    private static final long serialVersionUID = 1L;
}