package com.oracle.curd.bean;

public class Type {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.protypeid
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String protypeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.typename
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String typename;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.protypeid
     *
     * @return the value of type.protypeid
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getProtypeid() {
        return protypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.protypeid
     *
     * @param protypeid the value for type.protypeid
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setProtypeid(String protypeid) {
        this.protypeid = protypeid == null ? null : protypeid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.typename
     *
     * @return the value of type.typename
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getTypename() {
        return typename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.typename
     *
     * @param typename the value for type.typename
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}