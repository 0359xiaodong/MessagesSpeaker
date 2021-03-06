package com.psaravan.messages.speaker;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Preferences page fragment.
 *
 * @author Saravan Pantham
 */
public class SettingsFragment extends PreferenceFragment {

    private CheckBoxPreference mSpeakOnlyOnHeadset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from the XML resource.
        addPreferencesFromResource(R.xml.preferences);

        mSpeakOnlyOnHeadset = (CheckBoxPreference) getPreferenceManager().findPreference("SPEAK_ONLY_ON_HEADSET");
        mSpeakOnlyOnHeadset.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                LocalApp.getSharedPreferences().edit()
                                               .putBoolean(LocalApp.SPEAK_ONLY_ON_HEADSET, (Boolean) newValue)
                                               .commit();
                return true;
            }
        });

        mSpeakOnlyOnHeadset = (CheckBoxPreference) getPreferenceManager().findPreference("SPEAK_ONLY_WHEN_LOCKED");
        mSpeakOnlyOnHeadset.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                LocalApp.getSharedPreferences().edit()
                        .putBoolean(LocalApp.SPEAK_ONLY_WHEN_LOCKED, (Boolean) newValue)
                        .commit();
                return true;
            }
        });
    }
}
