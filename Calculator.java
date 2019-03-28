public class Calculator{

    public static double function(double first,double second,String operator){
      String[]ary=new String[5];
      ary[0]="+";
      ary[1]="-";
      ary[2]="*";
      ary[3]="/";
      ary[4]="%";
      if(operator.equals(ary[0])){
        return second+first;
      }
      else if(operator.equals(ary[1])){
        return second-first;
      }
      else if(operator.equals(ary[2])){
        return second*first;
      }
      else if(operator.equals(ary[3])){
        return second/first;
      }
      else {
        return second%first;
      }
  }
  public static boolean isOperator(String a){
    String[]ary=new String[5];
    ary[0]="+";
    ary[1]="-";
    ary[2]="*";
    ary[3]="/";
    ary[4]="%";
    for(int j=0;j<ary.length;j++){
      if(a.equals(ary[j])){
        return true;
      }
    }
    return false;
  }
  public static double eval(String a){
    MyDeque<Double>list=new MyDeque<Double>();
    String memo="";
    for(int i=0;i<a.length();i++){
    //  System.out.println(a.substring(i,i+1));
            if(isOperator(a.substring(i,i+1))){
               //System.out.println(list);
               double store=function(list.removeLast(),list.removeLast(),a.substring(i,i+1));
               list.addLast(store);
               //System.out.println(list);
               memo="";
               i++;
          }
      else if(!a.substring(i,i+1).equals(" ")){
        memo+=a.substring(i,i+1);
        //System.out.println(memo);
      }
      else{
        //System.out.println(memo);
        list.addLast(Double.parseDouble(memo));
        memo="";
      }

  }
    return list.getLast();

  }
  public static void main(String[]args){
    System.out.println(eval(("1 2 3 4 5 + * - -") ));
  }

}
