public class Textbook extends Book {
    int edition;
  
    public Textbook(String title, double price, int editionNo) {
        super(title, price);
        edition = editionNo;
    }

    public String getBookInfo() {
        return super.getBookInfo()+"-"+edition;
    }

    public int getEdition() { return edition; }

    public boolean canSubstituteFor(Textbook check) {
        String thisInfo = super.getBookInfo();
        String thisName = "";
        for (int i=0;i<thisInfo.length()-1;i++) {
            if (thisInfo.substring(i,i+1).equals("-")) thisName = thisInfo.substring(0,i);
        }
        String othInfo = check.getBookInfo();
        String othName = "";
        int othEdition = Integer.MAX_VALUE;
        for (int i=0;i<othInfo.length()-1;i++) {
            if (othInfo.substring(i,i+1).equals("-")) {
                othName = othInfo.substring(0,i);
                othInfo = othInfo.substring(i+1);
            }
        }
        for (int i=0;i<othInfo.length()-1;i++) {
            if (othInfo.substring(i,i+1).equals("-")) othEdition = Integer.parseInt(othInfo.substring(i+1));
        }
        return (thisName.equals(othName) && edition>=othEdition);
    }

    // There may be instance variables, constructors, and methods that are not shown.
}