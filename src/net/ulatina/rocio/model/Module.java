package net.ulatina.rocio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@Table(name="module")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to FunctionHasModule
	@OneToMany(mappedBy="module")
	private Set<FunctionHasModule> functionHasModules;

	//bi-directional many-to-one association to ModuleHasApp
	@OneToMany(mappedBy="module")
	private Set<ModuleHasApp> moduleHasApps;

	public Module() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FunctionHasModule> getFunctionHasModules() {
		return this.functionHasModules;
	}

	public void setFunctionHasModules(Set<FunctionHasModule> functionHasModules) {
		this.functionHasModules = functionHasModules;
	}

	public FunctionHasModule addFunctionHasModule(FunctionHasModule functionHasModule) {
		getFunctionHasModules().add(functionHasModule);
		functionHasModule.setModule(this);

		return functionHasModule;
	}

	public FunctionHasModule removeFunctionHasModule(FunctionHasModule functionHasModule) {
		getFunctionHasModules().remove(functionHasModule);
		functionHasModule.setModule(null);

		return functionHasModule;
	}

	public Set<ModuleHasApp> getModuleHasApps() {
		return this.moduleHasApps;
	}

	public void setModuleHasApps(Set<ModuleHasApp> moduleHasApps) {
		this.moduleHasApps = moduleHasApps;
	}

	public ModuleHasApp addModuleHasApp(ModuleHasApp moduleHasApp) {
		getModuleHasApps().add(moduleHasApp);
		moduleHasApp.setModule(this);

		return moduleHasApp;
	}

	public ModuleHasApp removeModuleHasApp(ModuleHasApp moduleHasApp) {
		getModuleHasApps().remove(moduleHasApp);
		moduleHasApp.setModule(null);

		return moduleHasApp;
	}

}