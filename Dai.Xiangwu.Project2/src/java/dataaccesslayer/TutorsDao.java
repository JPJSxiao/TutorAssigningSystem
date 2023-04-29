/* File: TutorsDao.java
 * Author: Xiangwu Dai
 * Date: 2023/3/25
 * Description: Assignment2
 */
package dataaccesslayer;

import java.util.List;
import transferobjects.CredentialsDTO;

import transferobjects.TutorDTO;

/**
 * a tutor interface
 * @author steph
 */
public interface TutorsDao {


    /**
     *
     * @return
     */
        
 	List<TutorDTO> getAllTutors();
        
    /**
     *
     * @param creds
     * @return
     */
    TutorDTO getTutorByName (CredentialsDTO creds);        

    /**
     *
     * @param creds
     * @return
     */
    boolean checkTutorExist (CredentialsDTO creds);
    
    /**
     *
     * @param creds
     * @return
     */
    boolean checkCourseGradeExist(CredentialsDTO creds);

    /**
     *
     * @param creds
     * @return
     */
    String getGradeCode(CredentialsDTO creds);

    /**
     *
     * @param creds
     */
    void assignTutor(CredentialsDTO creds);
}
