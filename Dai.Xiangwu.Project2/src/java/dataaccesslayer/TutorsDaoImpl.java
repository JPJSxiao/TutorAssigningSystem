/* File: TutorsDaoImpl.java
 * Author: Xiangwu Dai
 * Date: 2023/3/25
 * Description: Assignment2
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.TutorDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import transferobjects.CredentialsDTO;

/**
 * a DAO implemented class
 * @author steph
 */
public class TutorsDaoImpl implements TutorsDao{
    private CredentialsDTO creds;

    /**
     * a constructor
     * @param creds
     */
    public TutorsDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }
    
    /**
     * a method to get a s tutor by name
     * @param creds
     * @return
     */
    @Override
	public TutorDTO getTutorByName (CredentialsDTO creds) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		           TutorDTO tutor = null;
		try{
			DataSource ds = new DataSource(creds);
			con = ds.createConnection();
			pstmt = con.prepareStatement(
			"SELECT TutorID, FirstName, LastName FROM tutor WHERE LastName= ? AND FirstName = ?");                          
			pstmt.setString(1, creds.getLastname());
 			pstmt.setString(2, creds.getFirstname());                       
                        
			rs = pstmt.executeQuery();
 			tutor = new TutorDTO();                       
			while(rs.next()){
				tutor.setTutorID(rs.getInt("TutorID"));
				tutor.setFirstName(rs.getString("firstName"));
				tutor.setLastName(rs.getString("lastName"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return tutor;
	}
        
    /**
     * a method to check the existence
     * @param creds 
     * @return a Boolean
     */
    @Override
	public boolean checkTutorExist (CredentialsDTO creds) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
                boolean existOrNot = false;
		try{
			DataSource ds = new DataSource(creds);
			con = ds.createConnection();
			pstmt = con.prepareStatement(
			"SELECT * FROM tutorcourse WHERE tutor_TutorID = ? AND Course_CourseCode = ? ");

                           
 			pstmt.setString(2, creds.getCoursecode());
 			pstmt.setInt(1, creds.getTutorID());  
                        
			rs = pstmt.executeQuery();
                                         
			if(rs.next()){
				existOrNot = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return existOrNot;
	}

    /**
     * check if the tutor has grade for the course
     * @param creds
     * @return true or false
     */
    @Override
        public boolean checkCourseGradeExist(CredentialsDTO creds){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
                boolean isExist = false;
		try{
			DataSource ds = new DataSource(creds);
			con = ds.createConnection();
			pstmt = con.prepareStatement(
			"SELECT GradeCode FROM grade LEFT JOIN student ON grade.student_StudentID = student.StudentID WHERE LastName= ? AND FirstName = ? AND Course_CourseCode = ?");
			pstmt.setString(1, creds.getLastname());
 			pstmt.setString(2, creds.getFirstname()); 
 			pstmt.setString(3, creds.getCoursecode());                        
			rs = pstmt.executeQuery();
                        if(rs.next()){
                           isExist = true; 
                        }                      
                        

                        
                                         

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return isExist;
	}
        
        
    /**
     * a method to get the grade code
     * @param creds a credential
     * @return a Boolean
     */
    @Override
	public String getGradeCode(CredentialsDTO creds) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
                String gradeCode = null;
		try{
			DataSource ds = new DataSource(creds);
			con = ds.createConnection();
			pstmt = con.prepareStatement(
			"SELECT GradeCode FROM grade LEFT JOIN student ON grade.student_StudentID = student.StudentID WHERE LastName= ? AND FirstName = ? AND Course_CourseCode = ?");
			pstmt.setString(1, creds.getLastname());
 			pstmt.setString(2, creds.getFirstname()); 
 			pstmt.setString(3, creds.getCoursecode());                        
			rs = pstmt.executeQuery();
                        if(rs.next()){
                           gradeCode = rs.getString("GradeCode"); 
                        }                      
                        

                        
                                         

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return gradeCode;
	}

    /**
     * a method to sign tutor
     * @param creds a credential
     */
    @Override
	public void assignTutor(CredentialsDTO creds) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TutorDTO author = null;
		try{
			DataSource ds = new DataSource(creds);
			con = ds.createConnection();
			pstmt = con.prepareStatement(
			"INSERT INTO tutorcourse (tutor_TutorID, course_CourseCode) VALUES (?, ?)");
         		pstmt.setInt(1, creds.getTutorID());
 			pstmt.setString(2, creds.getCoursecode());   
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}

	}

    /**
     * method to get all tutors
     * @return a tutor list
     */
    @Override
	public List<TutorDTO> getAllTutors() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TutorDTO> tutors = null;
		try{
			DataSource ds = new DataSource(creds);
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT tutor_TutorID, LastName, FirstName FROM tutorcourse LEFT JOIN tutor \n" +
"ON tutorcourse.tutor_TutorID = tutor.TutorID WHERE tutorcourse.course_CourseCode = ? ");
                        pstmt.setString(1, creds.getCoursecode());
                        
			rs = pstmt.executeQuery();
			tutors = new ArrayList<TutorDTO>();
			while(rs.next()){
				TutorDTO tutor = new TutorDTO();
				tutor.setTutorID(rs.getInt("tutor_TutorID"));
				tutor.setFirstName(rs.getString("firstName"));
				tutor.setLastName(rs.getString("lastName"));
				tutors.add(tutor);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return tutors;
	}
}
