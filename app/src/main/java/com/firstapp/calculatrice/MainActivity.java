package com.firstapp.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    ArrayList<Object> operation = new ArrayList<Object>();
    ArrayList<Object> display=new ArrayList<Object>();
    double var1,var2;
    char operator;
    boolean negative=false;
    Button zero,one,two,three,four,five,six,seven,eight,nine;
    TextView operationHistory,result;
    Button equal,divide,add,sub,modulo,multiply,divX,pow,square,clear,clearElement,delete;
    Button addSub,comma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //definition des elements:
        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);

        operationHistory=findViewById(R.id.operation);
        result=findViewById(R.id.resultat);

        equal=findViewById(R.id.equal);
        divide=findViewById(R.id.division);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.subtract);
        multiply=findViewById(R.id.multiply);
        modulo=findViewById(R.id.modulo);
        divX=findViewById(R.id.divideX);
        pow=findViewById(R.id.pow2);
        square=findViewById(R.id.racine);
        clear=findViewById(R.id.C);
        clearElement=findViewById(R.id.CE);
        delete=findViewById(R.id.delete);

        addSub=findViewById(R.id.addSub);
        comma=findViewById(R.id.comma);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!display.isEmpty()) {
                    display.remove(display.size() - 1);
                    Display(display);
                }
            }
        });

        addSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                negative=true;
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(0);
                Display(display);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(1);
                Display(display);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(2);
                Display(display);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(3);
                Display(display);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(4);
                Display(display);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(5);
                Display(display);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(6);
                Display(display);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(7);
                Display(display);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(8);
                Display(display);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add(9);
                Display(display);
            }
        });

        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.add('.');
                Display(display);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.addAll(display);
                operation.add('+');
                DisplayOperation(operation);
                display.clear();
                Display(display);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.addAll(display);
                operation.add('-');
                DisplayOperation(operation);
                display.clear();
                Display(display);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.addAll(display);
                operation.add('*');
                DisplayOperation(operation);
                display.clear();
                Display(display);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.addAll(display);
                operation.add('/');
                DisplayOperation(operation);
                display.clear();
                Display(display);
            }
        });
        modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.addAll(display);
                operation.add('%');
                DisplayOperation(operation);
                display.clear();
                Display(display);
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (Object element : display)
                    sb.append(element);
                double value = Double.parseDouble(sb.toString());
                value*=value;
                display.clear();
                display.add(value);
                Display(display);

            }
        });

        divX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (Object element : display)
                    sb.append(element);
                double value = Double.parseDouble(sb.toString());
                value=1/value;
                display.clear();
                display.add(value);
                Display(display);
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (Object element : display)
                    sb.append(element);
                double value = Double.parseDouble(sb.toString());
                value=Math.sqrt(value);
                display.clear();
                display.add(value);
                Display(display);
            }
        });
        clearElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.clear();
                Display(display);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.clear();
                display.clear();
                DisplayOperation(operation);
                Display(display);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.size()>0)
                display.remove(display.size() - 1);
                Display(display);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.addAll(display);
                Display(operation);
                display.clear();
                operation=OperationBuilder(operation);
                double value=executeOperation(operation);
                display.add(value);
                Display(display);

            }
        });

    }

    void Display(ArrayList<Object> list){
        StringBuilder sb = new StringBuilder();
        for (Object element : list)
            sb.append(element);
        result.setText(sb.toString());
    }
    void DisplayOperation(ArrayList<Object> list){
        StringBuilder sb = new StringBuilder();
        for (Object element : list)
            sb.append(element);
        operationHistory.setText(sb.toString());
    }
    public ArrayList<Object> OperationBuilder(ArrayList<Object> list) {
        if (list == null || list.isEmpty()) return new ArrayList<>();

        ArrayList<Object> result = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();

        for (Object item : list) {
            String itemString = item.toString();
            if (isNumericString(itemString) || itemString.equals(".")) {
                // Si l'élément est une chaîne numérique ou un séparateur décimal, ajoutez-le au nombre en cours de construction
                numberBuilder.append(itemString);
            } else {
                // Si l'élément n'est pas numérique, ajoutez le nombre construit, puis l'opérateur
                if (numberBuilder.length() > 0) {
                    result.add(Double.parseDouble(numberBuilder.toString()));
                    numberBuilder.setLength(0);
                }
                result.add(item);
            }
        }

        // Ajoutez le dernier nombre construit (s'il y en a un)
        if (numberBuilder.length() > 0) {
            result.add(Double.parseDouble(numberBuilder.toString()));
        }

        return result;
    }

    private boolean isNumericString(String itemString) {
        try {
            Double.parseDouble(itemString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(Object item) {
        // Check if the item is an operator (you may need to modify this based on your use case)
        if (item instanceof String) {
            String str = (String) item;
            return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("divX") || str.equals("pow") || str.equals("sqr");
        }
        return false;
    }

    public double executeOperation(ArrayList<Object> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The input list is empty or null.");
        }

        Stack<Double> numberStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (Object item : list) {
            if (item instanceof Double) {
                numberStack.push((Double) item);
            } else if (item instanceof String) {
                String operator = (String) item;
                while (!operatorStack.isEmpty() && hasPrecedence(operator, operatorStack.peek())) {
                    double operand2 = numberStack.pop();
                    double operand1 = numberStack.pop();
                    String op = operatorStack.pop();
                    double result = performOperation(operand1, operand2, op);
                    numberStack.push(result);
                }
                operatorStack.push(operator);
            } else {
                throw new IllegalArgumentException("Unsupported element in the list: " + item);
            }
        }

        while (!operatorStack.isEmpty()) {
            double operand2 = numberStack.pop();
            double operand1 = numberStack.pop();
            String operator = operatorStack.pop();
            double result = performOperation(operand1, operand2, operator);
            numberStack.push(result);
        }

        if (numberStack.size() != 1 || !operatorStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression.");
        }

        return numberStack.pop();
    }

    private boolean hasPrecedence(String op1, String op2) {
        return (op1.equals("*") || op1.equals("/") || op1.equals("%")) && (op2.equals("+") || op2.equals("-"));
    }

    private double performOperation(double operand1, double operand2, String operator) {
        double result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0.0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                result = operand1 / operand2;
                break;
            case "%":
                result = operand1 % operand2;
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
        return result;
    }


}