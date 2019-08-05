package pojos;

import java.util.Date;
import javax.persistence.*;

@Entity //mandatory
@Table(name="dac_customers")
public class Customer {
	
	private Integer id;
	private String name,email,password,role;
	private double regAmount;
	private Date regDate;
	private CustomerType custType;
	private byte[] photo;
	public Customer() {
		System.out.println("in cust constr");
	}
	public Customer(String name, String email, String password, String role, double regAmount, Date regDate,
			CustomerType custType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.custType = custType;
	}
	@Id //mandatory --property level
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=15,name="cust_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=15,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println("in set email");
		this.email = email;
	}
	@Column(length=15)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=15)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="reg_amt",columnDefinition="double(6,1)")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Enumerated(EnumType.STRING)
	public CustomerType getCustType() {
		return custType;
	}
	public void setCustType(CustomerType custType) {
		this.custType = custType;
	}
	@Lob
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", regAmount=" + regAmount + ", regDate=" + regDate + ", custType=" + custType + "]";
	}
	
	
	

}
