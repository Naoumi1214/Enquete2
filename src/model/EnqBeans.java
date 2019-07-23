package model;

public class EnqBeans {
	String Name = "";
	String Coment = "";
	int Count = 0;//票数

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getComent() {
		return Coment;
	}

	public void setComent(String coment) {
		if (this.Coment.length() >= 1) {
			Coment += "," + coment;
		} else {
			Coment += coment;
		}
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count += count;
	}
}
