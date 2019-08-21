package data;

/* Snacks class: Represents a specific snack. */

public class Snacks {
	private String name;

	public Snacks() {
		this.name = "KitKat";
	}

	public Snacks(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !Snacks.class.isAssignableFrom(o.getClass())) {
			return false;
		}
		final Snacks s = (Snacks) o;
		return this.name == s.name;
	}
}
