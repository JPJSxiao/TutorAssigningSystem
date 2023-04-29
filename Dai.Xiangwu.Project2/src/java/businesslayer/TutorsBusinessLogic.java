/* File: TutorsBusinessLogic.java
 * Author: Xiangwu Dai
 * Date: 2023/3/25
 * Description: Assignment2
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.TutorsDaoImpl;
import transferobjects.TutorDTO;
import transferobjects.CredentialsDTO;
import dataaccesslayer.TutorsDao;

/**
 * business tier class
 * @author Xiangwu Dai
 */

public class TutorsBusinessLogic {
//	private static final int FIRST_NAME_MAX_LENGTH = 30;
//	private static final int LAST_NAME_MAX_LENGTH = 30;
        
	private TutorsDao tutorsDao = null;
//	private CredentialsDTO creds;
        
    /**
     * constructor to initialize
     * @param creds
     */     
	public TutorsBusinessLogic(CredentialsDTO creds){
	tutorsDao = new TutorsDaoImpl(creds);
	}
        
     /**
     * get tutor by name
     * @param creds a CredentialsDTO object
     * @return TutorDTO object
     */   
        
        public TutorDTO getTutorByName(CredentialsDTO creds){
        return tutorsDao.getTutorByName(creds);
        }
        
    /**
     *check if the tutor exists
     * @param creds
     * @return true or false
     */
    public boolean checkTutorExist (CredentialsDTO creds){
        return tutorsDao.checkTutorExist(creds);
        }
    
    /**
     *check if the tutor has the grade for the course
     * @param creds
     * @return true or false
     */
    public boolean checkCourseGradeExist(CredentialsDTO creds){
        return tutorsDao.checkCourseGradeExist(creds);
    }
    
    /**
     *check the qualification
     * @param creds a credential
     * @return a Boolean
     */
    public boolean checkQualification (CredentialsDTO creds){
            
         boolean isQualified = false; 
         String grade = tutorsDao.getGradeCode(creds);
         if (grade.contains("A"))
              {
                 isQualified = true;
               
              }
         
         return isQualified;
        } 
        
    /**
     * assign a tutor
     * @param creds a credential
     */
    public void assignTutor(CredentialsDTO creds){
            tutorsDao.assignTutor(creds);
        }
	
    /**
     *get all tutors
     * @return a tutor list
     */
    public List<TutorDTO> getAllTutors(){
		return tutorsDao.getAllTutors();
	}
        
 
}
