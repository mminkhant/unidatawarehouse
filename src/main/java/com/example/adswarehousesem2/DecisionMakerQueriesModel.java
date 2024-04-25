package com.example.adswarehousesem2;

/**
 * This class models the data required for decision making queries related to student performance and course statistics.
 * It encapsulates various attributes related to students, courses, and academic performance metrics.
 */

    public class DecisionMakerQueriesModel {

        private long totalStudent;

        private long totalPassStudent;

        private long totalFailStudent;

        private long enrolledStudent;

        private long timeID;

        private String studentName;

        private String courseName;

        private long academicYear;

        private long passPercentage;

        private long failRatePercentage;

        private long studentCount;

        private long moduleCount;

        private String DOB;

        private String CITY;

        private String ageStatus;

        private long averagePassRate;

        private long averageFailRate;

        private long overallPassRate;

        private long overallFailRate;

        private long passStudents;

        private long failStudents;

        private long failRate;

        public long getTotalStudent() {
            return totalStudent;
        }

        public void setTotalStudent(long totalStudent) {
            this.totalStudent = totalStudent;
        }

        public long getTotalPassStudent() {
            return totalPassStudent;
        }

        public void setTotalPassStudent(long totalPassStudent) {
            this.totalPassStudent = totalPassStudent;
        }

        public long getTotalFailStudent() {
            return totalFailStudent;
        }

        public void setTotalFailStudent(long totalFailStudent) {
            this.totalFailStudent = totalFailStudent;
        }

        public long getEnrolledStudent() {
            return enrolledStudent;
        }

        public void setEnrolledStudent(long enrolledStudent) {
            this.enrolledStudent = enrolledStudent;
        }

        public long getTimeID() {
            return timeID;
        }

        public void setTimeID(long timeID) {
            this.timeID = timeID;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public long getAcademicYear() {
            return academicYear;
        }

        public void setAcademicYear(long academicYear) {
            this.academicYear = academicYear;
        }

        public long getPassPercentage() {
            return passPercentage;
        }

        public void setPassPercentage(long passPercentage) {
            this.passPercentage = passPercentage;
        }

        public long getFailRatePercentage() {
            return failRatePercentage;
        }

        public void setFailRatePercentage(long failRatePercentage) {
            this.failRatePercentage = failRatePercentage;
        }

        public long getStudentCount() {
            return studentCount;
        }

        public void setStudentCount(long studentCount) {
            this.studentCount = studentCount;
        }

        public long getModuleCount() {
            return moduleCount;
        }

        public void setModuleCount(long moduleCount) {
            this.moduleCount = moduleCount;
        }

        public String getDOB() {
            return DOB;
        }

        public void setDOB(String DOB) {
            this.DOB = DOB;
        }

        public String getCITY() {
            return CITY;
        }

        public void setCITY(String CITY) {
            this.CITY = CITY;
        }

        public String getAgeStatus() {
            return ageStatus;
        }

        public void setAgeStatus(String ageStatus) {
            this.ageStatus = ageStatus;
        }

        public long getAveragePassRate() {
            return averagePassRate;
        }

        public void setAveragePassRate(long averagePassRate) {
            this.averagePassRate = averagePassRate;
        }

        public long getAverageFailRate() {
            return averageFailRate;
        }

        public void setAverageFailRate(long averageFailRate) {
            this.averageFailRate = averageFailRate;
        }

        public long getOverallPassRate() {
            return overallPassRate;
        }

        public void setOverallPassRate(long overallPassRate) {
            this.overallPassRate = overallPassRate;
        }

        public long getOverallFailRate() {
            return overallFailRate;
        }

        public void setOverallFailRate(long overallFailRate) {
            this.overallFailRate = overallFailRate;
        }

        public long getPassStudents() {
            return passStudents;
        }

        public void setPassStudents(long passStudents) {
            this.passStudents = passStudents;
        }

        public long getFailStudents() {
            return failStudents;
        }

        public void setFailStudents(long failStudents) {
            this.failStudents = failStudents;
        }

        public long getFailRate() {
            return failRate;
        }

        public void setFailRate(long failRate) {
            this.failRate = failRate;
        }
    }

