 /* 
  * 
 Author: Xiangwu Dai
 * Date: 2023/3/25
 * Description: Assignment2
 */
package transferobjects;

/**
 * a DTO used to store and transfer DBMS login credentials
 * between businesslayer and dataacesslayer
 * @author kriger
 */

public class CredentialsDTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String coursecode;
    private Integer tutorID;

    /**
     * simple getter for user name portion of the credentials
     * @return user name portion of the credentials
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * simple getter for tutor portion of the credentials
     * @return tutor portion of the credentials
     */    

    public Integer getTutorID() {
        return tutorID;
    }
    /**
     * simple setter for tutorID portion of the credentials
     * @param tutorID password portion of the credentials
     */
    public void setTurtorID(Integer tutorID) {
        this.tutorID = tutorID;
    }

    /**
     * simple setter for user name portion of the credentials
     * @param username user name portion of the credentials
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * simple getter for password portion of the credentials
     * @return password portion of the credentials
     */
    public String getPassword() {
        return password;
    }

    /**
     * simple setter for password portion of the credentials
     * @param password password portion of the credentials
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * simple getter for first name portion of the credentials
     * @return first name portion of the credentials
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * simple setter for first name portion of the credentials
     * @param firstname password portion of the credentials
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * simple getter for last name portion of the credentials
     * @return last name portion of the credentials
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * simple setter for last name portion of the credentials
     * @param lastname password portion of the credentials
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * simple getter for course code portion of the credentials
     * @return course code portion of the credentials
     */
    public String getCoursecode() {
        return coursecode;
    }
    /**
     * simple setter for course code portion of the credentials
     * @param coursecode password portion of the credentials
     */
    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }
    
    
    
}//class
