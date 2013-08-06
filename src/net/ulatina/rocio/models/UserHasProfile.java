package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_has_profile database table.
 * 
 */
@Entity
@Table(name="user_has_profile")
public class UserHasProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserHasProfilePK id;

	private byte enable;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	private Profile profile;

	public UserHasProfile() {
	}

	public UserHasProfilePK getId() {
		return this.id;
	}

	public void setId(UserHasProfilePK id) {
		this.id = id;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}