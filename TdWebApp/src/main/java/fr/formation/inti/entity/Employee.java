package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer empid;
	private Date enddate;
	private String firstname;
	private String lastname;
	private LocalDateTime startdate;
	private String title;
	private Integer assignedbranchid;
	private Integer deptid;
	private Integer superiorempid;
	
	
	
	
	public Employee(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	public Employee() {
		super();
	}


	public Employee(String firstname2, String lastname2, String title2, int superiorempid2, int assignedbranchid2,
			int deptid2) {
		this.assignedbranchid=assignedbranchid2;
		this.deptid=deptid2;
		this.firstname=firstname2;
		this.lastname=lastname2;
		this.title=title2;
		this.superiorempid=superiorempid2;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println(formatter.format(date));
		this.startdate =now;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMP_ID",	 nullable = false)
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	
	@Column(name = "END_DATE")
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "LAST_NAME", nullable = false)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name = "START_DATE")
	public LocalDateTime getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "ASSIGNED_BRANCH_ID")
	public Integer getAssignedbranchid() {
		return assignedbranchid;
	}
	public void setAssignedbranchid(Integer assignedbranchid) {
		this.assignedbranchid = assignedbranchid;
	}
	
	@Column(name = "DEPT_ID")
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	
	@Column(name = "SUPERIOR_EMP_ID")
	public Integer getSuperiorempid() {
		return superiorempid;
	}
	public void setSuperiorempid(Integer superiorempid) {
		this.superiorempid = superiorempid;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
	


}
