package pk.edu.pucit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView equation;
    TextView removeALL;
    TextView divide;
    TextView multiply;
    TextView subtract;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView plus;
    TextView four;
    TextView five;
    TextView six;
    TextView percentage;
    TextView one;
    TextView two;
    TextView three;
    TextView delete;
    TextView doubleZero;
    TextView zero;
    TextView point;
    TextView equalTo;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation=findViewById(R.id.tv_equation);
        equation.setText("");
        result=findViewById(R.id.tv_result);
        result.setVisibility(View.GONE);
        removeALL=findViewById(R.id.remove_All);
        View.OnClickListener remove= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.setText("");
                result.setText("");
                result.setVisibility(View.GONE);
                equation.setTextSize(TypedValue.COMPLEX_UNIT_PT,
                        getResources().getDimension(R.dimen.textsize2));
                // Drawable shadow=(Drawable)getResources().getDrawable(R.drawable.shadow);
                //removeALL.setBackground(shadow);

            }
        };
        removeALL.setOnClickListener(remove);

        divide=findViewById(R.id.divide);
        View.OnClickListener div=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("/");
            }
        };
        divide.setOnClickListener(div);

        multiply=findViewById(R.id.multiply);
        View.OnClickListener mul=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("*");
            }
        };
        multiply.setOnClickListener(mul);

        subtract=findViewById(R.id.subtract);
        View.OnClickListener sub=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("-");
            }
        };
        subtract.setOnClickListener(sub);

        seven=findViewById(R.id.seven);
        View.OnClickListener sev=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("7");
            }
        };
        seven.setOnClickListener(sev);

        eight=findViewById(R.id.eight);
        View.OnClickListener eig=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("8");
            }
        };
        eight.setOnClickListener(eig);

        nine=findViewById(R.id.nine);
        View.OnClickListener nin=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("9");
            }
        };
        nine.setOnClickListener(nin);

        plus=findViewById(R.id.plus);
        View.OnClickListener pl=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("+");
            }
        };
        plus.setOnClickListener(pl);

        four=findViewById(R.id.four);
        View.OnClickListener fo=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("4");
            }
        };
        four.setOnClickListener(fo);

        five=findViewById(R.id.five);
        View.OnClickListener fiv=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("5");
            }
        };
        five.setOnClickListener(fiv);

        six=findViewById(R.id.six);
        View.OnClickListener si=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("6");
            }
        };
        six.setOnClickListener(si);

        percentage=findViewById(R.id.percentage);
        View.OnClickListener percent=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("%");
            }
        };
        percentage.setOnClickListener(percent);

        one=findViewById(R.id.one);
        View.OnClickListener on=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("1");
            }
        };
        one.setOnClickListener(on);

        two=findViewById(R.id.two);
        View.OnClickListener tw=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("2");
            }
        };
        two.setOnClickListener(tw);

        three=findViewById(R.id.three);
        View.OnClickListener thr=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("3");
            }
        };
        three.setOnClickListener(thr);

        delete=findViewById(R.id.delete);
        View.OnClickListener del=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence cS=equation.getText();
                String str=cS.toString();
                String result = null;
                if ((str.length() > 0)) {
                    result = str.substring(0, str.length() - 1);
                }
                equation.setText(result);
            }
        };
        delete.setOnClickListener(del);

        doubleZero=findViewById(R.id.double_zero);
        View.OnClickListener dZ=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("00");
            }
        };
        doubleZero.setOnClickListener(dZ);

        zero=findViewById(R.id.zero);
        View.OnClickListener ze=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append("0");
            }
        };
        zero.setOnClickListener(ze);

        point=findViewById(R.id.point);
        View.OnClickListener po=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.append(".");
            }
        };
        point.setOnClickListener(po);

        equalTo=findViewById(R.id.tv_calculate);
        View.OnClickListener eqT=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence cS=equation.getText();
                String str=cS.toString();
                 Expression e=new Expression();
                 e.setExpression(str);
                String ans=e.evaluate();

                result.setText(ans);
                result.setVisibility(View.VISIBLE);
                equation.setTextSize(TypedValue.COMPLEX_UNIT_PT,
                        getResources().getDimension(R.dimen.textsize));

            }
        };
        equalTo.setOnClickListener(eqT);
    }
}
