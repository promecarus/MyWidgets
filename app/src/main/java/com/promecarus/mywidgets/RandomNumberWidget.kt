package com.promecarus.mywidgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class RandomNumberWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int
) {
    val lastUpdate = "Random: " + NumberGenerator.generate(100)
    val views = RemoteViews(context.packageName, R.layout.random_number_widget)
    views.setTextViewText(R.id.appwidget_text, lastUpdate)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
