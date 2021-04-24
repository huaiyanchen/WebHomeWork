package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * product
 * @author 
 */
@Data
public class Product implements Serializable {
    private Integer id;

    private String pname;

    private Double price;

    private Integer num;

    private Integer discount;

    private Integer typeid;

    private Integer state;

    private static final long serialVersionUID = 1L;
}