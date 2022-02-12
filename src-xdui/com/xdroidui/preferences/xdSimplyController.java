/*
 * Copyright (C) 2022 a xdroidOSS, xyzprjkt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.xdroidui.preferences;

import android.content.Intent;
import android.os.Build;
import android.os.SystemProperties;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.widget.LayoutPreference;
import androidx.cardview.widget.CardView;

public class xdSimplyController extends BasePreferenceController implements View.OnTouchListener {

    Context context;

    public xdSimplyController(Context context, String key) {
        super(context, key);
        this.context = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }


    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        LayoutPreference mPreference = screen.findPreference("xd_firmware_header");
	    onBindItems(mPreference.findViewById(R.id.xd_firmware_banner_container));
    }

    public void onBindItems(View holder) {
        View root = holder;
        CardView banner = root.findViewById(R.id.xd_firmware_banner_card);
        banner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final Intent kebeletEgg = new Intent();
                kebeletEgg.setClassName("id.xyzprjkt.xd.xdcore", "id.xyzprjkt.xd.xdcore.egg.kebeletMain");
                context.startActivity(kebeletEgg);
                return false;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        return true;
    }
}