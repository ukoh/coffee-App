package com.kelly.coffeecup;

import java.text.NumberFormat;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


//this app display an order form to display coffee//
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity==0){
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    //This method is called when the order button is clicked//
    public void submitOrder(View view) {
        EditText Test = (EditText) findViewById(R.id.name_field);
        String value = Test.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhipped = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(haswhipped, hasChocolate);
        String priceMessage = createOrderSummary(value, price, haswhipped, hasChocolate);
        displayMessage(priceMessage);


    }

    private int calculatePrice(boolean addwhippedCream, boolean addChocolate) {
        int basePrice = 150;
        if (addwhippedCream){
            basePrice = basePrice + 50;
        }
        if (addChocolate){
            basePrice =basePrice + 100;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String value, int price, boolean addwhippedCream, boolean addChocolate) {

        String priceMessage = "Name: " + value;
        priceMessage += "\nAdd whipped cream? " + addwhippedCream;
        priceMessage+="\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: ₦" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    // This method displays the given quantity value on the screen.//

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    //This method displays the given quantity value on the screen//
    private void displayMessage(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.order_summary_text_view);
        quantityTextView.setText(message);
    }
}