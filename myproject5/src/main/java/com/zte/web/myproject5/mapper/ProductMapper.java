package com.zte.web.myproject5.mapper;

import com.zte.web.myproject5.model.Product;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newProduct
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer aT);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newProduct
     *
     * @mbg.generated
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newProduct
     *
     * @mbg.generated
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newProduct
     *
     * @mbg.generated
     */
    Product selectByPrimaryKey(Integer aT);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newProduct
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newProduct
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Product record);
}