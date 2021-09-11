package po;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer id;

    private String manger;

    private String name;

    private Double pay;

    private String remark;

    public Student(Integer id, String manger, String name, Double pay, String remark) {
        this.id = id;
        this.manger = manger;
        this.name = name;
        this.pay = pay;
        this.remark = remark;
    }

    private static final long serialVersionUID = 1L;
}