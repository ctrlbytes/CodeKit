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

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@SuppressWarnings("unused")
public class YLog {

    private static String LOG_TAG_PREFIX = "";
    private static boolean LOG_ENABLED = false;

    public static void init(String appTag, boolean enabled) {
        LOG_TAG_PREFIX = appTag;
        LOG_ENABLED = enabled;
    }

    public static String createLogTag(String tag) {
        tag = LOG_TAG_PREFIX + "-" + tag;
        if (tag.length() > 22) {
            tag = tag.substring(0, 22);
        }
        return tag;
    }

    public static void d(String tag, String msg) {
        if (LOG_ENABLED)
            Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (LOG_ENABLED)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (LOG_ENABLED)
            Log.d(tag, msg, tr);
    }

    public static void e(String TAG, String Msg) {
        if (LOG_ENABLED) {
            Log.e(TAG, Msg);
        }
    }

    /*
        Inspired by Jordan Hill
        https://twitter.com/DivineOmega/status/695744177557106688
    */
    public static void e(String TAG, String Msg, Throwable t) {
        if (LOG_ENABLED) {
            try {
                Log.e(TAG, "https://stackoverflow.com/search?q=" + URLEncoder.encode(t.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException ignored) {

            }
            Log.e(TAG, Msg, t);
        }
    }

    /*
        Inspired by Jordan Hill
        https://twitter.com/DivineOmega/status/695744177557106688
    */
    public static void w(String TAG, String Msg, Throwable t) {
        if (LOG_ENABLED) {
            try {
                Log.w(TAG, "https://stackoverflow.com/search?q=" + URLEncoder.encode(t.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException ignored) {

            }
            Log.w(TAG, Msg, t);
        }
    }
}