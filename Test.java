public class Test{
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("bruder gib wort ein");
            System.exit(1);
        }
        DEA kausimausi = new DEA(State.MISSING_AB);
        boolean res = kausimausi.test(args[0]);
        System.out.println(res);
    }
}