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

    @TableGenerator(name = "id_gen", initialValue = 35454)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
    private Integer id;
    private String name;
}
