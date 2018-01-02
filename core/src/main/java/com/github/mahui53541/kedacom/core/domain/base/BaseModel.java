package com.github.mahui53541.kedacom.core.domain.base;

import javax.persistence.*;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 13:22
 * @version:1.0.0
 */
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
