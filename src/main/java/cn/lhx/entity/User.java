package cn.lhx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lee549
 * @date 2020/2/24 21:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id ;
    private String name;
    private String password;
    private Boolean admin;

    @NumberFormat(pattern = "#,###")
    private Long deptId;

//
//    注解@JsonFormat主要是后台到前台的时间格式的转换
//
//    注解@DataFormAT主要是前后到后台的时间格式的转换
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")

    //@JSONField(format = "yyyy-MM-dd HH:mm:ss")

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;



}
