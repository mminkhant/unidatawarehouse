package com.example.adswarehousesem2;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.AuthenticationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "DecisionMakerQueriesEJB")
public class DecisionMakerQueriesBean {
    public DecisionMakerQueriesBean() {
    }

    @EJB
    OracleDatabaseBean oracleDatabaseBean;

    public void getLogin(String username, String password) throws AuthenticationException {
        Connection connection = oracleDatabaseBean.getOracleClient();
        String sql = "SELECT * FROM TBLUSER WHERE USER_NAME = ? AND USER_PASSWORD = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();
            if (!resultSet.next()) {
                throw new AuthenticationException("Username or Password incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AuthenticationException("Error");
        }
    }

    // Fetches data regarding Query1 //
    public List<DecisionMakerQueriesModel> fetchQuery1Data() {
        List<DecisionMakerQueriesModel> dataList = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT c.COURSE_NAME, t.ACADEMIC_YEAR, SUM(f.Total_Student) AS Enrolled_Students " +
                    "FROM university_Fact f " +
                    "JOIN course_Dim c ON f.COURSE_ID = c.COURSE_ID " +
                    "JOIN time_Dim t ON f.TIME_ID = t.TIME_ID " +
                    "GROUP BY c.COURSE_NAME, t.ACADEMIC_YEAR " +
                    "ORDER BY t.ACADEMIC_YEAR, c.COURSE_NAME";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setCourseName(rs.getString("COURSE_NAME"));
                model.setAcademicYear(rs.getLong("ACADEMIC_YEAR"));
                model.setEnrolledStudent(rs.getLong("Enrolled_Students"));
                dataList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query2//
    public List<DecisionMakerQueriesModel> fetchQuery2Data() {
        List<DecisionMakerQueriesModel> dataList2 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT c.COURSE_NAME, t.ACADEMIC_YEAR, \n" +
                    "       SUM(f.Total_Pass_Student) AS Passed_Students, \n" +
                    "       SUM(f.Total_Fail_Student) AS Failed_Students\n" +
                    "FROM university_Fact f\n" +
                    "JOIN course_Dim c ON f.COURSE_ID = c.COURSE_ID\n" +
                    "JOIN time_Dim t ON f.TIME_ID = t.TIME_ID\n" +
                    "GROUP BY c.COURSE_NAME, t.ACADEMIC_YEAR\n" +
                    "ORDER BY t.ACADEMIC_YEAR, c.COURSE_NAME ";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setCourseName(rs.getString("COURSE_NAME"));
                model.setAcademicYear(rs.getLong("ACADEMIC_YEAR"));
                model.setPassStudents(rs.getLong("Passed_Students"));
                model.setFailStudents(rs.getLong("Failed_Students"));
                dataList2.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList2;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query3 //
    public List<DecisionMakerQueriesModel> fetchQuery3Data() {
        List<DecisionMakerQueriesModel> dataList3 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT c.COURSE_NAME, t.ACADEMIC_YEAR, \n" +
                    "       (SUM(f.Total_Pass_Student) * 100 / NULLIF(SUM(f.Total_Student), 0)) AS Pass_Percentage\n" +
                    "FROM university_Fact f\n" +
                    "JOIN course_Dim c ON f.COURSE_ID = c.COURSE_ID\n" +
                    "JOIN time_Dim t ON f.TIME_ID = t.TIME_ID\n" +
                    "GROUP BY c.COURSE_NAME, t.ACADEMIC_YEAR\n" +
                    "ORDER BY t.ACADEMIC_YEAR, c.COURSE_NAME ";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setCourseName(rs.getString("COURSE_NAME"));
                model.setAcademicYear(rs.getLong("ACADEMIC_YEAR"));
                model.setPassPercentage(rs.getLong("Pass_Percentage"));
                dataList3.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList3;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query4 //
    public List<DecisionMakerQueriesModel> fetchQuery4Data() {
        List<DecisionMakerQueriesModel> dataList4 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT \n" +
                    "    t.ACADEMIC_YEAR, \n" +
                    "    c.COURSE_NAME,\n" +
                    "    (f.Total_Fail_Student * 100.0 / f.Total_Student) AS Fail_Rate_Percentage\n" +
                    "FROM \n" +
                    "    university_Fact f\n" +
                    "JOIN \n" +
                    "    time_Dim t ON f.TIME_ID = t.TIME_ID\n" +
                    "JOIN \n" +
                    "    course_Dim c ON f.COURSE_ID = c.COURSE_ID\n" +
                    "ORDER BY \n" +
                    "    t.ACADEMIC_YEAR, c.COURSE_NAME";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setAcademicYear(rs.getLong("ACADEMIC_YEAR"));
                model.setCourseName(rs.getString("COURSE_NAME"));
                model.setFailRatePercentage(rs.getLong("FAIL_RATE_PERCENTAGE"));

                dataList4.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList4;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query5 //
    public List<DecisionMakerQueriesModel> fetchQuery5Data() {
        List<DecisionMakerQueriesModel> dataList5 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT CITY, COUNT(*) AS Student_Count\n" +
                    "FROM student_Dim\n" +
                    "GROUP BY CITY\n" +
                    "ORDER BY Student_Count DESC\n" +
                    "FETCH FIRST 3 ROWS ONLY";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setCITY(rs.getString("CITY"));
                model.setStudentCount(rs.getLong("STUDENT_COUNT"));
                dataList5.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList5;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query6 //
    public List<DecisionMakerQueriesModel> fetchQuery6Data() {
        List<DecisionMakerQueriesModel> dataList6 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT \n" +
                    "    c.COURSE_NAME, \n" +
                    "    COUNT(m.MODULE_ID) AS Module_Count\n" +
                    "FROM \n" +
                    "    course_Dim c\n" +
                    "JOIN \n" +
                    "    module_Dim m ON c.COURSE_ID = m.COURSE_ID\n" +
                    "GROUP BY \n" +
                    "    c.COURSE_NAME\n" +
                    "ORDER BY \n" +
                    "    Module_Count DESC";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setCourseName(rs.getString("COURSE_NAME"));
                model.setModuleCount(rs.getLong("Module_Count"));
                dataList6.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList6;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query7 //
    public List<DecisionMakerQueriesModel> fetchQuery7Data() {
        List<DecisionMakerQueriesModel> dataList7 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT STUDENT_NAME, DOB, \n" +
                    "       CASE WHEN DOB = (SELECT MIN(DOB) FROM student_Dim) THEN 'Oldest'\n" +
                    "            WHEN DOB = (SELECT MAX(DOB) FROM student_Dim) THEN 'Youngest'\n" +
                    "       END AS Age_Status\n" +
                    "FROM student_Dim\n" +
                    "WHERE DOB IN (SELECT MIN(DOB) FROM student_Dim) \n" +
                    "      OR DOB IN (SELECT MAX(DOB) FROM student_Dim) ";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setStudentName(rs.getString("STUDENT_NAME"));
                model.setDOB(rs.getString("DOB"));
                model.setAgeStatus(rs.getString("AGE_STATUS"));
                dataList7.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList7;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query8 //
    public List<DecisionMakerQueriesModel> fetchQuery8Data() {
        List<DecisionMakerQueriesModel> dataList8 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT \n" +
                    "    c.COURSE_NAME,\n" +
                    "    AVG(f.Total_Pass_Student * 100.0 / f.Total_Student) AS Average_Pass_Rate,\n" +
                    "    AVG(f.Total_Fail_Student * 100.0 / f.Total_Student) AS Average_Fail_Rate\n" +
                    "FROM university_Fact f\n" +
                    "JOIN course_Dim c ON f.COURSE_ID = c.COURSE_ID\n" +
                    "GROUP BY c.COURSE_NAME\n" +
                    "ORDER BY Average_Pass_Rate DESC, Average_Fail_Rate ASC";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setCourseName(rs.getString("COURSE_NAME"));
                model.setAveragePassRate(rs.getLong("Average_Pass_Rate"));
                model.setAverageFailRate(rs.getLong("Average_Fail_Rate"));
                dataList8.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList8;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query9 //
    public List<DecisionMakerQueriesModel> fetchQuery9Data() {
        List<DecisionMakerQueriesModel> dataList9 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT \n" +
                    "    t.ACADEMIC_YEAR,\n" +
                    "    (SUM(f.Total_Pass_Student) * 100.0) / SUM(f.Total_Student) AS Overall_Pass_Rate\n" +
                    "FROM university_Fact f\n" +
                    "JOIN time_Dim t ON f.TIME_ID = t.TIME_ID\n" +
                    "GROUP BY t.ACADEMIC_YEAR\n" +
                    "ORDER BY Overall_Pass_Rate DESC\n" +
                    "FETCH FIRST ROW ONLY";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setAcademicYear(rs.getLong("ACADEMIC_YEAR"));
                model.setOverallPassRate(rs.getLong("Overall_Pass_Rate"));
                dataList9.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList9;  // return a list of data models containing the fetched data. //
    }

    // Fetches data regarding Query10 //
    public List<DecisionMakerQueriesModel> fetchQuery10Data() {
        List<DecisionMakerQueriesModel> dataList10 = new ArrayList<>();
        try {
            Connection connection = oracleDatabaseBean.getOracleClient();

            String sql = "SELECT \n" +
                    "    t.ACADEMIC_YEAR,\n" +
                    "    (SUM(f.Total_Fail_Student) * 100.0) / SUM(f.Total_Student) AS Overall_Fail_Rate\n" +
                    "FROM university_Fact f\n" +
                    "JOIN time_Dim t ON f.TIME_ID = t.TIME_ID\n" +
                    "GROUP BY t.ACADEMIC_YEAR\n" +
                    "ORDER BY Overall_Fail_Rate DESC\n" +
                    "FETCH FIRST ROW ONLY";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DecisionMakerQueriesModel model = new DecisionMakerQueriesModel();
                model.setAcademicYear(rs.getLong("ACADEMIC_YEAR"));
                model.setOverallFailRate(rs.getLong("Overall_Fail_Rate"));
                dataList10.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList10;  // return a list of data models containing the fetched data. //
    }
}
