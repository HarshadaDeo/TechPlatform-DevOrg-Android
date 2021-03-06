package com.platform.utility;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;

public class LocaleManager extends ContextWrapper {

    @SuppressWarnings("WeakerAccess")
    public LocaleManager(Context base) {
        super(base);
    }

    public static Context setNewLocale(Context context, Locale newLocale) {
        Resources res = context.getResources();
        Configuration configuration = res.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            configuration.setLocale(newLocale);

            LocaleList localeList = new LocaleList(newLocale);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);

            context = context.createConfigurationContext(configuration);
        } else {
            configuration.setLocale(newLocale);
            context = context.createConfigurationContext(configuration);
        }

        return new LocaleManager(context);
    }
}
