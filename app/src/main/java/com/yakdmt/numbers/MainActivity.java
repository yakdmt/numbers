package com.yakdmt.numbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.yakdmt.numbers.util.Converter;
import com.yakdmt.numbers.util.ParseException;
import com.yakdmt.numbers.util.Parser;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText mOutput, mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mInput = (EditText) findViewById(R.id.number_input);
        mOutput = (EditText) findViewById(R.id.text_output);

        mInput.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length()==0) {
            mOutput.setText("");
            mOutput.setHint(getString(R.string.output_hint));
            return;
        }
        String normalizedString = null;
        try {
           normalizedString = Parser.getInstance().normalizeString(s.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            if (e.getErrorType().equals(ParseException.ErrorType.TOO_LONG)){
                onTooLongNumber();
                return;
            }

        }
        if (normalizedString != null) {
            long number = 0;
            try {
                number = Parser.getInstance().parseString(normalizedString);
            } catch (ParseException e) {
                e.printStackTrace();
                if (e.getErrorType().equals(ParseException.ErrorType.NOT_A_NUMBER)){
                    mInput.setText("");
                    Toast.makeText(this, getString(R.string.invalid_number), Toast.LENGTH_LONG).show();
                    return;
                }
            }
            String outputText = Converter.getInstance().convertToText(number);
            mOutput.setText(outputText);
        }
    }

    private void onTooLongNumber(){
        mOutput.setHint(getString(R.string.too_long));
        mOutput.setText("");
    }


}
