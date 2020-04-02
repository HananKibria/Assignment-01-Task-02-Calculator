package pk.edu.pucit.calculator;
import java.io.*;
import java.util.*;

public class Expression {
    private String exp;
    private String value1;
    private String value2;
    public boolean validationCheck()
    {
        if(exp.charAt(0)=='!' || exp.charAt(0)=='*' || exp.charAt(0)=='/')
        {
            return false;
        }
        for (int i=0;i<exp.length();i++) {
            char y = exp.charAt(i);
            if( y=='/'|| y=='*' || y=='-' || y=='+')
            {
                if(i==exp.length()-1)
                {
                    return false;
                }
                char z=exp.charAt(i+1);
                if(z=='/'|| z=='*' ||z=='-' || z=='+')
                {
                    return false;
                }
            }
            if(y=='%')
            {
                if(i==exp.length()-1)
                {
                    return true;
                }
                char z=exp.charAt(i+1);
                if(z=='/'|| z=='*' ||z=='-' || z=='+')
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        boolean check=false;
        for (int i=0;i<exp.length();i++) {
            char y = exp.charAt(i);
            if(y=='.')
            {
                check=true;
                if(i==exp.length()-1)
                {
                    return true;
                }
                i=i+1;
                y=exp.charAt(i);
            }
            if(y=='%' || y=='/' || y=='*' || y=='-' || y=='+')
            {
                check=false;
            }
            if(y=='.' && check)
            {
                return false;
            }
        }
       return true;
    }
    public void setExpression(String str)
    {
        exp=str;
    }
    public String evaluate()
    {
        Boolean check2 = validationCheck();
        if(check2==false) {
                return "Syntax Error";
        }

        int l=0;
        String newExp;
        int start=0;
        value1="";
        value2="";
        Boolean check =true;
        for (int i=0;i<exp.length();i++)
        {
            char y=exp.charAt(i);
            l=exp.length();
            String ho=value1;
            if(y=='+' || y=='-')
            {
                value1="";
                start=i+1;
            }
            else {
                if (y == '%' || y == '/' || y == '*' && value1!="") {
                    int f = value1.length();
                    if (value1.length() == 0) {
                        start = i + 1;
                    }
                }
                if (y == '%' && value1!="") {
                    double v1 = Double.parseDouble(value1);
                    double v3 = v1 / 100.0;
                    String str = Double.toString(v3);
                    newExp = exp.substring(0, start) + str + exp.substring(i + 1, l);
                    exp = newExp;
                    i=-1;
                    value1="";
                    start=0;
                    y='a';
                }
                else {
                    if (y == '/' || y == '*' && value1!="") {
                        int j = i;
                        j++;
                        i++;


                        while (j < l && exp.charAt(j) != '/' && exp.charAt(j) != '*' && exp.charAt(j) != '+' && exp.charAt(j) != '-' && exp.charAt(j) != '%') {
                            char z = exp.charAt(j);
                            value2 = value2 + z;
                            j++;
                            i++;
                        }
                        Double v1 = Double.parseDouble(value1);
                        Double v2 = Double.parseDouble(value2);

                        Double v3 = 0.0;
                        if (y == '/') {
                            if(v2==0)
                            {
                                return "Math Error";
                            }
                            Double a = v1 / v2;
                            v3 = Math.round(a * 10000000.0) / 10000000.0;
                        } else if (y == '*') {
                            Double a = v1 * v2;
                            v3 = Math.round(a * 10000000.0) / 10000000.0;

                        }
                        String str = Double.toString(v3);
                        if (i != l - 1) {
                            newExp = exp.substring(0, start) + str + exp.substring(i, l);
                            i = start;

                        } else {
                            newExp = exp.substring(0, start) + str;
                        }
                        exp = newExp;
                        y = exp.charAt(i);
                        value1 = "";
                        value2 = "";
                    }
                    value1 = value1 + y;
                }
            }
        }
        value2="";
        value1="";
        for (int i=0;i<l;i++) {

            char y=exp.charAt(i);
            l=exp.length();
            if( (y=='+'  || y=='-' ) && value1!="" )
            {
                start=0;
                if(value1.length()==0) {
                    start = i + 1;
                }
            }
            if((y=='+' || y=='-') && value1!="" )
            {
                int j=i;
                j++;
                i++;
                while(j<l  && (exp.charAt(j) != '/' && exp.charAt(j) != '*' && exp.charAt(j) != '+' && exp.charAt(j) != '-' && exp.charAt(j) != '%'))
                {
                    char z=exp.charAt(j);
                    value2=value2 +z;
                    j++;
                    i++;
                }
                Double v1=Double.parseDouble(value1);
                Double v2=Double.parseDouble(value2);

                Double v3=0.0;
                if(y=='+')
                {
                    Double a= v1+v2;
                    v3 = Math.round(a * 10000000.0) / 10000000.0;
                }
                else if(y=='-')
                {
                    Double a = v1 - v2;
                    v3 = Math.round(a * 10000000.0) / 10000000.0;

                }
                String str=Double.toString(v3);
                if(i!=l-1) {
                    newExp = exp.substring(0, start) + str + exp.substring(i, l);

                }
                else
                {
                    newExp = exp.substring(0, start) + str;
                }
                i=-1;
                exp=newExp;
                value1="";
                value2="";
            }
            if(y!='+' && y!='-')
            value1=value1 +y;
        }
        return exp;
    }
};
