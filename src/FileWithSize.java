import java.io.File;

public class FileWithSize {
	private File file;
	private Long size;
	private FileSizeUnitType unit;

	public FileWithSize() {
	}

	public FileWithSize(File file, Long size, FileSizeUnitType unit) {
		this.file = file;
		this.size = size;
		this.unit = unit;
	}

	public File getFile() {
		return file;
	}

	public Long getSize() {
		return size;
	}

	public FileSizeUnitType getUnit() {
		return unit;
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}

	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	public String getUnitDescription() {
		return unit.getDescription();
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setUnit(FileSizeUnitType unit) {
		this.unit = unit;
	}
}
