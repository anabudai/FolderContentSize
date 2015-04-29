import java.util.List;

public interface FileSizeCalculator {
	
	public List<FileWithSize> calculate(String path);
}
