package com.oracle.curd.bean;

public class Manager {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.managerid
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String managerid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.managername
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String managername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.card
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String card;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.sex
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.tel
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.stafftype
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String stafftype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.pwd
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    private String pwd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.managerid
     *
     * @return the value of manager.managerid
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getManagerid() {
        return managerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.managerid
     *
     * @param managerid the value for manager.managerid
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setManagerid(String managerid) {
        this.managerid = managerid == null ? null : managerid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.managername
     *
     * @return the value of manager.managername
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getManagername() {
        return managername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.managername
     *
     * @param managername the value for manager.managername
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.card
     *
     * @return the value of manager.card
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getCard() {
        return card;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.card
     *
     * @param card the value for manager.card
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.sex
     *
     * @return the value of manager.sex
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.sex
     *
     * @param sex the value for manager.sex
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.tel
     *
     * @return the value of manager.tel
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.tel
     *
     * @param tel the value for manager.tel
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.stafftype
     *
     * @return the value of manager.stafftype
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getStafftype() {
        return stafftype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.stafftype
     *
     * @param stafftype the value for manager.stafftype
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setStafftype(String stafftype) {
        this.stafftype = stafftype == null ? null : stafftype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.pwd
     *
     * @return the value of manager.pwd
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.pwd
     *
     * @param pwd the value for manager.pwd
     *
     * @mbg.generated Wed Dec 23 13:56:28 CST 2020
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerid='" + managerid + '\'' +
                ", managername='" + managername + '\'' +
                ", card='" + card + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", stafftype='" + stafftype + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}