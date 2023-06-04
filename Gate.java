public abstract class Gate {
    protected boolean []in = new boolean[2];
    protected boolean out;

    public Gate(boolean in1, boolean in2){
        in[0]=in1;
        in[1]=in2;
    }
    public Gate(){this(false,false);}

    public boolean isOut() {
        return out;
    }
    public void setIn(int i, boolean b) {in[i]=b;}
    public abstract boolean calculateOutput();
}
