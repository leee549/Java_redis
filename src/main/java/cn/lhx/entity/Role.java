package cn.lhx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    private Long id;
    private String name;
    private String sn;
    private List<Permission> permissions;

}
