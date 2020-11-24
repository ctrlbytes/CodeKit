/*
 * MIT License
 *
 * Copyright (c) 2020 CtrlBytes Technologies
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package com.ctrlbytes.codekit.utils

import android.content.Context
import android.content.Intent

@Suppress("unused")
object AppsInDevice {

    @JvmStatic
    fun isInstalled(context: Context, packageName: String): Boolean {
        val appIntent = Intent(Intent.ACTION_MAIN, null).addCategory(Intent.CATEGORY_LAUNCHER)
        val resolveInfoList = context.packageManager.queryIntentActivities(appIntent, 0)
        for (resolveInfo in resolveInfoList) {
            if (resolveInfo.activityInfo.packageName == packageName) {
                return true
            }
        }
        return false
    }

    object Packages {
        const val FACEBOOK = "com.facebook.katana"
        const val FACEBOOK_MESSENGER = "com.facebook.orca"
        const val FACEBOOK_LITE = "com.facebook.lite"
        const val FACEBOOK_MENTIONS = "com.facebook.Mentions"
        const val FACEBOOK_GROUPS = "com.facebook.groups"
        const val FACEBOOK_PAGES_MANAGER = "com.facebook.pages.app"
        const val WHATSAPP = "com.whatsapp"
        const val VIBER = "com.viber.voip"
        const val TELEGRAM = "org.telegram.messenger"
        const val GOOGLE = "com.google.android.googlequicksearchbox"
        const val GOOGLE_DRIVE = "com.google.android.apps.docs"
        const val GOOGLE_TRANSLATE = "com.google.android.apps.translate"
        const val GOOGLE_CALENDAR = "com.google.android.calendar"
        const val GOOGLE_MAPS = "com.google.android.apps.maps"
        const val GOOGLE_DOCS = "com.google.android.apps.docs.editors.docs"
        const val GOOGLE_ALLO = "com.google.android.apps.fireball"
        const val GOOGLE_SHEETS = "com.google.android.apps.docs.editors.sheets"
        const val CHROME = "com.android.chrome"
        const val GMAIL = "com.google.android.gm"
        const val YOUTUBE = "com.google.android.youtube"
        const val HANGOUTS = "com.google.android.talk"
        const val UBER = "com.ubercab"
        const val LYFT = "me.lyft.android"
        const val CLEAN_MASTER = "com.cleanmaster.mguard"
        const val DUBSMASH = "com.mobilemotion.dubsmash"
        const val SNAPCHAT = "com.snapchat.android"
        const val NETFLIX = "com.netflix.mediaclient"
        const val MSQRD = "me.msqrd.android"
        const val QUORA = "com.quora.android"
        const val LINKEDIN = "com.linkedin.android"
        const val PINTEREST = "com.pinterest"
        const val TUMBLR = "com.tumblr"
    }
}