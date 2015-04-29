public enum FileType {
	DIRECTORY("DIR"), FILE("FILE");

	private FileType(String description) {
		this.description = description;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public static String getDescriptionByFileType(boolean isDirectory) {
		return isDirectory ? DIRECTORY.getDescription() : FILE.getDescription();
	}
}
