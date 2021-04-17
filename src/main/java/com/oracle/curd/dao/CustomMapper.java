package com.oracle.curd.dao;

import com.oracle.curd.bean.Custom;
import com.oracle.curd.bean.CustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    long countByExample(CustomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int deleteByExample(CustomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int deleteByPrimaryKey(String cusid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int insert(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int insertSelective(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    List<Custom> selectByExample(CustomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    Custom selectByPrimaryKey(String cusid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int updateByPrimaryKeySelective(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    int updateByPrimaryKey(Custom record);
}