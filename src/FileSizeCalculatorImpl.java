import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSizeCalculatorImpl implements FileSizeCalculator {

	public List<FileWithSize> calculate(String path) {
		List<File> files = getFiles(path);
		List<FileWithSize> filesInBytes = new ArrayList<FileWithSize>();
		for (File file : files) {
			Long fileSize = calculate(file);
			filesInBytes.add(new FileWithSize(file, fileSize,
					FileSizeUnitType.BYTE));
		}
		return filesInBytes;
	}

	private List<File> getFiles(String path) {
		List<File> files = new ArrayList<File>();
		File file = new File(path);
		if (file.isDirectory()) {
			files.addAll(Arrays.asList(file.listFiles()));
		} else if (file.isFile()) {
			files.add(file);
		} else {
			throw new IllegalArgumentException("Path must be of a valid file");
		}
		return files;
	}

	private Long calculate(File file) {
		Long fileSize = 0l;
		if (file.isFile()) {
			fileSize = file.length();
		} else if (file.isDirectory()) {
			fileSize = calculateFolderSize(file);
		}
		return fileSize;
	}

	private Long calculateFolderSize(File folder) {
		Long folderSize = 0l;
		for (File file : folder.listFiles()) {
			if (file.isFile())
				folderSize += file.length();
			else
				folderSize += calculateFolderSize(file);
		}
		return folderSize;
	}
}
