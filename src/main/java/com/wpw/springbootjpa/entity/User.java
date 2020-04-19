package com.wpw.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wpw.springbootjpa.vo.RequestVo;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wpw
 */
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class User extends RequestVo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_name", length = 50)
    private String lastName;
}
