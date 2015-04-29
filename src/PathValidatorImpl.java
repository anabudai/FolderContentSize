import java.io.File;

public class PathValidatorImpl implements PathValidator {
	private String args[];

	public PathValidatorImpl(String[] args) {
		this.args = args;
	}

	public boolean validate() {
		checkIfPathWasProvided(args);
		checkIfOnlyOnePathWasProvided(args);
		checkIfPathIsAFolder(args);
		checkIfPathIsAbsolute(args);
		return true;
	}

	private void checkIfPathWasProvided(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException(
					"You must provide the path of the folder");
		}
	}

	private void checkIfOnlyOnePathWasProvided(String[] args) {
		if (args.length > 1) {
			throw new IllegalArgumentException(
					"Only one folder path must be provided");
		}
	}

	private void checkIfPathIsAFolder(String[] args) {
		File file = new File(args[0]);
		if (!file.isDirectory()) {
			throw new IllegalArgumentException(
					"The path provided must be a folder");
		}
	}

	private void checkIfPathIsAbsolute(String[] args) {
		File file = new File(args[0]);
		if (!file.isAbsolute()) {
			throw new IllegalArgumentException(
					"The folder path must be absolute");
		}
	}
}
