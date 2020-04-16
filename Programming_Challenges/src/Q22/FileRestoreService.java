package Q22;

import java.util.HashSet;
import java.util.Set;

public class FileRestoreService {
	
	private Set<String> failedSet;
	int fileLen;
	int fileN;
	
	public FileRestoreService() {
		this.failedSet = new HashSet<>();
	}

	public String getOriginal(String[] fragments) {
		failedSet.clear();
		this.fileLen = fileLength(fragments);
		this.fileN = fragments.length/2;
		
		for(int i=0; i<fragments.length; i++) {
			String f1 = fragments[i];
			
			for(int j=i+1; j<fragments.length; j++) {
				String f2 = fragments[j];
				
				if(f1.length()+f2.length() == fileLen) {
					if(isRightPattern(fragments, f1+f2, i, j))
						return (f1+f2);
					else if(isRightPattern(fragments, f2+f1, i, j))
						return (f2+f1);
					else {
						failedSet.add(f1+f2);
						failedSet.add(f2+f1);
					}
				}
			}
		}
		return "No Solution.";
	}
	
	private boolean isRightPattern(String[] fragments, String pattern, int i, int j) {
		if(failedSet.contains(pattern))
			return false;
		
		Set<Integer> usingIndex = new HashSet<>();
		usingIndex.add(i);
		usingIndex.add(j);
		
		int count = 1;
		
		for(int k=0; k<fragments.length; k++) {
			if(usingIndex.contains(k))	
				continue;
			String f1 = fragments[k];
			
			for(int l=k+1; l<fragments.length; l++) {
				String f2 = fragments[l];
				
				if(usingIndex.contains(l) ||
				   (f1.length()+f2.length()!=this.fileLen))
					continue;
				
				if((f1+f2).equals(pattern) || (f2+f1).equals(pattern)) {
					usingIndex.add(k);
					usingIndex.add(l);
					count++;
					break;
				}
			}
		}
		
		return (count==fileN);
	}

	private int fileLength(String[] fragments) {
		int max_file_len = fragments[0].length();
		int min_file_len = fragments[0].length();
		
		for(int i=1; i<fragments.length; i++) {
			int currentLen = fragments[i].length();
			
			if(max_file_len < currentLen)
				max_file_len = currentLen;
			
			if(min_file_len > currentLen)
				min_file_len = currentLen;
		}
		
		return (max_file_len + min_file_len);
	}

}
