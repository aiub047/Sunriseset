package com.bright.sunriseset

import android.content.Context
import android.content.ContextWrapper
import android.os.LocaleList
import java.util.Locale

class ContextUtils(base: Context) : ContextWrapper(base) {
    companion object {
        fun updateLocale(
            context: Context,
            switchTo: Locale
        ): ContextUtils {
            val resources = context.resources
            val configuration = resources.configuration
            val localeList = LocaleList(switchTo)
            LocaleList.setDefault(localeList)
            configuration.setLocales(localeList)
            val updatedContext = context.createConfigurationContext(configuration)
            return ContextUtils(updatedContext)
        }
    }
}