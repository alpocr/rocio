package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to App
	@OneToMany(mappedBy="function")
	private List<App> apps;

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

	public List<App> getApps() {
		return this.apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	public App addApp(App app) {
		getApps().add(app);
		app.setFunction(this);

		return app;
	}

	public App removeApp(App app) {
		getApps().remove(app);
		app.setFunction(null);

		return app;
	}

}