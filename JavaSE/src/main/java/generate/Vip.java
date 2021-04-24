package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * vip
 * @author 
 */
@Data
public class Vip implements Serializable {
    private Integer id;

    private String cardnumber;

    private String vipname;

    private String iphone;

    private Integer jifen;

    private Double money;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}