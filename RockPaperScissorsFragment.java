package com.linecorp.reviewexam.rockpaperscissors;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * A placeholder to keep hand buttons and a text view for results.
 */
public class RockPaperScissorsFragment extends Fragment {

    class PrsButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            HandButton button = (HandButton) v;
            if (button.getRest() != 0) {
                button.play();
                button.updateText();
                getOpponentHand();
                int result = button.getHand().compareTo(opponentHand);

                TextView resultTextView = ((TextView) getActivity().findViewById(R.id.text_view));
                if (result < 0) {
                    resultTextView.setText(resultTextView.getText() + "LOSE"
                            + "(You: " + button.getHand().toString() + ", Opponent: "
                            + opponentHand.toString() + ")\n");
                } else if (result > 0) {
                    resultTextView.setText(resultTextView.getText() + "WIN"
                            + "(You: " + button.getHand().toString() + ", Opponent: "
                            + opponentHand.toString() + ")\n");
                } else {
                    resultTextView.setText(resultTextView.getText() + "DRAW"
                            + "(You: " + button.getHand().toString() + ", Opponent: "
                            + opponentHand.toString() + ")\n");
                }
            }
        }
    }

    HandButton rockButton;
    HandButton scissorsButton;
    HandButton paperButton;

    Hand opponentHand = Hand.ROCK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.rockpaperscissors_fragment, container, false);
        rockButton = (HandButton) fragmentView.findViewById(R.id.rock_button);
        scissorsButton = (HandButton) fragmentView.findViewById(R.id.scissors_button);
        paperButton = (HandButton) fragmentView.findViewById(R.id.paper_button);

        rockButton.setOnClickListener(new PrsButtonClickListener());
        scissorsButton.setOnClickListener(new PrsButtonClickListener());
        paperButton.setOnClickListener(new PrsButtonClickListener());

        return fragmentView;
    }

    public void getOpponentHand() {
        try {
            URL url = new URL("http://example.com/randhand");
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new BufferedInputStream(connection.getInputStream())));
            String str = reader.readLine();
            while (!TextUtils.isEmpty(str)) {
                opponentHand = Hand.fromInt(Integer.valueOf(str.trim()));
                str = reader.readLine();
            }
        } catch (IOException e) {
            ErrorReporter.report(e);
        }
    }
}
