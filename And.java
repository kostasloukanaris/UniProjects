public class And extends Gate{
    public And(boolean in1, boolean in2){
        super(in1,in2);
    }
    public And(){this(false,false);}
    public boolean calculateOutput(){
       return out=in[0]&&in[1];
    }
}
