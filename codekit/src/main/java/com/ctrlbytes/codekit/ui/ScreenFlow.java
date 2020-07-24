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

package com.ctrlbytes.codekit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.annotation.CheckResult;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

@SuppressWarnings("unused")
public class ScreenFlow {

    private Activity mActivity;
    private Fragment mFragment;
    private int mResultCode;
    private Class<? extends Activity> mDestinationActivity;
    private boolean hasSharedElements;
    private Pair<View, String>[] mSharedElements;
    private Bundle mBundle;
    private int mFlags;
    private boolean hasFlags;

    private ScreenFlow(ScreenFlowBuilder mBuilder) {
        this.mActivity = mBuilder.mActivity;
        this.mFragment = mBuilder.mFragment;
        this.mDestinationActivity = mBuilder.mDestinationActivity;
        this.mResultCode = mBuilder.mResultCode;
        this.hasSharedElements = mBuilder.hasSharedElements;
        this.mSharedElements = mBuilder.mSharedElements;
        this.mBundle = mBuilder.mBundle;
        this.mFlags = mBuilder.mFlags;
        this.hasFlags = mBuilder.hasFlags;
    }

    void launch() {
        if (!hasSharedElements) {
            if (mActivity != null) {
                if (mResultCode == -1) {
                    mActivity.startActivity(createIntent());
                } else {
                    mActivity.startActivityForResult(createIntent(), mResultCode);
                }
            } else if (mFragment != null) {
                if (mResultCode == -1) {
                    mFragment.startActivity(createIntent());
                } else {
                    mFragment.startActivityForResult(createIntent(), mResultCode);
                }
            }
        } else {
            if (mActivity != null) {
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(mActivity, mSharedElements);
                if (mResultCode == -1) {
                    mActivity.startActivity(createIntent(), options.toBundle());
                } else {
                    mActivity.startActivityForResult(createIntent(), mResultCode, options.toBundle());
                }
            } else if (mFragment != null) {
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(mFragment.requireActivity(), mSharedElements);
                if (mResultCode == -1) {
                    mFragment.startActivity(createIntent(), options.toBundle());
                } else {
                    mFragment.startActivityForResult(createIntent(), mResultCode, options.toBundle());
                }
            }
        }
    }

    private Intent createIntent() {
        Intent intent;
        if (mActivity != null) {
            intent = new Intent(mActivity, mDestinationActivity);
        } else {
            intent = new Intent(mFragment.getActivity(), mDestinationActivity);
        }
        intent.putExtras(mBundle);

        if (hasFlags) {
            intent.setFlags(mFlags);
        }
        return intent;
    }

    @CheckResult
    public static ScreenFlowBuilder from(Activity mActivity) {
        return new ScreenFlowBuilder(mActivity);
    }

    @CheckResult
    public static ScreenFlowBuilder from(Fragment fragment) {
        return new ScreenFlowBuilder(fragment);
    }

    public static class ScreenFlowBuilder {

        private Activity mActivity = null;
        private Fragment mFragment = null;
        private Class<? extends Activity> mDestinationActivity;
        private int mResultCode = -1;
        private boolean hasSharedElements = false;
        private Pair<View, String>[] mSharedElements;
        private int mFlags;
        private boolean hasFlags = false;
        private Bundle mBundle = new Bundle();

        private ScreenFlowBuilder(Activity activity) {
            this.mActivity = activity;
        }

        private ScreenFlowBuilder(Fragment fragment) {
            this.mFragment = fragment;
        }

        @CheckResult
        public ScreenFlowBuilder useResult(int resultCode) {
            this.mResultCode = resultCode;
            return this;
        }

        @CheckResult
        public ScreenFlowBuilder useFlags(int flags) {
            hasFlags = true;
            this.mFlags = flags;
            return this;
        }

        @SafeVarargs
        @CheckResult
        public final ScreenFlowBuilder withSharedElements(Pair<View, String>... sharedElements) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                hasSharedElements = true;
                mSharedElements = sharedElements;
            }
            return this;
        }

        @CheckResult
        public ScreenFlowBuilder withArg(String Key, Integer object) {
            mBundle.putInt(Key, object);
            return this;
        }

        @CheckResult
        public ScreenFlowBuilder withArg(String Key, String object) {
            mBundle.putString(Key, object);
            return this;
        }

        @CheckResult
        public ScreenFlowBuilder withArg(String Key, Double object) {
            mBundle.putDouble(Key, object);
            return this;
        }

        @CheckResult
        public ScreenFlowBuilder withIntegerListArg(String Key, ArrayList<Integer> object) {
            mBundle.putIntegerArrayList(Key, object);
            return this;
        }

        @CheckResult
        public ScreenFlowBuilder withStringListArg(String Key, ArrayList<String> object) {
            mBundle.putStringArrayList(Key, object);
            return this;
        }

        public void to(Class<? extends Activity> destinationActivity) {
            mDestinationActivity = destinationActivity;
            new ScreenFlow(this).launch();
        }
    }
}
