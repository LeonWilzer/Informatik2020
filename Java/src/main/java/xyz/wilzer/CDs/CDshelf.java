
public class CDshelf {
    private CD[] cds;

    public static void main(String[] args){
        new CDshelf();
    }
    public CDshelf(){
        cds = new CD[50];
    }

    public void insertCD(String pTitle, String pArtist, int pYear){
        int num = 0;
        while(cds[num] != null && num<cds.length)
            num++;
        if (num>=cds.length)
            return;
        cds[num] = new CD(pTitle, pArtist, pYear);
    }

    public CD[] searchTitle(String pTitle){
        int sum = 0;
        int count = 0;
        CD[] results;
        for(int i = 0; i<cds.length; i++){
            if (cds[i] != null && cds[i].GetTitle() == pTitle)
                sum++;
        }
        results = new CD[sum];
        for(int i = 0; i<cds.length; i++){
            if (cds[i] != null && cds[i].GetTitle() == pTitle){
                results[count] = cds[i];
                count++;
            }
        }
        return results;
    }

    public CD[] searchArtist(String pArtist){
        int sum = 0;
        int count = 0;
        CD[] results;
        for(int i = 0; i<cds.length; i++){
            if (cds[i] != null && cds[i].GetArtist() == pArtist)
                sum++;
        }
        results = new CD[sum];
        for(int i = 0; i<cds.length; i++){
            if (cds[i] != null && cds[i].GetArtist() == pArtist){
                results[count] = cds[i];
                count++;
            }
        }
        return results;
    }

    public CD[] searchYear(int pYear){
        int sum = 0;
        int count = 0;
        CD[] results;
        for(int i = 0; i<cds.length; i++){
            if (cds[i] != null && cds[i].GetYear() == pYear)
                sum++;
        }
        results = new CD[sum];
        for(int i = 0; i<cds.length; i++){
            if (cds[i] != null && cds[i].GetYear() == pYear){
                results[count] = cds[i];
                count++;
            }
        }
        return results;
    }

    public void removeCD(int pID){
        cds[pID] = null;
    }

    public CD[] GetAllCDs(){
        return cds;
    }
}
