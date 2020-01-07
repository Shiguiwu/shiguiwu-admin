package com.shiguiwu.admin.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: ${DESC}
 * @author: stone
 * @date: Created by 2020/1/5 21:32
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class SysRole extends BaseEntity<Integer> {


    private static final long serialVersionUID = 5631419793882631401L;

    private String name;

    private String description;


}