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

package com.ctrlbytes.codekit.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;

import androidx.annotation.StringRes;

import java.util.List;

@SuppressWarnings("unused")
public class AppsInDevice {

    public static boolean isInstalled(Context context, String packageName) {
        Intent appIntent = new Intent(Intent.ACTION_MAIN, null).addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfoList = context.getPackageManager().queryIntentActivities(appIntent, 0);
        for (ResolveInfo resolveInfo : resolveInfoList) {
            if (resolveInfo.activityInfo.packageName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static void sharePlainText(Context context, @StringRes int shareTitle, String text) {
        Intent shareIntent = new Intent()
                .setAction(Intent.ACTION_SEND)
                .putExtra(Intent.EXTRA_TEXT, text)
                .setType("text/plain");
        context.startActivity(Intent.createChooser(shareIntent, context.getString(shareTitle)));
    }

    public interface Packages {
        String FACEBOOK = "com.facebook.katana";
        String FACEBOOK_MESSENGER = "com.facebook.orca";
        String FACEBOOK_LITE = "com.facebook.lite";
        String FACEBOOK_MENTIONS = "com.facebook.Mentions";
        String FACEBOOK_GROUPS = "com.facebook.groups";
        String FACEBOOK_PAGES_MANAGER = "com.facebook.pages.app";

        String WHATSAPP = "com.whatsapp";
        String VIBER = "com.viber.voip";
        String TELEGRAM = "org.telegram.messenger";

        String GOOGLE = "com.google.android.googlequicksearchbox";
        String GOOGLE_DRIVE = "com.google.android.apps.docs";
        String GOOGLE_TRANSLATE = "com.google.android.apps.translate";
        String GOOGLE_CALENDAR = "com.google.android.calendar";
        String GOOGLE_MAPS = "com.google.android.apps.maps";
        String GOOGLE_DOCS = "com.google.android.apps.docs.editors.docs";
        String GOOGLE_ALLO = "com.google.android.apps.fireball";
        String GOOGLE_SHEETS = "com.google.android.apps.docs.editors.sheets";
        String CHROME = "com.android.chrome";
        String GMAIL = "com.google.android.gm";
        String YOUTUBE = "com.google.android.youtube";
        String HANGOUTS = "com.google.android.talk";

        String UBER = "com.ubercab";
        String LYFT = "me.lyft.android";

        String CLEAN_MASTER = "com.cleanmaster.mguard";
        String DUBSMASH = "com.mobilemotion.dubsmash";
        String SNAPCHAT = "com.snapchat.android";
        String NETFLIX = "com.netflix.mediaclient";
        String MSQRD = "me.msqrd.android";
        String QUORA = "com.quora.android";
        String LINKEDIN = "com.linkedin.android";
        String PINTEREST = "com.pinterest";
        String TUMBLR = "com.tumblr";
    }
}
