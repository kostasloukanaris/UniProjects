public class Breadboard {
    int columns;
    int rows;
    boolean[][] bbholes;
    public Breadboard( int columns, int rows){
        this.columns=columns;
        this.rows=rows;
        bbholes= new  boolean[rows][columns];

    }
}
