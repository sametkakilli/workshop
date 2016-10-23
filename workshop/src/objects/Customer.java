package objects;

public class Customer {
	private int Id;
	private String name;
	private String surname;
	private String adress;
	private String telephone;
	private String mail;
	private String password;

	public Customer(int id, String name, String surname, String adress, String telephone, String mail, String password) {
		super();
		Id = id;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.telephone = telephone;
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer() {

	}

}
