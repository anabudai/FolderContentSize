public class FileWithSizeFromByteToKBTransformerImpl implements
		FileWithSizeTransformer {

	private static final long KB = 1024;

	public FileWithSize transform(FileWithSize file) {
		FileWithSize fileWithSizeInKB = new FileWithSize();
		fileWithSizeInKB.setFile(file.getFile());
		fileWithSizeInKB.setUnit(FileSizeUnitType.KILOBYTE);
		fileWithSizeInKB.setSize(getSizeInKB(file.getSize()));
		return fileWithSizeInKB;
	}

	private long getSizeInKB(long sizeInBytes) {
		return sizeInBytes / KB;
	}

}
