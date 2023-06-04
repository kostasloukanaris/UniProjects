public class Nor extends Gate{
        public Nor(boolean in1, boolean in2){
            super(in1,in2);
        }
        public Nor(){this(false,false);}
        public boolean calculateOutput(){
            return out= !(in[0]||in[1]);
        }
    }


