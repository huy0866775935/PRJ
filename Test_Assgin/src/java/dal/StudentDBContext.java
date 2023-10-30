/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Student;

/**
 *
 * @author sonnt
 */
public class StudentDBContext extends DBContext<Student> {

    @Override
    public void insert(Student model) {
        try {
            connection.setAutoCommit(false);
            String sql_insert = "INSERT INTO [Student]\n"
                    + "           ([sname]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender]\n"
                    + "           ,[did])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setString(1, model.getName());
            stm_insert.setDate(2, model.getDob());
            stm_insert.setBoolean(3, model.isGender());
            stm_insert.setInt(4, model.getDept().getId());
            stm_insert.executeUpdate();

            String sql_getid = "SELECT @@IDENTITY as [sid]";
            PreparedStatement stm_getid = connection.prepareStatement(sql_getid);
            ResultSet rs = stm_getid.executeQuery();
            if (rs.next()) {
                model.setId(rs.getInt("sid"));
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void update(Student model) {
        try {
            String sql_insert = "UPDATE [Student]\n"
                    + "   SET [sname] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[did] = ?\n"
                    + " WHERE [sid] = ?";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setString(1, model.getName());
            stm_insert.setDate(2, model.getDob());
            stm_insert.setBoolean(3, model.isGender());
            stm_insert.setInt(4, model.getDept().getId());
            stm_insert.setInt(5, model.getId());
            stm_insert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Student model) {
        try {
            String sql_insert = "DELETE Student\n"
                    + " WHERE [sid] = ?";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, model.getId());
            stm_insert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student get(Student model) {
        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.dob,d.did,d.dname\n"
                    + "FROM Student s INNER JOIN Department d ON s.did = d.did WHERE s.sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getId());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                s.setDept(d);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.dob,d.did,d.dname\n"
                    + "FROM Student s INNER JOIN Department d ON s.did = d.did";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                s.setDept(d);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return students;

    }
    
    
    public ArrayList<Student> searchByDeptId(int did) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.dob,d.did,d.dname\n"
                    + "FROM Student s INNER JOIN Department d ON s.did = d.did ";
            
            if(did > 0)
                sql+= " WHERE s.did = ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            
             if(did > 0)
                 stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                s.setDept(d);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return students;

    }
}
