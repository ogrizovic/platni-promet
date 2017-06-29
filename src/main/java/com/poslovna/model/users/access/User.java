package com.poslovna.model.users.access;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.poslovna.model.Banka;
import com.poslovna.model.users.Klijent;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(unique = true, nullable = false)
	@Size(min = 6, max = 30)
	@NotEmpty
	@Pattern(regexp = "[\\w]{6,30}")
	private String username;
	
	@Column(unique = true, nullable = false)
	@Email
	@NotEmpty
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, length=32)
	private byte[] salt;
	
	@NotNull
	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"))
	private Collection<Role> roles;
	
	@NotNull
	@ManyToOne
	private Banka bank;
	
	@OneToOne(mappedBy = "user")
	@JoinColumn(name="klijent_id")
	private Klijent klijent;
	
	/*@NotNull
	@OneToOne
	private Subjekat subject;*/
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
//		this.subject = subject;
	}
	
	

	public User(String username, String email, String password, byte[] salt, Collection<Role> roles, Banka bank) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.roles = roles;
		this.bank = bank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Banka getBank() {
		return bank;
	}

	public void setBank(Banka bank) {
		this.bank = bank;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	

/*	public Subjekat getSubject() {
		return subject;
	}

	public void setSubject(Subjekat subject) {
		this.subject = subject;
	}*/
	
	
}
