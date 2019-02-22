package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable {
    private Integer id;

    private String name;

    private String pwd;

    private static final long serialVersionUID = 1L;


}