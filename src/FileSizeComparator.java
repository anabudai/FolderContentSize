import java.util.Comparator;

public class FileSizeComparator implements Comparator<FileWithSize> {

	public int compare(FileWithSize firstFileWithSize,
			FileWithSize secondFileWithSize) {
		return firstFileWithSize.getSize().compareTo(
				secondFileWithSize.getSize());
	}
}
