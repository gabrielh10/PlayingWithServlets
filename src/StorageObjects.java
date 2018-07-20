import java.io.InputStream;
import java.util.ArrayList;

//Guarda as entradas do usuário num singleton para serem acessados em outro servlet.

public class StorageObjects {
	private static StorageObjects instance;
	private InputStream image;
	private ArrayList<String> emails;
	private ArrayList<String> names;
	private ArrayList<String> countries;
	private ArrayList<String> institutes;
	private ArrayList<String> status;

	private StorageObjects() {}
	//singleton
	public static StorageObjects getInstance() {
		if(instance == null) {
			instance = new StorageObjects();
		}
		return instance;
	}
	
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	public ArrayList<String> getCountries() {
		return countries;
	}
	public void setCountries(ArrayList<String> countries) {
		this.countries = countries;
	}
	public ArrayList<String> getInstitutes() {
		return institutes;
	}
	public void setInstitutes(ArrayList<String> institutes) {
		this.institutes = institutes;
	}
	public ArrayList<String> getStatus() {
		return status;
	}
	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public ArrayList<String> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}
}
