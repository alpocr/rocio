package net.ulatina.rocio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profile_has_app database table.
 * 
 */
@Entity
@Table(name="profile_has_app")
public class ProfileHasApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfileHasAppPK id;

	private byte enable;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	private Profile profile;

	//bi-directional many-to-one association to App
	@ManyToOne
	private App app;

	public ProfileHasApp() {
	}

	public ProfileHasAppPK getId() {
		return this.id;
	}

	public void setId(ProfileHasAppPK id) {
		this.id = id;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public App getApp() {
		return this.app;
	}

	public void setApp(App app) {
		this.app = app;
	}

}