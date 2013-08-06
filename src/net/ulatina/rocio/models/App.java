package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the app database table.
 * 
 */
@Entity
@Table(name="app")
public class App implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	private String path;

	//bi-directional many-to-one association to ModuleHasApp
	@OneToMany(mappedBy="app")
	private Set<ModuleHasApp> moduleHasApps;

	//bi-directional many-to-one association to ProfileHasApp
	@OneToMany(mappedBy="app")
	private Set<ProfileHasApp> profileHasApps;

	public App() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<ModuleHasApp> getModuleHasApps() {
		return this.moduleHasApps;
	}

	public void setModuleHasApps(Set<ModuleHasApp> moduleHasApps) {
		this.moduleHasApps = moduleHasApps;
	}

	public ModuleHasApp addModuleHasApp(ModuleHasApp moduleHasApp) {
		getModuleHasApps().add(moduleHasApp);
		moduleHasApp.setApp(this);

		return moduleHasApp;
	}

	public ModuleHasApp removeModuleHasApp(ModuleHasApp moduleHasApp) {
		getModuleHasApps().remove(moduleHasApp);
		moduleHasApp.setApp(null);

		return moduleHasApp;
	}

	public Set<ProfileHasApp> getProfileHasApps() {
		return this.profileHasApps;
	}

	public void setProfileHasApps(Set<ProfileHasApp> profileHasApps) {
		this.profileHasApps = profileHasApps;
	}

	public ProfileHasApp addProfileHasApp(ProfileHasApp profileHasApp) {
		getProfileHasApps().add(profileHasApp);
		profileHasApp.setApp(this);

		return profileHasApp;
	}

	public ProfileHasApp removeProfileHasApp(ProfileHasApp profileHasApp) {
		getProfileHasApps().remove(profileHasApp);
		profileHasApp.setApp(null);

		return profileHasApp;
	}

}