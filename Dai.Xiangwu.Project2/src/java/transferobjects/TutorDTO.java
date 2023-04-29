/* File: TutorDTO.java
 * Author: Xiangwu Dai
 * Date: 2023/3/25
 * Description: Assignment2
 */
package transferobjects;

/**
 * a DTO class
 * @author steph
 */
public class TutorDTO {
    private Integer tutorID;
    private String firstName;
    private String lastName;
    
    /**
     * a method to get tutor ID
     * @return tutorID
     */
    public Integer getTutorID(){
    	return tutorID;
    }

    /**
     *a method to set ID
     * @param authorID
     */
    public void setTutorID(Integer authorID){
    	this.tutorID = authorID;
    }
    
    /**
     * a method to get first name
     * @return first name
     */
    public String getFirstName(){
    	return firstName;
    }

    /**
     * a method to set first name
     * @param firstName
     */
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    /**
     * a method to get last name
     * @return last name
     */
    public String getLastName(){
    	return lastName;
    }

    /**
     * a method set last name
     * @param lastName
     */
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    
}
