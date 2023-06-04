public class Nand extends Gate{
    public Nand(boolean in1, boolean in2){
        super(in1,in2);
    }
    public Nand(){this(false,false);}
    public boolean calculateOutput(){
        return out=!(in[0]&&in[1]);
    }
}
