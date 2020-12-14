package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;

    int mStoryPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryPath = savedInstanceState.getInt("currPath");
        } else {
            mStoryPath = 1;
        }

        // Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);

        // Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryPath == 1 || mStoryPath == 2) {
                    showThirdPath();
                }

                if (mStoryPath == 3) {
                    showThirdEnding();
                }

                mStoryPath++;
            }
        });

        // Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryPath == 1) {
                    showSecondPath();
                }

                if (mStoryPath == 2) {
                    showFirstEnding();
                }

                if (mStoryPath == 3) {
                    showSecondEnding();
                }

                mStoryPath++;
            }
        });
    }

    void showSecondPath() {
        mStoryTextView.setText(R.string.T2_Story);
        mTopButton.setText(R.string.T2_Ans1);
        mBottomButton.setText(R.string.T2_Ans2);
    }

    void showThirdPath() {
        mStoryTextView.setText(R.string.T3_Story);
        mTopButton.setText(R.string.T3_Ans1);
        mBottomButton.setText(R.string.T3_Ans2);
    }

    void showFirstEnding() {
        mStoryTextView.setText(R.string.T4_End);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setVisibility(View.INVISIBLE);
    }

    void showSecondEnding() {
        mStoryTextView.setText(R.string.T5_End);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setVisibility(View.INVISIBLE);
    }

    void showThirdEnding() {
        mStoryTextView.setText(R.string.T6_End);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setVisibility(View.INVISIBLE);
    }
}
