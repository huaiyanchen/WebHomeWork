package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * orderdetails
 * @author 
 */
@Data
public class Orderdetails implements Serializable {
    private Integer id;

    private Integer orderid;

    private Integer productid;

    private Integer num;

    private Double money;

    private static final long serialVersionUID = 1L;
}