package omy.boston.optionpreferences;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by LosFrancisco on 25-Jan-17.
 */

public class CustomPreferenceFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}

