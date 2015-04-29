public class FileSizeFormatterImpl implements FileSizeFormatter {

	public String format(FileWithSize file) {
		StringBuilder fileDescription = new StringBuilder();
		fileDescription.append(FileType.getDescriptionByFileType(file
				.isDirectory()));
		fileDescription.append(GeneralConstants.STR_SPACE);
		fileDescription.append(file.getAbsolutePath());
		fileDescription.append(GeneralConstants.STR_SPACE);
		fileDescription.append(file.getSize());
		fileDescription.append(GeneralConstants.STR_SPACE);
		fileDescription.append(file.getUnitDescription());
		return fileDescription.toString();
	}
}
