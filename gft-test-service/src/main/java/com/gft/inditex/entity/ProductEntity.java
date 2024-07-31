package com.gft.inditex.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 3L;


    @TableGenerator(name = "id_gen", initialValue = 35454)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
    private Integer id;
    private String name;
}
