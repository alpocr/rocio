package net.ulatina.rocio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the function database table.
 * 
 */
@Entity
@Table(name="function")
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	private String path;

	//bi-directional many-to-one association to FunctionHasModule
	@OneToMany(mappedBy="function")
	private Set<FunctionHasModule> functionHasModules;

	public Function() {
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<FunctionHasModule> getFunctionHasModules() {
		return this.functionHasModules;
	}

	public void setFunctionHasModules(Set<FunctionHasModule> functionHasModules) {
		this.functionHasModules = functionHasModules;
	}

	public FunctionHasModule addFunctionHasModule(FunctionHasModule functionHasModule) {
		getFunctionHasModules().add(functionHasModule);
		functionHasModule.setFunction(this);

		return functionHasModule;
	}

	public FunctionHasModule removeFunctionHasModule(FunctionHasModule functionHasModule) {
		getFunctionHasModules().remove(functionHasModule);
		functionHasModule.setFunction(null);

		return functionHasModule;
	}

}