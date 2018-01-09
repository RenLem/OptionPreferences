package omy.boston.optionpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by LosFrancisco on 25-Jan-17.
 */

public class CustomPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new CustomPreferenceFragment())
                .commit();
    }
}
