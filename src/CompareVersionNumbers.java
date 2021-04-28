public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        String[] splittedVersion1 = version1.split("\\.");
        String[] splittedVersion2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        int revision1;
        int revision2;
        while (index1 < splittedVersion1.length || index2 < splittedVersion2.length) {
            revision1 = getNextRevision(splittedVersion1, index1);
            revision2 = getNextRevision(splittedVersion2, index2);
            if (revision1 < revision2) {
                return -1;
            } else if (revision1 > revision2) {
                return 1;
            }
            index1++;
            index2++;
        }
        return 0;
    }
    
    private int getNextRevision(String[] splittedVersion, int index) {
        if (index >= splittedVersion.length) return 0;
        
        String strPattern = "^0+";
        String cleanedSplittedVersion = splittedVersion[index].replaceAll(strPattern, "");
        if (cleanedSplittedVersion.isEmpty()) return 0;
        return Integer.parseInt(cleanedSplittedVersion); 
    }
}
