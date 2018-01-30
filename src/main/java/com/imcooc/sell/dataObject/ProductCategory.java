package com.imcooc.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@DynamicUpdate
@Data  //打包的时候再生成，性能是一样的
public class ProductCategory {



    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private  Integer   categoryType;

    /**
     * 创建时间
     */
    private  Date  createTime;

    //更新时间
    private  Date  updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
