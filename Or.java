public class Or extends Gate {
        public Or(boolean in1, boolean in2){
            super(in1,in2);
        }
        public Or(){this(false,false);}
        public boolean calculateOutput(){
           return out=in[0]||in[1];
        }
    }

