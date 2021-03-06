package com.ryan.citystory.mapper;



import java.util.List;


public interface BaseMapper<T, E> {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(E id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T
     *
     * @mbg.generated
     */
    int insert(T t);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T
     *
     * @mbg.generated
     */
    T selectByPrimaryKey(E id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T
     *
     * @mbg.generated
     */
    List<T> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(T t);

    List<T> findByObject(T t);
}
