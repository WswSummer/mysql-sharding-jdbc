package com.wsw.mysqlshardingjdbc.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author WangSongWen
 * @Date: Created in 14:48 2021/1/21
 * @Description:
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class testUser implements Serializable, Comparable{
    private static final long serialVersionUID = -1205226416664488559L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    @Override
    public int compareTo(Object o) {
        testUser u= (testUser) o;
        return this.id.compareTo(u.id);
    }
}
