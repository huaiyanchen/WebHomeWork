package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * empinfo
 * @author 
 */
@Data
public class Empinfo implements Serializable {
    private Integer id;

    private String account;

    private String pwd;

    private Integer deptid;

    private String name;

    private String sex;

    private Date entrytime;

    private static final long serialVersionUID = 1L;
}