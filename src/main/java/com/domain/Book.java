package com.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@TableName("tbl_book")
public class Book implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
