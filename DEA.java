public class DEA {
    private State state;

    public DEA(State i) {
        state = i;
    }

    private void consume(char c) {
        if("abcd".indexOf(c) < 0){
            System.out.println("dummer bloat nutz Alphabet");
            System.exit(1);
        }
        if(c=='d'){
             state = State.ERROR;
             return;
        }
        switch (state) {
            case MISSING_AB:
                if (c == 'a') state = State.MISSING_B;
                break;
            case MISSING_B:
                if (c == 'b') state = State.FINAL;
                if (c == 'c') state = State.MISSING_AB;
                break;
            case FINAL:
                if (c == 'a') state = State.MISSING_B;
                if (c == 'b' || c=='c') state = State.MISSING_AB;
                break;
            case ERROR:
                break;
        }
    }
    public boolean test(String s) {
        for (int i = 0; i < s.length(); i++) consume(s.charAt(i));
        return state.equals(State.FINAL);
    }
}
