package com.nodomain.abhijit.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDot, btnCx;
    Button btnClr, btnEql;
    TextView result, extra, extra2;
    int clickAdd=0, clickSub=0, clickMul=0, clickDiv=0, clickEql=0, clickDot=0;

    float first_num, second_num,res;
    String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.calculator);
        navigationView.setNavigationItemSelectedListener(this);

        btn0=(Button) findViewById(R.id.btn0);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
        btn6=(Button) findViewById(R.id.btn6);
        btn7=(Button) findViewById(R.id.btn7);
        btn8=(Button) findViewById(R.id.btn8);
        btn9=(Button) findViewById(R.id.btn9);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnSub=(Button) findViewById(R.id.btnSub);
        btnMul=(Button) findViewById(R.id.btnMul);
        btnDiv=(Button) findViewById(R.id.btnDiv);
        btnClr=(Button) findViewById(R.id.btnClr);
        btnEql=(Button) findViewById(R.id.btnEql);
        btnDot=(Button) findViewById(R.id.btnDot);
        result=(TextView) findViewById(R.id.result);
        extra=(TextView) findViewById(R.id.extra);
        extra2=(TextView) findViewById(R.id.extra2);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString()+"9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++clickDot;
                if(clickDot==1){
                    result.setText(result.getText().toString()+".");
                }
                else{
                    result.setText(result.getText().toString()+"");
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator==""&&result.getText()==""){
                    Toast.makeText(MainActivity.this,"Please Enter a Number",Toast.LENGTH_LONG).show();
                }
                else if(extra.getText()=="Total"){
                    clickAdd++;
                    first_num = Float.parseFloat(result.getText().toString());
                    if(first_num%1==0){
                        extra.setText(Integer.toString((int)first_num));
                    }
                    else{
                        extra.setText(Float.toString(first_num));
                    }
                    result.setText("");
                    extra2.setText("+");
                    operator = "+";
                    clickSub=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="+"&&result.getText()!=""){
                    clickAdd++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num+second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("+");
                    result.setText("");
                    operator="+";
                    clickSub=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="-"&&result.getText()!=""){
                    clickAdd++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num-second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("+");
                    result.setText("");
                    operator="+";
                    clickSub=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="*"&&result.getText()!=""){
                    clickAdd++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num*second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("+");
                    result.setText("");
                    operator="+";
                    clickSub=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="/"&&result.getText()!=""){
                    clickAdd++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num/second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("+");
                    result.setText("");
                    operator="+";
                    clickSub=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else{
                    clickAdd++;
                    clickDot=0;
                    if (clickAdd == 1) {
                        first_num = Float.parseFloat(result.getText().toString());
                        if(first_num%1==0){
                            extra.setText(Integer.toString((int)first_num));
                        }
                        else{
                            extra.setText(Float.toString(first_num));
                        }
                        result.setText("");
                        extra2.setText("+");
                        operator = "+";
                        clickSub=1;
                        clickDiv=1;
                        clickMul=1;
                    }
                    else if(clickSub==1&&clickAdd==2){
                        extra2.setText("+");
                        operator="+";
                        clickAdd=1;
                    }
                    else if(clickMul==1&&clickAdd==2){
                        extra2.setText("+");
                        operator="+";
                        clickAdd=1;
                    }
                    else if(clickDiv==1&&clickAdd==2){
                        extra2.setText("+");
                        operator="+";
                        clickAdd=1;
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please Enter a Number",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator==""&&result.getText()==""){
                    Toast.makeText(MainActivity.this,"Please Enter a Number",Toast.LENGTH_LONG).show();
                }
                else if(extra.getText()=="Total"){
                    clickSub++;
                    first_num = Float.parseFloat(result.getText().toString());
                    if(first_num%1==0){
                        extra.setText(Integer.toString((int)first_num));
                    }
                    else{
                        extra.setText(Float.toString(first_num));
                    }
                    result.setText("");
                    extra2.setText("-");
                    operator = "-";
                    clickAdd=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="-"&&result.getText()!=""){
                    clickSub++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num-second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("-");
                    result.setText("");
                    operator="-";
                    clickAdd=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="+"&&result.getText()!=""){
                    clickSub++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num+second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("-");
                    result.setText("");
                    operator="-";
                    clickAdd=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="*"&&result.getText()!=""){
                    clickSub++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num*second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("-");
                    result.setText("");
                    operator="-";
                    clickAdd=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="/"&&result.getText()!=""){
                    clickSub++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num/second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("-");
                    result.setText("");
                    operator="-";
                    clickAdd=1;
                    clickDiv=1;
                    clickMul=1;
                }
                else{
                    clickSub++;
                    clickDot=0;
                    if (clickSub == 1) {
                        first_num = Float.parseFloat(result.getText().toString());
                        if(first_num%1==0){
                            extra.setText(Integer.toString((int)first_num));
                        }
                        else{
                            extra.setText(Float.toString(first_num));
                        }
                        result.setText("");
                        extra2.setText("-");
                        operator = "-";
                        clickAdd=1;
                        clickDiv=1;
                        clickMul=1;
                    }
                    else if(clickAdd==1&&clickSub==2){
                        extra2.setText("-");
                        operator="-";
                        clickSub=1;
                    }
                    else if(clickMul==1&&clickSub==2){
                        extra2.setText("-");
                        operator="-";
                        clickSub=1;
                    }
                    else if(clickDiv==1&&clickSub==2){
                        extra2.setText("-");
                        operator="-";
                        clickSub=1;
                    }
                    else{
                    }
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator==""&&result.getText()==""){
                    Toast.makeText(MainActivity.this,"Please Enter a Number",Toast.LENGTH_LONG).show();
                }
                else if(extra.getText()=="Total"){
                    clickMul++;
                    first_num = Float.parseFloat(result.getText().toString());
                    if(first_num%1==0){
                        extra.setText(Integer.toString((int)first_num));
                    }
                    else{
                        extra.setText(Float.toString(first_num));
                    }
                    result.setText("");
                    extra2.setText("x");
                    operator = "*";
                    clickSub=1;
                    clickDiv=1;
                    clickAdd=1;
                }
                else if (extra.getText()!=""&&operator=="*"&&result.getText()!=""){
                    clickMul++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num*second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("x");
                    result.setText("");
                    operator="*";
                    clickSub=1;
                    clickDiv=1;
                    clickAdd=1;
                }
                else if (extra.getText()!=""&&operator=="+"&&result.getText()!=""){
                    clickMul++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num+second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("x");
                    result.setText("");
                    operator="*";
                    clickSub=1;
                    clickDiv=1;
                    clickAdd=1;
                }
                else if (extra.getText()!=""&&operator=="-"&&result.getText()!=""){
                    clickMul++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num-second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("x");
                    result.setText("");
                    operator="*";
                    clickSub=1;
                    clickDiv=1;
                    clickAdd=1;
                }
                else if (extra.getText()!=""&&operator=="/"&&result.getText()!=""){
                    clickMul++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num/second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("x");
                    result.setText("");
                    operator="*";
                    clickSub=1;
                    clickDiv=1;
                    clickAdd=1;
                }
                else{
                    clickMul++;
                    clickDot=0;
                    if (clickMul == 1) {
                        first_num = Float.parseFloat(result.getText().toString());
                        if(first_num%1==0){
                            extra.setText(Integer.toString((int)first_num));
                        }
                        else{
                            extra.setText(Float.toString(first_num));
                        }
                        result.setText("");
                        extra2.setText("x");
                        operator = "*";
                        clickSub=1;
                        clickDiv=1;
                        clickAdd=1;
                    }
                    else if(clickAdd==1&&clickMul==2){
                        extra2.setText("x");
                        operator="*";
                        clickMul=1;
                    }
                    else if(clickSub==1&&clickMul==2){
                        extra2.setText("x");
                        operator="*";
                        clickMul=1;
                    }
                    else if(clickDiv==1&&clickMul==2){
                        extra2.setText("x");
                        operator="*";
                        clickMul=1;
                    }
                    else{
                    }
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator==""&&result.getText()==""){
                    Toast.makeText(MainActivity.this,"Please Enter a Number",Toast.LENGTH_LONG).show();
                }
                else if(extra.getText()=="Total"){
                    clickDiv++;
                    first_num = Float.parseFloat(result.getText().toString());
                    if(first_num%1==0){
                        extra.setText(Integer.toString((int)first_num));
                    }
                    else{
                        extra.setText(Float.toString(first_num));
                    }
                    result.setText("");
                    extra2.setText("/");
                    operator = "/";
                    clickSub=1;
                    clickAdd=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="/"&&result.getText()!=""){
                    clickDiv++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num/second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("/");
                    result.setText("");
                    operator="/";
                    clickSub=1;
                    clickAdd=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="+"&&result.getText()!=""){
                    clickDiv++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num+second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("/");
                    result.setText("");
                    operator="/";
                    clickSub=1;
                    clickAdd=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="-"&&result.getText()!=""){
                    clickDiv++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num-second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("/");
                    result.setText("");
                    operator="/";
                    clickSub=1;
                    clickAdd=1;
                    clickMul=1;
                }
                else if (extra.getText()!=""&&operator=="*"&&result.getText()!=""){
                    clickDiv++;
                    second_num = Float.parseFloat(result.getText().toString());
                    res=first_num*second_num;
                    first_num=res;
                    if(res%1==0){
                        extra.setText(Integer.toString((int)res));
                    }
                    else{
                        result.setText(Float.toString(res));
                    }
                    extra2.setText("/");
                    result.setText("");
                    operator="/";
                    clickSub=1;
                    clickAdd=1;
                    clickMul=1;
                }
                else{
                    clickDiv++;
                    clickDot=0;
                    if (clickDiv == 1) {
                        first_num = Float.parseFloat(result.getText().toString());
                        if(first_num%1==0){
                            extra.setText(Integer.toString((int)first_num));
                        }
                        else{
                            extra.setText(Float.toString(first_num));
                        }
                        result.setText("");
                        extra2.setText("/");
                        operator = "/";
                        clickSub=1;
                        clickAdd=1;
                        clickMul=1;
                    }
                    else if(clickAdd==1&&clickDiv==2){
                        extra2.setText("/");
                        operator="/";
                        clickDiv=1;
                    }
                    else if(clickSub==1&&clickDiv==2){
                        extra2.setText("/");
                        operator="/";
                        clickDiv=1;
                    }
                    else if(clickMul==1&&clickDiv==2){
                        extra2.setText("/");
                        operator="/";
                        clickDiv=1;
                    }
                    else{
                    }
                }
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText()==""&&extra.getText()==""){
                    Toast.makeText(MainActivity.this,"Everything is already cleared!",Toast.LENGTH_LONG).show();
                }
                else{
                    result.setText("");
                    extra.setText("");
                    extra2.setText("");
                    operator="";
                    clickAdd=0;
                    clickSub=0;
                    clickMul=0;
                    clickDiv=0;
                    clickDot=0;
                }
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText()==""){
                    Toast.makeText(MainActivity.this,"Please Enter a Number!",Toast.LENGTH_LONG).show();
                }
                else {
                    second_num = Float.parseFloat(result.getText().toString());
                    clickAdd=0;
                    clickDot=0;
                    clickMul=0;
                    clickDiv=0;
                    clickSub=0;
                    if (operator == "+") {
                        res=first_num+second_num;
                        extra2.setText("=");
                        if(res%1==0){
                            result.setText(Integer.toString((int)res));
                            if(first_num%1==0&&second_num%1==0){
                                extra.setText(Integer.toString((int)first_num)+" + "+Integer.toString((int)second_num));
                            }else{
                                extra.setText(Float.toString(first_num)+" + "+Float.toString(second_num));
                            }
                        }
                        else{
                            result.setText(Float.toString(res));
                            if(first_num%1==0&&second_num%1!=0){
                                extra.setText(Integer.toString((int)first_num)+" + "+Float.toString(second_num));
                            }else if (first_num%1!=0&&second_num%1==0){
                                extra.setText(Float.toString(first_num)+" + "+Integer.toString((int)second_num));
                            }
                            else{
                                extra.setText(Float.toString(first_num)+" + "+Float.toString(second_num));
                            }
                        }
                    }
                    else if (operator == "-") {
                        res=first_num-second_num;
                        extra2.setText("=");
                        if(res%1==0){
                            result.setText(Integer.toString((int)res));
                            if(first_num%1==0&&second_num%1==0){
                                extra.setText(Integer.toString((int)first_num)+" - "+Integer.toString((int)second_num));
                            }else{
                                extra.setText(Float.toString(first_num)+" - "+Float.toString(second_num));
                            }
                        }
                        else{
                            result.setText(Float.toString(res));
                            if(first_num%1==0&&second_num%1!=0){
                                extra.setText(Integer.toString((int)first_num)+" - "+Float.toString(second_num));
                            }else if (first_num%1!=0&&second_num%1==0){
                                extra.setText(Float.toString(first_num)+" - "+Integer.toString((int)second_num));
                            }
                            else{
                                extra.setText(Float.toString(first_num)+" - "+Float.toString(second_num));
                            }
                        }
                    }
                    else if (operator == "*") {
                        res=first_num*second_num;
                        extra2.setText("=");
                        if(res%1==0){
                            result.setText(Integer.toString((int)res));
                            if (first_num%1==0&&second_num%1==0){
                                extra.setText(Integer.toString((int)first_num)+" x "+Integer.toString((int)second_num));
                            }else if (first_num%1!=0&&second_num%1==0){
                                extra.setText(Float.toString(first_num)+" x "+Integer.toString((int)second_num));
                            }else if (first_num%1==0&&second_num%1!=0){
                                extra.setText(Integer.toString((int)first_num)+" x "+Float.toString(second_num));
                            }else{
                                extra.setText(Float.toString(first_num)+" x "+Float.toString(second_num));
                            }
                        }
                        else{
                            result.setText(Float.toString(res));
                            if (first_num%1==0&&second_num%1==0){
                                extra.setText(Integer.toString((int)first_num)+" x "+Integer.toString((int)second_num));
                            }else if (first_num%1!=0&&second_num%1==0){
                                extra.setText(Float.toString(first_num)+" x "+Integer.toString((int)second_num));
                            }else if (first_num%1==0&&second_num%1!=0){
                                extra.setText(Integer.toString((int)first_num)+" x "+Float.toString(second_num));
                            }else{
                                extra.setText(Float.toString(first_num)+" x "+Float.toString(second_num));
                            }
                        }
                    }
                    else if(operator==""){
                        extra.setText("Total");
                        extra2.setText("=");
                        result.setText(Float.toString(second_num));
                    }
                    else {
                        if (second_num == 0) {
                            result.setText("Error");
                            extra.setText("Error");
                            extra2.setText("");
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                        } else {
                            res=first_num/second_num;
                            extra2.setText("=");
                            if(res%1==0){
                                result.setText(Integer.toString((int)res));
                                if (first_num%1==0&&second_num%1==0){
                                    extra.setText(Integer.toString((int)first_num)+" / "+Integer.toString((int)second_num));
                                }else if (first_num%1!=0&&second_num%1==0){
                                    extra.setText(Float.toString(first_num)+" / "+Integer.toString((int)second_num));
                                }else if (first_num%1==0&&second_num%1!=0){
                                    extra.setText(Integer.toString((int)first_num)+" / "+Float.toString(second_num));
                                }else{
                                    extra.setText(Float.toString(first_num)+" / "+Float.toString(second_num));
                                }
                            }
                            else{
                                result.setText(Float.toString(res));
                                if (first_num%1==0&&second_num%1==0){
                                    extra.setText(Integer.toString((int)first_num)+" / "+Integer.toString((int)second_num));
                                }else if (first_num%1!=0&&second_num%1==0){
                                    extra.setText(Float.toString(first_num)+" / "+Integer.toString((int)second_num));
                                }else if (first_num%1==0&&second_num%1!=0){
                                    extra.setText(Integer.toString((int)first_num)+" / "+Float.toString(second_num));
                                }else{
                                    extra.setText(Float.toString(first_num)+" / "+Float.toString(second_num));
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.calculator) {
            // Handle the camera action
        } else if (id == R.id.nav_simple_calculator) {
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_complex_calculator) {
            Intent j=new Intent(this,Main3Activity.class);
            startActivity(j);

        } else if (id == R.id.nav_manage) {
            Toast.makeText(MainActivity.this,"No Tools Available for now",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(this,"No Sharing Option Available for Now",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(this,"No Sending Option Available for Now",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
