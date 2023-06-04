public class Xor extends Gate{
        public Xor(boolean in1, boolean in2){
             super(in1,in2);
         }
        public Xor(){
            this(false,false);
        }
        public boolean calculateOutput(){
            return out = (in[0] && !in[1]) ? (in[0] || in[1]) : false;
        }
   }


