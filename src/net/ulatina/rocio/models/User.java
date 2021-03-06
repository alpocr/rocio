package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte agreement;

	private byte enable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login")
	private Date lastLogin;

	private String lastname;

	private String name;

	private String nid;

	private String password;

	private String username;

	//bi-directional many-to-one association to UserHasProfile
	@OneToMany(mappedBy="user")
	private Set<UserHasProfile> userHasProfiles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAgreement() {
		return this.agreement;
	}

	public void setAgreement(byte agreement) {
		this.agreement = agreement;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNid() {
		return this.nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<UserHasProfile> getUserHasProfiles() {
		return this.userHasProfiles;
	}

	public void setUserHasProfiles(Set<UserHasProfile> userHasProfiles) {
		this.userHasProfiles = userHasProfiles;
	}

	public UserHasProfile addUserHasProfile(UserHasProfile userHasProfile) {
		getUserHasProfiles().add(userHasProfile);
		userHasProfile.setUser(this);

		return userHasProfile;
	}

	public UserHasProfile removeUserHasProfile(UserHasProfile userHasProfile) {
		getUserHasProfiles().remove(userHasProfile);
		userHasProfile.setUser(null);

		return userHasProfile;
	}

}