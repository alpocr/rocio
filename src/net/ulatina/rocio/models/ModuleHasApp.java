package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the module_has_app database table.
 * 
 */
@Entity
@Table(name="module_has_app")
public class ModuleHasApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ModuleHasAppPK id;

	private String enable;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	//bi-directional many-to-one association to App
	@ManyToOne
	private App app;

	public ModuleHasApp() {
	}

	public ModuleHasAppPK getId() {
		return this.id;
	}

	public void setId(ModuleHasAppPK id) {
		this.id = id;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public App getApp() {
		return this.app;
	}

	public void setApp(App app) {
		this.app = app;
	}

}