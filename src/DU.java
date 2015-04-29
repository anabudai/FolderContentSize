import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DU {

	public static void main(String[] args) {
		if (isValidPath(args)) {
			sortFilesBySizeAndShowSizes(args[0]);
		} else {
			throw new IllegalArgumentException(
					"Folder path provided is invalid;");
		}
	}

	private static boolean isValidPath(String[] args) {
		PathValidator pathValidator = new PathValidatorImpl(args);
		return pathValidator.validate();
	}

	private static void sortFilesBySizeAndShowSizes(String folderPath) {
		List<FileWithSize> filesInBytes = getFilesSortedInBytes(folderPath);
		List<FileWithSize> filesInKB = transformFilesFromBytesToKB(filesInBytes);
		showFiles(filesInKB);
	}

	private static List<FileWithSize> getFilesSortedInBytes(String folderPath) {
		List<FileWithSize> filesInBytes = getFilesInBytes(folderPath);
		Collections.sort(filesInBytes, new FileSizeComparator());
		return filesInBytes;
	}

	private static List<FileWithSize> transformFilesFromBytesToKB(
			List<FileWithSize> files) {
		List<FileWithSize> filesInKB = new ArrayList<FileWithSize>();
		FileWithSizeTransformer fileTransformer = new FileWithSizeFromByteToKBTransformerImpl();
		for (FileWithSize file : files) {
			FileWithSize fileInKB = fileTransformer.transform(file);
			filesInKB.add(fileInKB);
		}
		return filesInKB;
	}

	private static List<FileWithSize> getFilesInBytes(String path) {
		FileSizeCalculator fileSizeCalculator = new FileSizeCalculatorImpl();
		return fileSizeCalculator.calculate(path);
	}

	private static void showFiles(List<FileWithSize> files) {
		FileSizeFormatter fileSizeFormatter = new FileSizeFormatterImpl();
		for (FileWithSize file : files) {
			System.out.println(fileSizeFormatter.format(file));
		}
	}
}
