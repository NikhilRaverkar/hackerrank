import java.io.*;
import java.util.*;

public class Solution {
    static boolean end=false;
    public static void main(String[] args) {
    List<String>a =new ArrayList<String>();
    List<String>b=new ArrayList<String>();
    List<String>res=new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int loop=sc.nextInt();
       // sc.next();
        for(int i=0;i<loop;i++) {
            String line1= sc.next();
            String line2=sc.next();
           a.add(line1);
            b.add(line2);
        }
    for(int j=0;j<loop;j++) {
        Stack<Character> stringa = new Stack();
        Stack<Character> stringb = new Stack();
        StringBuilder build1 = new StringBuilder(a.remove(0)).reverse();
        StringBuilder build2 = new StringBuilder(b.remove(0)).reverse();
        char[] work1 = build1.toString().toCharArray();
        char[] work2 = build2.toString().toCharArray();
        end=false;
        for (int i  = 0; i < work1.length; i++) {
            stringa.push(work1[i]);
        }
        for (int i = 0; i < work2.length; i++) {
            stringb.push(work2[i]);
        }
        StringBuilder result = new StringBuilder();
        boolean worked =false;
        boolean resu =false;

        int count=0;
        while (stringa.size() > 0 || stringb.size() > 0) {
            if (stringa.size() > 0 && stringb.size() > 0) {
              //  System.out.println(stringa.lastElement()+" "+stringb.lastElement());
                if (String.valueOf(stringa.lastElement()).compareTo(String.valueOf(stringb.lastElement())) < 0) {
                    char data = stringa.pop();
                    result.append(data);
                    worked=false;
                    end=false;
                }else if (String.valueOf(stringa.lastElement()).compareTo(String.valueOf(stringb.lastElement())) == 0){


                    if(!worked && !end) {
                       resu  = decide(stringa, stringb);
                       worked=true;
                      // count=0;
                    }
                    if(stringa.size()<=1){
                        resu=false;
                    }
                    if(stringb.size()<=1){
                        resu=true;
                    }
                    if(end) {
                       /* if(stringa.size()>=6 && stringb.size()>=6) {
                           // System.out.println(stringa.toArray()[3]);
                            if (stringa.toString().replace(" ","").substring((stringa.size()-7),(stringa.size()-1)).compareTo(stringb.toString().replace(" ","").substring((stringb.size()-7),(stringb.size()-1))) < 0) {
                                resu=true;
                            }else{
                                resu=false;
                            }
                        }*/
                    }
                    if(resu){
                        char data = stringa.pop();
                        result.append(data);//count++;
                    }else{
                        char data = stringb.pop();
                        result.append(data);
                        //count++;
                    }
                }
                else {
                    char data = stringb.pop();
                    result.append(data);
                    worked=false;
                    end=false;
                }
            } else {
                if (stringa.size() <= 0) {
                    char data = stringb.pop();
                    result.append(data);
                } else {
                    char data = stringa.pop();
                    result.append(data);
                }
            }
        }
        String finaldata = result.toString();
        //res.add(finaldata);
        System.out.println(finaldata);
    }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }

    private static boolean decide(Stack<Character> stringa, Stack<Character> stringb) {
        int min = Math.min(stringa.size(),stringb.size());
        //System.out.println(stringa.elementAt(stringa.size()-1) +"AT A");
        //System.out.println(stringb.elementAt(stringa.size()-1) +"AT B");
        //System.out.println(stringb.lastElement() +"AT B LAST");
        boolean retvalue=false;
        for(int i=1;i<=min;i++){
         //   System.out.println("LAST"+String.valueOf(stringa.elementAt(stringa.size()-i))+" " +(String.valueOf(stringb.elementAt(stringb.size()-i))));
            if((String.valueOf(stringa.elementAt(stringa.size()-i)).compareTo(String.valueOf(stringb.elementAt(stringb.size()-i))) < 0) ){
                retvalue= true;
                break;
            }else if((String.valueOf(stringa.elementAt(stringa.size()-i)).compareTo(String.valueOf(stringb.elementAt(stringb.size()-i))) > 0) ){
                retvalue= false;
                break;
            }
                if(i==min ){

                end=true;
                    if(stringa.size()==min){
                        retvalue =false;
                    }else{
                        retvalue=true;
                    }
                }

        }
        return retvalue;
    }

}