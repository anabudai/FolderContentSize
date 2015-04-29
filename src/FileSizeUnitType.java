public enum FileSizeUnitType {

	BYTE("BYTE"), KILOBYTE("KB");

	private FileSizeUnitType(String description) {
		this.description = description;
	}

	private String description;

	public String getDescription() {
		return description;
	}
}
